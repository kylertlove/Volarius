package net.nerds.volarius.resourcePlants.farmer;


import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nerds.volarius.resourcePlants.ResourceCropBlockEntities;

public class FarmingUnit extends Block implements BlockEntityProvider {

    public FarmingUnit() {
        super(FabricBlockSettings.of(Material.METAL).build());
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new FarmingUnitBlockEntity();
    }

    @Override
    public boolean activate(BlockState state, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (!world.isClient) {
            ContainerProviderRegistry.INSTANCE.openContainer(ResourceCropBlockEntities.FARMER_CONTAINER, player, buf -> buf.writeBlockPos(blockPos));
        }
        return true;
    }

    @Override
    public BlockRenderType getRenderType(BlockState var1) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onBlockRemoved(BlockState blockState_1, World world_1, BlockPos blockPos_1, BlockState blockState_2, boolean boolean_1) {
        if (blockState_1.getBlock() != blockState_2.getBlock()) {
            super.onBlockRemoved(blockState_1, world_1, blockPos_1, blockState_2, boolean_1);
            world_1.removeBlockEntity(blockPos_1);
        }
    }

    @Override
    public boolean onBlockAction(BlockState blockState_1, World world_1, BlockPos blockPos_1, int int_1, int int_2) {
        super.onBlockAction(blockState_1, world_1, blockPos_1, int_1, int_2);
        BlockEntity blockEntity_1 = world_1.getBlockEntity(blockPos_1);
        return blockEntity_1 == null ? false : blockEntity_1.onBlockAction(int_1, int_2);
    }

}
