package net.nerds.volarius.resourcePlants.farmer;

import net.minecraft.container.Container;
import net.minecraft.container.Slot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.world.World;

public class FarmingUnitContainer extends Container {

    public final Inventory inventory;
    public final PlayerInventory playerInventory;
    public final World world;

    public FarmingUnitContainer(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(null, syncId);
        this.inventory = inventory;
        this.playerInventory = playerInventory;
        this.world = playerInventory.player.world;

        //Upgrade Slot
        this.addSlot(new Slot(inventory, 0, 8, 61));

        //Input plant slots
        this.addSlot(new Slot(inventory, 1, 134, 9));
        this.addSlot(new Slot(inventory, 2, 152, 9));
        this.addSlot(new Slot(inventory, 3, 134, 27));
        this.addSlot(new Slot(inventory, 4, 152, 27));

        for(int i = 0; i < 7; ++i) {
            this.addSlot(new Slot(inventory, 5 + i, 44 + i * 18, 55));
        }

        //Vanilla Slots
        int i;
        for(i = 0; i < 3; ++i) {
            for(int var4 = 0; var4 < 9; ++var4) {
                this.addSlot(new Slot(playerInventory, var4 + i * 9 + 9, 8 + var4 * 18, 84 + i * 18));
            }
        }

        for(i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity playerEntity) {
        return this.playerInventory.canPlayerUseInv(playerEntity);
    }
}
