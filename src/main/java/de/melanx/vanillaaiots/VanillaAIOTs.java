package de.melanx.vanillaaiots;

import de.melanx.vanillaaiots.compat.CompatHelper;
import de.melanx.vanillaaiots.config.VanillaCondition;
import de.melanx.vanillaaiots.items.AIOTRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.moddingx.libx.mod.ModXRegistration;
import org.moddingx.libx.registration.RegistrationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

@Mod("vanillaaiots")
public final class VanillaAIOTs extends ModXRegistration {

    public static Logger LOGGER = LoggerFactory.getLogger(VanillaAIOTs.class);
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
        CraftingHelper.register(VanillaCondition.SERIALIZER);
        CompatHelper.loadTiers();
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

    public static VanillaAIOTs getInstance() {
        return instance;
    }
}
