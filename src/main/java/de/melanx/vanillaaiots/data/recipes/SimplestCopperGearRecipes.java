package de.melanx.vanillaaiots.data.recipes;

import de.melanx.vanillaaiots.compat.CompatHelper;
import de.melanx.vanillaaiots.config.VanillaCondition;
import de.melanx.vanillaaiots.registration.AIOTRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.teamsolar.simplest_copper_gear.item.ModItems;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;

import javax.annotation.Nonnull;
import java.util.List;

public class SimplestCopperGearRecipes extends RecipeProviderBase implements CraftingExtension {

    public SimplestCopperGearRecipes(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {
        this.shapeless(this.output(AIOTRegistry.copperAiot), RecipeCategory.TOOLS, AIOTRegistry.copperAiot, ModItems.COPPER_SWORD.get(), ModItems.COPPER_PICKAXE.get(), ModItems.COPPER_AXE.get(), ModItems.COPPER_SHOVEL.get(), ModItems.COPPER_HOE.get());
    }

    private ResourceLocation output(@Nonnull Item item) {
        return this.mod.resource(CompatHelper.SIMPLEST_COPPER_GEAR + "/" + BuiltInRegistries.ITEM.getKey(item).getPath());
    }

    @Override
    protected List<ICondition> conditions() {
        return List.of(new ModLoadedCondition(CompatHelper.SIMPLEST_COPPER_GEAR), new VanillaCondition());
    }
}
