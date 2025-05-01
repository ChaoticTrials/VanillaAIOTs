package de.melanx.vanillaaiots.compat.aether;

import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import io.github.razordevs.deep_aether.item.gear.skyjade.SkyjadeTool;
import io.github.razordevs.deep_aether.item.gear.skyjade.SkyjadeWeapon;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class DeepAetherAIOTs {

    public static Item getDeepAetherAiot(ToolMaterials tier, Item.Properties properties, ItemAttributeModifiers attributes) {
        return switch(tier) {
            case SKYJADE -> new DeepAetherAIOTs.SkyjadeAiot(tier, properties, attributes);
            case STRATUS -> new DeepAetherAIOTs.StratusAiot(tier, properties, attributes);
            default -> throw new IllegalArgumentException("Unknown tier: " + tier);
        };
    }

    public static class SkyjadeAiot extends BaseAiot implements SkyjadeTool, SkyjadeWeapon {

        public SkyjadeAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }

        @Override
        public boolean canAttackBlock(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull Player player) {
            this.disableSound(player, pos);
            return super.canAttackBlock(state, level, pos, player);
        }
    }

    public static class StratusAiot extends AetherAIOTs.GravititeAiot {

        public StratusAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }
    }
}
