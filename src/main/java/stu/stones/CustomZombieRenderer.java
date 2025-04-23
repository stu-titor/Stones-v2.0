package stu.stones;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class CustomZombieRenderer extends ZombieEntityRenderer {
    public CustomZombieRenderer(EntityRenderFactory.Context context) {
        super(context, new CustomZombieModel(context.getPart(ModModelLayers.CUSTOM_ZOMBIE)), 0.5f);
    }

    @Override
    public void getTexture(CustomZombieEntity entity) {
        return Identifier.of("custom_zombie", "textures/entity/custom_zombie.png");
    }
}