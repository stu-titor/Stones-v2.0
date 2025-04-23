package stu.stones;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class ModModelLayers {
    public static final EntityModelLayer CUSTOM_ZOMBIE = new EntityModelLayer(Idenifier.of("stones", "custom_zombie"), "main");

    public static void register(){
	EntityModelLayerRegistry.registerModelLayer(CUSTOM_ZOMBIE, CustomZombieModel::getTexturedModelData);
    }
    
}