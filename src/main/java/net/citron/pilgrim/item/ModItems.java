package net.citron.pilgrim.item;

import net.citron.pilgrim.Pilgrim;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item Crystal = registerItem("crystal", new Item(new Item.Settings()));
    public static Item AMBER = registerItem("amber", new AmberItem(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Pilgrim.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Pilgrim.LOGGER.info("Registering Mod Items for" + Pilgrim.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(Crystal);
            entries.add(AMBER);
        });
    }
}
