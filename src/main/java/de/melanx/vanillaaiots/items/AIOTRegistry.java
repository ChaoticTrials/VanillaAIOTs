package de.melanx.vanillaaiots.items;

import de.melanx.vanillaaiots.VanillaAIOTs;
import de.melanx.vanillaaiots.compat.CompatHelper;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModList;
import org.moddingx.libx.annotation.registration.RegisterClass;

import java.util.List;

@RegisterClass(registry = "ITEM_REGISTRY")
public class AIOTRegistry {

    @SuppressWarnings("ConstantConditions")
    public static final Item woodenAiot = new BaseAiot(6, -2.4F, ToolMaterials.WOODEN, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item stoneAiot = new BaseAiot(7, -2.4F, ToolMaterials.STONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item ironAiot = new BaseAiot(6, -2.4F, ToolMaterials.IRON, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item goldenAiot = new BaseAiot(6, -2.4F, ToolMaterials.GOLDEN, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item diamondAiot = new BaseAiot(5, -2.4F, ToolMaterials.DIAMOND, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item netheriteAiot = new BaseAiot(5, -2.4F, ToolMaterials.NETHERITE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));

    public static final Item boneAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.BONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item coalAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.COAL, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item copperAiot = AIOTRegistry.makeItem(NonNullList.of(CompatHelper.COPPERIZED, CompatHelper.MOREVANILLATOOLS), 0, -2.4F, ToolMaterials.COPPER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item emeraldAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.EMERALD, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item enderAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.ENDER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item fieryAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.FIERY, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item glowstoneAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.GLOWSTONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item lapisAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.LAPIS, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item netherAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.NETHER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item obsidianAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.OBSIDIAN, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item paperAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.PAPER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item prismarineAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.PRISMARINE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item quartzAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.QUARTZ, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item redstoneAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.REDSTONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item slimeAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -2.4F, ToolMaterials.SLIME, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));

    public static Item makeItem(String modid, float attackDamageModifier, float attackSpeedModifier, ToolMaterials tier, Item.Properties properties) {
        return AIOTRegistry.makeItem(List.of(modid), attackDamageModifier, attackSpeedModifier, tier, properties);
    }

    public static Item makeItem(List<String> modids, float attackDamageModifier, float attackSpeedModifier, ToolMaterials tier, Item.Properties properties) {
        for (String modid : modids) {
            if (ModList.get().isLoaded(modid)) {
                return new BaseAiot(attackDamageModifier, attackSpeedModifier, tier, properties);
            }
        }

        return new DummyItem(modids);
    }
}
