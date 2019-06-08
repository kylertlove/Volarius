package net.nerds.volarius.machines.farmer;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.nerds.volarius.machines.MachineBlockEntities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FarmingUnitBlockEntity extends BlockEntity implements Tickable, BlockEntityClientSerializable, Inventory {

    Logger logger = LogManager.getLogger();

    private int tickCounter = 0; //counter to validate if waited
    private int tickValidator = 60; //how many ticks to wait
    private int farmingRange = 3; //blocks range away from farming unit
    private int maxStorage = 54;
    public DefaultedList<ItemStack> inventory;

    public FarmingUnitBlockEntity() {
        super(MachineBlockEntities.FARMING_UNIT_ENTITY);
        inventory = DefaultedList.create(maxStorage, ItemStack.EMPTY);
    }

    @Override
    public void fromClientTag(CompoundTag tag) {
        this.fromTag(tag);
    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        return this.toTag(tag);
    }

    @Override
    public void fromTag(CompoundTag nbt) {
        super.fromTag(nbt);
        inventory = DefaultedList.create(maxStorage, ItemStack.EMPTY);
        Inventories.fromTag(nbt, this.inventory);
    }

    @Override
    public CompoundTag toTag(CompoundTag nbt) {
        super.toTag(nbt);
        Inventories.toTag(nbt, this.inventory);
        return nbt;
    }

    @Override
    public void tick() {
        if(tickCounter >= tickValidator) {
            tickCounter = 0;
            attemptHarvest();
        } else {
            tickCounter++;
        }
    }

    @Override
    public int getInvSize() {
        return inventory.size();
    }

    @Override
    public boolean isInvEmpty() {
        Iterator var1 = this.inventory.iterator();

        ItemStack itemStack_1;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            itemStack_1 = (ItemStack)var1.next();
        } while(itemStack_1.isEmpty());

        return false;
    }

    @Override
    public ItemStack getInvStack(int i) {
        return inventory.get(i);
    }

    @Override
    public ItemStack takeInvStack(int i, int i1) {
        return Inventories.splitStack(this.inventory, i, i1);
    }

    @Override
    public ItemStack removeInvStack(int i) {
        return Inventories.removeStack(inventory, i);
    }

    @Override
    public void setInvStack(int i, ItemStack itemStack) {
        inventory.set(i, itemStack);
        this.markDirty();
    }

    @Override
    public boolean canPlayerUseInv(PlayerEntity playerEntity) {
        return false;
    }

    @Override
    public void clear() {
        inventory.clear();
    }

    /**
     * Called during tick().
     * attempts to harvest grown CropBlocks and will add drops to inventory and replant with CropBlock seed
     */
    private void attemptHarvest() {
        if(!world.isClient) {
            List<ItemStack> drops;
            Iterable<BlockPos> farmingArea = BlockPos.iterate(new BlockPos(pos.getX() - farmingRange, pos.getY(), pos.getZ() - farmingRange),
                    new BlockPos(pos.getX() + farmingRange, pos.getY(), pos.getZ() + farmingRange));
            for(BlockPos blockPos : farmingArea) {
                Block block = world.getBlockState(blockPos).getBlock();
                if(world.getBlockEntity(pos) != null && block instanceof CropBlock) {
                    CropBlock cropBlock = (CropBlock) world.getBlockState(blockPos).getBlock();
                    if(cropBlock.isMature(world.getBlockState(blockPos))) {
                        //get drops from crop
                        drops = CropBlock.getDroppedStacks(world.getBlockState(blockPos), (ServerWorld) world, blockPos, null);
                        //add drops to inventory (-1 seedItem)
                        AliasedBlockItem seedsFromPlant = addItemsToInventory(drops);
                        //attempt to replant with seed
                        replantSeed(seedsFromPlant, blockPos);
                    }
                }
            }
        }
    }

    private AliasedBlockItem addItemsToInventory(List<ItemStack> itemStackList) {
        AliasedBlockItem aliasedBlockItems = null;
        for(ItemStack itemStack : itemStackList) {
            //remove a seed from stack for planting
            if((itemStack.getItem() instanceof AliasedBlockItem && ((AliasedBlockItem) itemStack.getItem()).getBlock() instanceof CropBlock)) {
                aliasedBlockItems = (AliasedBlockItem) itemStack.getItem();
                itemStack.subtractAmount(1);
            }
            //loop through inventory looking for space
            for(int i = 0; i < inventory.size(); i++) {
                if(inventory.get(i).isEmpty() && itemStack.getAmount() > 0) {
                    inventory.set(i, itemStack);
                    markDirty();
                    break;
                } else if(inventory.get(i).isEqualIgnoreTags(itemStack) &&
                        (inventory.get(i).getAmount() + itemStack.getAmount() < 64 &&
                                itemStack.getAmount() > 0)
                ) {
                    inventory.set(i, new ItemStack(itemStack.getItem(), itemStack.getAmount() + inventory.get(i).getAmount()));
                    markDirty();
                    break;
                }
            }
        }
        return aliasedBlockItems;
    }

    private void replantSeed(AliasedBlockItem aliasedBlockItem, BlockPos blockPos) {
        if(aliasedBlockItem != null) {
            if(world.getBlockState(blockPos.down()).getBlock() instanceof FarmlandBlock && aliasedBlockItem.getBlock() instanceof CropBlock) {
                world.setBlockState(blockPos, aliasedBlockItem.getBlock().getDefaultState(), 11);
            }
        }
    }
}
