package de.melanx.vanillaaiots.compat;

import de.melanx.morevanillalib.api.normal.ToolMaterials;
import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.items.DummyItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.fml.ModList;

public class ToolsCompat {

    public static final String MODID = "morevanillatools";

    public static Item makeItem(float attackDamageModifier, float attackSpeedModifier, de.melanx.vanillaaiots.tools.ToolMaterials tier, Item.Properties properties) {
        if (ToolsCompat.isMoreVanillaToolsLoaded()) {
            return new BaseAiot(attackDamageModifier, attackSpeedModifier, tier, properties);
        } else {
            return new DummyItem(MODID);
        }
    }

    public static Tier getTierFor(String tier) {
        if (!ToolsCompat.isMoreVanillaToolsLoaded()) {
            return DummyItem.DUMMY_TIER;
        }

        return switch (tier) {
            case "bone" -> ToolMaterials.BONE;
            case "coal" -> ToolMaterials.COAL;
            case "emerald" -> ToolMaterials.EMERALD;
            case "ender" -> ToolMaterials.ENDER;
            case "fiery" -> ToolMaterials.FIERY;
            case "glowstone" -> ToolMaterials.GLOWSTONE;
            case "lapis" -> ToolMaterials.LAPIS;
            case "nether" -> ToolMaterials.NETHER;
            case "obsidian" -> ToolMaterials.OBSIDIAN;
            case "paper" -> ToolMaterials.PAPER;
            case "prismarine" -> ToolMaterials.PRISMARINE;
            case "quartz" -> ToolMaterials.QUARTZ;
            case "redstone" -> ToolMaterials.REDSTONE;
            case "slime" -> ToolMaterials.SLIME;
            default -> DummyItem.DUMMY_TIER;
        };
    }

    public static int getDurabilityFor(String tier) {
        Tier compat = ToolsCompat.getTierFor(tier);

        return compat.getUses();
    }

    public static boolean isMoreVanillaToolsLoaded() {
        return ModList.get().isLoaded(MODID);
    }
}
