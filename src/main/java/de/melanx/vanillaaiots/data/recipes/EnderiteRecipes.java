package de.melanx.vanillaaiots.data.recipes;

import de.melanx.vanillaaiots.compat.CompatHelper;
import de.melanx.vanillaaiots.config.VanillaCondition;
import de.melanx.vanillaaiots.items.AIOTRegistry;
import io.github.lieonlion.enderite.Init.ItemInit;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.registries.ForgeRegistries;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.SmithingExtension;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;

import javax.annotation.Nonnull;
import java.util.List;

public class EnderiteRecipes extends RecipeProviderBase implements CraftingExtension, SmithingExtension {

    public EnderiteRecipes(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {
        this.shapeless(this.output(AIOTRegistry.enderiteAiot), RecipeCategory.TOOLS, AIOTRegistry.enderiteAiot, ItemInit.ENDERITE_SWORD.get(), ItemInit.ENDERITE_PICKAXE.get(), ItemInit.ENDERITE_AXE.get(), ItemInit.ENDERITE_SHOVEL.get(), ItemInit.ENDERITE_HOE.get());
        this.smithing(RecipeCategory.TOOLS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, AIOTRegistry.netheriteAiot, ItemInit.ENDERITE_INGOT.get(), AIOTRegistry.enderiteAiot);
    }

    private ResourceLocation output(@Nonnull Item item) {
        //noinspection ConstantConditions
        return this.mod.resource(CompatHelper.ENDERITE + "/" + ForgeRegistries.ITEMS.getKey(item).getPath());
    }

    @Override
    protected List<ICondition> conditions() {
        return List.of(new ModLoadedCondition(CompatHelper.ENDERITE), new VanillaCondition());
    }
}
