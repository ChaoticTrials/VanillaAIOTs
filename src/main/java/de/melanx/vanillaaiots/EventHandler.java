package de.melanx.vanillaaiots;

import de.melanx.vanillaaiots.compat.LibCompat;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public void onLivingDamage(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof Player player && LibCompat.isMoreVanillaLibLoaded()) {
            LibCompat.onLivingDamageEvent(player, event);
        }
    }
}
