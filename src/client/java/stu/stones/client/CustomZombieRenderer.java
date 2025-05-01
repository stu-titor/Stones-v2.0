package stu.stones.client;


import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.util.Identifier;

public class CustomZombieRenderer extends ZombieEntityRendererStu {
    public CustomZombieRenderer(EntityRendererFactory.Context context) {
        super(context);
    }


}