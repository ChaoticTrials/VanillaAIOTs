package de.melanx.vanillaaiots.util;

import de.melanx.vanillaaiots.VanillaAIOTs;
import net.minecraft.network.chat.TranslatableComponent;

public class ComponentUtil {

    public static TranslatableComponent getTooltip(String s, Object... replacements) {
        return new TranslatableComponent("tooltip." + VanillaAIOTs.getInstance().modid + "." + s, replacements);
    }
}
