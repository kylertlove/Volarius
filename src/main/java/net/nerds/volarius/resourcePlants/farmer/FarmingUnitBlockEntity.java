package net.nerds.volarius.resourcePlants.farmer;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.Direction;
import net.nerds.volarius.resourcePlants.ResourceCropBlockEntities;

import java.util.Iterator;

public class FarmingUnitBlockEntity extends BlockEntity implements Tickable, BlockEntityClientSerializable, SidedInventory {

    private int tickCounter = 0; //counter to validate if waited
    private int tickValidator = 20; //how many ticks to wait
    public DefaultedList<ItemStack> inventory;

    public FarmingUnitBlockEntity() {
        super(ResourceCropBlockEntities.FARMING_UNIT_ENTITY);
        inventory = DefaultedList.create(12, ItemStack.EMPTY);
    }

    @Override
    public void tick() {

    }

    @Override
    public void fromClientTag(CompoundTag nbt) {
        this.fromTag(nbt);
        inventory = DefaultedList.create(12, ItemStack.EMPTY);
        Inventories.fromTag(nbt, this.inventory);
    }

    @Override
    public CompoundTag toClientTag(CompoundTag nbt) {
        super.toTag(nbt);
        Inventories.toTag(nbt, this.inventory);
        return nbt;
    }

    @Override
    public int[] getInvAvailableSlots(Direction direction) {
        return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    }

    @Override
    public boolean canInsertInvStack(int i, ItemStack var2, Direction var3) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    @Override
    public boolean canExtractInvStack(int i, ItemStack var2, Direction var3) {
        return i == 5 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10 || i == 11;
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
    public ItemStack takeInvStack(int i, int j) {
        return Inventories.splitStack(inventory, i, j);
    }

    @Override
    public ItemStack removeInvStack(int i) {
        return Inventories.removeStack(this.inventory, i);
    }

    @Override
    public void setInvStack(int i, ItemStack itemStack) {
        inventory.set(i, itemStack);
    }

    @Override
    public boolean canPlayerUseInv(PlayerEntity playerEntity) {
        BlockEntity blockEntity;
        try{
            blockEntity = this.world.getBlockEntity(this.pos);
            if (blockEntity != this) {
                return false;
            } else {
                return playerEntity.squaredDistanceTo((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
            }
        } catch (Exception ex) {
            System.out.println("Null Pointer getting block entity");
            return false;
        }
    }

    @Override
    public void clear() {
        inventory.clear();
    }
}
