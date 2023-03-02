package com.bungfro.corruption.client.screen.wpoc;

import com.bungfro.corruption.Corruption;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WorkplaceOfCorruptionScreen extends AbstractContainerScreen<WorkplaceOfCorruptionMenu> {
    private static final ResourceLocation WORKPLACE_LOCATION = new ResourceLocation(Corruption.MOD_ID, "textures/gui/corruption_workplace.png");
    private boolean widthTooNarrow;

    public WorkplaceOfCorruptionScreen(WorkplaceOfCorruptionMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    protected void init() {
        super.init();
        this.imageHeight = 256;
        this.imageWidth = 256;

        this.widthTooNarrow = this.width < 379;
        this.titleLabelX = 29;
    }

    public void containerTick() {
        super.containerTick();
    }

    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        if (this.widthTooNarrow) {
            this.renderBg(pPoseStack, pPartialTick, pMouseX, pMouseY);
        } else {
            super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        }

        this.renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pX, int pY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, WORKPLACE_LOCATION);
        int i = this.leftPos;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(pPoseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

    protected boolean isHovering(int pX, int pY, int pWidth, int pHeight, double pMouseX, double pMouseY) {
        return (!this.widthTooNarrow) && super.isHovering(pX, pY, pWidth, pHeight, pMouseX, pMouseY);
    }

    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        return this.widthTooNarrow ? true : super.mouseClicked(pMouseX, pMouseY, pButton);
    }

    protected boolean hasClickedOutside(double pMouseX, double pMouseY, int pGuiLeft, int pGuiTop, int pMouseButton) {
        boolean flag = pMouseX < (double) pGuiLeft || pMouseY < (double) pGuiTop || pMouseX >= (double) (pGuiLeft + this.imageWidth) || pMouseY >= (double) (pGuiTop + this.imageHeight);

        return super.hasClickedOutside(pMouseX, pMouseY, pGuiLeft, pGuiTop, pMouseButton) && flag;
    }

    /**
     * Called when the mouse is clicked over a slot or outside the gui.
     */
    protected void slotClicked(Slot pSlot, int pSlotId, int pMouseButton, ClickType pType) {
        super.slotClicked(pSlot, pSlotId, pMouseButton, pType);
    }

}

