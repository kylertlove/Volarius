package net.nerds.volarius.toolsAndGear.netherStarTools;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.nerds.volarius.Volarius;

public class NetherStarSword extends SwordItem {

	public NetherStarSword(ToolMaterial toolMaterial, int dmgMultiplier, float coolDown) {
		super(toolMaterial, dmgMultiplier, coolDown, new Item.Settings().group(Volarius.resourceCropItemGroup));
	}
}
