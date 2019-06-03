package net.nerds.volarius.resourcePlants;

import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nerds.volarius.Volarius;

public class ResourceCropItems {

    public static Item COAL_SEED;

    public static void init() {
        COAL_SEED = Registry.register(Registry.ITEM,
                        new Identifier(Volarius.MODID, "coal_seed"),
                        new AliasedBlockItem(ResourceCropBlocks.COAL_PLANT, (new Item.Settings().itemGroup(ItemGroup.MATERIALS))));
    }
}
