package com.bungfro.corruption.client.models;


import com.bungfro.corruption.Corruption;
import com.bungfro.corruption.entity.entities.BulculiterEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class BulculiterEntityModel extends EntityModel<BulculiterEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Corruption.MOD_ID, "bulculiter_entity"), "main");
	private final ModelPart mean;
	private final ModelPart l_hand;
	private final ModelPart r_hand;
	private final ModelPart tail;

	public BulculiterEntityModel(ModelPart root) {
		this.mean = root.getChild("mean");
		this.l_hand = root.getChild("l_hand");
		this.r_hand = root.getChild("r_hand");
		this.tail = root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition mean = partdefinition.addOrReplaceChild("mean", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(32, 32).addBox(5.0F, -17.0F, -9.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 32).addBox(-9.0F, -10.0F, -9.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 32).addBox(-10.0F, -13.0F, -10.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 32).addBox(8.0F, -14.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 32).addBox(5.0F, -9.0F, -9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 32).addBox(-10.0F, -9.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		mean.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -8.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -16.0F, -5.0F, -0.5236F, 0.1309F, 0.0F));

		mean.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -8.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -16.0F, -5.0F, -0.5236F, -0.1309F, 0.0F));

		PartDefinition l_hand = partdefinition.addOrReplaceChild("l_hand", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, 3.0F));

		l_hand.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -4.0F, -16.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(32, 40).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -5.0F, -11.0F, 0.2618F, -0.2618F, 0.0F));

		PartDefinition r_hand = partdefinition.addOrReplaceChild("r_hand", CubeListBuilder.create(), PartPose.offset(8.0F, 9.0F, -8.0F));

		r_hand.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -4.0F, -16.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(32, 40).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 0.0F, 0.0F, 0.2618F, 0.2618F, 0.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, 0.0F));

		tail.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		tail.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.5718F, -1.3301F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 3.0F, 0.2618F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(BulculiterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		mean.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		l_hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		r_hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}