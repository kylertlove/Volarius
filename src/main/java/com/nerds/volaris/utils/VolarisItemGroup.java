package com.nerds.volaris.utils;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class VolarisItemGroup extends ItemGroup {

    public VolarisItemGroup() {
        super("assets/volaris");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.ACACIA_BOAT);
    }
}
