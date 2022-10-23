package de.melanx.vanillaaiots;

import de.melanx.vanillaaiots.config.VanillaCondition;
import de.melanx.vanillaaiots.items.AIOTRegistry;
import io.github.noeppi_noeppi.libx.mod.registration.ModXRegistration;
import io.github.noeppi_noeppi.libx.mod.registration.RegistrationBuilder;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nonnull;

@Mod("vanillaaiots")
public final class VanillaAIOTs extends ModXRegistration {

    private static VanillaAIOTs instance;

    public VanillaAIOTs() {
        super(new CreativeModeTab("vanillaaiots") {

            @Nonnull
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(AIOTRegistry.diamondAiot);
            }
        });

        instance = this;

        MinecraftForge.EVENT_BUS.register(new EventHandler());
        CraftingHelper.register(VanillaCondition.SERIALIZER);
    }

    @Override
    protected void initRegistration(RegistrationBuilder builder) {
        builder.setVersion(1);
    }

    @Override
    protected void setup(FMLCommonSetupEvent event) {
        // NO-OP
    }

    @Override
    protected void clientSetup(FMLClientSetupEvent event) {
        // NO-OP
    }

    public static VanillaAIOTs getInstance() {
        return instance;
    }
}
