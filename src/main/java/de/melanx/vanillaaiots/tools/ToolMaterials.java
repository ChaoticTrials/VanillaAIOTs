package de.melanx.vanillaaiots.tools;

import de.melanx.vanillaaiots.compat.ToolsCompat;
import de.melanx.vanillaaiots.config.ConfigureableMaterial;
import de.melanx.vanillaaiots.config.ModConfig;
import de.melanx.vanillaaiots.data.AIOTTags;
import io.github.noeppi_noeppi.libx.util.LazyValue;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Items;
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
    NETHERITE(ModConfig.ToolValues.netherite, Tiers.NETHERITE.getUses(), () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE)),

    BONE(ModConfig.ToolValues.MoreVanillaTools.bone, () -> Ingredient.of(Tags.Items.BONES)),
    COAL(ModConfig.ToolValues.MoreVanillaTools.coal, () -> Ingredient.of(Items.COAL)),
    EMERALD(ModConfig.ToolValues.MoreVanillaTools.emerald, () -> Ingredient.of(Tags.Items.GEMS_EMERALD)),
    ENDER(ModConfig.ToolValues.MoreVanillaTools.ender, () -> Ingredient.of(Tags.Items.ENDER_PEARLS)),
    FIERY(ModConfig.ToolValues.MoreVanillaTools.fiery, () -> Ingredient.of(Items.MAGMA_BLOCK)),
    GLOWSTONE(ModConfig.ToolValues.MoreVanillaTools.glowstone, () -> Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)),
    LAPIS(ModConfig.ToolValues.MoreVanillaTools.lapis, () -> Ingredient.of(Tags.Items.GEMS_LAPIS)),
    NETHER(ModConfig.ToolValues.MoreVanillaTools.nether, () -> Ingredient.of(Items.NETHER_BRICKS)),
    OBSIDIAN(ModConfig.ToolValues.MoreVanillaTools.obsidian, () -> Ingredient.of(Tags.Items.OBSIDIAN)),
    PAPER(ModConfig.ToolValues.MoreVanillaTools.paper, () -> Ingredient.of(Items.PAPER)),
    PRISMARINE(ModConfig.ToolValues.MoreVanillaTools.prismarine, () -> Ingredient.of(Tags.Items.DUSTS_PRISMARINE)),
    QUARTZ(ModConfig.ToolValues.MoreVanillaTools.quartz, () -> Ingredient.of(Tags.Items.GEMS_QUARTZ)),
    REDSTONE(ModConfig.ToolValues.MoreVanillaTools.redstone, () -> Ingredient.of(Tags.Items.DUSTS_REDSTONE)),
    SLIME(ModConfig.ToolValues.MoreVanillaTools.slime, () -> Ingredient.of(Tags.Items.SLIMEBALLS));

    private final ConfigureableMaterial material;
    private final int durability;
    private final LazyValue<Ingredient> repairIngredient;

    ToolMaterials(ConfigureableMaterial material, Supplier<Ingredient> repairIngredient) {
        int baseDurability = ToolsCompat.getDurabilityFor(material);
        if (baseDurability < 0 && ToolsCompat.isMoreVanillaToolsLoaded()) {
            throw new IllegalStateException("Invalid tier detected");
        }
        this.material = material;
        this.durability = baseDurability * ModConfig.durabilityModifier;
        this.repairIngredient = new LazyValue<>(repairIngredient);
    }

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
