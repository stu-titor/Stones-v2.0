package stu.stones;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;


public class ModEntities {

        public static final EntityType<CustomZombieEntity> CUSTOM_ZOMBIE = Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.of("stones", "custom_zombie"),
                FabricEntityType.Builder.createMob(CustomZombieEntity::new,SpawnGroup.MONSTER, builder -> builder )
                        .dimensions(0.6f, 1.95f).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of("stones","custom_zombie"))));


        public static void registerModEntities() {
            FabricDefaultAttributeRegistry.register(CUSTOM_ZOMBIE, CustomZombieEntity.createMobAttributes());
        }
}
