package com.nerds.volaris;

import com.nerds.volaris.utils.VolarisItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Volaris.ID)
public class Volaris {
    private static final Logger LOGGER = LogManager.getLogger();
    public static ItemGroup volarisItemGroup = new VolarisItemGroup();
    public static final String ID = "volaris";

    public Volaris() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
