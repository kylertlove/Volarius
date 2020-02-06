package com.nerds.volaris.Gear.Emerald;

import com.nerds.volaris.Volaris;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import java.util.ArrayList;
import java.util.List;

public class EmeraldGear {

	private static EmeraldTier toolTier = new EmeraldTier();
	public static EmeraldArmorTier armorTier = new EmeraldArmorTier();

	public static List<Item> init() {
		List<Item> emeraldGear = new ArrayList<>();

		//Sword
		Item emeraldSword = new SwordItem(toolTier, 4, -2.4F, getProps())
				.setRegistryName(Volaris.ID, "emerald_sword");
		emeraldGear.add(emeraldSword);

		//Pick
		Item emeraldPick = new PickaxeItem(toolTier, 1, -2.8F, getProps())
				.setRegistryName(Volaris.ID, "emerald_pick");
		emeraldGear.add(emeraldPick);

		//Shovel
		Item emeraldShovel = new ShovelItem(toolTier, 1.5F, -3.0F, getProps())
				.setRegistryName(Volaris.ID, "emerald_shovel");
		emeraldGear.add(emeraldShovel);

		//Axe
		Item emeraldAxe = new AxeItem(toolTier, 5.0F, -3.0F, getProps())
				.setRegistryName(Volaris.ID, "emerald_axe");
		emeraldGear.add(emeraldAxe);

		//Hoe
		Item emeraldHoe = new HoeItem(toolTier, 0.0F, getProps())
				.setRegistryName(Volaris.ID, "emerald_hoe");
		emeraldGear.add(emeraldHoe);

		//helmet
		Item emeraldHelmet = new ArmorItem(armorTier, EquipmentSlotType.HEAD, getProps())
				.setRegistryName(Volaris.ID, "emerald_helmet");
		emeraldGear.add(emeraldHelmet);

		//chestplate
		Item emeraldChest = new ArmorItem(armorTier, EquipmentSlotType.CHEST, getProps())
				.setRegistryName(Volaris.ID, "emerald_chestplate");
		emeraldGear.add(emeraldChest);

		//leggings
		Item emeraldLegs = new ArmorItem(armorTier, EquipmentSlotType.LEGS, getProps())
				.setRegistryName(Volaris.ID, "emerald_leggings");
		emeraldGear.add(emeraldLegs);

		//boots
		Item emeraldBoots = new ArmorItem(armorTier, EquipmentSlotType.FEET, getProps())
				.setRegistryName(Volaris.ID, "emerald_boots");
		emeraldGear.add(emeraldLegs);

		return emeraldGear;
	}

	private static Item.Properties getProps() {
		return new Item.Properties().group(Volaris.volarisItemGroup);
	}


	public static class EmeraldTier implements IItemTier {

		@Override
		public int getMaxUses() {
			return 2000;
		}

		@Override
		public float getEfficiency() {
			return 7.0F;
		}

		@Override
		public float getAttackDamage() {
			return 7.0F;
		}

		@Override
		public int getHarvestLevel() {
			return 3;
		}

		@Override
		public int getEnchantability() {
			return 25;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return Ingredient.fromItems(Items.EMERALD);
		}
	}

	public static class EmeraldArmorTier implements IArmorMaterial {

		private static final int[] dmg_array = new int[]{13, 15, 16, 11};
		private static final int[] emrald_dmg = new int[]{4, 8, 10, 4};

		@Override
		public int getDurability(EquipmentSlotType equipmentSlotType) {
			return dmg_array[equipmentSlotType.getIndex()] * 40;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
			return emrald_dmg[equipmentSlotType.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return 27;
		}

		@Override
		public SoundEvent getSoundEvent() {
			return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return Ingredient.fromItems(Items.EMERALD);
		}

		@Override
		public String getName() {
			return "emerald";
		}

		@Override
		public float getToughness() {
			return 2.0F;
		}
	}

}
