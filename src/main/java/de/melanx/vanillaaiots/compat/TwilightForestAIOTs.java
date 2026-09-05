package de.melanx.vanillaaiots.compat;

import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import org.moddingx.libx.creativetab.CreativeTabItemProvider;
import org.moddingx.libx.creativetab.CreativeTabX;

import java.util.stream.Stream;

public class TwilightForestAIOTs {

    public static Item getTwilightForestAiot(ToolMaterials tier, Item.Properties properties, ItemAttributeModifiers attributes) {
        return switch(tier) {
            case IRONWOOD -> new TwilightForestAIOTs.IronwoodAiot(tier, properties, attributes);
            case STEELEAF -> new TwilightForestAIOTs.SteeleafAiot(tier, properties, attributes);
            default -> throw new IllegalStateException("Unknown tier" + tier);
        };
    }

    public static class IronwoodAiot extends BaseAiot implements CreativeTabItemProvider {

        public IronwoodAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }

        @Override
        public Stream<ItemStack> makeCreativeTabStacks(CreativeTabX.TabContext ctx) {
            ItemStack stack = new ItemStack(this);

            IronwoodAiot.applyEnchantments(stack, ctx.context().holders().lookupOrThrow(Registries.ENCHANTMENT));

            return Stream.of(stack);
        }

        public static void applyEnchantments(ItemStack stack, HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup) {
            stack.enchant(enchantmentRegistryLookup.getOrThrow(Enchantments.KNOCKBACK), 1);
            stack.enchant(enchantmentRegistryLookup.getOrThrow(Enchantments.EFFICIENCY), 2);
            stack.enchant(enchantmentRegistryLookup.getOrThrow(Enchantments.UNBREAKING), 1);
            stack.enchant(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE), 1);
        }
    }

    public static class SteeleafAiot extends BaseAiot implements CreativeTabItemProvider {

        public SteeleafAiot(Tier tier, Properties properties, ItemAttributeModifiers attributes) {
            super(tier, properties, attributes);
        }

        @Override
        public Stream<ItemStack> makeCreativeTabStacks(CreativeTabX.TabContext ctx) {
            ItemStack stack = new ItemStack(this);

            SteeleafAiot.applyEnchantments(stack, ctx.context().holders().lookupOrThrow(Registries.ENCHANTMENT));

            return Stream.of(stack);
        }

        public static void applyEnchantments(ItemStack stack, HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup) {
            stack.enchant(enchantmentRegistryLookup.getOrThrow(Enchantments.LOOTING), 2);
            stack.enchant(enchantmentRegistryLookup.getOrThrow(Enchantments.EFFICIENCY), 3);
            stack.enchant(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE), 3);
        }
    }
}
