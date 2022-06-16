package de.melanx.vanillaaiots.config;

import com.google.gson.JsonObject;
import de.melanx.vanillaaiots.VanillaAIOTs;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class VanillaCondition implements ICondition {

    public static final ResourceLocation KEY = new ResourceLocation(VanillaAIOTs.getInstance().modid, "vanilla_only");

    @Override
    public ResourceLocation getID() {
        return KEY;
    }

    @Override
    public boolean test(IContext context) {
        return !ModConfig.vanillaOnly;
    }

    public static final IConditionSerializer<VanillaCondition> SERIALIZER = new IConditionSerializer<>() {

        @Override
        public void write(JsonObject json, VanillaCondition value) {
            // nothing
        }

        @Override
        public VanillaCondition read(JsonObject json) {
            return new VanillaCondition();
        }

        @Override
        public ResourceLocation getID() {
            return KEY;
        }
    };
}
