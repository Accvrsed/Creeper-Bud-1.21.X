package net.cvrse.creepbud.entity;

import net.cvrse.creepbud.CreeperBud;
import net.cvrse.creepbud.entity.custom.CreeperBudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<CreeperBudEntity> CREEPERBUD = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CreeperBud.MOD_ID, "creeperbud"),
            EntityType.Builder.create(CreeperBudEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.5f, 1f). build());

    public static void registerModEntities() {
        CreeperBud.LOGGER.info("Registering Mod entities for " + CreeperBud.MOD_ID);
    }
}
