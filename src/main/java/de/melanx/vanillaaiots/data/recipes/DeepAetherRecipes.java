package de.melanx.vanillaaiots.data.recipes;

import de.melanx.vanillaaiots.compat.CompatHelper;
import de.melanx.vanillaaiots.config.VanillaCondition;
import de.melanx.vanillaaiots.registration.AIOTRegistry;
import io.github.razordevs.deep_aether.init.DAItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.SmithingExtension;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;

import javax.annotation.Nonnull;
import java.util.List;

public class DeepAetherRecipes extends RecipeProviderBase implements CraftingExtension, SmithingExtension {

    public DeepAetherRecipes(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {
        this.shapeless(this.output(AIOTRegistry.skyjadeAiot), RecipeCategory.TOOLS, AIOTRegistry.skyjadeAiot, DAItems.SKYJADE_TOOLS_SWORD.get(), DAItems.SKYJADE_TOOLS_PICKAXE.get(), DAItems.SKYJADE_TOOLS_AXE.get(), DAItems.SKYJADE_TOOLS_SHOVEL.get(), DAItems.SKYJADE_TOOLS_HOE.get());

        this.shapeless(this.output(AIOTRegistry.stratusAiot), RecipeCategory.TOOLS, AIOTRegistry.stratusAiot, DAItems.STRATUS_SWORD.get(), DAItems.STRATUS_PICKAXE.get(), DAItems.STRATUS_AXE.get(), DAItems.STRATUS_SHOVEL.get(), DAItems.STRATUS_HOE.get());
        this.smithing(RecipeCategory.TOOLS, DAItems.STRATUS_SMITHING_TEMPLATE.get(), AIOTRegistry.gravititeAiot, DAItems.STRATUS_INGOT.get(), AIOTRegistry.stratusAiot);
    }

    private ResourceLocation output(@Nonnull Item item) {
        //noinspection ConstantConditions
        return this.mod.resource(CompatHelper.DEEP_AETHER + "/" + BuiltInRegistries.ITEM.getKey(item).getPath());
    }

    @Override
    protected List<ICondition> conditions() {
        return List.of(new ModLoadedCondition(CompatHelper.DEEP_AETHER), new VanillaCondition());
    }
}
