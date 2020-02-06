package com.nerds.volaris.Gear.NetherStar;

import com.nerds.volaris.Volaris;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import java.util.ArrayList;
import java.util.List;

public class NetherStarGear {

	private static NetherStarTier toolTier = new NetherStarTier();
	public static NetherStarArmorTier armorTier = new NetherStarArmorTier();

	public static List<Item> init() {
		List<Item> netherStarGear = new ArrayList<>();

		//Sword
		Item netherStarSword = new SwordItem(toolTier, 5, -2.4F, getProps())
				.setRegistryName(Volaris.ID, "nether_star_sword");
		netherStarGear.add(netherStarSword);

		//Pick
		Item netherStarPick = new PickaxeItem(toolTier, 1, -2.8F, getProps())
				.setRegistryName(Volaris.ID, "nether_star_pick");
		netherStarGear.add(netherStarPick);

		//Shovel
		Item netherStarShovel = new ShovelItem(toolTier, 1.5F, -3.0F, getProps())
				.setRegistryName(Volaris.ID, "nether_star_shovel");
		netherStarGear.add(netherStarShovel);

		//Axe
		Item netherStarAxe = new AxeItem(toolTier, 6.0F, -3.0F, getProps())
				.setRegistryName(Volaris.ID, "nether_star_axe");
		netherStarGear.add(netherStarAxe);

		//Hoe
		Item netherStarHoe = new HoeItem(toolTier, 0.0F, getProps())
				.setRegistryName(Volaris.ID, "nether_star_hoe");
		netherStarGear.add(netherStarHoe);

		//helmet
		Item netherStarHelmet = new ArmorItem(armorTier, EquipmentSlotType.HEAD, getProps())
				.setRegistryName(Volaris.ID, "nether_star_helmet");
		netherStarGear.add(netherStarHelmet);

		//chestplate
		Item netherStarChest = new ArmorItem(armorTier, EquipmentSlotType.CHEST, getProps())
				.setRegistryName(Volaris.ID, "nether_star_chestplate");
		netherStarGear.add(netherStarChest);

		//leggings
		Item netherStarLegs = new ArmorItem(armorTier, EquipmentSlotType.LEGS, getProps())
				.setRegistryName(Volaris.ID, "nether_star_leggings");
		netherStarGear.add(netherStarLegs);

		//boots
		Item netherStarBoots = new ArmorItem(armorTier, EquipmentSlotType.FEET, getProps())
				.setRegistryName(Volaris.ID, "nether_star_boots");
		netherStarGear.add(netherStarLegs);

		return netherStarGear;
	}

	private static Item.Properties getProps() {
		return new Item.Properties().group(Volaris.volarisItemGroup);
	}


	public static class NetherStarTier implements IItemTier {

		@Override
		public int getMaxUses() {
			return 4000;
		}

		@Override
		public float getEfficiency() {
			return 9.0F;
		}

		@Override
		public float getAttackDamage() {
			return 8.0F;
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
			return Ingredient.fromItems(Items.NETHER_STAR);
		}
	}
	
	public static class NetherStarArmorTier implements IArmorMaterial {

		private static final int[] dmg_array = new int[]{13, 15, 16, 11};
		private static final int[] nether_star_dmg = new int[]{6, 12, 16, 6};

		@Override
		public int getDurability(EquipmentSlotType equipmentSlotType) {
			return dmg_array[equipmentSlotType.getIndex()] * 75;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
			return nether_star_dmg[equipmentSlotType.getIndex()];
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
			return Ingredient.fromItems(Items.NETHER_STAR);
		}

		@Override
		public String getName() {
			return "nether_star";
		}

		@Override
		public float getToughness() {
			return 3.0F;
		}
	}

}
