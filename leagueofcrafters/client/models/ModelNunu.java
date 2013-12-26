package leagueofcrafters.client.models;

import leagueofcrafters.entity.EntityNuNu;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelNunu extends ModelBase {
	// fields
	ModelRenderer LFoot;
	ModelRenderer RFoot;
	ModelRenderer Belly;
	ModelRenderer Body;
	ModelRenderer RArm1;
	ModelRenderer LArm1;
	ModelRenderer LArm2;
	ModelRenderer RArm2;
	ModelRenderer LLeg;
	ModelRenderer RLeg;
	ModelRenderer RBigToe;
	ModelRenderer LToe2;
	ModelRenderer NunuNeck;
	ModelRenderer LBigToe;
	ModelRenderer RToe2;
	ModelRenderer LToe1;
	ModelRenderer RToe1;
	ModelRenderer Head;
	ModelRenderer NunuBody;
	ModelRenderer Neck;
	ModelRenderer Head2;
	ModelRenderer NunuLLeg;
	ModelRenderer NunuRLeg;
	ModelRenderer NunuRArm;
	ModelRenderer NunuLArm;
	ModelRenderer Snowball;

	ModelRenderer LeftLeg;
	ModelRenderer RightLeg;

	public ModelNunu() {
		textureWidth = 128;
		textureHeight = 64;

		LeftLeg = new ModelRenderer(this, "LeftLeg");
		LFoot = new ModelRenderer(this, 0, 0);
		LFoot.addBox(0F, 0F, 0F, 7, 4, 11);
		LFoot.setRotationPoint(9F, 20F, -8F);
		LFoot.setTextureSize(64, 32);
		LFoot.mirror = true;
		setRotation(LFoot, 0F, -0.4461433F, 0F);
		LLeg = new ModelRenderer(this, 60, 40);
		LLeg.addBox(0F, 0F, 0F, 5, 12, 5);
		LLeg.setRotationPoint(4.5F, 10F, -1.5F);
		LLeg.setTextureSize(64, 32);
		LLeg.mirror = true;
		setRotation(LLeg, 0F, 0F, -0.1487144F);
		LToe2 = new ModelRenderer(this, 48, 33);
		LToe2.addBox(0F, 0F, 0F, 2, 2, 4);
		LToe2.setRotationPoint(16.5F, 22F, -8.1F);
		LToe2.setTextureSize(64, 32);
		LToe2.mirror = true;
		setRotation(LToe2, 0F, -0.9294653F, 0F);
		NunuLLeg = new ModelRenderer(this, 52, 39);
		NunuLLeg.addBox(0F, 0F, 0F, 2, 5, 2);
		NunuLLeg.setRotationPoint(1.5F, -19.7F, -4F);
		NunuLLeg.setTextureSize(64, 32);
		NunuLLeg.mirror = true;
		setRotation(NunuLLeg, -0.8551081F, -0.6320364F, 0F);
		LBigToe = new ModelRenderer(this, 60, 33);
		LBigToe.addBox(0F, 0F, 0F, 3, 3, 4);
		LBigToe.setRotationPoint(9F, 21F, -10.6F);
		LBigToe.setTextureSize(64, 32);
		LBigToe.mirror = true;
		setRotation(LBigToe, 0F, 0F, 0F);
		LToe1 = new ModelRenderer(this, 48, 33);
		LToe1.addBox(0F, 0F, 0F, 2, 2, 4);
		LToe1.setRotationPoint(13.2F, 22F, -9.6F);
		LToe1.setTextureSize(64, 32);
		LToe1.mirror = true;
		setRotation(LToe1, 0F, -0.4461433F, 0F);
		LeftLeg.addChild(LFoot);
		LeftLeg.addChild(LToe1);
		LeftLeg.addChild(LToe2);
		LeftLeg.addChild(LBigToe);
		LeftLeg.addChild(LLeg);

		RightLeg = new ModelRenderer(this, "RightLeg");
		RFoot = new ModelRenderer(this, 0, 0);
		RFoot.addBox(0F, 0F, 0F, 7, 4, 11);
		RFoot.setRotationPoint(-15F, 20F, -5.2F);
		RFoot.setTextureSize(64, 32);
		RFoot.mirror = true;
		setRotation(RFoot, 0F, 0.4461433F, 0F);
		RBigToe = new ModelRenderer(this, 60, 33);
		RBigToe.addBox(0F, 0F, 0F, 3, 3, 4);
		RBigToe.setRotationPoint(-11.7F, 21F, -10.6F);
		RBigToe.setTextureSize(64, 32);
		RBigToe.mirror = true;
		setRotation(RBigToe, 0F, 0F, 0F);
		RToe2 = new ModelRenderer(this, 48, 33);
		RToe2.addBox(0F, 0F, 0F, 2, 2, 4);
		RToe2.setRotationPoint(-17F, 22F, -6.6F);
		RToe2.setTextureSize(64, 32);
		RToe2.mirror = true;
		setRotation(RToe2, 0F, 0.9294653F, 0F);
		RToe1 = new ModelRenderer(this, 48, 33);
		RToe1.addBox(0F, 0F, 0F, 2, 2, 4);
		RToe1.setRotationPoint(-14.8F, 22F, -9F);
		RToe1.setTextureSize(64, 32);
		RToe1.mirror = true;
		setRotation(RToe1, 0F, 0.4461433F, 0F);
		RLeg = new ModelRenderer(this, 60, 40);
		RLeg.addBox(0F, 0F, 0F, 5, 12, 5);
		RLeg.setRotationPoint(-10F, 10F, 1.5F);
		RLeg.setTextureSize(64, 32);
		RLeg.mirror = true;
		setRotation(RLeg, -0.1115358F, 1.189716F, 0.0743572F);

		RightLeg.addChild(RFoot);
		RightLeg.addChild(RLeg);
		RightLeg.addChild(RToe1);
		RightLeg.addChild(RToe2);
		RightLeg.addChild(RBigToe);

		Belly = new ModelRenderer(this, 66, 0);
		Belly.addBox(0F, 0F, 0F, 16, 16, 15);
		Belly.setRotationPoint(-8F, -2F, -9F);
		Belly.setTextureSize(64, 32);
		Belly.mirror = true;
		setRotation(Belly, 0.2602503F, 0F, 0F);
		Body = new ModelRenderer(this, 80, 31);
		Body.addBox(0F, 0F, 0F, 12, 14, 12);
		Body.setRotationPoint(-6F, -11F, -13F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0.5576792F, 0F, 0F);
		RArm1 = new ModelRenderer(this, 0, 54);
		RArm1.addBox(0F, 0F, 0F, 15, 5, 5);
		RArm1.setRotationPoint(-7F, -15.8F, -2F);
		RArm1.setTextureSize(64, 32);
		RArm1.mirror = true;
		setRotation(RArm1, 0F, 3.141593F, -1.041001F);
		LArm1 = new ModelRenderer(this, 0, 54);
		LArm1.addBox(0F, 0F, 0F, 15, 5, 5);
		LArm1.setRotationPoint(6F, -16F, -7F);
		LArm1.setTextureSize(64, 32);
		LArm1.mirror = true;
		setRotation(LArm1, 0F, 0.6320364F, 0.8922867F);
		LArm2 = new ModelRenderer(this, 0, 38);
		LArm2.addBox(0F, 0F, 0F, 14, 8, 8);
		LArm2.setRotationPoint(-18F, 0F, -2F);
		LArm2.setTextureSize(64, 32);
		LArm2.mirror = true;
		setRotation(LArm2, 0F, 1.858931F, -1.152537F);
		RArm2 = new ModelRenderer(this, 0, 38);
		RArm2.addBox(0F, 0F, 0F, 14, 8, 8);
		RArm2.setRotationPoint(8F, -4F, -9F);
		RArm2.setTextureSize(64, 32);
		RArm2.mirror = true;
		setRotation(RArm2, 0F, 2.044824F, -0.8179294F);
		NunuNeck = new ModelRenderer(this, 40, 54);
		NunuNeck.addBox(0F, 0F, 0F, 5, 5, 5);
		NunuNeck.setRotationPoint(0F, -27F, -8F);
		NunuNeck.setTextureSize(64, 32);
		NunuNeck.mirror = true;
		setRotation(NunuNeck, 0F, 0, 0.8285667F);
		Head = new ModelRenderer(this, 54, 24);
		Head.addBox(0F, 0F, 0F, 3, 3, 3);
		Head.setRotationPoint(-1.65F, -24.8F, -8.3F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0.1115358F, 0F, 0F);
		NunuBody = new ModelRenderer(this, 48, 14);
		NunuBody.addBox(0F, 0F, 0F, 5, 6, 4);
		NunuBody.setRotationPoint(-2.5F, -23F, -6.6F);
		NunuBody.setTextureSize(64, 32);
		NunuBody.mirror = true;
		setRotation(NunuBody, 0.2602503F, 0F, 0F);
		Neck = new ModelRenderer(this, 0, 15);
		Neck.addBox(0F, 0F, 0F, 14, 14, 6);
		Neck.setRotationPoint(0F, -22F, -12F);
		Neck.setTextureSize(64, 32);
		Neck.mirror = true;
		setRotation(Neck, -0.1487144F, 0.1115358F, 0.8285667F);
		Head2 = new ModelRenderer(this, 40, 0);
		Head2.addBox(0F, 0F, 0F, 8, 9, 5);
		Head2.setRotationPoint(-4.5F, -16F, -15F);
		Head2.setTextureSize(64, 32);
		Head2.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		NunuRLeg = new ModelRenderer(this, 52, 39);
		NunuRLeg.addBox(0F, 0F, 0F, 2, 5, 2);
		NunuRLeg.setRotationPoint(-3F, -19F, -4F);
		NunuRLeg.setTextureSize(64, 32);
		NunuRLeg.mirror = true;
		setRotation(NunuRLeg, -0.8551081F, 0.5205006F, 0F);
		NunuRArm = new ModelRenderer(this, 48, 39);
		NunuRArm.addBox(0F, 0F, 0F, 1, 4, 1);
		NunuRArm.setRotationPoint(-3F, -22.5F, -5F);
		NunuRArm.setTextureSize(64, 32);
		NunuRArm.mirror = true;
		setRotation(NunuRArm, -1.896109F, 0.7435722F, 0F);
		NunuLArm = new ModelRenderer(this, 48, 39);
		NunuLArm.addBox(0F, 0F, 0F, 1, 4, 1);
		NunuLArm.setRotationPoint(2F, -22.5F, -5F);
		NunuLArm.setTextureSize(64, 32);
		NunuLArm.mirror = true;
		setRotation(NunuLArm, -0.8179294F, -0.1858931F, 0F);
		Snowball = new ModelRenderer(this, 20, 30);
		Snowball.addBox(0F, 0F, 0F, 2, 2, 2);
		Snowball.setRotationPoint(-6F, -24.7F, -10F);
		Snowball.setTextureSize(64, 32);
		Snowball.mirror = true;
		setRotation(Snowball, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.renderNuNu((EntityNuNu) entity, f, f1, f2, f3, f4, f5);
	}

	public void renderNuNu(EntityNuNu entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		LeftLeg.render(f5);
		RightLeg.render(f5);
		Belly.render(f5);
		Body.render(f5);
		RArm1.render(f5);
		LArm1.render(f5);
		LArm2.render(f5);
		RArm2.render(f5);
		NunuNeck.render(f5);
		Head.render(f5);
		NunuBody.render(f5);
		Neck.render(f5);
		Head2.render(f5);
		NunuLLeg.render(f5);
		NunuRLeg.render(f5);
		NunuRArm.render(f5);
		NunuLArm.render(f5);
		if (entity.timer <= 75)
			Snowball.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * .5F * f1 * 0.5F;
		this.LeftLeg.rotateAngleY = 0.0f;

		this.RightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * .5F * f1;
		this.RightLeg.rotateAngleY = 0.0F;

	}

}
