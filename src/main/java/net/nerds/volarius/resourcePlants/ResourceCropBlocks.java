package net.nerds.volarius.resourcePlants;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nerds.volarius.Volarius;

public class ResourceCropBlocks {

    public static final ResourceCropBlock COAL_PLANT =
            Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "coal_plant"), new ResourceCropBlock(ResourceCropItems.COAL_SEED));
    public static final ResourceCropBlock BONE_PLANT =
            Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "bone_plant"), new ResourceCropBlock(ResourceCropItems.BONE_SEED));
    public static final ResourceCropBlock IRON_PLANT =
            Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "iron_plant"), new ResourceCropBlock(ResourceCropItems.IRON_SEED));
    public static final ResourceCropBlock GOLD_PLANT =
            Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "gold_plant"), new ResourceCropBlock(ResourceCropItems.GOLD_SEED));
    public static final ResourceCropBlock DIAMOND_PLANT =
            Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "diamond_plant"), new ResourceCropBlock(ResourceCropItems.DIAMOND_SEED));
    public static final ResourceCropBlock EMERALD_PLANT =
            Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "emerald_plant"), new ResourceCropBlock(ResourceCropItems.EMERALD_SEED));
    public static final ResourceCropBlock LAPIS_PLANT =
            Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "lapis_plant"), new ResourceCropBlock(ResourceCropItems.LAPIS_SEED));
    public static final ResourceCropBlock REDSTONE_PLANT =
            Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "redstone_plant"), new ResourceCropBlock(ResourceCropItems.REDSTONE_SEED));
    public static final ResourceCropBlock OBSIDIAN_PLANT =
            Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "obsidian_plant"), new ResourceCropBlock(ResourceCropItems.OBSIDIAN_SEED));
    public static final ResourceCropBlock NETHER_STAR_PLANT =
            Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "nether_star_plant"), new ResourceCropBlock(ResourceCropItems.NETHER_STAR_SEED));
    public static final ResourceCropBlock GLOWSTONE_PLANT =
            Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "glowstone_plant"), new ResourceCropBlock(ResourceCropItems.GLOWSTONE_SEED));
    public static final ResourceCropBlock NETHER_QUARTZ_PLANT =
            Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "nether_quartz_plant"), new ResourceCropBlock(ResourceCropItems.NETHER_QUARTZ_SEED));


    public static void init() {
    }
}
