package de.melanx.vanillaaiots.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;

import java.util.Set;

import static net.minecraftforge.common.ToolActions.*;

public class ToolUtil {

    public static final Set<ToolAction> DEFAULT_AIOT_ACTIONS = Set.of(
            AXE_DIG, AXE_STRIP, AXE_SCRAPE, AXE_WAX_OFF,
            HOE_DIG, HOE_TILL,
            SHOVEL_DIG, SHOVEL_FLATTEN,
            PICKAXE_DIG,
            SWORD_DIG
    );

    public static InteractionResult toolUse(UseOnContext context, ToolAction toolAction) {
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
            if (toolAction == HOE_TILL) {
                modifiedState = ToolUtil.getHoeTillingState(state, context);
                if (state.getBlock() == Blocks.ROOTED_DIRT) {
                    Block.popResourceFromFace(level, pos, side, new ItemStack(Items.HANGING_ROOTS));
                }
            }

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
                    level.setBlock(pos, modifiedState, 11);
                    stack.hurtAndBreak(1, player, playerEntity -> playerEntity.broadcastBreakEvent(context.getHand()));
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        return InteractionResult.PASS;
    }

    public static BlockState getHoeTillingState(BlockState state, UseOnContext context) {
        Block block = state.getBlock();
        if (block == Blocks.ROOTED_DIRT) {
            return Blocks.DIRT.defaultBlockState();
        }

        if (context.getClickedFace() != Direction.DOWN && context.getLevel().getBlockState(context.getClickedPos().above()).isAir()) {
            if (block == Blocks.GRASS_BLOCK || block == Blocks.DIRT_PATH || block == Blocks.DIRT) {
                return Blocks.FARMLAND.defaultBlockState();
            }

            if (block == Blocks.COARSE_DIRT) {
                return Blocks.DIRT.defaultBlockState();
            }
        }

        return null;
    }
}
