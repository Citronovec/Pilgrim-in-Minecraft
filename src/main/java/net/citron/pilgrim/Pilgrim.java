package net.citron.pilgrim;

import net.citron.pilgrim.block.ModBlocks;
import net.citron.pilgrim.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pilgrim implements ModInitializer {
	public static final String MOD_ID = "pilgrim";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
//toto je test komentáře XD
	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}