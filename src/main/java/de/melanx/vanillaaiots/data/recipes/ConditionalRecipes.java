package de.melanx.vanillaaiots.data.recipes;

import de.melanx.MoreVanillaTools.util.ModItems;
import de.melanx.vanillaaiots.compat.CompatHelper;
import de.melanx.vanillaaiots.config.VanillaCondition;
import de.melanx.vanillaaiots.items.AIOTRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.registries.ForgeRegistries;
import org.moddingx.libx.annotation.data.Datagen;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;
import org.moddingx.libx.mod.ModX;

import javax.annotation.Nonnull;
import java.util.List;

@Datagen
public class ConditionalRecipes extends RecipeProviderBase implements CraftingExtension {

    public ConditionalRecipes(ModX mod, DataGenerator generator) {
        super(mod, generator);
    }

    @Override
    protected void setup() {
        this.shapeless(this.output(AIOTRegistry.boneAiot), AIOTRegistry.boneAiot, ModItems.boneSword, ModItems.bonePickaxe, ModItems.boneAxe, ModItems.boneShovel, ModItems.boneHoe);
        this.shapeless(this.output(AIOTRegistry.coalAiot), AIOTRegistry.coalAiot, ModItems.coalSword, ModItems.coalPickaxe, ModItems.coalAxe, ModItems.coalShovel, ModItems.coalHoe);
        this.shapeless(this.output(AIOTRegistry.copperAiot), AIOTRegistry.copperAiot, ModItems.copperSword, ModItems.copperPickaxe, ModItems.copperAxe, ModItems.copperShovel, ModItems.copperHoe);
        this.shapeless(this.output(AIOTRegistry.emeraldAiot), AIOTRegistry.emeraldAiot, ModItems.emeraldSword, ModItems.emeraldPickaxe, ModItems.emeraldAxe, ModItems.emeraldShovel, ModItems.emeraldHoe);
        this.shapeless(this.output(AIOTRegistry.enderAiot), AIOTRegistry.enderAiot, ModItems.enderSword, ModItems.enderPickaxe, ModItems.enderAxe, ModItems.enderShovel, ModItems.enderHoe);
        this.shapeless(this.output(AIOTRegistry.fieryAiot), AIOTRegistry.fieryAiot, ModItems.fierySword, ModItems.fieryPickaxe, ModItems.fieryAxe, ModItems.fieryShovel, ModItems.fieryHoe);
        this.shapeless(this.output(AIOTRegistry.glowstoneAiot), AIOTRegistry.glowstoneAiot, ModItems.glowstoneSword, ModItems.glowstonePickaxe, ModItems.glowstoneAxe, ModItems.glowstoneShovel, ModItems.glowstoneHoe);
        this.shapeless(this.output(AIOTRegistry.lapisAiot), AIOTRegistry.lapisAiot, ModItems.lapisSword, ModItems.lapisPickaxe, ModItems.lapisAxe, ModItems.lapisShovel, ModItems.lapisHoe);
        this.shapeless(this.output(AIOTRegistry.netherAiot), AIOTRegistry.netherAiot, ModItems.netherSword, ModItems.netherPickaxe, ModItems.netherAxe, ModItems.netherShovel, ModItems.netherHoe);
        this.shapeless(this.output(AIOTRegistry.obsidianAiot), AIOTRegistry.obsidianAiot, ModItems.obsidianSword, ModItems.obsidianPickaxe, ModItems.obsidianAxe, ModItems.obsidianShovel, ModItems.obsidianHoe);
        this.shapeless(this.output(AIOTRegistry.paperAiot), AIOTRegistry.paperAiot, ModItems.paperSword, ModItems.paperPickaxe, ModItems.paperAxe, ModItems.paperShovel, ModItems.paperHoe);
        this.shapeless(this.output(AIOTRegistry.prismarineAiot), AIOTRegistry.prismarineAiot, ModItems.prismarineSword, ModItems.prismarinePickaxe, ModItems.prismarineAxe, ModItems.prismarineShovel, ModItems.prismarineHoe);
        this.shapeless(this.output(AIOTRegistry.quartzAiot), AIOTRegistry.quartzAiot, ModItems.quartzSword, ModItems.quartzPickaxe, ModItems.quartzAxe, ModItems.quartzShovel, ModItems.quartzHoe);
        this.shapeless(this.output(AIOTRegistry.redstoneAiot), AIOTRegistry.redstoneAiot, ModItems.redstoneSword, ModItems.redstonePickaxe, ModItems.redstoneAxe, ModItems.redstoneShovel, ModItems.redstoneHoe);
        this.shapeless(this.output(AIOTRegistry.slimeAiot), AIOTRegistry.slimeAiot, ModItems.slimeSword, ModItems.slimePickaxe, ModItems.slimeAxe, ModItems.slimeShovel, ModItems.slimeHoe);
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
