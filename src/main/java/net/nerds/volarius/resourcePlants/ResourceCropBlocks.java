package net.nerds.volarius.resourcePlants;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nerds.volarius.Volarius;

public class ResourceCropBlocks {

    public static final ResourceCropBlock COAL_PLANT =
            Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "coal_plant"), new ResourceCropBlock(ResourceCropItems.COAL_SEED));

    public static void init() {

    }
}
