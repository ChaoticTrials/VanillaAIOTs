package de.melanx.vanillaaiots.items;

import de.melanx.vanillaaiots.VanillaAIOTs;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import io.github.noeppi_noeppi.libx.annotation.registration.RegisterClass;
import net.minecraft.world.item.Item;

@RegisterClass
public class AIOTRegistry {

    @SuppressWarnings("ConstantConditions")
    public static final Item woodenAiot = new BaseAiot(0, 0, ToolMaterials.WOODEN, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item stoneAiot = new BaseAiot(0, 0, ToolMaterials.STONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item ironAiot = new BaseAiot(0, 0, ToolMaterials.IRON, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item goldenAiot = new BaseAiot(0, 0, ToolMaterials.GOLDEN, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item diamondAiot = new BaseAiot(0, 0, ToolMaterials.DIAMOND, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item netheriteAiot = new BaseAiot(0, 0, ToolMaterials.NETHERITE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));

//    public static final Item boneAiot = new BaseAiot(ToolMaterials.BONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
//    public static final Item coalAiot = new BaseAiot(ToolMaterials.COAL, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
//    public static final Item emeraldAiot = new BaseAiot(ToolMaterials.EMERALD, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
//    public static final Item enderAiot = new BaseAiot(ToolMaterials.ENDER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
//    public static final Item fieryAiot = new BaseAiot(ToolMaterials.FIERY, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
//    public static final Item glowstoneAiot = new BaseAiot(ToolMaterials.GLOWSTONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
//    public static final Item lapisAiot = new BaseAiot(ToolMaterials.LAPIS, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
//    public static final Item netherAiot = new BaseAiot(ToolMaterials.NETHER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
//    public static final Item obsidianAiot = new BaseAiot(ToolMaterials.OBSIDIAN, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
//    public static final Item paperAiot = new BaseAiot(ToolMaterials.PAPER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
//    public static final Item prismarineAiot = new BaseAiot(ToolMaterials.PRISMARINE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
//    public static final Item quartzAiot = new BaseAiot(ToolMaterials.QUARTZ, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
//    public static final Item redstoneAiot = new BaseAiot(ToolMaterials.REDSTONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
//    public static final Item slimeAiot = new BaseAiot(ToolMaterials.SLIME, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
}
