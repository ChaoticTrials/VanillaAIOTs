package de.melanx.vanillaaiots.compat;

import net.minecraft.world.item.Tier;
import net.minecraftforge.fml.ModList;
import net.onvoid.copperized.common.CopperizedTiers;

public class CopperizedCompat {

    public static final String MODID = "copperized";

    public static Tier getCopper() {
        return CopperizedTiers.COPPER;
    }

    public static boolean isCopperizedLoaded() {
        return ModList.get().isLoaded(MODID);
    }
}
