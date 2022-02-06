package de.melanx.vanillaaiots.data;

import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import io.github.noeppi_noeppi.libx.annotation.data.Datagen;
import io.github.noeppi_noeppi.libx.data.provider.CommonTagsProviderBase;
import io.github.noeppi_noeppi.libx.mod.ModX;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

@Datagen
public class AIOTTags extends CommonTagsProviderBase {

    public static final Tag.Named<Block> MINEABLE_WITH_AIOT = BlockTags.bind("forge:mineable/aiot");

    public AIOTTags(ModX mod, DataGenerator generator, ExistingFileHelper fileHelper) {
        super(mod, generator, fileHelper);
    }

    @Override
    public void setup() {
        //noinspection unchecked
        this.block(MINEABLE_WITH_AIOT).addTags(
                BlockTags.MINEABLE_WITH_AXE,
                BlockTags.MINEABLE_WITH_HOE,
                BlockTags.MINEABLE_WITH_PICKAXE,
                BlockTags.MINEABLE_WITH_SHOVEL
        );
    }

    @Override
    public void defaultItemTags(Item item) {
        if (item instanceof BaseAiot aiot) {
            ToolMaterials material = aiot.getTier();
//            switch (material) {
//                case WOODEN -> this.item(ModTags.Items.WOOD_TOOLS).add(item);
//                case STONE -> this.item(ModTags.Items.STONE_TOOLS).add(item);
//                case IRON -> this.item(ModTags.Items.IRON_TOOLS).add(item);
//                case GOLDEN -> this.item(ModTags.Items.GOLD_TOOLS).add(item);
//                case DIAMOND -> this.item(ModTags.Items.DIAMOND_TOOLS).add(item);
//                case NETHERITE -> this.item(ModTags.Items.NETHERITE_TOOLS).add(item);
//            }
//            if (RangeMaterials.BONE.equals(material)) {
//                this.item(ModTags.Items.BONE_TOOLS).add(item);
//            } else if (RangeMaterials.COAL.equals(material)) {
//                this.item(ModTags.Items.COAL_TOOLS).add(item);
//            } else if (RangeMaterials.EMERALD.equals(material)) {
//                this.item(ModTags.Items.EMERALD_TOOLS).add(item);
//            } else if (RangeMaterials.ENDER.equals(material)) {
//                this.item(ModTags.Items.ENDER_TOOLS).add(item);
//            } else if (RangeMaterials.FIERY.equals(material)) {
//                this.item(ModTags.Items.FIERY_TOOLS).add(item);
//            } else if (RangeMaterials.GLOWSTONE.equals(material)) {
//                this.item(ModTags.Items.GLOWSTONE_TOOLS).add(item);
//            } else if (RangeMaterials.LAPIS.equals(material)) {
//                this.item(ModTags.Items.LAPIS_TOOLS).add(item);
//            } else if (RangeMaterials.NETHER.equals(material)) {
//                this.item(ModTags.Items.NETHER_TOOLS).add(item);
//            } else if (RangeMaterials.OBSIDIAN.equals(material)) {
//                this.item(ModTags.Items.OBSIDIAN_TOOLS).add(item);
//            } else if (RangeMaterials.PAPER.equals(material)) {
//                this.item(ModTags.Items.PAPER_TOOLS).add(item);
//            } else if (RangeMaterials.PRISMARINE.equals(material)) {
//                this.item(ModTags.Items.PRISMARINE_TOOLS).add(item);
//            } else if (RangeMaterials.QUARTZ.equals(material)) {
//                this.item(ModTags.Items.QUARTZ_TOOLS).add(item);
//            } else if (RangeMaterials.REDSTONE.equals(material)) {
//                this.item(ModTags.Items.REDSTONE_TOOLS).add(item);
//            } else if (RangeMaterials.SLIME.equals(material)) {
//                this.item(ModTags.Items.SLIME_TOOLS).add(item);
//            }
        }
    }
}
