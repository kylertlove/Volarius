package net.nerds.volarius.machines;

import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nerds.volarius.Volarius;
import net.nerds.volarius.machines.farmer.FarmingUnitBlockEntity;
import net.nerds.volarius.machines.farmer.FarmingUnitContainer;
import net.nerds.volarius.resourcePlants.ResourceCropBlocks;

import java.util.function.Supplier;

public class MachineBlockEntities {


    public static BlockEntityType FARMING_UNIT_ENTITY;
    public static final Identifier FARMER_CONTAINER = new Identifier(Volarius.MODID, "farmer_container");

    public static void init(){
        FARMING_UNIT_ENTITY = registerTile(new Identifier(Volarius.MODID, "farming_unit"), FarmingUnitBlockEntity.class, MachineBlockManager.FARMING_UNIT);
    }

    public static void initGui() {
        ContainerProviderRegistry.INSTANCE.registerFactory(FARMER_CONTAINER, (syncid, identifier, player, buf) -> {
            return new FarmingUnitContainer(syncid, player.inventory, (FarmingUnitBlockEntity) player.world.getBlockEntity(buf.readBlockPos()));
        });
    }


    public static BlockEntityType registerTile(Identifier identifier, Class<? extends BlockEntity> blockEntity, Block... blocks) {
        return Registry.register(Registry.BLOCK_ENTITY, identifier, BlockEntityType.Builder.create((Supplier<BlockEntity>) () -> {
            try {
                return blockEntity.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            return null;
        }, blocks).build(null));
    }
}
