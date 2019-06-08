package net.nerds.volarius.toolsAndGear;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nerds.volarius.Volarius;
import net.nerds.volarius.toolsAndGear.netherStarTools.*;

public class ToolsAndGearManager {

	private static ArmorBase netherStarHelmet;
	private static ArmorBase netherStarChest;
	private static ArmorBase netherStarLeggings;
	private static ArmorBase netherStarBoots;
	private static Item netherStarSword = new NetherStarSword(VolariusToolMaterials.NETHER_STAR, 9, -2.4f);
	private static Item netherStarAxe = new NetherStarAxe(VolariusToolMaterials.NETHER_STAR, 10, -3.0F);
	private static Item netherStarShovel = new NetherStarShovel(VolariusToolMaterials.NETHER_STAR, 3, -3.0F);
	private static Item netherStarHoe = new NetherStarHoe(VolariusToolMaterials.NETHER_STAR, 3, 0.0f);
	private static Item netherStarPick = new NetherStarPick(VolariusToolMaterials.NETHER_STAR, 3, -2.8F);

	public static void init() {
		/**
		 * Armor
		 */
		netherStarHelmet = Registry.register(Registry.ITEM,
				new Identifier(Volarius.MODID, "nether_star_helmet"),
				new ArmorBase(VolariusArmorMaterials.NETHER_STAR_ARMOR_MATERIAL, EquipmentSlot.HEAD));
		netherStarChest = Registry.register(Registry.ITEM,
				new Identifier(Volarius.MODID, "nether_star_chest"),
				new ArmorBase(VolariusArmorMaterials.NETHER_STAR_ARMOR_MATERIAL, EquipmentSlot.CHEST));
		netherStarLeggings = Registry.register(Registry.ITEM,
				new Identifier(Volarius.MODID, "nether_star_leggings"),
				new ArmorBase(VolariusArmorMaterials.NETHER_STAR_ARMOR_MATERIAL, EquipmentSlot.LEGS));
		netherStarBoots = Registry.register(Registry.ITEM,
				new Identifier(Volarius.MODID, "nether_star_boots"),
				new ArmorBase(VolariusArmorMaterials.NETHER_STAR_ARMOR_MATERIAL, EquipmentSlot.FEET));

		/**
		 * Tools
		 */
		Registry.register(Registry.ITEM, new Identifier(Volarius.MODID, "nether_star_sword"), netherStarSword);
		Registry.register(Registry.ITEM, new Identifier(Volarius.MODID, "nether_star_axe"), netherStarAxe);
		Registry.register(Registry.ITEM, new Identifier(Volarius.MODID, "nether_star_pick"), netherStarPick);
		Registry.register(Registry.ITEM, new Identifier(Volarius.MODID, "nether_star_shovel"), netherStarShovel);
		Registry.register(Registry.ITEM, new Identifier(Volarius.MODID, "nether_star_hoe"), netherStarHoe);
	}
}
