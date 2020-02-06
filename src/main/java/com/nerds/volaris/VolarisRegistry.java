package com.nerds.volaris;

import com.nerds.volaris.Food.FoodManager;
import com.nerds.volaris.Gear.Emerald.EmeraldGear;
import com.nerds.volaris.Gear.NetherStar.NetherStarGear;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class VolarisRegistry {

    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {

    }

    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> itemRegisterEvent) {

        FoodManager.init().forEach(item -> itemRegisterEvent.getRegistry().register(item));

        NetherStarGear.init().forEach(item -> itemRegisterEvent.getRegistry().register(item));

        EmeraldGear.init().forEach(item -> itemRegisterEvent.getRegistry().register(item));
    }
}
