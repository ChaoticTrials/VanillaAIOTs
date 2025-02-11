package de.melanx.vanillaaiots.config;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.conditions.ICondition;

import javax.annotation.Nonnull;

public class VanillaCondition implements ICondition {

    public static MapCodec<VanillaCondition> CODEC = MapCodec.unit(VanillaCondition::new);

    @Override
    public boolean test(@Nonnull IContext context) {
        return !ModConfig.vanillaOnly;
    }

    @Nonnull
    @Override
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
    }
}
