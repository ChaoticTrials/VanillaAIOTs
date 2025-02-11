package de.melanx.vanillaaiots.registration;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import org.moddingx.libx.annotation.registration.RegisterClass;

import java.util.function.UnaryOperator;

@RegisterClass(registry = "DATA_COMPONENT_TYPE")
public class ModDataComponentTypes {

    public static final DataComponentType<Boolean> hoeMode = ModDataComponentTypes.builder(builder -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL));

    private static <T> DataComponentType<T> builder(UnaryOperator<DataComponentType.Builder<T>> builder) {
        return builder.apply(new DataComponentType.Builder<>()).build();
    }
}
