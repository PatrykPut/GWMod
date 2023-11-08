package net.patrykput.gw.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.patrykput.gw.entity.ModEntities;
import net.patrykput.gw.entity.custom.CustomArrow;

public class MusketItem extends CrossbowItem {

    public MusketItem(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player) {
            Player player = (Player) entityLiving;
            if (!worldIn.isClientSide && getUseDuration(stack) - timeLeft >= 20) {
                CustomArrow arrow = new CustomArrow(ModEntities.CUSTOM_ARROW.get(), worldIn);
                arrow.setOwner(player);
                arrow.setPos(player.getX(), player.getY() + player.getEyeHeight(), player.getZ());
                arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                worldIn.addFreshEntity(arrow);
            }
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 20;
    }
}