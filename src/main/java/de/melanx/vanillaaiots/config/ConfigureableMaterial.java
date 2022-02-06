package de.melanx.vanillaaiots.config;

import net.minecraft.world.item.Tier;

public record ConfigureableMaterial(float speed, float attackDamageBonus, int harvestLevel, int enchantmentValue) {

    public static ConfigureableMaterial of(Tier tier) {
        //noinspection deprecation
        return new ConfigureableMaterial(tier.getSpeed(), tier.getAttackDamageBonus(), tier.getLevel(), tier.getEnchantmentValue());
    }
}
