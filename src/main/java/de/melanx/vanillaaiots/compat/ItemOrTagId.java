package de.melanx.vanillaaiots.compat;

import net.minecraft.resources.ResourceLocation;

public record ItemOrTagId(String modid, String id, boolean isTag) {

    public ItemOrTagId(String modid, String id) {
        this(modid, id, false);
    }

    public ResourceLocation getLocation() {
        return new ResourceLocation(this.modid, this.id);
    }
}
