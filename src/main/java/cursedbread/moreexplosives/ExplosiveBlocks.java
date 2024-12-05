package cursedbread.moreexplosives;

import cursedbread.moreexplosives.customTnts.BlockX8TNT;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockTNT;
import net.minecraft.core.block.material.Material;
import turniplabs.halplibe.helper.BlockBuilder;

import static cursedbread.moreexplosives.ExplosiveMain.MOD_ID;

public class ExplosiveBlocks {

	public static int blockId;

	public static Block x8Tnt;

	private void initializeBlockDetails(){

	}
	public void initilizeBlocks() {
		x8Tnt = new BlockBuilder(MOD_ID)
			.setBlockModel(block -> new BlockModelStandard<>(block)
				.withTextures(":block/x8_tnt_top", "moreexplosives:block/x8_tnt_bottom", "moreexplosives:block/x8_tnt_side")
			)
				.build(new BlockX8TNT("x8Tnt", blockId++));

		initializeBlockDetails();
	}
}
