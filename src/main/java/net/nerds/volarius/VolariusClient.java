package net.nerds.volarius;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.util.math.BlockPos;
import net.nerds.volarius.resourcePlants.ResourceCropBlockEntities;
import net.nerds.volarius.resourcePlants.farmer.FarmingUnitBlockEntity;
import net.nerds.volarius.resourcePlants.farmer.FarmingUnitContainer;
import net.nerds.volarius.resourcePlants.farmer.FarmingUnitGui;

public class VolariusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        this.registerClientGuis();
    }

    private void registerClientGuis() {
        System.out.println("--------------------------------------------GUI Register----------------------------------");
        ScreenProviderRegistry.INSTANCE.registerFactory(ResourceCropBlockEntities.FARMER_CONTAINER, ((syncid, identifier, player, buf) -> {
            BlockPos pos = buf.readBlockPos();
            FarmingUnitBlockEntity farmer = (FarmingUnitBlockEntity) player.world.getBlockEntity(pos);
            return new FarmingUnitGui(farmer, new FarmingUnitContainer(syncid, player.inventory, farmer));
        }));

    }
}
