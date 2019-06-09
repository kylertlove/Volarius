package net.nerds.volarius.machines.fishTrap;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.loot.LootSupplier;
import net.minecraft.world.loot.LootTables;
import net.minecraft.world.loot.context.LootContext;
import net.minecraft.world.loot.context.LootContextParameters;
import net.minecraft.world.loot.context.LootContextTypes;
import net.nerds.volarius.machines.MachineBlockEntities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.List;

public class FishTrapBlockEntity extends BlockEntity implements Tickable, BlockEntityClientSerializable, Inventory {

    Logger logger = LogManager.getLogger();

    private int tickCounter = 0; //counter to validate if waited
    private int tickValidator = 200; //how many ticks to wait
    private float lureLevel = 3.0f;
    private int maxStorage = 54;
    public DefaultedList<ItemStack> inventory;

    public FishTrapBlockEntity() {
        super(MachineBlockEntities.FISH_TRAP_ENTITY);
        inventory = DefaultedList.create(maxStorage, ItemStack.EMPTY);
    }

    @Override
    public void tick() {
        if(tickCounter >= tickValidator) {
            tickCounter = 0;
            validateWaterAndFish();
        } else {
            tickCounter++;
        }
    }

    /**
     * Try to fish
     */
    private void validateWaterAndFish() {
        if(!world.isClient) {
            boolean isSurroundedByWater = true;
            Iterable<BlockPos> waterCheckInterator = BlockPos.iterate(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1),
                    new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1));
            for(BlockPos blockPos : waterCheckInterator) {
                Block block = world.getBlockState(blockPos).getBlock();
                if(world.getBlockEntity(pos) != null && (block != Blocks.WATER && !(block instanceof FishTrapBlock))) {
                    isSurroundedByWater = false;
                    break;
                }
            }
            if(isSurroundedByWater) {
                fish();
            }
        }
    }

    /**
     * fish for loot
     */
    private void fish() {
            ItemStack itemStack = new ItemStack(Items.FISHING_ROD);
            LootContext.Builder lootContextBuilder = (new LootContext.Builder((ServerWorld)this.world))
                    .put(LootContextParameters.POSITION, new BlockPos(pos))
                    .put(LootContextParameters.TOOL, itemStack)
                    .setRandom(world.random).setLuck(lureLevel);
            LootSupplier lootSupplier = this.world.getServer().getLootManager().getSupplier(LootTables.FISHING_GAMEPLAY);
            List<ItemStack> list = lootSupplier.getDrops(lootContextBuilder.build(LootContextTypes.FISHING));
            addItemsToInventory(list);
    }

    private void addItemsToInventory(List<ItemStack> itemStackList) {
        for(ItemStack itemStack : itemStackList) {
            //loop through inventory looking for space
            for(int i = 0; i < inventory.size(); i++) {
                if(inventory.get(i).isEmpty()) {
                    inventory.set(i, itemStack);
                    markDirty();
                    break;
                } else if(inventory.get(i).isEqualIgnoreTags(itemStack) &&
                         (inventory.get(i).getAmount() + itemStack.getAmount() < 64) &&
                          itemStack.canStack()) {
                    inventory.set(i, new ItemStack(itemStack.getItem(), itemStack.getAmount() + inventory.get(i).getAmount()));
                    markDirty();
                    break;
                }
            }
        }
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
}
