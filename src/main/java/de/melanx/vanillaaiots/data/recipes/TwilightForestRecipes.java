package de.melanx.vanillaaiots.data.recipes;

import de.melanx.vanillaaiots.compat.CompatHelper;
import de.melanx.vanillaaiots.compat.TwilightForestAIOTs;
import de.melanx.vanillaaiots.config.VanillaCondition;
import de.melanx.vanillaaiots.registration.AIOTRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.SmithingExtension;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;
import twilightforest.init.TFItems;

import javax.annotation.Nonnull;
import java.util.List;

public class TwilightForestRecipes extends RecipeProviderBase implements CraftingExtension, SmithingExtension {

    private final HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup;

    public TwilightForestRecipes(DatagenContext context) {
        super(context);
        this.enchantmentRegistryLookup = context.registries().registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
    }

    @Override
    protected void setup() {
        ItemStack ironwoodAiot = new ItemStack(AIOTRegistry.ironwoodAiot);
        ItemStack steeleafAiot = new ItemStack(AIOTRegistry.steeleafAiot);

        TwilightForestAIOTs.IronwoodAiot.applyEnchantments(ironwoodAiot, this.enchantmentRegistryLookup);
        TwilightForestAIOTs.SteeleafAiot.applyEnchantments(steeleafAiot, this.enchantmentRegistryLookup);

        this.shapeless(this.output(AIOTRegistry.ironwoodAiot), RecipeCategory.TOOLS, ironwoodAiot, TFItems.IRONWOOD_SWORD, TFItems.IRONWOOD_PICKAXE, TFItems.IRONWOOD_AXE, TFItems.IRONWOOD_SHOVEL, TFItems.IRONWOOD_HOE);
        this.shapeless(this.output(AIOTRegistry.steeleafAiot), RecipeCategory.TOOLS, steeleafAiot, TFItems.STEELEAF_SWORD, TFItems.STEELEAF_PICKAXE, TFItems.STEELEAF_AXE, TFItems.STEELEAF_SHOVEL, TFItems.STEELEAF_HOE);
    }

    private ResourceLocation output(@Nonnull Item item) {
        //noinspection ConstantConditions
        return this.mod.resource(CompatHelper.TWILIGHT_FOREST + "/" + BuiltInRegistries.ITEM.getKey(item).getPath());
    }

    @Override
    protected List<ICondition> conditions() {
        return List.of(new ModLoadedCondition(CompatHelper.TWILIGHT_FOREST), new VanillaCondition());
    }
}
