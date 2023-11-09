package net.patrykput.gw.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class HolyCross extends SwordItem {

    public HolyCross(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

   @Mod.EventBusSubscriber(modid = "gw")
   public static class MyModEventHandlers {
        @SubscribeEvent
       public void onLivingHurt(LivingHurtEvent event){
            if (event.getSource().getDirectEntity() instanceof Player) {
                Player player = (Player) event.getSource().getDirectEntity();
                if (player.getMainHandItem().getItem() instanceof HolyCross) {
                    if (event.getEntity() instanceof Zombie || event.getEntity() instanceof Skeleton) {
                        event.setAmount(event.getAmount() + 500.0F);
                    }
                }
            }
        }
   }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {

            components.add(Component.literal("+10 damage against undead").withStyle(ChatFormatting.YELLOW));

        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }
}
