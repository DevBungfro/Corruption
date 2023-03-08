package com.bungfro.corruption.block.entity.renderer;

import com.bungfro.corruption.block.entity.WorkplaceOfCorruptionBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class WorkplaceOfCorruptionBlockEntityRenderer implements BlockEntityRenderer<WorkplaceOfCorruptionBlockEntity> {
    public WorkplaceOfCorruptionBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(WorkplaceOfCorruptionBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {

        pPoseStack.pushPose();
        pPoseStack.translate(0.5f, 0.65f, 0.5f);
        pPoseStack.scale(0.25f, 0.25f, 0.25f);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(90));

        pPoseStack.popPose();
    }
}
