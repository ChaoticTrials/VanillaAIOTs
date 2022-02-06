package de.melanx.vanillaaiots.data;

import de.melanx.vanillaaiots.items.AIOTRegistry;
import io.github.noeppi_noeppi.libx.annotation.data.Datagen;
import io.github.noeppi_noeppi.libx.data.provider.recipe.RecipeProviderBase;
import io.github.noeppi_noeppi.libx.data.provider.recipe.crafting.CraftingExtension;
import io.github.noeppi_noeppi.libx.mod.ModX;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;

@Datagen
public class Recipes extends RecipeProviderBase implements CraftingExtension {

    public Recipes(ModX mod, DataGenerator generator) {
        super(mod, generator);
    }

    @Override
    protected void setup() {
        this.shapeless(AIOTRegistry.woodenAiot, Items.WOODEN_SWORD, Items.WOODEN_PICKAXE, Items.WOODEN_AXE, Items.WOODEN_SHOVEL, Items.WOODEN_HOE);
        this.shapeless(AIOTRegistry.stoneAiot, Items.STONE_SWORD, Items.STONE_PICKAXE, Items.STONE_AXE, Items.STONE_SHOVEL, Items.STONE_HOE);
        this.shapeless(AIOTRegistry.ironAiot, Items.IRON_SWORD, Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, Items.IRON_HOE);
        this.shapeless(AIOTRegistry.goldenAiot, Items.GOLDEN_SWORD, Items.GOLDEN_PICKAXE, Items.GOLDEN_AXE, Items.GOLDEN_SHOVEL, Items.GOLDEN_HOE);
        this.shapeless(AIOTRegistry.diamondAiot, Items.DIAMOND_SWORD, Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE, Items.DIAMOND_SHOVEL, Items.DIAMOND_HOE);
        this.shapeless(AIOTRegistry.netheriteAiot, Items.NETHERITE_SWORD, Items.NETHERITE_PICKAXE, Items.NETHERITE_AXE, Items.NETHERITE_SHOVEL, Items.NETHERITE_HOE);

//        this.addonTool(AIOTRegistry.boneAiot, ModItems.boneSword, ModItems.bonePickaxe, ModItems.boneAxe, ModItems.boneShovel, ModItems.boneHoe);
//        this.addonTool(AIOTRegistry.coalAiot, ModItems.coalSword, ModItems.coalPickaxe, ModItems.coalAxe, ModItems.coalShovel, ModItems.coalHoe);
//        this.addonTool(AIOTRegistry.emeraldAiot, ModItems.emeraldSword, ModItems.emeraldPickaxe, ModItems.emeraldAxe, ModItems.emeraldShovel, ModItems.emeraldHoe);
//        this.addonTool(AIOTRegistry.enderAiot, ModItems.enderSword, ModItems.enderPickaxe, ModItems.enderAxe, ModItems.enderShovel, ModItems.enderHoe);
//        this.addonTool(AIOTRegistry.fieryAiot, ModItems.fierySword, ModItems.fieryPickaxe, ModItems.fieryAxe, ModItems.fieryShovel, ModItems.fieryHoe);
//        this.addonTool(AIOTRegistry.glowstoneAiot, ModItems.glowstoneSword, ModItems.glowstonePickaxe, ModItems.glowstoneAxe, ModItems.glowstoneShovel, ModItems.glowstoneHoe);
//        this.addonTool(AIOTRegistry.lapisAiot, ModItems.lapisSword, ModItems.lapisPickaxe, ModItems.lapisAxe, ModItems.lapisShovel, ModItems.lapisHoe);
//        this.addonTool(AIOTRegistry.netherAiot, ModItems.netherSword, ModItems.netherPickaxe, ModItems.netherAxe, ModItems.netherShovel, ModItems.netherHoe);
//        this.addonTool(AIOTRegistry.obsidianAiot, ModItems.obsidianSword, ModItems.obsidianPickaxe, ModItems.obsidianAxe, ModItems.obsidianShovel, ModItems.obsidianHoe);
//        this.addonTool(AIOTRegistry.paperAiot, ModItems.paperSword, ModItems.paperPickaxe, ModItems.paperAxe, ModItems.paperShovel, ModItems.paperHoe);
//        this.addonTool(AIOTRegistry.prismarineAiot, ModItems.prismarineSword, ModItems.prismarinePickaxe, ModItems.prismarineAxe, ModItems.prismarineShovel, ModItems.prismarineHoe);
//        this.addonTool(AIOTRegistry.quartzAiot, ModItems.quartzSword, ModItems.quartzPickaxe, ModItems.quartzAxe, ModItems.quartzShovel, ModItems.quartzHoe);
//        this.addonTool(AIOTRegistry.redstoneAiot, ModItems.redstoneSword, ModItems.redstonePickaxe, ModItems.redstoneAxe, ModItems.redstoneShovel, ModItems.redstoneHoe);
//        this.addonTool(AIOTRegistry.slimeAiot, ModItems.slimeSword, ModItems.slimePickaxe, ModItems.slimeAxe, ModItems.slimeShovel, ModItems.slimeHoe);
    }

//    private void addonTool(Item result, Item sword, Item pickaxe, Item axe, Item shovel, Item hoe) {
//        ShapelessRecipeBuilder.shapeless(result)
//                .requires(sword)
//                .requires(pickaxe)
//                .requires(axe)
//                .requires(shovel)
//                .requires(hoe)
//                .group(VanillaAIOTs.getInstance().modid)
//                .unlockedBy("has_material", has(Items.STICK))
//                .save(WrapperResult.transformJson(this.consumer(), json -> {
//                    JsonArray array = new JsonArray();
//                    array.add(VanillaCondition.SERIALIZER.getJson(new VanillaCondition()));
//                    array.add(ModLoadedCondition.Serializer.INSTANCE.getJson(new ModLoadedCondition("morevanillatools")));
//                    json.add("conditions", array);
//                }));
//    }
}
