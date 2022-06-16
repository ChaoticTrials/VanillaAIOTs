package de.melanx.vanillaaiots.compat;

import de.melanx.morevanillalib.util.ComponentUtil;
import de.melanx.vanillaaiots.items.BaseAiot;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;

import java.util.List;

public class LibCompat {

    public static final String MODID = "morevanillalib";

    public static void editHoverText(BaseAiot item, ItemStack stack, Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Screen.hasShiftDown()) {
            tooltip.add(ComponentUtil.getTooltip("durability", item.getTier().getUses()).withStyle(ChatFormatting.GRAY));
            tooltip.add(ComponentUtil.getTooltip("harvest_level", item.getTier().getLevel()).withStyle(ChatFormatting.GRAY));
            tooltip.add(ComponentUtil.getTooltip("repairing_item", item.getTier().getRepairIngredient().getItems()[0].getItem().getDescription().getString()).withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.add(ComponentUtil.getTooltip("more_information").withStyle(ChatFormatting.ITALIC, ChatFormatting.GRAY));
        }
    }

    public static boolean isMoreVanillaLibLoaded() {
        return ModList.get().isLoaded(MODID);
    }
}
