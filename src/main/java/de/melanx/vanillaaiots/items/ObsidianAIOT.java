package de.melanx.vanillaaiots.items;

import de.melanx.morevanillalib.api.IConfigurableTier;
import de.melanx.morevanillalib.api.aiot.AIOTBase;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;

public class ObsidianAIOT extends AIOTBase {

    public ObsidianAIOT(IConfigurableTier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        if (state.is(Tags.Blocks.OBSIDIAN)) {
            int efficiencyLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, stack);
            return 5.0F * efficiencyLevel + 1;
        }

        return super.getDestroySpeed(stack, state);
    }
}
