package cursedbread.moreexplosives;

import cursedbread.moreexplosives.customTnts.BlockX8TNT;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockTNT;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.sound.BlockSound;
import turniplabs.halplibe.helper.BlockBuilder;

import static cursedbread.moreexplosives.ExplosiveMain.MOD_ID;

public class ExplosiveBlocks {

	BlockBuilder modtnt = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
		.setHardness(0.0f)
		.setResistance(0.0f)
		.setBlockModel(BlockModelStandard::new);

	public static int blockId;

	public static Block x8Tnt;

	private void initializeBlockDetails(){

	}
	public void initilizeBlocks() {
		x8Tnt = modtnt
			.setBlockModel(block -> new BlockModelStandard<>(block).withTextures("moreexplosives:block/x8_tnt_top", "moreexplosives:block/x8_tnt_bottom", "moreexplosives:block/x8_tnt_side"))
			.build(new BlockX8TNT("x8Tnt", blockId++));

		initializeBlockDetails();
	}
}
