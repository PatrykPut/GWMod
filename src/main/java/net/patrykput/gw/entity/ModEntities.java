package net.patrykput.gw.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.patrykput.gw.GW;
import net.patrykput.gw.entity.custom.CustomArrow;

@Mod.EventBusSubscriber(modid = GW.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GW.MOD_ID);

    public static final RegistryObject<EntityType<CustomArrow>> CUSTOM_ARROW = ENTITIES.register("custom_arrow",
            () -> EntityType.Builder.of((EntityType.EntityFactory<CustomArrow>) CustomArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .build("custom_arrow"));
}