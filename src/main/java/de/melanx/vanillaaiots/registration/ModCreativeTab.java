package de.melanx.vanillaaiots.registration;

import de.melanx.vanillaaiots.config.ModConfig;
import de.melanx.vanillaaiots.items.BaseAiot;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import org.moddingx.libx.creativetab.CreativeTabX;
import org.moddingx.libx.mod.ModX;

public class ModCreativeTab extends CreativeTabX {

    public ModCreativeTab(ModX mod) {
        super(mod);
    }

    @Override
    protected void addItems(TabContext ctx) {
        this.addModItems(ctx, item -> item instanceof BaseAiot tool && (tool.isVanilla() || !ModConfig.vanillaOnly));
    }

    @Override
    protected void buildTab(CreativeModeTab.Builder builder) {
        builder.icon(AIOTRegistry.diamondAiot::getDefaultInstance)
                .title(Component.literal("Vanilla AIOTs"));
    }
}
