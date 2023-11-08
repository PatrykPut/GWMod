package net.patrykput.gw.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.patrykput.gw.entity.ModEntities;
import net.patrykput.gw.entity.custom.CustomArrow;

public class CustomArrowItem extends ArrowItem {

    public CustomArrowItem(Properties properties) {
        super(properties);
    }
    @Override
    public AbstractArrow createArrow(Level world, ItemStack ammoStack, LivingEntity shooter) {
        return new CustomArrow(ModEntities.CUSTOM_ARROW.get(), shooter, world);
    }
}
