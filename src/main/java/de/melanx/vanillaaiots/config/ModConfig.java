package de.melanx.vanillaaiots.config;

import de.melanx.vanillaaiots.compat.ToolsCompat;
import io.github.noeppi_noeppi.libx.annotation.config.RegisterConfig;
import io.github.noeppi_noeppi.libx.config.Config;
import io.github.noeppi_noeppi.libx.config.Group;
import net.minecraft.world.item.Tiers;

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

        @Group("If you installed MoreVanillaTools later, please remove this whole section to generate proper values")
        public static class MoreVanillaTools {

            @Config
            public static ConfigureableMaterial bone = ConfigureableMaterial.of(ToolsCompat.getTierFor("bone"));

            @Config
            public static ConfigureableMaterial coal = ConfigureableMaterial.of(ToolsCompat.getTierFor("coal"));

            @Config
            public static ConfigureableMaterial emerald = ConfigureableMaterial.of(ToolsCompat.getTierFor("emerald"));

            @Config
            public static ConfigureableMaterial ender = ConfigureableMaterial.of(ToolsCompat.getTierFor("ender"));

            @Config
            public static ConfigureableMaterial fiery = ConfigureableMaterial.of(ToolsCompat.getTierFor("fiery"));

            @Config
            public static ConfigureableMaterial glowstone = ConfigureableMaterial.of(ToolsCompat.getTierFor("glowstone"));

            @Config
            public static ConfigureableMaterial lapis = ConfigureableMaterial.of(ToolsCompat.getTierFor("lapis"));

            @Config
            public static ConfigureableMaterial nether = ConfigureableMaterial.of(ToolsCompat.getTierFor("nether"));

            @Config
            public static ConfigureableMaterial obsidian = ConfigureableMaterial.of(ToolsCompat.getTierFor("obsidian"));

            @Config
            public static ConfigureableMaterial paper = ConfigureableMaterial.of(ToolsCompat.getTierFor("paper"));

            @Config
            public static ConfigureableMaterial prismarine = ConfigureableMaterial.of(ToolsCompat.getTierFor("prismarine"));

            @Config
            public static ConfigureableMaterial quartz = ConfigureableMaterial.of(ToolsCompat.getTierFor("quartz"));

            @Config
            public static ConfigureableMaterial redstone = ConfigureableMaterial.of(ToolsCompat.getTierFor("redstone"));

            @Config
            public static ConfigureableMaterial slime = ConfigureableMaterial.of(ToolsCompat.getTierFor("slime"));
        }
    }
}
