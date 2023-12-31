package net.patrykput.gw.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TridentItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.patrykput.gw.GW;
import net.patrykput.gw.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GW.MOD_ID);

    public static final RegistryObject<Item> IRON_SHOT_ITEM = ITEMS.register("iron_shot_item",
            () -> new CustomArrowItem(new Item.Properties().tab(ModCreativeModeTab.GW_TAB)));
    public static final RegistryObject<Item> HOLY_CROSS = ITEMS.register("holy_cross",
            () -> new HolyCross(Tiers.IRON,5,-3F, new Item.Properties().tab(ModCreativeModeTab.GW_TAB)));
    public static final RegistryObject<Item> AMBER = ITEMS.register("amber",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.GW_TAB)));
    public static final RegistryObject<Item> MUSKET = ITEMS.register("basic_musket",
            () -> new MusketItem(new Item.Properties().tab(ModCreativeModeTab.GW_TAB)));
    public static final RegistryObject<Item> AMBER_SPEAR = ITEMS.register("amber_spear",
            () -> new TridentItem(new Item.Properties().tab(ModCreativeModeTab.GW_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register((eventBus));
    }
}