package cursedbread.moreexplosives;

import cursedbread.moreexplosives.customTnts.EntityX8TNT;
import net.minecraft.client.render.entity.TNTRenderer;
import turniplabs.halplibe.helper.EntityHelper;

public class ExplosiveEntities {
	public static int entityId;

	public void initilizeEntities(){
		EntityHelper.createEntity(EntityX8TNT.class, entityId++, "x8tnt", TNTRenderer::new);
	}
}
