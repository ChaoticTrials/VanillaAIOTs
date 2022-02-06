package de.melanx.vanillaaiots.tools;

import de.melanx.vanillaaiots.config.ConfigureableMaterial;
import de.melanx.vanillaaiots.config.ModConfig;
import de.melanx.vanillaaiots.data.AIOTTags;
import io.github.noeppi_noeppi.libx.util.LazyValue;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public enum ToolMaterials implements Tier {

    WOODEN(ModConfig.ToolValues.wood, Tiers.WOOD.getUses(), () -> Ingredient.of(ItemTags.PLANKS)),
    STONE(ModConfig.ToolValues.stone, Tiers.STONE.getUses(), () -> Ingredient.of(Tags.Items.COBBLESTONE)),
    IRON(ModConfig.ToolValues.iron, Tiers.IRON.getUses(), () -> Ingredient.of(Tags.Items.INGOTS_IRON)),
    GOLDEN(ModConfig.ToolValues.gold, Tiers.GOLD.getUses(), () -> Ingredient.of(Tags.Items.INGOTS_GOLD)),
    DIAMOND(ModConfig.ToolValues.diamond, Tiers.DIAMOND.getUses(), () -> Ingredient.of(Tags.Items.GEMS_DIAMOND)),
    NETHERITE(ModConfig.ToolValues.netherite, Tiers.NETHERITE.getUses(), () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE));

//    BONE(ToolValueConfig.AIOTs.bone, () -> Ingredient.of(Tags.Items.BONES)),
//    COAL(ToolValueConfig.AIOTs.coal, () -> Ingredient.of(Items.COAL)),
//    EMERALD(ToolValueConfig.AIOTs.emerald, () -> Ingredient.of(Tags.Items.GEMS_EMERALD)),
//    ENDER(ToolValueConfig.AIOTs.ender, () -> Ingredient.of(Tags.Items.ENDER_PEARLS)),
//    FIERY(ToolValueConfig.AIOTs.fiery, () -> Ingredient.of(Items.MAGMA_BLOCK)),
//    GLOWSTONE(ToolValueConfig.AIOTs.glowstone, () -> Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)),
//    LAPIS(ToolValueConfig.AIOTs.lapis, () -> Ingredient.of(Tags.Items.GEMS_LAPIS)),
//    NETHER(ToolValueConfig.AIOTs.nether, () -> Ingredient.of(Items.NETHER_BRICKS)),
//    OBSIDIAN(ToolValueConfig.AIOTs.obsidian, () -> Ingredient.of(Tags.Items.OBSIDIAN)),
//    PAPER(ToolValueConfig.AIOTs.paper, () -> Ingredient.of(Items.PAPER)),
//    PRISMARINE(ToolValueConfig.AIOTs.prismarine, () -> Ingredient.of(Tags.Items.DUSTS_PRISMARINE)),
//    QUARTZ(ToolValueConfig.AIOTs.quartz, () -> Ingredient.of(Tags.Items.GEMS_QUARTZ)),
//    REDSTONE(ToolValueConfig.AIOTs.redstone, () -> Ingredient.of(Tags.Items.DUSTS_REDSTONE)),
//    SLIME(ToolValueConfig.AIOTs.slime, () -> Ingredient.of(Tags.Items.SLIMEBALLS));

    private final ConfigureableMaterial material;
    private final int durability;
    private final LazyValue<Ingredient> repairIngredient;

    ToolMaterials(ConfigureableMaterial material, int baseDurability, Supplier<Ingredient> repairIngredient) {
        this.material = material;
        this.durability = baseDurability * ModConfig.durabilityModifier;
        this.repairIngredient = new LazyValue<>(repairIngredient);
    }

    @Override
    public int getUses() {
        return this.durability;
    }

    @Override
    public float getSpeed() {
        return this.material.speed();
    }

    @Override
    public float getAttackDamageBonus() {
        return this.material.attackDamageBonus();
    }

    @Override
    public int getLevel() {
        return this.material.harvestLevel();
    }

    @Override
    public int getEnchantmentValue() {
        return this.material.enchantmentValue();
    }

    @Nonnull
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public Tag<Block> getTag() {
        return AIOTTags.MINEABLE_WITH_AIOT;
    }
}
