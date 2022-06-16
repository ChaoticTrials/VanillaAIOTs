package de.melanx.vanillaaiots.util;

import de.melanx.vanillaaiots.VanillaAIOTs;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class ComponentUtil {

    public static MutableComponent getTooltip(String s, Object... replacements) {
        return Component.translatable("tooltip." + VanillaAIOTs.getInstance().modid + "." + s, replacements);
    }
}
