package net.nerds.volarius.machines;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nerds.volarius.Volarius;
import net.nerds.volarius.machines.farmer.FarmingUnitBlock;
import net.nerds.volarius.machines.fishTrap.FishTrapBlock;

public class MachineBlockManager {

	//Farming Unit Block
	public static final FarmingUnitBlock FARMING_UNIT = new FarmingUnitBlock();
	public static final FishTrapBlock FISH_TRAP = new FishTrapBlock();

	public static void init() {
		MachineBlockEntities.init();
		MachineBlockEntities.initGui();
		blockInit();
	}

	private static void blockInit() {
		Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "farming_unit"), FARMING_UNIT);
		Registry.register(Registry.ITEM,
				new Identifier(Volarius.MODID, "farming_unit"),
				new BlockItem(FARMING_UNIT, new Item.Settings().itemGroup(Volarius.resourceCropItemGroup)));

		Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "fish_trap"), FISH_TRAP);
		Registry.register(Registry.ITEM,
				new Identifier(Volarius.MODID, "fish_trap"),
				new BlockItem(FISH_TRAP, new Item.Settings().itemGroup(Volarius.resourceCropItemGroup)));
	}
}
