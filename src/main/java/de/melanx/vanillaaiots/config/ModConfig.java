package de.melanx.vanillaaiots.config;

import io.github.noeppi_noeppi.libx.annotation.config.RegisterConfig;
import io.github.noeppi_noeppi.libx.config.Config;
import io.github.noeppi_noeppi.libx.config.Group;
import net.minecraft.world.item.Tiers;

@RegisterConfig
public class ModConfig {

    //    @Config("This is only relevant when MoreVanillaTools is installed") TODO
    public static boolean vanillaOnly = false;

    @Config({"Multiplier to calculate the durability", "Single tool durability * this value = durability"})
    public static int durabilityModifier = 5;

    @Group
    public static class ToolValues {

        //        @Config
        public static ConfigureableMaterial wood = ConfigureableMaterial.of(Tiers.WOOD);

        //        @Config
        public static ConfigureableMaterial stone = ConfigureableMaterial.of(Tiers.STONE);

        //        @Config
        public static ConfigureableMaterial iron = ConfigureableMaterial.of(Tiers.IRON);

        //        @Config
        public static ConfigureableMaterial gold = ConfigureableMaterial.of(Tiers.GOLD);

        //        @Config
        public static ConfigureableMaterial diamond = ConfigureableMaterial.of(Tiers.DIAMOND);

        //        @Config
        public static ConfigureableMaterial netherite = ConfigureableMaterial.of(Tiers.NETHERITE);
    }
}
