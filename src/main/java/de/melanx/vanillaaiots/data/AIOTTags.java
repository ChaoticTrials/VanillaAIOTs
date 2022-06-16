package de.melanx.vanillaaiots.data;

import de.melanx.morevanillalib.data.ModTags;
import de.melanx.vanillaaiots.items.BaseAiot;
import de.melanx.vanillaaiots.tools.ToolMaterials;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.moddingx.libx.annotation.data.Datagen;
import org.moddingx.libx.datagen.provider.CommonTagsProviderBase;
import org.moddingx.libx.mod.ModX;

@Datagen
public class AIOTTags extends CommonTagsProviderBase {

    public static final TagKey<Block> MINEABLE_WITH_AIOT = BlockTags.create(new ResourceLocation("forge", "mineable/aiot"));

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
            switch (material) {
                case WOODEN -> this.item(ModTags.Items.WOOD_TOOLS).add(item);
                case STONE -> this.item(ModTags.Items.STONE_TOOLS).add(item);
                case IRON -> this.item(ModTags.Items.IRON_TOOLS).add(item);
                case GOLDEN -> this.item(ModTags.Items.GOLD_TOOLS).add(item);
                case DIAMOND -> this.item(ModTags.Items.DIAMOND_TOOLS).add(item);
                case NETHERITE -> this.item(ModTags.Items.NETHERITE_TOOLS).add(item);

                case BONE -> this.item(ModTags.Items.BONE_TOOLS).add(item);
                case COAL -> this.item(ModTags.Items.COAL_TOOLS).add(item);
                case EMERALD -> this.item(ModTags.Items.EMERALD_TOOLS).add(item);
                case ENDER -> this.item(ModTags.Items.ENDER_TOOLS).add(item);
                case FIERY -> this.item(ModTags.Items.FIERY_TOOLS).add(item);
                case GLOWSTONE -> this.item(ModTags.Items.GLOWSTONE_TOOLS).add(item);
                case LAPIS -> this.item(ModTags.Items.LAPIS_TOOLS).add(item);
                case NETHER -> this.item(ModTags.Items.NETHER_TOOLS).add(item);
                case OBSIDIAN -> this.item(ModTags.Items.OBSIDIAN_TOOLS).add(item);
                case PAPER -> this.item(ModTags.Items.PAPER_TOOLS).add(item);
                case PRISMARINE -> this.item(ModTags.Items.PRISMARINE_TOOLS).add(item);
                case QUARTZ -> this.item(ModTags.Items.QUARTZ_TOOLS).add(item);
                case REDSTONE -> this.item(ModTags.Items.REDSTONE_TOOLS).add(item);
                case SLIME -> this.item(ModTags.Items.SLIME_TOOLS).add(item);
            }
        }
    }
}
