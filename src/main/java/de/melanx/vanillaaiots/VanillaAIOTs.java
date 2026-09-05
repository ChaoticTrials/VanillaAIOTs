package de.melanx.vanillaaiots;

import de.melanx.vanillaaiots.compat.CompatHelper;
import de.melanx.vanillaaiots.data.AIOTTags;
import de.melanx.vanillaaiots.data.ItemModels;
import de.melanx.vanillaaiots.data.recipes.*;
import de.melanx.vanillaaiots.registration.ModCreativeTab;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.moddingx.libx.datagen.DatagenSystem;
import org.moddingx.libx.mod.ModXRegistration;
import org.moddingx.libx.registration.RegistrationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod("vanillaaiots")
public final class VanillaAIOTs extends ModXRegistration {

    public static Logger LOGGER = LoggerFactory.getLogger(VanillaAIOTs.class);
    private static VanillaAIOTs instance;
    private final ModCreativeTab creativeTab;

    public VanillaAIOTs() {
        instance = this;
        this.creativeTab = new ModCreativeTab(this);

        DatagenSystem.create(this, system -> {
            system.addDataProvider(AIOTTags::new);
            system.addDataProvider(ItemModels::new);
            system.addDataProvider(Recipes::new);
            system.addDataProvider(ConditionalRecipes::new);
            system.addDataProvider(SimplestCopperGearRecipes::new);
//            system.addDataProvider(AetherLostContentRecipes::new);
            system.addDataProvider(AetherRecipes::new);
            system.addDataProvider(DeepAetherRecipes::new);
            system.addDataProvider(TwilightForestRecipes::new);
        });

        CompatHelper.loadTiers();
    }

    @Override
    protected void setup(FMLCommonSetupEvent event) {
        // NO-OP
    }

    @Override
    protected void clientSetup(FMLClientSetupEvent event) {
        // NO-OP
    }

    @Override
    protected void initRegistration(RegistrationBuilder builder) {
        // NO-OP
    }

    public static VanillaAIOTs getInstance() {
        return instance;
    }

    public static ModCreativeTab getCreativeTab() {
        return instance.creativeTab;
    }
}
