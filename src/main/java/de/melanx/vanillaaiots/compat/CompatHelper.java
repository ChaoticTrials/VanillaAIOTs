package de.melanx.vanillaaiots.compat;

import com.aetherteam.aether.item.combat.AetherItemTiers;
import com.aetherteam.aether.item.tools.abilities.ValkyrieTool;
import de.melanx.MoreVanillaTools.items.ToolMaterials;
import de.melanx.vanillaaiots.VanillaAIOTs;
import de.melanx.vanillaaiots.config.ModConfig;
import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.items.DummyItem;
import io.github.razordevs.deep_aether.init.DATiers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.NeoForge;
import net.teamsolar.simplest_copper_gear.item.ModToolTiers;

import javax.annotation.Nonnull;
import java.util.*;

public class CompatHelper {

    public static String MOREVANILLATOOLS = "morevanillatools";
    public static String SIMPLEST_COPPER_GEAR = "simplest_copper_gear";
    public static String AETHER = "aether";
    public static String AETHER_LOST_CONTENT = "lost_aether_content";
    public static String DEEP_AETHER = "deep_aether";
    private static final Map<String, Tier> LOADED_TIERS = new HashMap<>();

    public static void loadTiers() {
        RegisterTiersEvent event = new RegisterTiersEvent();
        NeoForge.EVENT_BUS.post(event);
        event.getTiersByModid().forEach((modid, map) -> {
            if (ModList.get().isLoaded(modid)) {
                LOADED_TIERS.putAll(map);
            }
        });

        if (ModList.get().isLoaded(AETHER)) {
            VanillaAIOTs.LOGGER.info("{} is loaded.", AETHER);
            LOADED_TIERS.put("skyroot", AetherItemTiers.SKYROOT);
            LOADED_TIERS.put("holystone", AetherItemTiers.HOLYSTONE);
            LOADED_TIERS.put("zanite", AetherItemTiers.ZANITE);
            LOADED_TIERS.put("gravitite", AetherItemTiers.GRAVITITE);
            LOADED_TIERS.put("valkyrie", AetherItemTiers.VALKYRIE);
        }

        if (ModList.get().isLoaded(AETHER_LOST_CONTENT)) {
            VanillaAIOTs.LOGGER.info("{} is loaded.", AETHER_LOST_CONTENT);
//            LOADED_TIERS.put("phoenix", LCItemTier.PHOENIX);
        }

        if (ModList.get().isLoaded(DEEP_AETHER)) {
            VanillaAIOTs.LOGGER.info("{} is loaded.", DEEP_AETHER);
            LOADED_TIERS.put("skyjade", DATiers.SKYJADE);
            LOADED_TIERS.put("stratus", DATiers.STRATUS);
        }

        if (ModList.get().isLoaded(SIMPLEST_COPPER_GEAR)) {
            VanillaAIOTs.LOGGER.info("{} is loaded.", SIMPLEST_COPPER_GEAR);
            LOADED_TIERS.put("copper", ModToolTiers.COPPER);
        }

        if (ModList.get().isLoaded(MOREVANILLATOOLS)) {
            VanillaAIOTs.LOGGER.info("{} is loaded.", MOREVANILLATOOLS);
            LOADED_TIERS.put("bone", ToolMaterials.BONE);
            LOADED_TIERS.put("coal", ToolMaterials.COAL);
            LOADED_TIERS.put("copper", ToolMaterials.COPPER);
            LOADED_TIERS.put("emerald", ToolMaterials.EMERALD);
            LOADED_TIERS.put("ender", ToolMaterials.ENDER);
            LOADED_TIERS.put("fiery", ToolMaterials.FIERY);
            LOADED_TIERS.put("glowstone", ToolMaterials.GLOWSTONE);
            LOADED_TIERS.put("lapis", ToolMaterials.LAPIS);
            LOADED_TIERS.put("nether", ToolMaterials.NETHER);
            LOADED_TIERS.put("obsidian", ToolMaterials.OBSIDIAN);
            LOADED_TIERS.put("paper", ToolMaterials.PAPER);
            LOADED_TIERS.put("prismarine", ToolMaterials.PRISMARINE);
            LOADED_TIERS.put("quartz", ToolMaterials.QUARTZ);
            LOADED_TIERS.put("redstone", ToolMaterials.REDSTONE);
            LOADED_TIERS.put("slime", ToolMaterials.SLIME);
        }
    }

    public static ItemAttributeModifiers applyAdditionalAttributes(Tier tier, ItemAttributeModifiers attributes) {
        if (tier == de.melanx.vanillaaiots.tools.ToolMaterials.VALKYRIE) {
            return attributes.withModifierAdded(
                    Attributes.BLOCK_INTERACTION_RANGE,
                    new AttributeModifier(ValkyrieTool.BLOCK_INTERACTION_RANGE_MODIFIER_UUID, 3.5F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
            ).withModifierAdded(
                    Attributes.ENTITY_INTERACTION_RANGE,
                    new AttributeModifier(ValkyrieTool.ENTITY_INTERACTION_RANGE_MODIFIER_UUID, 3.5F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
            );
        }

        return attributes;
    }

    public static Item makeItem(String modid, float attackDamageModifier, float attackSpeedModifier, String tier, Item.Properties properties) {
        return CompatHelper.makeItem(List.of(modid), attackDamageModifier, attackSpeedModifier, tier, properties);
    }

    public static Item makeItem(List<String> modids, float attackDamageModifier, float attackSpeedModifier, String tier, Item.Properties properties) {
        if (LOADED_TIERS.containsKey(tier)) {
            return new BaseAiot(CompatHelper.createTier(CompatHelper.getTierFor(tier)), properties);
        }

        return new DummyItem(modids);
    }

    public static Tier getTierFor(String material) {
        return LOADED_TIERS.getOrDefault(material.toLowerCase(Locale.ROOT), DummyItem.DUMMY_TIER);
    }

    public static int getDurabilityFor(String tier) {
        return CompatHelper.getTierFor(tier).getUses();
    }

    public static Ingredient getIngredientByIds(ItemOrTagId... ids) {
        Set<Ingredient> ingredients = new HashSet<>();
        for (ItemOrTagId id : ids) {
            if (id.isTag()) {
                TagKey<Item> tag = TagKey.create(Registries.ITEM, id.getLocation());
                ingredients.add(Ingredient.of(tag));
            } else {
                Item item = BuiltInRegistries.ITEM.get(id.getLocation());
                if (item == Items.AIR && !id.getLocation().equals(ResourceLocation.fromNamespaceAndPath("minecraft", "air"))) {
                    VanillaAIOTs.LOGGER.info("Item doesn't exist: {}", id);
                }
                ingredients.add(Ingredient.of(item));
            }
        }

        return ingredients.isEmpty() ? Ingredient.EMPTY : Ingredient.fromValues(ingredients.stream().flatMap(i -> Arrays.stream(i.getValues())));
    }

    public static boolean isLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }

    /**
     * @param base The {@link Tier} the material is made of
     * @return The tier used for the self-made AIOT
     */
    public static Tier createTier(Tier base) {
        return new Tier() {

            @Override
            public int getUses() {
                return (int) (base.getUses() * ModConfig.durabilityModifier);
            }

            @Override
            public float getSpeed() {
                return base.getSpeed();
            }

            @Override
            public float getAttackDamageBonus() {
                return base.getAttackDamageBonus();
            }

            @Nonnull
            @Override
            public TagKey<Block> getIncorrectBlocksForDrops() {
                return base.getIncorrectBlocksForDrops();
            }

            @Override
            public int getEnchantmentValue() {
                return base.getEnchantmentValue();
            }

            @Nonnull
            @Override
            public Ingredient getRepairIngredient() {
                return base.getRepairIngredient();
            }
        };
    }
}
