//package de.melanx.vanillaaiots.data.recipes;
//
//import com.legacy.lost_aether.registry.LCItems;
//import de.melanx.vanillaaiots.compat.CompatHelper;
//import de.melanx.vanillaaiots.config.VanillaCondition;
//import de.melanx.vanillaaiots.items.AIOTRegistry;
//import net.minecraft.data.recipes.RecipeCategory;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.Item;
//import net.minecraftforge.common.crafting.conditions.ICondition;
//import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
//import net.minecraftforge.registries.ForgeRegistries;
//import org.moddingx.libx.datagen.DatagenContext;
//import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
//import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;
//
//import javax.annotation.Nonnull;
//import java.util.List;
//
//public class AetherLostContentRecipes extends RecipeProviderBase implements CraftingExtension {
//
//    public AetherLostContentRecipes(DatagenContext context) {
//        super(context);
//    }
//
//    @Override
//    protected void setup() {
//        this.shapeless(this.output(AIOTRegistry.phoenixAiot), RecipeCategory.TOOLS, AIOTRegistry.phoenixAiot, LCItems.phoenix_sword, LCItems.phoenix_pickaxe, LCItems.phoenix_axe, LCItems.phoenix_shovel, LCItems.phoenix_hoe);
//    }
//
//    private ResourceLocation output(@Nonnull Item item) {
//        //noinspection ConstantConditions
//        return this.mod.resource(CompatHelper.AETHER_LOST_CONTENT + "/" + ForgeRegistries.ITEMS.getKey(item).getPath());
//    }
//
//    @Override
//    protected List<ICondition> conditions() {
//        return List.of(new ModLoadedCondition(CompatHelper.AETHER_LOST_CONTENT), new VanillaCondition());
//    }
//}
