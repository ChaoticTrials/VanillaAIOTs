package de.melanx.vanillaaiots.compat.aether;

import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import io.github.razordevs.deep_aether.item.gear.skyjade.SkyjadeTool;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class DeepAetherAIOTs {

    public static Item getDeepAetherAiot(ToolMaterials tier, Item.Properties properties, ItemAttributeModifiers attributes) {
        return switch(tier) {
            case SKYJADE -> new DeepAetherAIOTs.SkyjadeAiot(tier, properties, attributes);
            case STRATUS -> new DeepAetherAIOTs.StratusAiot(tier, properties, attributes);
            default -> throw new IllegalArgumentException("Unknown tier: " + tier);
        };
    }

    public static class SkyjadeAiot extends BaseAiot implements SkyjadeTool {

        public SkyjadeAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }
    }

    public static class StratusAiot extends AetherAIOTs.GravititeAiot {

        public StratusAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }
    }
}
