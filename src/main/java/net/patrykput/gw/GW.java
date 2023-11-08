package net.patrykput.gw;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.patrykput.gw.block.ModBlocks;
import net.patrykput.gw.entity.ModEntities;
import net.patrykput.gw.entity.custom.CustomArrowRenderer;
import net.patrykput.gw.item.ModItems;
import org.slf4j.Logger;

@Mod(GW.MOD_ID)
public class GW {

    public static final String MOD_ID = "gw";
    private static final Logger LOGGER = LogUtils.getLogger();

    public GW() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modEventBus);
        ModEntities.ENTITIES.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {

    }
    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public class ClientSetup {
        @SubscribeEvent
        public static void doSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.CUSTOM_ARROW.get(), CustomArrowRenderer::new);
        }
    }
}