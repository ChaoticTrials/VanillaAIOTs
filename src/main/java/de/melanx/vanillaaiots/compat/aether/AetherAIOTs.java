package de.melanx.vanillaaiots.compat.aether;

import com.aetherteam.aether.item.tools.abilities.*;
import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;

import javax.annotation.Nonnull;

public class AetherAIOTs {

    public static Item getAetherAiot(float attackDamageModifier, float attackSpeedModifier, ToolMaterials tier, Item.Properties properties) {
        return switch ( tier ) {
            case SKYROOT -> new AetherAIOTs.SkyrootAiot(attackDamageModifier, attackSpeedModifier, tier, properties);
            case HOLYSTONE -> new AetherAIOTs.HolystoneAiot(attackDamageModifier, attackSpeedModifier, tier, properties);
            case ZANITE -> new AetherAIOTs.ZaniteAiot(attackDamageModifier, attackSpeedModifier, tier, properties);
            case GRAVITITE -> new AetherAIOTs.GravititeAiot(attackDamageModifier, attackSpeedModifier, tier, properties);
            case VALKYRIE -> new AetherAIOTs.ValkyrieAiot(attackDamageModifier, attackSpeedModifier, tier, properties);
            default -> throw new IllegalArgumentException("Unknown tier: " + tier);
        };
    }

    public static class SkyrootAiot extends BaseAiot implements SkyrootTool {

        public SkyrootAiot(float attackDamageModifier, float attackSpeedModifier, Tier tier, Properties properties) {
            super(attackDamageModifier, attackSpeedModifier, tier, properties);
        }
    }

    public static class HolystoneAiot extends BaseAiot implements HolystoneTool {

        public HolystoneAiot(float attackDamageModifier, float attackSpeedModifier, Tier tier, Properties properties) {
            super(attackDamageModifier, attackSpeedModifier, tier, properties);
        }
    }

    public static class ZaniteAiot extends BaseAiot implements ZaniteTool {

        public ZaniteAiot(float attackDamageModifier, float attackSpeedModifier, Tier tier, Properties properties) {
            super(attackDamageModifier, attackSpeedModifier, tier, properties);
        }
    }

    public static class GravititeAiot extends BaseAiot implements GravititeTool {

        public GravititeAiot(float attackDamageModifier, float attackSpeedModifier, Tier tier, Properties properties) {
            super(attackDamageModifier, attackSpeedModifier, tier, properties);
        }

        @Nonnull
        @Override
        public InteractionResult useOn(@Nonnull UseOnContext context) {
            return !this.floatBlock(context) ? super.useOn(context) : InteractionResult.sidedSuccess(context.getLevel().isClientSide());
        }
    }

    public static class ValkyrieAiot extends BaseAiot implements ValkyrieTool {

        public ValkyrieAiot(float attackDamageModifier, float attackSpeedModifier, Tier tier, Properties properties) {
            super(attackDamageModifier, attackSpeedModifier, tier, properties);
        }
    }
}
