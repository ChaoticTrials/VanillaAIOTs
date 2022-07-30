package de.melanx.vanillaaiots.items;

import de.melanx.vanillaaiots.compat.LibCompat;
import de.melanx.vanillaaiots.config.ModConfig;
import de.melanx.vanillaaiots.data.AIOTTags;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import de.melanx.vanillaaiots.util.ComponentUtil;
import de.melanx.vanillaaiots.util.ToolUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class BaseAiot extends DiggerItem {

    private final ToolMaterials tier;
    private final boolean isVanilla;

    public BaseAiot(float attackDamageModifier, float attackSpeedModifier, ToolMaterials tier, Properties properties) {
        super(attackDamageModifier, attackSpeedModifier, tier, AIOTTags.MINEABLE_WITH_AIOT, properties);
        this.tier = tier;
        this.isVanilla = tier == ToolMaterials.WOODEN
                || tier == ToolMaterials.STONE
                || tier == ToolMaterials.IRON
                || tier == ToolMaterials.GOLDEN
                || tier == ToolMaterials.DIAMOND
                || tier == ToolMaterials.NETHERITE;
    }

    @Nonnull
    @Override
    public InteractionResult useOn(@Nonnull UseOnContext context) {
        Player player = context.getPlayer();

        if (player == null) return InteractionResult.PASS;

        ItemStack item = context.getItemInHand();
        boolean hoemode = isHoemode(item);

        InteractionResult result = InteractionResult.PASS;
        for (ToolAction action : ToolActions.DEFAULT_AXE_ACTIONS) {
            if (result != InteractionResult.PASS) {
                break;
            }

            result = ToolUtil.toolUse(context, action);
        }

        if (result == InteractionResult.PASS) {
            if (hoemode) {
                result = ToolUtil.toolUse(context, ToolActions.HOE_TILL);
            } else {
                result = ToolUtil.toolUse(context, ToolActions.SHOVEL_FLATTEN);
            }
        }

        if (LibCompat.isMoreVanillaLibLoaded()) {
            LibCompat.onUseOn(this, context);
        }

        return result;
    }

    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@Nonnull Level level, @Nonnull Player player, @Nonnull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide && player.isCrouching()) {
            Style dark_blue = Style.EMPTY.withColor(ChatFormatting.DARK_BLUE);
            Style aqua = Style.EMPTY.withColor(ChatFormatting.AQUA);
            MutableComponent text = ComponentUtil.getTooltip("toggleMode").append(": ").withStyle(dark_blue);
            MutableComponent pathMode = ComponentUtil.getTooltip("pathMode", Blocks.DIRT_PATH.getName().getString()).withStyle(aqua);
            MutableComponent hoeMode = ComponentUtil.getTooltip("hoeMode").withStyle(aqua);

            if (isHoemode(stack)) {
                setHoemode(stack, false);
                text = text.append(pathMode);
            } else {
                setHoemode(stack, true);
                text = text.append(hoeMode);
            }

            player.displayClientMessage(text, true);

            return InteractionResultHolder.success(stack);
        }

        return super.use(level, player, hand);
    }

    @Override
    public boolean hurtEnemy(@Nonnull ItemStack stack, @Nonnull LivingEntity target, @Nonnull LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);

        if (LibCompat.isMoreVanillaLibLoaded()) {
            LibCompat.onHurtEnemy(this, stack, target, attacker);
        }

        return result;
    }

    @Override
    public boolean mineBlock(@Nonnull ItemStack stack, @Nonnull Level level, @Nonnull BlockState state, @Nonnull BlockPos pos, @Nonnull LivingEntity entityLiving) {
        boolean result = super.mineBlock(stack, level, state, pos, entityLiving);

        if (LibCompat.isMoreVanillaLibLoaded()) {
            LibCompat.onMineBlock(this, stack, level, state, pos, entityLiving);
        }

        return result;
    }

    @Override
    public int getBurnTime(@Nonnull ItemStack stack, @Nullable RecipeType<?> recipeType) {
        return this.tier == ToolMaterials.WOODEN ? 400 : 0;
    }

    @Nonnull
    @Override
    public ToolMaterials getTier() {
        return this.tier;
    }

    public boolean isVanilla() {
        return this.isVanilla;
    }

    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
        if (state.is(Tags.Blocks.OBSIDIAN)) {
            int efficiencyLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, stack);
            return 5.0F * efficiencyLevel + 1;
        }

        if (state.is(Blocks.COBWEB)) {
            return 15.0F;
        }

        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolUtil.DEFAULT_AIOT_ACTIONS.contains(toolAction);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return (this.tier != ToolMaterials.SLIME || enchantment != Enchantments.KNOCKBACK) && super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level level, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag isAdvanced) {
        if (LibCompat.isMoreVanillaLibLoaded()) {
            LibCompat.editHoverText(this, stack, level, tooltip, isAdvanced);
        }

        super.appendHoverText(stack, level, tooltip, isAdvanced);
    }

    @Override
    public void fillItemCategory(@Nonnull CreativeModeTab category, @Nonnull NonNullList<ItemStack> items) {
        if (!this.isVanilla && ModConfig.vanillaOnly) {
            return;
        }

        super.fillItemCategory(category, items);
    }

    private static void setHoemode(ItemStack stack, boolean b) {
        stack.getOrCreateTag().putBoolean("hoemode", b);
    }

    private static boolean isHoemode(ItemStack stack) {
        return stack.isEmpty() || !stack.getOrCreateTag().contains("hoemode") || stack.getOrCreateTag().getBoolean("hoemode");
    }
}
