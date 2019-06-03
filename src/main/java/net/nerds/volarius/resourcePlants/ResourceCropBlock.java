package net.nerds.volarius.resourcePlants;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ResourceCropBlock extends BeetrootsBlock {

    private Item SeedType;

    public ResourceCropBlock(Item seedType) {
        super(FabricBlockSettings
                .of(Material.PLANT)
                .breakInstantly()
                .noCollision()
                .ticksRandomly()
                .sounds(BlockSoundGroup.CROP)
                .build());
        this.SeedType = seedType;
    }

    @Environment(EnvType.CLIENT)
    @Override
    protected ItemConvertible getSeedsItem() {
        System.out.println("Getting a new Coal Seed");
        return this.SeedType;
    }

    @Override
    public Identifier getDropTableId() {
        Identifier identifier = Registry.BLOCK.getId(this);
        return new Identifier(identifier.getNamespace(), "blocks/" + identifier.getPath());
    }
}
