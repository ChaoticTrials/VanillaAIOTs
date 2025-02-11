package de.melanx.vanillaaiots.registration;

import com.mojang.serialization.MapCodec;
import de.melanx.vanillaaiots.config.VanillaCondition;
import net.neoforged.neoforge.common.conditions.ICondition;
import org.moddingx.libx.annotation.registration.RegisterClass;

@RegisterClass(registry = "CONDITION_CODECS")
public class ModConditionCodecs {

    public static final MapCodec<? extends ICondition> vanillaOnly = VanillaCondition.CODEC;
}
