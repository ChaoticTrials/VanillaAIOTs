package de.melanx.vanillaaiots.items;

import de.melanx.vanillaaiots.VanillaAIOTs;
import de.melanx.vanillaaiots.config.ModConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.moddingx.libx.annotation.registration.RegisterClass;

@RegisterClass(registry = "CREATIVE_MODE_TAB")
public class ModCreativeTab {

    public static final CreativeModeTab morevanillatoolsTab = CreativeModeTab.builder()
            .title(Component.literal("Vanilla AIOTs"))
            .icon(() -> new ItemStack(AIOTRegistry.diamondAiot))
            .displayItems((enabledFlags, output) -> {
                for (Item item : ForgeRegistries.ITEMS.getValues()) {
                    //noinspection DataFlowIssue
                    if (VanillaAIOTs.getInstance().modid.equals(ForgeRegistries.ITEMS.getKey(item).getNamespace())) {
                        if (!(item instanceof BaseAiot tool) || (!tool.isVanilla() && ModConfig.vanillaOnly)) {
                            continue;
                        }

                        output.accept(new ItemStack(item));
                    }
                }
            })
            .build();
}
