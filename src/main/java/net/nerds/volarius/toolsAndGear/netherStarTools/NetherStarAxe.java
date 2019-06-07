package net.nerds.volarius.toolsAndGear.netherStarTools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.nerds.volarius.Volarius;

public class NetherStarAxe extends AxeItem {
	public NetherStarAxe(ToolMaterial toolMaterial, int dmgModifier, float attackSpeed) {
		super(toolMaterial, dmgModifier, attackSpeed, new Item.Settings().itemGroup(Volarius.resourceCropItemGroup));
	}
}
