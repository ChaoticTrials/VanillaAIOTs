package de.melanx.vanillaaiots.data.recipes;

import de.melanx.vanillaaiots.items.AIOTRegistry;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Items;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;

public class Recipes extends RecipeProviderBase implements CraftingExtension {

    public Recipes(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {
        this.shapeless(RecipeCategory.TOOLS, AIOTRegistry.woodenAiot, Items.WOODEN_SWORD, Items.WOODEN_PICKAXE, Items.WOODEN_AXE, Items.WOODEN_SHOVEL, Items.WOODEN_HOE);
        this.shapeless(RecipeCategory.TOOLS, AIOTRegistry.stoneAiot, Items.STONE_SWORD, Items.STONE_PICKAXE, Items.STONE_AXE, Items.STONE_SHOVEL, Items.STONE_HOE);
        this.shapeless(RecipeCategory.TOOLS, AIOTRegistry.ironAiot, Items.IRON_SWORD, Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, Items.IRON_HOE);
        this.shapeless(RecipeCategory.TOOLS, AIOTRegistry.goldenAiot, Items.GOLDEN_SWORD, Items.GOLDEN_PICKAXE, Items.GOLDEN_AXE, Items.GOLDEN_SHOVEL, Items.GOLDEN_HOE);
        this.shapeless(RecipeCategory.TOOLS, AIOTRegistry.diamondAiot, Items.DIAMOND_SWORD, Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE, Items.DIAMOND_SHOVEL, Items.DIAMOND_HOE);
        this.shapeless(RecipeCategory.TOOLS, AIOTRegistry.netheriteAiot, Items.NETHERITE_SWORD, Items.NETHERITE_PICKAXE, Items.NETHERITE_AXE, Items.NETHERITE_SHOVEL, Items.NETHERITE_HOE);
    }
}
