package de.melanx.vanillaaiots.compat;

import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.data.ModTags;
import de.melanx.morevanillalib.util.ComponentUtil;
import de.melanx.morevanillalib.util.ToolUtil;
import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.ModList;

import java.util.List;

// TODO 1.19 Put this in MoreVanillaLib and call it from here
public class LibCompat {

    public static final String MODID = "morevanillalib";

    public static void onHurtEnemy(Item item, ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.level.isClientSide && stack.is(ModTags.Items.PAPER_TOOLS) && FeatureConfig.PaperDamage.enabled
                && target.level.random.nextDouble() < FeatureConfig.PaperDamage.chance) {
            ToolUtil.paperDamage(attacker);
        }
    }

    public static void onUseOn(Item item, UseOnContext context) {
        if (context.getPlayer() != null && context.getPlayer().level.isClientSide && context.getItemInHand().is(ModTags.Items.PAPER_TOOLS)
                && FeatureConfig.PaperDamage.enabled && context.getPlayer().level.random.nextDouble() < FeatureConfig.PaperDamage.chance) {
            ToolUtil.paperDamage(context.getPlayer());
        }
    }

    public static void onMineBlock(Item item, ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!level.isClientSide && state.getDestroySpeed(level, pos) != 0.0F && stack.is(ModTags.Items.PAPER_TOOLS)
                && FeatureConfig.PaperDamage.enabled && level.random.nextDouble() < FeatureConfig.PaperDamage.chance) {
            ToolUtil.paperDamage(entityLiving);
        }
    }

    public static void onLivingDamageEvent(Player player, LivingDamageEvent event) {
        Item heldItem = player.getMainHandItem().getItem();
        ToolMaterials toolType = heldItem instanceof BaseAiot item ? item.getTier() : null;
        if (toolType != null) {
            LivingEntity entity = event.getEntityLiving();
            if (toolType == ToolMaterials.BONE) {
                if (entity instanceof AbstractSkeleton) {
                    ToolUtil.moreDamage(event);
                }
            } else if (toolType == ToolMaterials.ENDER) {
                if (entity instanceof EnderMan || entity instanceof Endermite) {
                    ToolUtil.moreDamage(event);
                }
            } else if (toolType == ToolMaterials.FIERY) {
                if (entity instanceof MagmaCube) {
                    ToolUtil.moreDamage(event);
                }
            } else if (toolType == ToolMaterials.PRISMARINE) {
                if (entity instanceof Guardian) {
                    ToolUtil.moreDamage(event);
                }
            } else if (toolType == ToolMaterials.SLIME) {
                if (entity instanceof Slime && !(entity instanceof MagmaCube)) {
                    ToolUtil.moreDamage(event);
                }
            }
        }
    }

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
