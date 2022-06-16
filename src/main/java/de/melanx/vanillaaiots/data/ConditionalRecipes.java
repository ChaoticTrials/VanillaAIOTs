package de.melanx.vanillaaiots.data;

import de.melanx.MoreVanillaTools.util.ModItems;
import de.melanx.vanillaaiots.config.VanillaCondition;
import de.melanx.vanillaaiots.items.AIOTRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.crafting.conditions.ICondition;
import org.moddingx.libx.annotation.data.Datagen;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;
import org.moddingx.libx.mod.ModX;

import java.util.List;

@Datagen
public class ConditionalRecipes extends RecipeProviderBase implements CraftingExtension {

    public ConditionalRecipes(ModX mod, DataGenerator generator) {
        super(mod, generator);
    }

    @Override
    protected void setup() {
        this.shapeless(AIOTRegistry.boneAiot, ModItems.boneSword, ModItems.bonePickaxe, ModItems.boneAxe, ModItems.boneShovel, ModItems.boneHoe);
        this.shapeless(AIOTRegistry.coalAiot, ModItems.coalSword, ModItems.coalPickaxe, ModItems.coalAxe, ModItems.coalShovel, ModItems.coalHoe);
        this.shapeless(AIOTRegistry.emeraldAiot, ModItems.emeraldSword, ModItems.emeraldPickaxe, ModItems.emeraldAxe, ModItems.emeraldShovel, ModItems.emeraldHoe);
        this.shapeless(AIOTRegistry.enderAiot, ModItems.enderSword, ModItems.enderPickaxe, ModItems.enderAxe, ModItems.enderShovel, ModItems.enderHoe);
        this.shapeless(AIOTRegistry.fieryAiot, ModItems.fierySword, ModItems.fieryPickaxe, ModItems.fieryAxe, ModItems.fieryShovel, ModItems.fieryHoe);
        this.shapeless(AIOTRegistry.glowstoneAiot, ModItems.glowstoneSword, ModItems.glowstonePickaxe, ModItems.glowstoneAxe, ModItems.glowstoneShovel, ModItems.glowstoneHoe);
        this.shapeless(AIOTRegistry.lapisAiot, ModItems.lapisSword, ModItems.lapisPickaxe, ModItems.lapisAxe, ModItems.lapisShovel, ModItems.lapisHoe);
        this.shapeless(AIOTRegistry.netherAiot, ModItems.netherSword, ModItems.netherPickaxe, ModItems.netherAxe, ModItems.netherShovel, ModItems.netherHoe);
        this.shapeless(AIOTRegistry.obsidianAiot, ModItems.obsidianSword, ModItems.obsidianPickaxe, ModItems.obsidianAxe, ModItems.obsidianShovel, ModItems.obsidianHoe);
        this.shapeless(AIOTRegistry.paperAiot, ModItems.paperSword, ModItems.paperPickaxe, ModItems.paperAxe, ModItems.paperShovel, ModItems.paperHoe);
        this.shapeless(AIOTRegistry.prismarineAiot, ModItems.prismarineSword, ModItems.prismarinePickaxe, ModItems.prismarineAxe, ModItems.prismarineShovel, ModItems.prismarineHoe);
        this.shapeless(AIOTRegistry.quartzAiot, ModItems.quartzSword, ModItems.quartzPickaxe, ModItems.quartzAxe, ModItems.quartzShovel, ModItems.quartzHoe);
        this.shapeless(AIOTRegistry.redstoneAiot, ModItems.redstoneSword, ModItems.redstonePickaxe, ModItems.redstoneAxe, ModItems.redstoneShovel, ModItems.redstoneHoe);
        this.shapeless(AIOTRegistry.slimeAiot, ModItems.slimeSword, ModItems.slimePickaxe, ModItems.slimeAxe, ModItems.slimeShovel, ModItems.slimeHoe);
    }

    @Override
    protected List<ICondition> conditions() {
        return List.of(new VanillaCondition());
    }
}
