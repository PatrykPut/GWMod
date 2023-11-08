package net.patrykput.gw.entity.custom;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class CustomArrowRenderer extends ArrowRenderer<CustomArrow> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("gw", "textures/entity/iron_shot.png");

    public CustomArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(CustomArrow arrow) {
        return TEXTURE;
    }
}

