package net.nerds.volarius.toolsAndGear;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.nerds.volarius.Volarius;

public class ArmorBase extends ArmorItem {

	public ArmorBase(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlot) {
		super(armorMaterial, equipmentSlot, new Item.Settings().group(Volarius.resourceCropItemGroup));
	}
}
