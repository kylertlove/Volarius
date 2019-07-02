package net.nerds.volarius.resourcePlants;

import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nerds.volarius.Volarius;

public class ResourceCropItems {

    public static Item COAL_SEED;
    public static Item BONE_SEED;
    public static Item IRON_SEED;
    public static Item GOLD_SEED;
    public static Item DIAMOND_SEED;
    public static Item EMERALD_SEED;
    public static Item LAPIS_SEED;
    public static Item REDSTONE_SEED;
    public static Item OBSIDIAN_SEED;
    public static Item NETHER_STAR_SEED;
    public static Item GLOWSTONE_SEED;
    public static Item NETHER_QUARTZ_SEED;
    public static Item ENDER_PEARL_SEED;

    public static void init() {
        COAL_SEED = Registry.register(Registry.ITEM,
                new Identifier(Volarius.MODID, "coal_seed"),
                new AliasedBlockItem(ResourceCropBlocks.COAL_PLANT, getItemSettings()));
        BONE_SEED = Registry.register(Registry.ITEM,
                new Identifier(Volarius.MODID, "bone_seed"),
                new AliasedBlockItem(ResourceCropBlocks.BONE_PLANT, getItemSettings()));
        IRON_SEED = Registry.register(Registry.ITEM,
                new Identifier(Volarius.MODID, "iron_seed"),
                new AliasedBlockItem(ResourceCropBlocks.IRON_PLANT, getItemSettings()));
        GOLD_SEED = Registry.register(Registry.ITEM,
                new Identifier(Volarius.MODID, "gold_seed"),
                new AliasedBlockItem(ResourceCropBlocks.GOLD_PLANT, getItemSettings()));
        DIAMOND_SEED = Registry.register(Registry.ITEM,
                new Identifier(Volarius.MODID, "diamond_seed"),
                new AliasedBlockItem(ResourceCropBlocks.DIAMOND_PLANT, getItemSettings()));
        EMERALD_SEED = Registry.register(Registry.ITEM,
                new Identifier(Volarius.MODID, "emerald_seed"),
                new AliasedBlockItem(ResourceCropBlocks.EMERALD_PLANT, getItemSettings()));
        LAPIS_SEED = Registry.register(Registry.ITEM,
                new Identifier(Volarius.MODID, "lapis_seed"),
                new AliasedBlockItem(ResourceCropBlocks.LAPIS_PLANT, getItemSettings()));
        REDSTONE_SEED = Registry.register(Registry.ITEM,
                new Identifier(Volarius.MODID, "redstone_seed"),
                new AliasedBlockItem(ResourceCropBlocks.REDSTONE_PLANT, getItemSettings()));
        OBSIDIAN_SEED = Registry.register(Registry.ITEM,
                new Identifier(Volarius.MODID, "obsidian_seed"),
                new AliasedBlockItem(ResourceCropBlocks.OBSIDIAN_PLANT, getItemSettings()));
        NETHER_STAR_SEED = Registry.register(Registry.ITEM,
                new Identifier(Volarius.MODID, "nether_star_seed"),
                new AliasedBlockItem(ResourceCropBlocks.NETHER_STAR_PLANT, getItemSettings()));
        GLOWSTONE_SEED = Registry.register(Registry.ITEM,
                new Identifier(Volarius.MODID, "glowstone_seed"),
                new AliasedBlockItem(ResourceCropBlocks.GLOWSTONE_PLANT, getItemSettings()));
        NETHER_QUARTZ_SEED = Registry.register(Registry.ITEM,
                new Identifier(Volarius.MODID, "nether_quartz_seed"),
                new AliasedBlockItem(ResourceCropBlocks.NETHER_QUARTZ_PLANT, getItemSettings()));
        ENDER_PEARL_SEED = Registry.register(Registry.ITEM,
                new Identifier(Volarius.MODID, "ender_pearl_seed"),
                new AliasedBlockItem(ResourceCropBlocks.ENDER_PEARL_PLANT, getItemSettings()));
    }

    private static Item.Settings getItemSettings() {
        return (new Item.Settings().group(Volarius.resourceCropItemGroup).recipeRemainder(Items.WHEAT_SEEDS));
    }
}
