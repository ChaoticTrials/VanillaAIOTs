package de.melanx.vanillaaiots.data.recipes;

import com.aetherteam.aether.item.AetherItems;
import de.melanx.vanillaaiots.compat.CompatHelper;
import de.melanx.vanillaaiots.config.VanillaCondition;
import de.melanx.vanillaaiots.items.AIOTRegistry;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.registries.ForgeRegistries;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;

import javax.annotation.Nonnull;
import java.util.List;

public class AetherRecipes extends RecipeProviderBase implements CraftingExtension {

    public AetherRecipes(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {
        this.shapeless(this.output(AIOTRegistry.skyrootAiot), RecipeCategory.TOOLS, AIOTRegistry.skyrootAiot, AetherItems.SKYROOT_SWORD.get(), AetherItems.SKYROOT_PICKAXE.get(), AetherItems.SKYROOT_AXE.get(), AetherItems.SKYROOT_SHOVEL.get(), AetherItems.SKYROOT_HOE.get());
        this.shapeless(this.output(AIOTRegistry.holystoneAiot), RecipeCategory.TOOLS, AIOTRegistry.holystoneAiot, AetherItems.HOLYSTONE_SWORD.get(), AetherItems.HOLYSTONE_PICKAXE.get(), AetherItems.HOLYSTONE_AXE.get(), AetherItems.HOLYSTONE_SHOVEL.get(), AetherItems.HOLYSTONE_HOE.get());
        this.shapeless(this.output(AIOTRegistry.zaniteAiot), RecipeCategory.TOOLS, AIOTRegistry.zaniteAiot, AetherItems.ZANITE_SWORD.get(), AetherItems.ZANITE_PICKAXE.get(), AetherItems.ZANITE_AXE.get(), AetherItems.ZANITE_SHOVEL.get(), AetherItems.ZANITE_HOE.get());
        this.shapeless(this.output(AIOTRegistry.gravititeAiot), RecipeCategory.TOOLS, AIOTRegistry.gravititeAiot, AetherItems.GRAVITITE_SWORD.get(), AetherItems.GRAVITITE_PICKAXE.get(), AetherItems.GRAVITITE_AXE.get(), AetherItems.GRAVITITE_SHOVEL.get(), AetherItems.GRAVITITE_HOE.get());
        this.shapeless(this.output(AIOTRegistry.valkyrieAiot), RecipeCategory.TOOLS, AIOTRegistry.valkyrieAiot, AetherItems.VALKYRIE_LANCE.get(), AetherItems.VALKYRIE_PICKAXE.get(), AetherItems.VALKYRIE_AXE.get(), AetherItems.VALKYRIE_SHOVEL.get(), AetherItems.VALKYRIE_HOE.get());
    }

    private ResourceLocation output(@Nonnull Item item) {
        //noinspection ConstantConditions
        return this.mod.resource(CompatHelper.AETHER + "/" + ForgeRegistries.ITEMS.getKey(item).getPath());
    }

    @Override
    protected List<ICondition> conditions() {
        return List.of(new ModLoadedCondition(CompatHelper.AETHER), new VanillaCondition());
    }
}
