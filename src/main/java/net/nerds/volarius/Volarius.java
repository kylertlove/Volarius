package net.nerds.volarius;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.nerds.volarius.resourcePlants.ResourceCropItems;
import net.nerds.volarius.resourcePlants.ResourcePlantManager;

public class Volarius implements ModInitializer {

    public static final String MODID = "volarius";
    public static ItemGroup modItemGroup = FabricItemGroupBuilder
            .build(new Identifier(MODID, MODID), () -> new ItemStack(ResourceCropItems.NETHER_STAR_SEED));

    @Override
    public void onInitialize() {
       ResourcePlantManager.init();
    }
}
