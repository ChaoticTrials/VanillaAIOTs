package de.melanx.vanillaaiots.data.recipes;

import de.melanx.vanillaaiots.compat.CompatHelper;
import de.melanx.vanillaaiots.config.VanillaCondition;
import de.melanx.vanillaaiots.items.AIOTRegistry;
import io.github.lieonlion.enderite.init.ItemsInit;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
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
        this.shapeless(this.output(AIOTRegistry.enderiteAiot), RecipeCategory.TOOLS, AIOTRegistry.enderiteAiot, ItemsInit.ENDERITE_SWORD.get(), ItemsInit.ENDERITE_PICKAXE.get(), ItemsInit.ENDERITE_AXE.get(), ItemsInit.ENDERITE_SHOVEL.get(), ItemsInit.ENDERITE_HOE.get());
        this.smithing(RecipeCategory.TOOLS, ItemsInit.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), AIOTRegistry.netheriteAiot, ItemsInit.ENDERITE_INGOT.get(), AIOTRegistry.enderiteAiot);

        this.shapeless(this.output(AIOTRegistry.obsidianInfusedEnderiteAiot), RecipeCategory.TOOLS, AIOTRegistry.obsidianInfusedEnderiteAiot, ItemsInit.OBSIDIAN_INFUSED_ENDERITE_SWORD.get(), ItemsInit.OBSIDIAN_INFUSED_ENDERITE_PICKAXE.get(), ItemsInit.OBSIDIAN_INFUSED_ENDERITE_AXE.get(), ItemsInit.OBSIDIAN_INFUSED_ENDERITE_SHOVEL.get(), ItemsInit.OBSIDIAN_INFUSED_ENDERITE_HOE.get());
        this.smithing(RecipeCategory.TOOLS, ItemsInit.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), AIOTRegistry.enderiteAiot, ItemsInit.OBSIDIAN_INFUSED_ENDERITE_INGOT.get(), AIOTRegistry.obsidianInfusedEnderiteAiot);
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
