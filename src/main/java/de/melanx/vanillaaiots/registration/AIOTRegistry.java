package de.melanx.vanillaaiots.registration;

import de.melanx.vanillaaiots.compat.CompatHelper;
import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.items.DummyItem;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModList;
import org.moddingx.libx.annotation.registration.RegisterClass;

import java.util.List;

@RegisterClass(registry = "ITEM")
public class AIOTRegistry {

    @SuppressWarnings("ConstantConditions")
    public static final Item woodenAiot = new BaseAiot(ToolMaterials.WOODEN, new Item.Properties());
    public static final Item stoneAiot = new BaseAiot(ToolMaterials.STONE, new Item.Properties());
    public static final Item ironAiot = new BaseAiot(ToolMaterials.IRON, new Item.Properties());
    public static final Item goldenAiot = new BaseAiot(ToolMaterials.GOLDEN, new Item.Properties());
    public static final Item diamondAiot = new BaseAiot(ToolMaterials.DIAMOND, new Item.Properties());
    public static final Item netheriteAiot = new BaseAiot(ToolMaterials.NETHERITE, new Item.Properties());

    public static final Item boneAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.BONE, new Item.Properties());
    public static final Item coalAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.COAL, new Item.Properties());
    public static final Item copperAiot = AIOTRegistry.makeItem(List.of(CompatHelper.SIMPLEST_COPPER_GEAR, CompatHelper.MOREVANILLATOOLS), ToolMaterials.COPPER, new Item.Properties());
    public static final Item emeraldAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.EMERALD, new Item.Properties());
    public static final Item enderAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.ENDER, new Item.Properties());
    public static final Item fieryAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.FIERY, new Item.Properties());
    public static final Item glowstoneAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.GLOWSTONE, new Item.Properties());
    public static final Item lapisAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.LAPIS, new Item.Properties());
    public static final Item netherAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.NETHER, new Item.Properties());
    public static final Item obsidianAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.OBSIDIAN, new Item.Properties());
    public static final Item paperAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.PAPER, new Item.Properties());
    public static final Item prismarineAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.PRISMARINE, new Item.Properties());
    public static final Item quartzAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.QUARTZ, new Item.Properties());
    public static final Item redstoneAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.REDSTONE, new Item.Properties());
    public static final Item slimeAiot = AIOTRegistry.makeItem(CompatHelper.MOREVANILLATOOLS, ToolMaterials.SLIME, new Item.Properties());

    public static final Item skyrootAiot = AIOTRegistry.makeItem(CompatHelper.AETHER, ToolMaterials.SKYROOT, new Item.Properties(), 6.0F, -3.0F);
    public static final Item holystoneAiot = AIOTRegistry.makeItem(CompatHelper.AETHER, ToolMaterials.HOLYSTONE, new Item.Properties(), 7.0F, -3.0F);
    public static final Item zaniteAiot = AIOTRegistry.makeItem(CompatHelper.AETHER, ToolMaterials.ZANITE, new Item.Properties(), 6.0F, -2.9F);
    public static final Item gravititeAiot = AIOTRegistry.makeItem(CompatHelper.AETHER, ToolMaterials.GRAVITITE, new Item.Properties(), 5.0F, -2.8F);
    public static final Item valkyrieAiot = AIOTRegistry.makeItem(CompatHelper.AETHER, ToolMaterials.VALKYRIE, new Item.Properties(), 5.0F, -3.1F);

    public static final Item phoenixAiot = AIOTRegistry.makeItem(CompatHelper.AETHER_LOST_CONTENT, ToolMaterials.PHOENIX, new Item.Properties()); // todo adjust damage and speed

    public static final Item skyjadeAiot = AIOTRegistry.makeItem(CompatHelper.DEEP_AETHER, ToolMaterials.SKYJADE, new Item.Properties(), 1.0F, -2.8F);
    public static final Item stratusAiot = AIOTRegistry.makeItem(CompatHelper.DEEP_AETHER, ToolMaterials.STRATUS, new Item.Properties(), 5.0F, -2.8F);

    public static Item makeItem(String modid, ToolMaterials tier, Item.Properties properties) {
        return AIOTRegistry.makeItem(List.of(modid), tier, properties, BaseAiot.ATTACK_DAMAGE, BaseAiot.ATTACK_SPEED);
    }

    public static Item makeItem(String modid, ToolMaterials tier, Item.Properties properties, float attackDamage, float attackSpeed) {
        return AIOTRegistry.makeItem(List.of(modid), tier, properties, attackDamage, attackSpeed);
    }

    public static Item makeItem(List<String> modids, ToolMaterials tier, Item.Properties properties) {
        return AIOTRegistry.makeItem(modids, tier, properties, BaseAiot.ATTACK_DAMAGE, BaseAiot.ATTACK_SPEED);
    }

    public static Item makeItem(List<String> modids, ToolMaterials tier, Item.Properties properties, float attackDamage, float attackSpeed) {
        for (String modid : modids) {
            if (ModList.get().isLoaded(modid)) {
                return new BaseAiot(tier, properties, DiggerItem.createAttributes(tier, attackDamage, attackSpeed));
            }
        }

        return new DummyItem(modids);
    }
}
