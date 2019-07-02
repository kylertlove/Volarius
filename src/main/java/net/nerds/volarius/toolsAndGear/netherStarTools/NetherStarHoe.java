package net.nerds.volarius.toolsAndGear.netherStarTools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.nerds.volarius.Volarius;

public class NetherStarHoe extends HoeItem {
	public NetherStarHoe(ToolMaterial toolMaterial, int dmgModifier, float attackSpeed) {
		super(toolMaterial, attackSpeed, new Item.Settings().group(Volarius.resourceCropItemGroup));
	}
}
