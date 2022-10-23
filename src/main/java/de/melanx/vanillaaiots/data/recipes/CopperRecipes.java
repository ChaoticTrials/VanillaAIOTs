package de.melanx.vanillaaiots.data.recipes;

import de.melanx.vanillaaiots.compat.CopperizedCompat;
import de.melanx.vanillaaiots.config.VanillaCondition;
import de.melanx.vanillaaiots.items.AIOTRegistry;
import io.github.noeppi_noeppi.libx.annotation.data.Datagen;
import io.github.noeppi_noeppi.libx.data.provider.recipe.RecipeProviderBase;
import io.github.noeppi_noeppi.libx.data.provider.recipe.crafting.CraftingExtension;
import io.github.noeppi_noeppi.libx.mod.ModX;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.onvoid.copperized.common.CopperizedItems;

import java.util.List;

@Datagen
public class CopperRecipes extends RecipeProviderBase implements CraftingExtension {

    public CopperRecipes(ModX mod, DataGenerator generator) {
        super(mod, generator);
    }

    @Override
    protected void setup() {
        this.shapeless(AIOTRegistry.copperAiot, CopperizedItems.COPPER_SWORD.get(), CopperizedItems.COPPER_PICKAXE.get(), CopperizedItems.COPPER_AXE.get(), CopperizedItems.COPPER_SHOVEL.get(), CopperizedItems.COPPER_HOE.get());
    }

    @Override
    protected List<ICondition> conditions() {
        return List.of(new ModLoadedCondition(CopperizedCompat.MODID), new VanillaCondition());
    }
}
