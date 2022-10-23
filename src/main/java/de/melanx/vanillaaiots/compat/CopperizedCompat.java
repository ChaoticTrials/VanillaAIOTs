package de.melanx.vanillaaiots.compat;

import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.items.DummyItem;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.fml.ModList;
import net.onvoid.copperized.common.CopperizedTiers;

public class CopperizedCompat {

    public static final String MODID = "copperized";

    public static Item makeItem(float attackDamageModifier, float attackSpeedModifier, ToolMaterials tier, Item.Properties properties) {
        if (ToolsCompat.isMoreVanillaToolsLoaded()) {
            return new BaseAiot(attackDamageModifier, attackSpeedModifier, tier, properties);
        } else {
            return new DummyItem(MODID);
        }
    }

    public static Tier getCopper() {
        return CopperizedTiers.COPPER;
    }

    public static boolean isCopperizedLoaded() {
        return ModList.get().isLoaded(MODID);
    }
}
