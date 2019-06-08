package net.nerds.volarius.toolsAndGear;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum VolariusArmorMaterials implements ArmorMaterial {
	NETHER_STAR_ARMOR_MATERIAL("nether_star_material", new int[]{7, 10, 12, 7}, new int[]{1000, 1300, 1200, 1100}, 30, 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> {
		return Ingredient.ofItems(Items.NETHER_STAR);
	});

	private String name;
	private int[] protectionAmounts;
	private int[] durability;
	private int enchantability;
	private SoundEvent equipSound;
	private float toughness;
	private Lazy<Ingredient> repairIngredient;

	VolariusArmorMaterials(String name, int[] protectionAmount, int[] durability, int enchantability, float toughness, SoundEvent soundEvent, Supplier<Ingredient> ingredientSupplier) {
		this.name = name;
		this.protectionAmounts = protectionAmount;
		this.durability = durability;
		this.enchantability = enchantability;
		this.toughness = toughness;
		this.equipSound = soundEvent;
		this.repairIngredient = new Lazy(ingredientSupplier);
	}

	@Override
	public int getDurability(EquipmentSlot equipmentSlot) {
		return durability[equipmentSlot.getEntitySlotId()] * 10;
	}

	@Override
	public int getProtectionAmount(EquipmentSlot equipmentSlot) {
		return protectionAmounts[equipmentSlot.getEntitySlotId()];
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return repairIngredient.get();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getToughness() {
		return toughness;
	}
}
