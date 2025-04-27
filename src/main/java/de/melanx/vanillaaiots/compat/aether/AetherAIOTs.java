package de.melanx.vanillaaiots.compat.aether;

import com.aetherteam.aether.item.tools.abilities.*;
import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.context.UseOnContext;

import javax.annotation.Nonnull;

public class AetherAIOTs {

    public static Item getAetherAiot(ToolMaterials tier, Item.Properties properties, ItemAttributeModifiers attributes) {
        return switch(tier) {
            case SKYROOT -> new AetherAIOTs.SkyrootAiot(tier, properties, attributes);
            case HOLYSTONE -> new AetherAIOTs.HolystoneAiot(tier, properties, attributes);
            case ZANITE -> new AetherAIOTs.ZaniteAiot(tier, properties, attributes);
            case GRAVITITE -> new AetherAIOTs.GravititeAiot(tier, properties, attributes);
            case VALKYRIE -> new AetherAIOTs.ValkyrieAiot(tier, properties, attributes);
            default -> throw new IllegalArgumentException("Unknown tier: " + tier);
        };
    }

    public static class SkyrootAiot extends BaseAiot implements SkyrootTool {

        public SkyrootAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }
    }

    public static class HolystoneAiot extends BaseAiot implements HolystoneTool {

        public HolystoneAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }
    }

    public static class ZaniteAiot extends BaseAiot implements ZaniteTool {

        public ZaniteAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }
    }

    public static class GravititeAiot extends BaseAiot implements GravititeTool {

        public GravititeAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }

        @Nonnull
        @Override
        public InteractionResult useOn(@Nonnull UseOnContext context) {
            return !this.floatBlock(context) ? super.useOn(context) : InteractionResult.sidedSuccess(context.getLevel().isClientSide());
        }
    }

    public static class ValkyrieAiot extends BaseAiot implements ValkyrieTool {

        public ValkyrieAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }
    }
}
