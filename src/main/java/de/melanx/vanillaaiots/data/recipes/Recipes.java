package de.melanx.vanillaaiots.data.recipes;

import de.melanx.vanillaaiots.registration.AIOTRegistry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;

public class Recipes extends RecipeProviderBase implements CraftingExtension {

    public Recipes(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {
        this.shapeless(AIOTRegistry.woodenAiot, Items.WOODEN_SWORD, Items.WOODEN_PICKAXE, Items.WOODEN_AXE, Items.WOODEN_SHOVEL, Items.WOODEN_HOE);
        this.shapeless(AIOTRegistry.stoneAiot, Items.STONE_SWORD, Items.STONE_PICKAXE, Items.STONE_AXE, Items.STONE_SHOVEL, Items.STONE_HOE);
        this.shapeless(AIOTRegistry.ironAiot, Items.IRON_SWORD, Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, Items.IRON_HOE);
        this.shapeless(AIOTRegistry.goldenAiot, Items.GOLDEN_SWORD, Items.GOLDEN_PICKAXE, Items.GOLDEN_AXE, Items.GOLDEN_SHOVEL, Items.GOLDEN_HOE);
        this.shapeless(AIOTRegistry.diamondAiot, Items.DIAMOND_SWORD, Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE, Items.DIAMOND_SHOVEL, Items.DIAMOND_HOE);
        this.shapeless(AIOTRegistry.netheriteAiot, Items.NETHERITE_SWORD, Items.NETHERITE_PICKAXE, Items.NETHERITE_AXE, Items.NETHERITE_SHOVEL, Items.NETHERITE_HOE);
    }

    private void shapeless(Item output, Item sword, Item pickaxe, Item axe, Item shovel, Item hoe) {
        this.shapeless(RecipeCategory.TOOLS, output,
                DataComponentIngredient.of(false, DataComponents.DAMAGE, 0, sword),
                DataComponentIngredient.of(false, DataComponents.DAMAGE, 0, pickaxe),
                DataComponentIngredient.of(false, DataComponents.DAMAGE, 0, axe),
                DataComponentIngredient.of(false, DataComponents.DAMAGE, 0, shovel),
                DataComponentIngredient.of(false, DataComponents.DAMAGE, 0, hoe)
        );
    }
}
