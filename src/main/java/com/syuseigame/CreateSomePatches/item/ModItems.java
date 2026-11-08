package com.syuseigame.CreateSomePatches.item;

import net.minecraft.world.item.Item;
import com.syuseigame.CreateSomePatches.createsomepatches;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(createsomepatches.MOD_ID);

//-----追加するアイテム群------
    public static final DeferredItem<Item> ENRICHED_QUARTZ=ITEMS.register("enriched_quartz",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MY_FLUID_BUCKET = ITEMS.register("bucket_in_heated_lava",() -> new Item(new Item.Properties()));
//--------------------------
public static void register(IEventBus eventBus)
{
    ITEMS.register(eventBus);
}
}

