package net.patrykput.gw.entity.custom;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;


public class CustomArrow extends AbstractArrow {

    public CustomArrow(EntityType<CustomArrow> type, double x, double y, double z, Level world) {
        super(type, world);
        this.setBaseDamage(20.0D);
        this.setNoGravity(true);
    }

    public CustomArrow(EntityType<CustomArrow> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
    }

    public CustomArrow(EntityType<CustomArrow> customArrowEntityType, Level worldIn) {
        super(customArrowEntityType, worldIn);
    }

    @Override
    public void tick() {
        super.tick();

        Vec3 vec3d = this.getDeltaMovement();
        double speed = 6.0D;
        this.setDeltaMovement(vec3d.scale(speed));
    }

    @Override
    protected ItemStack getPickupItem() {
        return null;
    }
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level.isClientSide) {
            this.remove(RemovalReason.KILLED);
        }
    }
}

