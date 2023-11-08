package net.patrykput.gw.item.custom;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.patrykput.gw.item.ModItems;

public class ModCreativeModeTab {
    public static final CreativeModeTab GW_TAB = new CreativeModeTab("gwtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MUSKET.get());
        }
    };
}

