package de.melanx.vanillaaiots.items;

import de.melanx.morevanillalib.api.aiot.AIOTBase;
import de.melanx.morevanillalib.api.aiot.AIOTMaterials;
import de.melanx.vanillaaiots.VanillaAIOTs;
import io.github.noeppi_noeppi.libx.annotation.registration.RegisterClass;
import net.minecraft.world.item.Item;

@RegisterClass
public class AIOTRegistry {

    @SuppressWarnings("ConstantConditions")
    public static final Item woodenAiot = new AIOTBase(AIOTMaterials.WOODEN, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item stoneAiot = new AIOTBase(AIOTMaterials.STONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item ironAiot = new AIOTBase(AIOTMaterials.IRON, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item goldenAiot = new AIOTBase(AIOTMaterials.GOLDEN, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item diamondAiot = new AIOTBase(AIOTMaterials.DIAMOND, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item netheriteAiot = new AIOTBase(AIOTMaterials.NETHERITE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));

    public static final Item boneAiot = new AIOTBase(AIOTMaterials.BONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item coalAiot = new AIOTBase(AIOTMaterials.COAL, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item emeraldAiot = new AIOTBase(AIOTMaterials.EMERALD, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item enderAiot = new AIOTBase(AIOTMaterials.ENDER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item fieryAiot = new AIOTBase(AIOTMaterials.FIERY, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item glowstoneAiot = new AIOTBase(AIOTMaterials.GLOWSTONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item lapisAiot = new AIOTBase(AIOTMaterials.LAPIS, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item netherAiot = new AIOTBase(AIOTMaterials.NETHER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item obsidianAiot = new ObsidianAIOT(AIOTMaterials.OBSIDIAN, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item paperAiot = new AIOTBase(AIOTMaterials.PAPER, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item prismarineAiot = new AIOTBase(AIOTMaterials.PRISMARINE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item quartzAiot = new AIOTBase(AIOTMaterials.QUARTZ, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item redstoneAiot = new AIOTBase(AIOTMaterials.REDSTONE, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
    public static final Item slimeAiot = new AIOTBase(AIOTMaterials.SLIME, new Item.Properties().tab(VanillaAIOTs.getInstance().tab));
}
