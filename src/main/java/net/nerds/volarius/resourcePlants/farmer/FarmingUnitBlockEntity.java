package net.nerds.volarius.resourcePlants.farmer;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.container.Container;
import net.minecraft.container.GenericContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.DefaultedList;
import net.nerds.volarius.resourcePlants.ResourceCropBlockEntities;

import java.util.Iterator;

public class FarmingUnitBlockEntity extends LootableContainerBlockEntity {

    private int tickCounter = 0; //counter to validate if waited
    private int tickValidator = 20; //how many ticks to wait
    public DefaultedList<ItemStack> inventory;

    public FarmingUnitBlockEntity() {
        super(ResourceCropBlockEntities.FARMING_UNIT_ENTITY);
        inventory = DefaultedList.create(54, ItemStack.EMPTY);
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

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inventory;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> inventory) {
        this.inventory = inventory;
    }

    @Override
    protected Component getContainerName() {
        return new TranslatableComponent("container.farming_unit", new Object[0]);
    }

    @Override
    protected Container createContainer(int i, PlayerInventory playerInventory) {
        return GenericContainer.createGeneric9x6(i, playerInventory, this);
    }
}
