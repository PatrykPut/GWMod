package net.patrykput.gw.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.patrykput.gw.entity.ModEntities;
import net.patrykput.gw.entity.custom.CustomArrow;

public class MusketItem extends Item {

    public MusketItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (!world.isClientSide) {
            CustomArrow arrow = new CustomArrow(ModEntities.CUSTOM_ARROW.get(), world);
            arrow.setOwner(player);
            arrow.setPos(player.getX(), player.getY() + player.getEyeHeight(), player.getZ());
            arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 6.0F, 4.0F);
            world.addFreshEntity(arrow);
        }
        return InteractionResultHolder.success(itemStack);
    }
    @Override
    public int getUseDuration(ItemStack stack) {
        return 100;
    }
}
//hund