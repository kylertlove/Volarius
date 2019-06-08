package net.nerds.volarius.toolsAndGear.netherStarTools;

import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.nerds.volarius.Volarius;

public class NetherStarShovel extends ShovelItem {

	public NetherStarShovel(ToolMaterial toolMaterial, int dmgModifier, float attackSpeed) {
		super(toolMaterial, dmgModifier, attackSpeed, new Item.Settings().itemGroup(Volarius.resourceCropItemGroup));
	}

}
