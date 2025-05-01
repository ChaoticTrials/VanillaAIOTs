package de.melanx.vanillaaiots.compat.aether;

import com.aetherteam.aether.item.combat.abilities.weapon.GravititeWeapon;
import com.aetherteam.aether.item.combat.abilities.weapon.HolystoneWeapon;
import com.aetherteam.aether.item.combat.abilities.weapon.SkyrootWeapon;
import com.aetherteam.aether.item.combat.abilities.weapon.ZaniteWeapon;
import com.aetherteam.aether.item.tools.abilities.*;
import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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

    public static class SkyrootAiot extends BaseAiot implements SkyrootTool, SkyrootWeapon {

        public SkyrootAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }
    }

    public static class HolystoneAiot extends BaseAiot implements HolystoneTool, HolystoneWeapon {

        public HolystoneAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }

        @Override
        public boolean hurtEnemy(@Nonnull ItemStack stack, @Nonnull LivingEntity target, @Nonnull LivingEntity attacker) {
            this.dropAmbrosium(target, attacker);
            return super.hurtEnemy(stack, target, attacker);
        }
    }

    public static class ZaniteAiot extends BaseAiot implements ZaniteTool, ZaniteWeapon {

        public ZaniteAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }
    }

    public static class GravititeAiot extends BaseAiot implements GravititeTool, GravititeWeapon {

        public GravititeAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }

        @Nonnull
        @Override
        public InteractionResult useOn(@Nonnull UseOnContext context) {
            return !this.floatBlock(context) ? super.useOn(context) : InteractionResult.sidedSuccess(context.getLevel().isClientSide());
        }

        @Override
        public boolean hurtEnemy(@Nonnull ItemStack stack, @Nonnull LivingEntity target, @Nonnull LivingEntity attacker) {
            this.launchEntity(target, attacker);
            return super.hurtEnemy(stack, target, attacker);
        }
    }

    public static class ValkyrieAiot extends BaseAiot implements ValkyrieTool {

        public ValkyrieAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }
    }
}
