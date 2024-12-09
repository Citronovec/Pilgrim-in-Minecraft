package net.citron.pilgrim.block;

import net.citron.pilgrim.Pilgrim;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.register;

public class ModBlocks {
    public static final Block PILL_BRICKS = register(
            "pill_bricks",
            new Block(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASEDRUM).solid().requiresTool().strength(2.0F, 6.0F)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Pilgrim.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Pilgrim.MOD_ID, name),
            new BlockItem(block,new Item.Settings()));
    }

    public static void registerModBlocks() {
        Pilgrim.LOGGER.info("Registering Blocks for "+ Pilgrim.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PILL_BRICKS);
        });
    }
}
