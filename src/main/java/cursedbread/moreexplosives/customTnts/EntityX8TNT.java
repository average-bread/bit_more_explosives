package cursedbread.moreexplosives.customTnts;

import net.minecraft.core.entity.EntityTNT;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;

public class EntityX8TNT extends EntityTNT {
	public int fuse = 0;
	public EntityX8TNT(World world) {
		super(world);
		this.blocksBuilding = true;
		this.setSize(0.98f, 0.98f);
		this.heightOffset = this.bbHeight / 2.0f;
	}

	public EntityX8TNT(World world, double d, double d1, double d2) {
		this(world);
		this.setPos(d, d1, d2);
		float f = (float)(Math.random() * 3.1415927410125732 * 2.0);
		this.xd = -MathHelper.sin(f * 3.141593f / 180.0f) * 0.02f;
		this.yd = 0.2f;
		this.zd = -MathHelper.cos(f * 3.141593f / 180.0f) * 0.02f;
		this.fuse = 80;
		this.xo = d;
		this.yo = d1;
		this.zo = d2;
	}

	@Override
	public void tick() {
		this.checkOnWater(true);
		this.checkOnWater(true);
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		this.yd -= 0.04;
		this.move(this.xd, this.yd, this.zd);
		this.xd *= 0.98;
		this.yd *= 0.98;
		this.zd *= 0.98;
		if (this.onGround) {
			this.xd *= 0.7;
			this.zd *= 0.7;
			this.yd *= -0.5;
		}
		if (this.fuse-- <= 0) {
			if (!this.world.isClientSide) {
				this.remove();
				this.explode();
			} else {
				this.remove();
			}
		} else {
			this.world.spawnParticle("smoke", this.x, this.y + 0.5, this.z, 0.0, 0.0, 0.0, 0);
		}
	}

	private void explode() {
		float f = 32.0f;
		this.world.createExplosion(null, this.x, this.y, this.z, f);
	}
}
