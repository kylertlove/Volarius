package com.nerds.volaris.utils;

import com.nerds.volaris.Volaris;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class VolarisItemGroup extends ItemGroup {

    public VolarisItemGroup() {
        super(Volaris.ID);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.NETHER_STAR);
    }
}
