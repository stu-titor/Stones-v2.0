package stu.stones.client;

import net.fabricmc.api.ClientModInitializer;

public class StonesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModModelLayers.register();
        EntityRendererRegistry.register(ModEntities.CUSTOM_ZOMBIE, CustomZombieRenderer::new);
    }
}
