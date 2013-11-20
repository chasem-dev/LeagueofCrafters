package leagueofcrafters.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelAnnie extends ModelBase {
	ModelRenderer Dress_Rim;
	ModelRenderer Dress1;
	ModelRenderer Dress2;
	ModelRenderer MonstrousHead;
	ModelRenderer LArm;
	ModelRenderer RArm;
	ModelRenderer BearRArm;
	ModelRenderer BearBody;
	ModelRenderer BearLarm;
	ModelRenderer BearLLeg;
	ModelRenderer BearRLeg;
	ModelRenderer BearHead;
	ModelRenderer LLeg;
	ModelRenderer RLeg;
	ModelRenderer BHair;
	ModelRenderer RHair;
	ModelRenderer LHair;
	ModelRenderer LEar;
	ModelRenderer REar;
	ModelRenderer LFoot;
	ModelRenderer RFoot;
	ModelRenderer Backpack;
	ModelRenderer Backpack2;
	ModelRenderer LeftLeg;
	ModelRenderer RightLeg;

	public ModelAnnie() {
		textureWidth = 128;
		textureHeight = 64;

		Dress_Rim = new ModelRenderer(this, 0, 26);
		Dress_Rim.addBox(0F, 0F, 0F, 10, 1, 10);
		Dress_Rim.setRotationPoint(-5F, 16.5F, -5F);
		Dress_Rim.setTextureSize(128, 64);
		Dress_Rim.mirror = true;
		setRotation(Dress_Rim, 0F, 0F, 0F);
		Dress1 = new ModelRenderer(this, 0, 14);
		Dress1.addBox(0F, 0F, 0F, 8, 4, 8);
		Dress1.setRotationPoint(-4F, 12.8F, -4F);
		Dress1.setTextureSize(128, 64);
		Dress1.mirror = true;
		setRotation(Dress1, 0F, 0F, 0F);
		Dress2 = new ModelRenderer(this, 0, 0);
		Dress2.addBox(0F, 0F, 0F, 6, 8, 6);
		Dress2.setRotationPoint(-3F, 6F, -3F);
		Dress2.setTextureSize(128, 64);
		Dress2.mirror = true;
		setRotation(Dress2, 0F, 0F, 0F);
		MonstrousHead = new ModelRenderer(this, 90, 0);
		MonstrousHead.addBox(0F, 0F, 0F, 10, 9, 9);
		MonstrousHead.setRotationPoint(-5F, -3F, -3.5F);
		MonstrousHead.setTextureSize(128, 64);
		MonstrousHead.mirror = true;
		setRotation(MonstrousHead, -0.1858931F, 0F, 0F);
		LArm = new ModelRenderer(this, 54, 0);
		LArm.addBox(0F, 0F, 0F, 2, 8, 2);
		LArm.setRotationPoint(1F, 7.2F, -0.5F);
		LArm.setTextureSize(128, 64);
		LArm.mirror = true;
		setRotation(LArm, 0F, 0F, -0.4833219F);
		RArm = new ModelRenderer(this, 54, 0);
		RArm.addBox(0F, 0F, 0F, 2, 8, 2);
		RArm.setRotationPoint(-3F, 6.5F, -0.5F);
		RArm.setTextureSize(128, 64);
		RArm.mirror = true;
		setRotation(RArm, 0F, 0F, 0.6320364F);
		BearRArm = new ModelRenderer(this, 65, 41);
		BearRArm.addBox(0F, 0F, 0F, 1, 2, 1);
		BearRArm.setRotationPoint(6F, 13.5F, 0F);
		BearRArm.setTextureSize(128, 64);
		BearRArm.mirror = true;
		setRotation(BearRArm, 0.1487144F, -0.5948578F, -0.2230717F);
		BearBody = new ModelRenderer(this, 57, 41);
		BearBody.addBox(0F, 0F, 0F, 2, 3, 2);
		BearBody.setRotationPoint(7F, 14F, 1F);
		BearBody.setTextureSize(128, 64);
		BearBody.mirror = true;
		setRotation(BearBody, -0.4089647F, -0.4089647F, 0.4833219F);
		BearLarm = new ModelRenderer(this, 65, 41);
		BearLarm.addBox(0F, 0F, 0F, 1, 2, 1);
		BearLarm.setRotationPoint(7.1F, 16.2F, 1.5F);
		BearLarm.setTextureSize(128, 64);
		BearLarm.mirror = true;
		setRotation(BearLarm, 0F, 0F, -0.4461433F);
		BearLLeg = new ModelRenderer(this, 65, 41);
		BearLLeg.addBox(0F, 0F, 0F, 1, 2, 1);
		BearLLeg.setRotationPoint(6.5F, 17F, 0.5F);
		BearLLeg.setTextureSize(128, 64);
		BearLLeg.mirror = true;
		setRotation(BearLLeg, 0F, 0F, 0F);
		BearRLeg = new ModelRenderer(this, 65, 41);
		BearRLeg.addBox(0F, 0F, 0F, 1, 2, 1);
		BearRLeg.setRotationPoint(5.7F, 16.5F, 0.5F);
		BearRLeg.setTextureSize(128, 64);
		BearRLeg.mirror = true;
		setRotation(BearRLeg, -0.1487144F, 0F, 0.7063936F);
		BearHead = new ModelRenderer(this, 53, 35);
		BearHead.addBox(0F, 0F, 0F, 3, 3, 3);
		BearHead.setRotationPoint(7.4F, 11.4F, 2.3F);
		BearHead.setTextureSize(128, 64);
		BearHead.mirror = true;
		setRotation(BearHead, -0.6320364F, -0.4461433F, 0.5205006F);
		LeftLeg = new ModelRenderer(this, "LeftLeg");

		LLeg = new ModelRenderer(this, 0, 37);
		LLeg.addBox(0F, 0F, 0F, 2, 6, 2);
		LLeg.setRotationPoint(1F, 16F, -1F);
		LLeg.setTextureSize(128, 64);
		LLeg.mirror = true;
		setRotation(LLeg, 0F, 0F, 0F);
		LFoot = new ModelRenderer(this, 0, 45);
		LFoot.addBox(0F, 0F, 0F, 2, 2, 3);
		LFoot.setRotationPoint(2.5F, 22F, 1F);
		LFoot.setTextureSize(128, 64);
		LFoot.mirror = true;
		setRotation(LFoot, 0F, 2.732628F, 0F);
		LeftLeg.addChild(LLeg);
		LeftLeg.addChild(LFoot);
		RightLeg = new ModelRenderer(this, "RightLeg");

		RLeg = new ModelRenderer(this, 0, 37);
		RLeg.addBox(0F, 0F, 0F, 2, 6, 2);
		RLeg.setRotationPoint(-3F, 16F, -1F);
		RLeg.setTextureSize(128, 64);
		RLeg.mirror = true;
		setRotation(RLeg, 0F, 0F, 0F);
		RFoot = new ModelRenderer(this, 0, 45);
		RFoot.addBox(0F, 0F, 0F, 2, 2, 3);
		RFoot.setRotationPoint(-0.7F, 22F, 0.5F);
		RFoot.setTextureSize(128, 64);
		RFoot.mirror = true;
		setRotation(RFoot, 0F, -2.806985F, 0F);
		RightLeg.addChild(RLeg);
		RightLeg.addChild(RFoot);

		BHair = new ModelRenderer(this, 90, 18);
		BHair.addBox(0F, 0F, 0F, 7, 4, 0);
		BHair.setRotationPoint(-3.5F, 5F, 4F);
		BHair.setTextureSize(128, 64);
		BHair.mirror = true;
		setRotation(BHair, 0.3148822F, 0F, 0F);
		RHair = new ModelRenderer(this, 90, 22);
		RHair.addBox(0F, 0F, 0F, 4, 4, 0);
		RHair.setRotationPoint(-3.8F, 3.3F, 4F);
		RHair.setTextureSize(128, 64);
		RHair.mirror = true;
		setRotation(RHair, 0.2974289F, 0F, 0.7063936F);
		LHair = new ModelRenderer(this, 90, 22);
		LHair.addBox(0F, 0F, 0F, 4, 4, 0);
		LHair.setRotationPoint(0.9F, 5.8F, 4F);
		LHair.setTextureSize(128, 64);
		LHair.mirror = true;
		setRotation(LHair, 0.2974289F, 0F, -0.7063936F);
		LEar = new ModelRenderer(this, 120, 18);
		LEar.addBox(0F, 0F, 0F, 3, 3, 1);
		LEar.setRotationPoint(2.8F, -4F, 0.2F);
		LEar.setTextureSize(128, 64);
		LEar.mirror = true;
		setRotation(LEar, -0.2602503F, 0.4461433F, 0.8179294F);
		REar = new ModelRenderer(this, 120, 18);
		REar.addBox(0F, 0F, 0F, 3, 3, 1);
		REar.setRotationPoint(-2.5F, -4F, 0.5F);
		REar.setTextureSize(128, 64);
		REar.mirror = true;
		setRotation(REar, -0.3717861F, 0F, 0.8179294F);
		Backpack = new ModelRenderer(this, 24, 0);
		Backpack.addBox(0F, 0F, 0F, 5, 6, 3);
		Backpack.setRotationPoint(-2.5F, 8.7F, 2F);
		Backpack.setTextureSize(128, 64);
		Backpack.mirror = true;
		setRotation(Backpack, 0.1487144F, 0F, 0F);
		Backpack2 = new ModelRenderer(this, 40, 0);
		Backpack2.addBox(0F, 0F, 0F, 4, 3, 3);
		Backpack2.setRotationPoint(-2F, 11F, 3.2F);
		Backpack2.setTextureSize(128, 64);
		Backpack2.mirror = true;
		setRotation(Backpack2, 0.1487144F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Dress_Rim.render(f5);
		Dress1.render(f5);
		Dress2.render(f5);
		MonstrousHead.render(f5);
		LArm.render(f5);
		RArm.render(f5);
		BearRArm.render(f5);
		BearBody.render(f5);
		BearLarm.render(f5);
		BearLLeg.render(f5);
		BearRLeg.render(f5);
		BearHead.render(f5);
		BHair.render(f5);
		RHair.render(f5);
		LHair.render(f5);
		LEar.render(f5);
		REar.render(f5);
		Backpack.render(f5);
		Backpack2.render(f5);
		LeftLeg.render(f5);
		RightLeg.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * .3F * f1 * 0.5F;
		this.LeftLeg.rotateAngleY = 0.0f;

		this.RightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * .3F * f1;
		this.RightLeg.rotateAngleY = 0.0F;

	}

}
