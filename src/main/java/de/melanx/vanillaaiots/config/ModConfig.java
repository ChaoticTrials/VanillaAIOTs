package de.melanx.vanillaaiots.config;

import net.minecraft.world.item.Tiers;
import org.moddingx.libx.annotation.config.RegisterConfig;
import org.moddingx.libx.config.Config;
import org.moddingx.libx.config.Group;

@RegisterConfig
public class ModConfig {

    @Config("This is only relevant when MoreVanillaTools is installed")
    public static boolean vanillaOnly = false;

    @Config({"Multiplier to calculate the durability", "Single tool durability * this value = durability"})
    public static int durabilityModifier = 5;

    @Group
    public static class ToolValues {

        @Config
        public static ConfigureableMaterial wood = ConfigureableMaterial.of(Tiers.WOOD);

        @Config
        public static ConfigureableMaterial stone = ConfigureableMaterial.of(Tiers.STONE);

        @Config
        public static ConfigureableMaterial iron = ConfigureableMaterial.of(Tiers.IRON);

        @Config
        public static ConfigureableMaterial gold = ConfigureableMaterial.of(Tiers.GOLD);

        @Config
        public static ConfigureableMaterial diamond = ConfigureableMaterial.of(Tiers.DIAMOND);

        @Config
        public static ConfigureableMaterial netherite = ConfigureableMaterial.of(Tiers.NETHERITE);
    }
}
