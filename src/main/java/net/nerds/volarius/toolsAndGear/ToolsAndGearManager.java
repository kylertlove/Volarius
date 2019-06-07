package net.nerds.volarius.toolsAndGear;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nerds.volarius.Volarius;
import net.nerds.volarius.toolsAndGear.netherStarTools.NetherStarAxe;
import net.nerds.volarius.toolsAndGear.netherStarTools.NetherStarSword;


public class ToolsAndGearManager {

	public static ArmorBase netherStarHelmet;
	public static ArmorBase netherStarChest;
	public static ArmorBase netherStarLeggings;
	public static ArmorBase netherStarBoots;
	public static Item NETHER_SWORD = new NetherStarSword(VolariusToolMaterials.NETHER_STAR, 5, -2.4f);
	public static Item NETHER_AXE = new NetherStarAxe(VolariusToolMaterials.NETHER_STAR, 8, -3.0F);
	public static Item NETHER_SHOVEL = new NetherStarAxe(VolariusToolMaterials.NETHER_STAR, 2, -3.0F);
	public static Item NETHER_HOE = new NetherStarAxe(VolariusToolMaterials.NETHER_STAR, 2, -2.8F);
	public static Item NETHER_PICK = new NetherStarAxe(VolariusToolMaterials.NETHER_STAR, 2, 0.0F);

	public static void init() {
		/**nether_star_sword.json
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
		Registry.register(Registry.ITEM, new Identifier(Volarius.MODID, "nether_star_sword"), NETHER_SWORD);
		Registry.register(Registry.ITEM, new Identifier(Volarius.MODID, "nether_star_axe"), NETHER_AXE);
		Registry.register(Registry.ITEM, new Identifier(Volarius.MODID, "nether_star_pick"), NETHER_PICK);
		Registry.register(Registry.ITEM, new Identifier(Volarius.MODID, "nether_star_shovel"), NETHER_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(Volarius.MODID, "nether_star_hoe"), NETHER_HOE);
	}
}
