package de.melanx.vanillaaiots.data.recipes;

import de.melanx.MoreVanillaTools.util.ModItems;
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

public class ConditionalRecipes extends RecipeProviderBase implements CraftingExtension {

    public ConditionalRecipes(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {
        this.shapeless(this.output(AIOTRegistry.boneAiot), RecipeCategory.TOOLS, AIOTRegistry.boneAiot, ModItems.boneSword, ModItems.bonePickaxe, ModItems.boneAxe, ModItems.boneShovel, ModItems.boneHoe);
        this.shapeless(this.output(AIOTRegistry.coalAiot), RecipeCategory.TOOLS, AIOTRegistry.coalAiot, ModItems.coalSword, ModItems.coalPickaxe, ModItems.coalAxe, ModItems.coalShovel, ModItems.coalHoe);
        this.shapeless(this.output(AIOTRegistry.copperAiot), RecipeCategory.TOOLS, AIOTRegistry.copperAiot, ModItems.copperSword, ModItems.copperPickaxe, ModItems.copperAxe, ModItems.copperShovel, ModItems.copperHoe);
        this.shapeless(this.output(AIOTRegistry.emeraldAiot), RecipeCategory.TOOLS, AIOTRegistry.emeraldAiot, ModItems.emeraldSword, ModItems.emeraldPickaxe, ModItems.emeraldAxe, ModItems.emeraldShovel, ModItems.emeraldHoe);
        this.shapeless(this.output(AIOTRegistry.enderAiot), RecipeCategory.TOOLS, AIOTRegistry.enderAiot, ModItems.enderSword, ModItems.enderPickaxe, ModItems.enderAxe, ModItems.enderShovel, ModItems.enderHoe);
        this.shapeless(this.output(AIOTRegistry.fieryAiot), RecipeCategory.TOOLS, AIOTRegistry.fieryAiot, ModItems.fierySword, ModItems.fieryPickaxe, ModItems.fieryAxe, ModItems.fieryShovel, ModItems.fieryHoe);
        this.shapeless(this.output(AIOTRegistry.glowstoneAiot), RecipeCategory.TOOLS, AIOTRegistry.glowstoneAiot, ModItems.glowstoneSword, ModItems.glowstonePickaxe, ModItems.glowstoneAxe, ModItems.glowstoneShovel, ModItems.glowstoneHoe);
        this.shapeless(this.output(AIOTRegistry.lapisAiot), RecipeCategory.TOOLS, AIOTRegistry.lapisAiot, ModItems.lapisSword, ModItems.lapisPickaxe, ModItems.lapisAxe, ModItems.lapisShovel, ModItems.lapisHoe);
        this.shapeless(this.output(AIOTRegistry.netherAiot), RecipeCategory.TOOLS, AIOTRegistry.netherAiot, ModItems.netherSword, ModItems.netherPickaxe, ModItems.netherAxe, ModItems.netherShovel, ModItems.netherHoe);
        this.shapeless(this.output(AIOTRegistry.obsidianAiot), RecipeCategory.TOOLS, AIOTRegistry.obsidianAiot, ModItems.obsidianSword, ModItems.obsidianPickaxe, ModItems.obsidianAxe, ModItems.obsidianShovel, ModItems.obsidianHoe);
        this.shapeless(this.output(AIOTRegistry.paperAiot), RecipeCategory.TOOLS, AIOTRegistry.paperAiot, ModItems.paperSword, ModItems.paperPickaxe, ModItems.paperAxe, ModItems.paperShovel, ModItems.paperHoe);
        this.shapeless(this.output(AIOTRegistry.prismarineAiot), RecipeCategory.TOOLS, AIOTRegistry.prismarineAiot, ModItems.prismarineSword, ModItems.prismarinePickaxe, ModItems.prismarineAxe, ModItems.prismarineShovel, ModItems.prismarineHoe);
        this.shapeless(this.output(AIOTRegistry.quartzAiot), RecipeCategory.TOOLS, AIOTRegistry.quartzAiot, ModItems.quartzSword, ModItems.quartzPickaxe, ModItems.quartzAxe, ModItems.quartzShovel, ModItems.quartzHoe);
        this.shapeless(this.output(AIOTRegistry.redstoneAiot), RecipeCategory.TOOLS, AIOTRegistry.redstoneAiot, ModItems.redstoneSword, ModItems.redstonePickaxe, ModItems.redstoneAxe, ModItems.redstoneShovel, ModItems.redstoneHoe);
        this.shapeless(this.output(AIOTRegistry.slimeAiot), RecipeCategory.TOOLS, AIOTRegistry.slimeAiot, ModItems.slimeSword, ModItems.slimePickaxe, ModItems.slimeAxe, ModItems.slimeShovel, ModItems.slimeHoe);
    }

    private ResourceLocation output(@Nonnull Item item) {
        //noinspection ConstantConditions
        return this.mod.resource(CompatHelper.MOREVANILLATOOLS + "/" + ForgeRegistries.ITEMS.getKey(item).getPath());
    }

    @Override
    protected List<ICondition> conditions() {
        return List.of(new ModLoadedCondition(CompatHelper.MOREVANILLATOOLS), new VanillaCondition());
    }
}
