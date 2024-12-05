package cursedbread.moreexplosives.customTnts;

import net.minecraft.core.block.BlockTNT;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityTNT;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemFirestriker;
import net.minecraft.core.world.World;

public class BlockX8TNT extends BlockTNT {
	public BlockX8TNT(String key, int id) {
		super(key, id);
	}

	@Override
	public void ignite(World world, int x, int y, int z, EntityPlayer player, boolean sound) {
		if (world.isClientSide) {
			if (player != null && player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ItemFirestriker) {
				player.inventory.getCurrentItem().damageItem(1, player);
			}
			return;
		}
		world.setBlockWithNotify(x, y, z, 0);
		EntityX8TNT e = new EntityX8TNT(world, (float)x + 0.5f, (float)y + 0.5f, (float)z + 0.5f);
		world.entityJoinedWorld(e);
		world.playSoundAtEntity(null, e, "random.fuse", 1.0f, 1.0f);
		if (player != null && player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ItemFirestriker) {
			player.inventory.getCurrentItem().damageItem(1, player);
		}
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z) {
		EntityX8TNT entity = new EntityX8TNT(world, (float)x + 0.5f, (float)y + 0.5f, (float)z + 0.5f);
		entity.fuse = world.rand.nextInt(entity.fuse / 4) + entity.fuse / 8;
		world.entityJoinedWorld(entity);
	}
}
