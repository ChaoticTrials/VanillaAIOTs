package de.melanx.vanillaaiots.compat.aether;

import com.google.common.collect.Multimap;
import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import teamrazor.deepaether.item.gear.skyjade.SkyjadeTool;
import teamrazor.deepaether.item.gear.skyjade.SkyjadeWeapon;

public class DeepAetherAIOTs {

    public static Item getDeepAetherAiot(float attackDamageModifier, float attackSpeedModifier, ToolMaterials tier, Item.Properties properties) {
        return switch (tier) {
            case SKYJADE -> new DeepAetherAIOTs.SkyjadeAiot(attackDamageModifier, attackSpeedModifier, tier, properties);
            case STRATUS -> new DeepAetherAIOTs.StratusAiot(attackDamageModifier, attackSpeedModifier, tier, properties);
            default -> throw new IllegalArgumentException("Unknown tier: " + tier);
        };
    }

    public static class SkyjadeAiot extends BaseAiot implements SkyjadeTool, SkyjadeWeapon {

        public SkyjadeAiot(float attackDamageModifier, float attackSpeedModifier, Tier tier, Properties properties) {
            super(attackDamageModifier, attackSpeedModifier, tier, properties);
        }

        @Override
        public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
            return this.increaseDamage(super.getAttributeModifiers(slot, stack), stack, slot);
        }
    }

    public static class StratusAiot extends AetherAIOTs.GravititeAiot {

        public StratusAiot(float attackDamageModifier, float attackSpeedModifier, Tier tier, Properties properties) {
            super(attackDamageModifier, attackSpeedModifier, tier, properties);
        }
    }
}
