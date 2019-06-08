package net.nerds.volarius;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.util.math.BlockPos;
import net.nerds.volarius.machines.MachineBlockEntities;
import net.nerds.volarius.machines.farmer.FarmingUnitBlockEntity;
import net.nerds.volarius.machines.farmer.FarmingUnitContainer;
import net.nerds.volarius.machines.farmer.FarmingUnitGui;
import net.nerds.volarius.machines.fishTrap.FishTrapBlockEntity;
import net.nerds.volarius.machines.fishTrap.FishTrapContainer;
import net.nerds.volarius.machines.fishTrap.FishTrapGui;

public class VolariusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        this.registerClientGuis();
    }

    private void registerClientGuis() {
        ScreenProviderRegistry.INSTANCE.registerFactory(MachineBlockEntities.FARMER_CONTAINER, ((syncid, identifier, player, buf) -> {
            BlockPos pos = buf.readBlockPos();
            FarmingUnitBlockEntity farmingUnit = (FarmingUnitBlockEntity) player.world.getBlockEntity(pos);
            return new FarmingUnitGui(farmingUnit, new FarmingUnitContainer(syncid, player.inventory, farmingUnit));
        }));

        ScreenProviderRegistry.INSTANCE.registerFactory(MachineBlockEntities.FISH_TRAP_CONTAINER, ((syncid, identifier, player, buf) -> {
            BlockPos pos = buf.readBlockPos();
            FishTrapBlockEntity fishTrapBlockEntity = (FishTrapBlockEntity) player.world.getBlockEntity(pos);
            return new FishTrapGui(fishTrapBlockEntity, new FishTrapContainer(syncid, player.inventory, fishTrapBlockEntity));
        }));

    }
}
