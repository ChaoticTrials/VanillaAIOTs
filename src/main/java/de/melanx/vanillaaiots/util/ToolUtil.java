package de.melanx.vanillaaiots.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.Set;

import static net.neoforged.neoforge.common.ItemAbilities.*;


public class ToolUtil {

    public static final Set<ItemAbility> DEFAULT_AIOT_ABILITIES = Set.of(
            AXE_DIG, AXE_STRIP, AXE_SCRAPE, AXE_WAX_OFF,
            HOE_DIG, HOE_TILL,
            SHOVEL_DIG, SHOVEL_FLATTEN, SHOVEL_DOUSE,
            PICKAXE_DIG,
            SWORD_DIG
    );

    public static InteractionResult toolUse(UseOnContext context, ItemAbility toolAction) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        ItemStack stack = context.getItemInHand();
        Direction side = context.getClickedFace();

        if (player != null
                && player.mayUseItemAt(pos, side, stack)
                && ((side != Direction.DOWN && level.isEmptyBlock(pos.above())) || AXE_STRIP == toolAction)) {

            BlockState state = level.getBlockState(pos);
            BlockState modifiedState = state.getToolModifiedState(context, toolAction, false);
            if (modifiedState != null) {
                SoundEvent sound;
                if (DEFAULT_AXE_ACTIONS.contains(toolAction)) {
                    if (toolAction == AXE_STRIP) {
                        sound = SoundEvents.AXE_STRIP;
                    } else if (toolAction == AXE_SCRAPE) {
                        sound = SoundEvents.AXE_SCRAPE;
                    } else {
                        sound = SoundEvents.AXE_WAX_OFF;
                    }
                } else if (DEFAULT_SHOVEL_ACTIONS.contains(toolAction)) {
                    sound = SoundEvents.SHOVEL_FLATTEN;
                } else {
                    sound = SoundEvents.HOE_TILL;
                }

                level.playSound(player, pos, sound, SoundSource.BLOCKS, 1, 1);
            } else if (state.getBlock() instanceof CampfireBlock && state.getValue(CampfireBlock.LIT)) {
                if (!level.isClientSide) {
                    level.levelEvent(player, 1009, pos, 0);
                }
                CampfireBlock.dowse(player, level, pos, state);
                modifiedState = state.setValue(CampfireBlock.LIT, false);
            }

            if (modifiedState != null) {
                if (!level.isClientSide) {
                    level.setBlock(pos, modifiedState, Block.UPDATE_ALL_IMMEDIATE);
                    stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        return InteractionResult.PASS;
    }
}
