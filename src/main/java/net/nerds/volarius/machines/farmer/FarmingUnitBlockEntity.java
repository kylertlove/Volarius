package net.nerds.volarius.machines.farmer;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Tickable;
import net.nerds.volarius.machines.MachineBlockEntities;

import java.util.Iterator;

public class FarmingUnitBlockEntity extends BlockEntity implements Tickable, BlockEntityClientSerializable, Inventory {

    private int tickCounter = 0; //counter to validate if waited
    private int tickValidator = 20; //how many ticks to wait
    public DefaultedList<ItemStack> inventory;

    public FarmingUnitBlockEntity() {
        super(MachineBlockEntities.FARMING_UNIT_ENTITY);
        inventory = DefaultedList.create(54, ItemStack.EMPTY);
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
        inventory = DefaultedList.create(54, ItemStack.EMPTY);
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
            System.out.println("try to farm");
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
}
