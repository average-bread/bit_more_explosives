package cursedbread.moreexplosives;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;

import java.util.Properties;


public class ExplosiveMain implements ModInitializer, GameStartEntrypoint {
    public static final String MOD_ID = "moreexplosives";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	static {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id","2200");
		prop.setProperty("starting_item_id","17890");
		prop.setProperty("starting_entity_id","634");
		ConfigHandler config = new ConfigHandler(MOD_ID,prop);
		ExplosiveBlocks.blockId = config.getInt("starting_block_id");
		ExplosiveItems.itemId = config.getInt("starting_item_id");
		ExplosiveEntities.entityId = config.getInt("starting_entity_id");
	}

    @Override
    public void onInitialize() {
        LOGGER.info("Exploding your pc");
		new ExplosiveBlocks().initilizeBlocks();
		new ExplosiveItems().initilizeItems();
		new ExplosiveEntities().initilizeEntities();
    }

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}
}
