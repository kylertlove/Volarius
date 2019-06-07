package net.nerds.volarius.toolsAndGear;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum  VolariusToolMaterials implements ToolMaterial {

	NETHER_STAR("nether_star", 3, 10610, 13.0F, 8.0F, 30, () -> {
		return Ingredient.ofItems(Items.NETHER_STAR);
	});

	private final int miningLevel;
	private final int durability;
	private final float blockBreakSpeed;
	private final float attackDamage;
	private final int enchantability;
	private final Lazy<Ingredient> repairIngredient;
	private final String name;

	VolariusToolMaterials(String name, int miningLevel, int durability, float blockBreakSpeed,
						  float attackDamage, int enchantability, Supplier<Ingredient> ingredientSupplier) {
		this.name = name;
		this.miningLevel = miningLevel;
		this.durability = durability;
		this.blockBreakSpeed = blockBreakSpeed;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairIngredient = new Lazy(ingredientSupplier);
	}

	@Override
	public int getDurability() {
		return this.durability;
	}

	@Override
	public float getBlockBreakingSpeed() {
		return this.blockBreakSpeed;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public int getMiningLevel() {
		return this.miningLevel;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return (Ingredient)this.repairIngredient.get();
	}

	@Environment(EnvType.CLIENT)
	public String getName(){
		return this.name;
	}
}
