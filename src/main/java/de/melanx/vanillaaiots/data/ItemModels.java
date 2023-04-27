package de.melanx.vanillaaiots.data;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.model.ItemModelProviderBase;

public class ItemModels extends ItemModelProviderBase {

    public ItemModels(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {

    }

    @Override
    protected void defaultItem(ResourceLocation id, Item item) {
        this.withExistingParent(id.getPath(), HANDHELD).texture("layer0", new ResourceLocation(id.getNamespace(), "item/" + id.getPath()));
    }
}
