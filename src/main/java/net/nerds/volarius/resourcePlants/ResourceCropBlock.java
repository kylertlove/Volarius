package net.nerds.volarius.resourcePlants;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class ResourceCropBlock extends BeetrootsBlock {

    private Item seedType;
    private static int luminance = 0;

    public ResourceCropBlock(Item seedType) {
        super(FabricBlockSettings
                .of(Material.PLANT)
                .breakInstantly()
                .noCollision()
                .ticksRandomly()
                .lightLevel(luminance)
                .sounds(BlockSoundGroup.CROP)
                .build());
        this.seedType = seedType;
    }

    @Environment(EnvType.CLIENT)
    @Override
    protected ItemConvertible getSeedsItem() {
        return this.seedType;
    }

    @Override
    public Identifier getDropTableId() {
        Identifier identifier = Registry.BLOCK.getId(this);
        return new Identifier(identifier.getNamespace(), "blocks/" + identifier.getPath());
    }

    @Override
    public void onScheduledTick(BlockState blockState, World world, BlockPos blockPos, Random random) {
            super.onScheduledTick(blockState, world, blockPos, random);
    }

}
