package de.melanx.vanillaaiots;

import de.melanx.morevanillalib.ModContent;
import io.github.noeppi_noeppi.libx.mod.registration.ModXRegistration;
import io.github.noeppi_noeppi.libx.mod.registration.RegistrationBuilder;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.NotNull;

@Mod("vanillaaiots")
public final class VanillaAIOTs extends ModXRegistration {

    public VanillaAIOTs() {
        super(new CreativeModeTab("vanillaaiots") {
            @Override
            public @NotNull ItemStack makeIcon() {
                return new ItemStack(Items.DIAMOND_AXE);
            }
        });
    }

    @Override
    protected void initRegistration(RegistrationBuilder builder) {

    }

    @Override
    protected void setup(FMLCommonSetupEvent event) {

    }

    @Override
    protected void clientSetup(FMLClientSetupEvent event) {

    }
}
