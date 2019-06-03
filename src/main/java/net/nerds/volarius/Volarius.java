package net.nerds.volarius;

import net.fabricmc.api.ModInitializer;
import net.nerds.volarius.resourcePlants.ResourcePlantManager;

public class Volarius implements ModInitializer {

    public static final String MODID = "volarius";

    @Override
    public void onInitialize() {
       ResourcePlantManager.init();
    }
}
