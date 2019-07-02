package net.nerds.volarius.machines;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nerds.volarius.Volarius;
import net.nerds.volarius.machines.farmer.FarmingUnitBlock;

public class MachineBlockManager {

	//Farming Unit Block
	public static final FarmingUnitBlock FARMING_UNIT = new FarmingUnitBlock();

	public static void init() {
		MachineBlockEntities.init();
		MachineBlockEntities.initGui();
		blockInit();
	}

	private static void blockInit() {
		Registry.register(Registry.BLOCK, new Identifier(Volarius.MODID, "farming_unit"), FARMING_UNIT);
		Registry.register(Registry.ITEM,
				new Identifier(Volarius.MODID, "farming_unit"),
				new BlockItem(FARMING_UNIT, new Item.Settings().group(Volarius.resourceCropItemGroup)));

	}
}
