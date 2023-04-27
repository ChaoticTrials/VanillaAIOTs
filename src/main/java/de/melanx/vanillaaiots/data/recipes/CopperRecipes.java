package de.melanx.vanillaaiots.data.recipes;

import de.melanx.vanillaaiots.compat.CompatHelper;
import de.melanx.vanillaaiots.config.VanillaCondition;
import de.melanx.vanillaaiots.items.AIOTRegistry;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.registries.ForgeRegistries;
import net.onvoid.copperized.common.CopperizedItems;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;

import javax.annotation.Nonnull;
import java.util.List;

public class CopperRecipes extends RecipeProviderBase implements CraftingExtension {

    public CopperRecipes(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {
        this.shapeless(this.output(AIOTRegistry.copperAiot), RecipeCategory.TOOLS, AIOTRegistry.copperAiot, CopperizedItems.COPPER_SWORD.get(), CopperizedItems.COPPER_PICKAXE.get(), CopperizedItems.COPPER_AXE.get(), CopperizedItems.COPPER_SHOVEL.get(), CopperizedItems.COPPER_HOE.get());
    }

    private ResourceLocation output(@Nonnull Item item) {
        //noinspection ConstantConditions
        return this.mod.resource(CompatHelper.COPPERIZED + "/" + ForgeRegistries.ITEMS.getKey(item).getPath());
    }

    @Override
    protected List<ICondition> conditions() {
        return List.of(new ModLoadedCondition(CompatHelper.COPPERIZED), new VanillaCondition());
    }
}
