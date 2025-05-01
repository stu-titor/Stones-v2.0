package stu.stones.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import stu.stones.ModEntities;

public class StonesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.CUSTOM_ZOMBIE, CustomZombieRenderer::new);
    }
}
