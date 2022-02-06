package de.melanx.vanillaaiots;

import de.melanx.vanillaaiots.items.AIOTRegistry;
import io.github.noeppi_noeppi.libx.mod.registration.ModXRegistration;
import io.github.noeppi_noeppi.libx.mod.registration.RegistrationBuilder;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.NotNull;

@Mod("vanillaaiots")
public final class VanillaAIOTs extends ModXRegistration {

    private static VanillaAIOTs instance;

    public VanillaAIOTs() {
        super(new CreativeModeTab("vanillaaiots") {
            @Override
            public @NotNull ItemStack makeIcon() {
                return new ItemStack(AIOTRegistry.redstoneAiot);
            }
        });

        instance = this;
    }

    @Override
    protected void initRegistration(RegistrationBuilder builder) {
        builder.setVersion(1);
    }

    @Override
    protected void setup(FMLCommonSetupEvent event) {

    }

    @Override
    protected void clientSetup(FMLClientSetupEvent event) {

    }

    public static VanillaAIOTs getInstance() {
        return instance;
    }
}
