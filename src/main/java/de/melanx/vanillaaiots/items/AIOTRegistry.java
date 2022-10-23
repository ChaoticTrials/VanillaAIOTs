package de.melanx.vanillaaiots.items;

import de.melanx.vanillaaiots.VanillaAIOTs;
import de.melanx.vanillaaiots.compat.ToolsCompat;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import io.github.noeppi_noeppi.libx.annotation.registration.RegisterClass;
import net.minecraft.world.item.Item;

@RegisterClass
public class AIOTRegistry {

    @SuppressWarnings("ConstantConditions")
    public static final Item woodenAiot = new BaseAiot(6, -2.4F, ToolMaterials.WOODEN, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item stoneAiot = new BaseAiot(7, -2.4F, ToolMaterials.STONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item ironAiot = new BaseAiot(6, -2.4F, ToolMaterials.IRON, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item goldenAiot = new BaseAiot(6, -2.4F, ToolMaterials.GOLDEN, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item diamondAiot = new BaseAiot(5, -2.4F, ToolMaterials.DIAMOND, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item netheriteAiot = new BaseAiot(5, -2.4F, ToolMaterials.NETHERITE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));

    public static final Item boneAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.BONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item coalAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.COAL, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item copperAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.COPPER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item emeraldAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.EMERALD, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item enderAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.ENDER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item fieryAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.FIERY, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item glowstoneAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.GLOWSTONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item lapisAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.LAPIS, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item netherAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.NETHER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item obsidianAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.OBSIDIAN, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item paperAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.PAPER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item prismarineAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.PRISMARINE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item quartzAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.QUARTZ, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item redstoneAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.REDSTONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item slimeAiot = ToolsCompat.makeItem(0, -2.4F, ToolMaterials.SLIME, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
}
