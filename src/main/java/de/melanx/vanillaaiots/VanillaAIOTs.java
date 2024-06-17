package de.melanx.vanillaaiots;

import de.melanx.vanillaaiots.compat.CompatHelper;
import de.melanx.vanillaaiots.config.VanillaCondition;
import de.melanx.vanillaaiots.data.AIOTTags;
import de.melanx.vanillaaiots.data.ItemModels;
import de.melanx.vanillaaiots.data.recipes.ConditionalRecipes;
import de.melanx.vanillaaiots.data.recipes.EnderiteRecipes;
import de.melanx.vanillaaiots.data.recipes.Recipes;
import de.melanx.vanillaaiots.data.recipes.SimplestCopperGearRecipes;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.moddingx.libx.datagen.DatagenSystem;
import org.moddingx.libx.mod.ModXRegistration;
import org.moddingx.libx.registration.RegistrationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod("vanillaaiots")
public final class VanillaAIOTs extends ModXRegistration {

    public static Logger LOGGER = LoggerFactory.getLogger(VanillaAIOTs.class);
    private static VanillaAIOTs instance;

    public VanillaAIOTs() {
        instance = this;
        CraftingHelper.register(VanillaCondition.SERIALIZER);

        DatagenSystem.create(this, system -> {
            system.addDataProvider(AIOTTags::new);
            system.addDataProvider(ItemModels::new);
            system.addDataProvider(Recipes::new);
            system.addDataProvider(ConditionalRecipes::new);
            system.addDataProvider(SimplestCopperGearRecipes::new);
            system.addDataProvider(EnderiteRecipes::new);
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
}
