package leagueofcrafters.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTeemo extends ModelBase {
	// fields
	ModelRenderer Neck;
	ModelRenderer Body;
	ModelRenderer LLeg;
	ModelRenderer RLeg;
	ModelRenderer RLeg2;
	ModelRenderer LFoot;
	ModelRenderer LLeg2;
	ModelRenderer RFoot;
	ModelRenderer RArm;
	ModelRenderer LArm;
	ModelRenderer Backpack;
	ModelRenderer Backpack2;
	ModelRenderer Blowgun;
	ModelRenderer Head;
	ModelRenderer HatBrim;
	ModelRenderer Hat;
	ModelRenderer Snout;
	ModelRenderer LEar;
	ModelRenderer LEar2;
	ModelRenderer REar;
	ModelRenderer REar2;
	ModelRenderer Plume;
	ModelRenderer Plume2;
	ModelRenderer Nose;
	ModelRenderer RBootDetail;
	ModelRenderer LBootDetail;
	ModelRenderer Map1;
	ModelRenderer Map2;
	ModelRenderer Plume3;
	ModelRenderer HeadFull;
	ModelRenderer LArmFull;
	ModelRenderer RArmFull;
	ModelRenderer LLegFull;
	ModelRenderer RLegFull;

	public ModelTeemo() {
		textureWidth = 64;
		textureHeight = 32;
		Neck = new ModelRenderer(this, 40, 0);
		Neck.addBox(0F, 0F, 0F, 6, 1, 6);
		Neck.setRotationPoint(-3F, 17F, -3F);
		Neck.setTextureSize(64, 32);
		Neck.mirror = true;
		setRotation(Neck, 0.1858931F, 0F, 0F);
		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(0F, 0F, 0F, 4, 5, 4);
		Body.setRotationPoint(-2F, 17F, -2F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0.1487144F, 0F, 0F);

		RLegFull = new ModelRenderer(this, "Right Leg");

		RLeg = new ModelRenderer(this, 58, 28);
		RLeg.addBox(0.2F, 0F, 0F, 1, 2, 2);
		RLeg.setRotationPoint(-3F, 20F, -1F);
		RLeg.setTextureSize(64, 32);
		RLeg.mirror = true;
		setRotation(RLeg, 0F, 0F, 0.1858931F);
		RLeg2 = new ModelRenderer(this, 60, 26);
		RLeg2.addBox(0F, 0F, 0F, 1, 1, 1);
		RLeg2.setRotationPoint(-3F, 22F, 0F);
		RLeg2.setTextureSize(64, 32);
		RLeg2.mirror = true;
		setRotation(RLeg2, 0F, 0F, 0F);
		RFoot = new ModelRenderer(this, 58, 23);
		RFoot.addBox(0F, 0F, 0F, 1, 1, 2);
		RFoot.setRotationPoint(2.3F, 23F, -1F);
		RFoot.setTextureSize(64, 32);
		RFoot.mirror = true;
		setRotation(RFoot, 0F, -0.2974289F, 0F);
		RBootDetail = new ModelRenderer(this, 60, 26);
		RBootDetail.addBox(0F, 0F, 0F, 1, 1, 1);
		RBootDetail.setRotationPoint(-3F, 21.5F, 0F);
		RBootDetail.setTextureSize(64, 32);
		RBootDetail.mirror = true;
		setRotation(RBootDetail, 0F, 0F, 0.555297F);
		LFoot = new ModelRenderer(this, 58, 23);
		LFoot.addBox(0F, 0F, 0F, 1, 1, 2);
		LFoot.setRotationPoint(-3.3F, 23F, -1F);
		LFoot.setTextureSize(64, 32);
		LFoot.mirror = true;
		setRotation(LFoot, 0F, 0.2974289F, 0F);

		RLegFull.addChild(RLeg);
		RLegFull.addChild(RLeg2);
		RLegFull.addChild(LFoot);
		RLegFull.addChild(RBootDetail);

		LLegFull = new ModelRenderer(this, "Left Leg");

		LLeg2 = new ModelRenderer(this, 60, 26);
		LLeg2.addBox(0F, 0F, 0F, 1, 1, 1);
		LLeg2.setRotationPoint(2F, 22F, 0F);
		LLeg2.setTextureSize(64, 32);
		LLeg2.mirror = true;
		setRotation(LLeg2, 0F, 0F, 0F);
		LLeg = new ModelRenderer(this, 58, 28);
		LLeg.addBox(-0.2F, 0F, 0F, 1, 2, 2);
		LLeg.setRotationPoint(2F, 20F, -1F);
		LLeg.setTextureSize(64, 32);
		LLeg.mirror = true;
		setRotation(LLeg, 0F, 0F, -0.1858931F);
		LBootDetail = new ModelRenderer(this, 60, 26);
		LBootDetail.addBox(0F, 0F, 0F, 1, 1, 1);
		LBootDetail.setRotationPoint(2F, 22F, 0F);
		LBootDetail.setTextureSize(64, 32);
		LBootDetail.mirror = true;
		setRotation(LBootDetail, 0F, 0F, -0.5576792F);
		LLegFull.addChild(LLeg);
		LLegFull.addChild(LLeg2);
		LLegFull.addChild(RFoot);
		LLegFull.addChild(LBootDetail);

		RArmFull = new ModelRenderer(this, "RARM");
		RArm = new ModelRenderer(this, 56, 7);
		RArm.addBox(0F, 0F, 0F, 1, 1, 3);
		RArm.setRotationPoint(-3F, 19F, -3F);
		RArm.setTextureSize(64, 32);
		RArm.mirror = true;
		setRotation(RArm, 0.3915114F, 0F, 0.669215F);
		Blowgun = new ModelRenderer(this, 20, 0);
		Blowgun.addBox(0F, 0F, 0F, 1, 6, 1);
		Blowgun.setRotationPoint(-2F, 17F, -6F);
		Blowgun.setTextureSize(64, 32);
		Blowgun.mirror = true;
		setRotation(Blowgun, 0.5063936F, -0.3717861F, 0.06F);

		RArmFull.addChild(RArm);
		RArmFull.addChild(Blowgun);

		LArm = new ModelRenderer(this, 48, 7);
		LArm.addBox(0F, 0F, 0F, 3, 1, 1);
		LArm.setRotationPoint(2F, 18F, -1F);
		LArm.setTextureSize(64, 32);
		LArm.mirror = true;
		setRotation(LArm, -0.1115358F, 0.5576792F, 0.669215F);

		Backpack = new ModelRenderer(this, 28, 0);
		Backpack.addBox(0F, 0F, 0F, 4, 4, 2);
		Backpack.setRotationPoint(-2F, 18F, 1F);
		Backpack.setTextureSize(64, 32);
		Backpack.mirror = true;
		setRotation(Backpack, 0.3091746F, 0F, 0F);
		Backpack2 = new ModelRenderer(this, 30, 6);
		Backpack2.addBox(0F, 0F, 0F, 4, 2, 1);
		Backpack2.setRotationPoint(-2F, 19F, 3F);
		Backpack2.setTextureSize(64, 32);
		Backpack2.mirror = true;
		setRotation(Backpack2, 0.3142143F, 0F, 0F);

		HeadFull = new ModelRenderer(this, "FullHead");

		Head = new ModelRenderer(this, 0, 24);
		Head.addBox(0F, 0F, 0F, 6, 4, 4);
		Head.setRotationPoint(-3F, 13F, -3F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0.2230717F, 0F, 0F);
		HatBrim = new ModelRenderer(this, 20, 25);
		HatBrim.addBox(0F, 0F, 0F, 8, 1, 6);
		HatBrim.setRotationPoint(-4F, 12F, -4F);
		HatBrim.setTextureSize(64, 32);
		HatBrim.mirror = true;
		setRotation(HatBrim, -0.2230717F, 0F, 0F);
		Hat = new ModelRenderer(this, 20, 17);
		Hat.addBox(0F, 0F, 0F, 6, 3, 5);
		Hat.setRotationPoint(-3F, 10F, -3F);
		Hat.setTextureSize(64, 32);
		Hat.mirror = true;
		setRotation(Hat, -0.2230717F, 0F, 0F);
		Snout = new ModelRenderer(this, 0, 21);
		Snout.addBox(0F, 0F, 0F, 4, 2, 1);
		Snout.setRotationPoint(-2F, 15F, -3.3F);
		Snout.setTextureSize(64, 32);
		Snout.mirror = true;
		setRotation(Snout, 0.1858931F, 0F, 0F);
		LEar = new ModelRenderer(this, 20, 14);
		LEar.addBox(0F, 0F, 0F, 2, 2, 1);
		LEar.setRotationPoint(3F, 11.5F, 0F);
		LEar.setTextureSize(64, 32);
		LEar.mirror = true;
		setRotation(LEar, 0F, 0F, 0.8179294F);
		LEar2 = new ModelRenderer(this, 20, 11);
		LEar2.addBox(0F, 0F, 0F, 1, 2, 1);
		LEar2.setRotationPoint(4F, 11.4F, -0.9F);
		LEar2.setTextureSize(64, 32);
		LEar2.mirror = true;
		setRotation(LEar2, 0.5948578F, 0F, 0.3717861F);
		REar = new ModelRenderer(this, 20, 14);
		REar.addBox(0F, 0F, 0F, 2, 2, 1);
		REar.setRotationPoint(-4F, 12F, 0F);
		REar.setTextureSize(64, 32);
		REar.mirror = true;
		setRotation(REar, 0F, 0F, -0.2974289F);
		REar2 = new ModelRenderer(this, 20, 11);
		REar2.addBox(0F, 0F, 0F, 1, 2, 1);
		REar2.setRotationPoint(-5F, 12F, 0F);
		REar2.setTextureSize(64, 32);
		REar2.mirror = true;
		setRotation(REar2, 0F, 0F, -0.8179294F);
		Plume = new ModelRenderer(this, 0, 17);
		Plume.addBox(0F, 0F, 0F, 1, 3, 1);
		Plume.setRotationPoint(-0.5F, 8F, 0F);
		Plume.setTextureSize(64, 32);
		Plume.mirror = true;
		setRotation(Plume, -0.5576792F, 0F, 0F);
		Plume2 = new ModelRenderer(this, 4, 16);
		Plume2.addBox(0F, 0F, 0F, 1, 2, 3);
		Plume2.setRotationPoint(-0.5F, 7.5F, 0F);
		Plume2.setTextureSize(64, 32);
		Plume2.mirror = true;
		setRotation(Plume2, -0.2974289F, 0F, 0F);
		Plume3 = new ModelRenderer(this, 8, 14);
		Plume3.addBox(0F, 0F, 0F, 1, 1, 1);
		Plume3.setRotationPoint(-0.5F, 8F, 1F);
		Plume3.setTextureSize(64, 32);
		Plume3.mirror = true;
		setRotation(Plume3, 0.7807508F, 0F, 0F);
		Nose = new ModelRenderer(this, 10, 22);
		Nose.addBox(0F, 0F, 0F, 1, 1, 1);
		Nose.setRotationPoint(-0.5F, 15.1F, -3F);
		Nose.setTextureSize(64, 32);
		Nose.mirror = true;
		setRotation(Nose, -0.669215F, 0F, 0F);

		HeadFull.addChild(Head);
		HeadFull.addChild(HatBrim);
		HeadFull.addChild(Hat);
		HeadFull.addChild(Snout);
		HeadFull.addChild(Nose);
		HeadFull.addChild(LEar);
		HeadFull.addChild(LEar2);
		HeadFull.addChild(Head);
		HeadFull.addChild(REar);
		HeadFull.addChild(REar2);
		HeadFull.addChild(Plume);
		HeadFull.addChild(Plume2);
		HeadFull.addChild(Plume3);

		Map1 = new ModelRenderer(this, 0, 9);
		Map1.addBox(0F, 0F, 0F, 1, 5, 1);
		Map1.setRotationPoint(-2.5F, 15F, 4F);
		Map1.setTextureSize(64, 32);
		Map1.mirror = true;
		setRotation(Map1, -0.2602503F, 0.2602503F, -0.2974289F);
		Map2 = new ModelRenderer(this, 0, 9);
		Map2.addBox(0F, 0F, 0F, 1, 5, 1);
		Map2.setRotationPoint(1F, 16F, 5F);
		Map2.setTextureSize(64, 32);
		Map2.mirror = true;
		setRotation(Map2, -0.8551081F, 0.5531351F, -0.0371786F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Neck.render(f5);
		Body.render(f5);
		RLegFull.render(f5);
		LLegFull.render(f5);
		HeadFull.render(f5);
		RArmFull.render(f5);
		LArm.render(f5);
		Backpack.render(f5);
		Backpack2.render(f5);
		Map1.render(f5);
		Map2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par6Entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, par6Entity);

		this.HeadFull.rotateAngleY = (f3 / (180F / (float) Math.PI));
		this.HeadFull.rotateAngleX = (f4 / (170F / (float) Math.PI));

		this.LLegFull.rotateAngleX = MathHelper.cos(f * 0.6662F) * .26F * f1 * 0.5F;
		this.LLegFull.rotateAngleY = 0.0f;

		this.RLegFull.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * .26F * f1;
		this.RLegFull.rotateAngleY = 0.0F;

		this.LArm.rotateAngleX = MathHelper.cos((float) Math.PI) * .24F * f1;
		this.RArmFull.rotateAngleX = MathHelper.cos(f * 0.6662F) * .24F * f1;

	}
}