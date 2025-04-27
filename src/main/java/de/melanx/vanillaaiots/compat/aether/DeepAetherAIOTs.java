package de.melanx.vanillaaiots.compat.aether;

import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import teamrazor.deepaether.item.gear.skyjade.SkyjadeTool;

public class DeepAetherAIOTs {

    public static Item getDeepAetherAiot(float attackDamageModifier, float attackSpeedModifier, ToolMaterials tier, Item.Properties properties) {
        return switch (tier) {
            case SKYJADE -> new DeepAetherAIOTs.SkyjadeAiot(attackDamageModifier, attackSpeedModifier, tier, properties);
            case STRATUS -> new DeepAetherAIOTs.StratusAiot(attackDamageModifier, attackSpeedModifier, tier, properties);
            default -> throw new IllegalArgumentException("Unknown tier: " + tier);
        };
    }

    public static class SkyjadeAiot extends BaseAiot implements SkyjadeTool {

        public SkyjadeAiot(float attackDamageModifier, float attackSpeedModifier, Tier tier, Properties properties) {
            super(attackDamageModifier, attackSpeedModifier, tier, properties);
        }
    }

    public static class StratusAiot extends AetherAIOTs.GravititeAiot {

        public StratusAiot(float attackDamageModifier, float attackSpeedModifier, Tier tier, Properties properties) {
            super(attackDamageModifier, attackSpeedModifier, tier, properties);
        }
    }
}
