package net.patrykput.gw.world.feature;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.patrykput.gw.GW;
import net.patrykput.gw.block.ModBlocks;


import java.util.List;
import java.util.function.Supplier;

    public class ModConfiguredFeatures {
        public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE =
                DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, GW.MOD_ID);

        public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_AMBER_ORES = Suppliers.memoize(() -> List.of(
                OreConfiguration.target(new BlockMatchTest(Blocks.SAND), ModBlocks.AMBER_ORE.get().defaultBlockState())));

        public static final RegistryObject<ConfiguredFeature<?,?>> AMBER_ORE = CONFIGURED_FEATURE.register("amber_ore",
                () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_AMBER_ORES.get(), 7)));

        public static void register(IEventBus eventBus) {
            CONFIGURED_FEATURE.register(eventBus);
        }
    }

