package net.nerds.volarius.toolsAndGear.netherStarTools;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.nerds.volarius.Volarius;

public class NetherStarPick extends PickaxeItem {
	public NetherStarPick(ToolMaterial toolMaterial, int dmgModifier, float attackSpeed) {
		super(toolMaterial, dmgModifier, attackSpeed, new Item.Settings().group(Volarius.resourceCropItemGroup));
	}
}
