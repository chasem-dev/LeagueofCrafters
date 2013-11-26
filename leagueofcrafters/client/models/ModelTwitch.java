package leagueofcrafters.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTwitch extends ModelBase {
	// fields
	ModelRenderer Body;
	ModelRenderer LLeg;
	ModelRenderer RLeg;
	ModelRenderer LFoot;
	ModelRenderer RFoot;
	ModelRenderer Head;
	ModelRenderer LArm;
	ModelRenderer LArm2;
	ModelRenderer RArm;
	ModelRenderer RArm2;
	ModelRenderer LPad;
	ModelRenderer RPad;
	ModelRenderer Snout2;
	ModelRenderer Snout;
	ModelRenderer Nose;
	ModelRenderer FrontTeeth;
	ModelRenderer LTooth1;
	ModelRenderer RTooth1;
	ModelRenderer LTooth2;
	ModelRenderer RTooth2;
	ModelRenderer BottomJaw;
	ModelRenderer LEar;
	ModelRenderer REar;
	ModelRenderer LMToe;
	ModelRenderer LLToe;
	ModelRenderer LRToe;
	ModelRenderer RMToe;
	ModelRenderer RRToe;
	ModelRenderer RLToe;
	ModelRenderer BowBody;
	ModelRenderer BowHandle;
	ModelRenderer BowCurve;
	ModelRenderer LBowCurve;
	ModelRenderer RBowCurve;
	ModelRenderer BowString;
	ModelRenderer BowGear;

	ModelRenderer FullLeftLeg;
	ModelRenderer FullRightLeg;
	ModelRenderer FullLeftArm;
	ModelRenderer FullRightArm;

	public ModelTwitch() {
		textureWidth = 128;
		textureHeight = 64;

		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(0F, 0F, 0F, 9, 11, 9);
		Body.setRotationPoint(-4.5F, 10F, -5.5F);
		Body.setTextureSize(128, 64);
		Body.mirror = true;
		setRotation(Body, 0.1487144F, 0F, 0F);
		FullLeftLeg = new ModelRenderer(this, "FullLLeg");

		LLeg = new ModelRenderer(this, 0, 33);
		LLeg.addBox(0F, 0F, 0F, 1, 2, 1);
		LLeg.setRotationPoint(1.5F, 20F, 0F);
		LLeg.setTextureSize(128, 64);
		LLeg.mirror = true;
		setRotation(LLeg, 0F, 0F, 0F);
		LFoot = new ModelRenderer(this, 0, 36);
		LFoot.addBox(0F, 0F, 0F, 3, 2, 5);
		LFoot.setRotationPoint(2F, 22F, -3.5F);
		LFoot.setTextureSize(128, 64);
		LFoot.mirror = true;
		setRotation(LFoot, 0F, -0.4089647F, 0F);
		LMToe = new ModelRenderer(this, 0, 43);
		LMToe.addBox(0F, 0F, 0F, 1, 1, 3);
		LMToe.setRotationPoint(3.8F, 23F, -5F);
		LMToe.setTextureSize(128, 64);
		LMToe.mirror = true;
		setRotation(LMToe, 0F, -0.4089647F, 0F);
		LLToe = new ModelRenderer(this, 0, 43);
		LLToe.addBox(0F, 0F, 0F, 1, 1, 3);
		LLToe.setRotationPoint(5.8F, 23F, -4F);
		LLToe.setTextureSize(128, 64);
		LLToe.mirror = true;
		setRotation(LLToe, 0F, -1.152537F, 0F);
		LRToe = new ModelRenderer(this, 0, 43);
		LRToe.addBox(0F, 0F, 0F, 1, 1, 3);
		LRToe.setRotationPoint(1.5F, 23F, -4.9F);
		LRToe.setTextureSize(128, 64);
		LRToe.mirror = true;
		setRotation(LRToe, 0F, 0.3717861F, 0F);

		FullLeftLeg.addChild(LLeg);
		FullLeftLeg.addChild(LFoot);
		FullLeftLeg.addChild(LLToe);
		FullLeftLeg.addChild(LRToe);
		FullLeftLeg.addChild(LMToe);

		FullRightLeg = new ModelRenderer(this, "FullRLeg");

		RFoot = new ModelRenderer(this, 0, 36);
		RFoot.addBox(0F, 0F, 0F, 3, 2, 5);
		RFoot.setRotationPoint(-5.7F, 22F, -1.5F);
		RFoot.setTextureSize(128, 64);
		RFoot.mirror = true;
		setRotation(RFoot, 0F, 0.5576792F, 0F);
		RLeg = new ModelRenderer(this, 0, 33);
		RLeg.addBox(0F, 0F, 0F, 1, 2, 1);
		RLeg.setRotationPoint(-2.5F, 20F, 0F);
		RLeg.setTextureSize(128, 64);
		RLeg.mirror = true;
		setRotation(RLeg, 0F, 0F, 0F);
		RMToe = new ModelRenderer(this, 0, 43);
		RMToe.addBox(0F, 0F, 0F, 1, 1, 3);
		RMToe.setRotationPoint(-6.3F, 23F, -4F);
		RMToe.setTextureSize(128, 64);
		RMToe.mirror = true;
		setRotation(RMToe, 0F, 0.5576792F, 0F);
		RRToe = new ModelRenderer(this, 0, 43);
		RRToe.addBox(0F, 0F, 0F, 1, 1, 3);
		RRToe.setRotationPoint(-7.3F, 23F, -2.5F);
		RRToe.setTextureSize(128, 64);
		RRToe.mirror = true;
		setRotation(RRToe, 0F, 1.152537F, 0F);
		RLToe = new ModelRenderer(this, 0, 43);
		RLToe.addBox(0F, 0F, 0F, 1, 1, 3);
		RLToe.setRotationPoint(-4.3F, 23F, -5F);
		RLToe.setTextureSize(128, 64);
		RLToe.mirror = true;
		setRotation(RLToe, 0F, -0.1115358F, 0F);
		FullRightLeg.addChild(RLeg);
		FullRightLeg.addChild(RFoot);
		FullRightLeg.addChild(RLToe);
		FullRightLeg.addChild(RRToe);
		FullRightLeg.addChild(RMToe);

		Head = new ModelRenderer(this, 36, 0);
		Head.addBox(0F, 0F, 0F, 5, 5, 5);
		Head.setRotationPoint(-2.5F, 7F, -8F);
		Head.setTextureSize(128, 64);
		Head.mirror = true;
		setRotation(Head, 0.3346075F, 0F, 0F);

		LArm = new ModelRenderer(this, 0, 20);
		LArm.addBox(0F, 0F, 0F, 6, 2, 2);
		LArm.setRotationPoint(3.5F, 10F, -1F);
		LArm.setTextureSize(128, 64);
		LArm.mirror = true;
		setRotation(LArm, 0F, 0.5948578F, 0.8179294F);
		LArm2 = new ModelRenderer(this, 0, 25);
		LArm2.addBox(0F, 0F, 0F, 6, 2, 2);
		LArm2.setRotationPoint(6.4F, 13.8F, -3F);
		LArm2.setTextureSize(128, 64);
		LArm2.mirror = true;
		setRotation(LArm2, -0.4089647F, 1.226894F, 0.8551081F);

		RArm = new ModelRenderer(this, 0, 21);
		RArm.addBox(0F, 0F, 0F, 6, 2, 2);
		RArm.setRotationPoint(-4F, 10F, 1F);
		RArm.setTextureSize(128, 64);
		RArm.mirror = true;
		setRotation(RArm, 0F, 2.637386F, 0.5042062F);
		RArm2 = new ModelRenderer(this, 0, 25);
		RArm2.addBox(0F, 0F, 0F, 6, 2, 2);
		RArm2.setRotationPoint(-8.5F, 12.7F, -1.3F);
		RArm2.setTextureSize(128, 64);
		RArm2.mirror = true;
		setRotation(RArm2, 0.2714957F, 1.822899F, 0.2714957F);

		LPad = new ModelRenderer(this, 0, 29);
		LPad.addBox(0F, 0F, 0F, 4, 1, 3);
		LPad.setRotationPoint(3.5F, 8.2F, -2F);
		LPad.setTextureSize(128, 64);
		LPad.mirror = true;
		setRotation(LPad, 0F, 0F, 0.5817764F);
		RPad = new ModelRenderer(this, 0, 29);
		RPad.addBox(0F, 0F, 0F, 4, 1, 3);
		RPad.setRotationPoint(-7F, 10.5F, -2F);
		RPad.setTextureSize(128, 64);
		RPad.mirror = true;
		setRotation(RPad, 0F, 0F, -0.5817764F);
		Snout2 = new ModelRenderer(this, 36, 15);
		Snout2.addBox(0F, 0F, 0F, 2, 2, 6);
		Snout2.setRotationPoint(-1F, 10.5F, -11F);
		Snout2.setTextureSize(128, 64);
		Snout2.mirror = true;
		setRotation(Snout2, 0.3346075F, 0F, 0F);
		Snout = new ModelRenderer(this, 36, 10);
		Snout.addBox(0F, 0F, 0F, 3, 3, 2);
		Snout.setRotationPoint(-1.5F, 9F, -9F);
		Snout.setTextureSize(128, 64);
		Snout.mirror = true;
		setRotation(Snout, 0.3346075F, 0F, 0F);
		Nose = new ModelRenderer(this, 36, 28);
		Nose.addBox(0F, 0F, 0F, 1, 2, 1);
		Nose.setRotationPoint(-0.5F, 9F, -12F);
		Nose.setTextureSize(128, 64);
		Nose.mirror = true;
		setRotation(Nose, 0.1487144F, 0F, 0F);
		FrontTeeth = new ModelRenderer(this, 52, 15);
		FrontTeeth.addBox(0F, 0F, 0F, 2, 2, 0);
		FrontTeeth.setRotationPoint(-1F, 11.4F, -10.3F);
		FrontTeeth.setTextureSize(128, 64);
		FrontTeeth.mirror = true;
		setRotation(FrontTeeth, 0.2974289F, 0F, 0F);
		LTooth1 = new ModelRenderer(this, 52, 21);
		LTooth1.addBox(-0.5F, 0F, 0F, 0, 1, 1);
		LTooth1.setRotationPoint(1.9F, 10.8F, -7.6F);
		LTooth1.setTextureSize(128, 64);
		LTooth1.mirror = true;
		setRotation(LTooth1, -0.5205006F, 0F, 0F);
		RTooth1 = new ModelRenderer(this, 52, 21);
		RTooth1.addBox(0F, 0F, 0F, 0, 1, 1);
		RTooth1.setRotationPoint(-1.4F, 10.8F, -7.6F);
		RTooth1.setTextureSize(128, 64);
		RTooth1.mirror = true;
		setRotation(RTooth1, -0.5205006F, 0F, 0F);
		LTooth2 = new ModelRenderer(this, 52, 21);
		LTooth2.addBox(0F, 0F, 0F, 0, 1, 1);
		LTooth2.setRotationPoint(0.9F, 10.8F, -8.8F);
		LTooth2.setTextureSize(128, 64);
		LTooth2.mirror = true;
		setRotation(LTooth2, -0.5205006F, 0F, 0F);
		RTooth2 = new ModelRenderer(this, 52, 21);
		RTooth2.addBox(0F, 0F, 0F, 0, 1, 1);
		RTooth2.setRotationPoint(-0.9F, 10.8F, -8.8F);
		RTooth2.setTextureSize(128, 64);
		RTooth2.mirror = true;
		setRotation(RTooth2, -0.5205006F, 0F, 0F);
		BottomJaw = new ModelRenderer(this, 36, 23);
		BottomJaw.addBox(0F, 0F, 0F, 2, 1, 4);
		BottomJaw.setRotationPoint(-1F, 12.7F, -9.1F);
		BottomJaw.setTextureSize(128, 64);
		BottomJaw.mirror = true;
		setRotation(BottomJaw, 0.6320364F, 0F, 0F);
		LEar = new ModelRenderer(this, 56, 0);
		LEar.addBox(0F, 0F, 0F, 2, 3, 1);
		LEar.setRotationPoint(1.4F, 3.3F, -4F);
		LEar.setTextureSize(128, 64);
		LEar.mirror = true;
		setRotation(LEar, -0.3346075F, 0F, 0.2974289F);
		REar = new ModelRenderer(this, 57, 0);
		REar.addBox(0F, 0F, 0F, 2, 3, 1);
		REar.setRotationPoint(-3.3F, 3.8F, -4F);
		REar.setTextureSize(128, 64);
		REar.mirror = true;
		setRotation(REar, -0.3346075F, 0F, -0.2974289F);

		BowBody = new ModelRenderer(this, 70, 0);
		BowBody.addBox(0F, 0F, 0F, 1, 2, 8);
		BowBody.setRotationPoint(-9F, 11.9F, -15F);
		BowBody.setTextureSize(128, 64);
		BowBody.mirror = true;
		setRotation(BowBody, -0.1115358F, 0F, 0F);
		BowHandle = new ModelRenderer(this, 70, 10);
		BowHandle.addBox(0F, 0F, 0F, 1, 3, 2);
		BowHandle.setRotationPoint(-9F, 13.2F, -8F);
		BowHandle.setTextureSize(128, 64);
		BowHandle.mirror = true;
		setRotation(BowHandle, 0.3717861F, 0F, 0F);
		BowCurve = new ModelRenderer(this, 88, 0);
		BowCurve.addBox(0F, 0F, 0F, 9, 1, 1);
		BowCurve.setRotationPoint(-13F, 11.8F, -16F);
		BowCurve.setTextureSize(128, 64);
		BowCurve.mirror = true;
		setRotation(BowCurve, -0.1115358F, 0F, 0F);
		LBowCurve = new ModelRenderer(this, 88, 4);
		LBowCurve.addBox(0F, 0F, 1F, 4, 1, 1);
		LBowCurve.setRotationPoint(-3.2F, 11.7F, -16.5F);
		LBowCurve.setTextureSize(128, 64);
		LBowCurve.mirror = true;
		setRotation(LBowCurve, -0.1115358F, -1.07818F, 0F);
		RBowCurve = new ModelRenderer(this, 88, 4);
		RBowCurve.addBox(0F, 0F, 0F, 4, 1, 1);
		RBowCurve.setRotationPoint(-12.1F, 11.8F, -15.5F);
		RBowCurve.setTextureSize(128, 64);
		RBowCurve.mirror = true;
		setRotation(RBowCurve, 0.0371786F, -2.119181F, 0.0371786F);
		BowString = new ModelRenderer(this, 88, 9);
		BowString.addBox(0F, 0F, 0F, 12, 1, 0);
		BowString.setRotationPoint(-14.5F, 12F, -12.8F);
		BowString.setTextureSize(128, 64);
		BowString.mirror = true;
		setRotation(BowString, 0.6320364F, 0F, 0F);
		BowGear = new ModelRenderer(this, 70, 15);
		BowGear.addBox(0F, 0F, 0F, 2, 1, 2);
		BowGear.setRotationPoint(-8.5F, 11.6F, -13.2F);
		BowGear.setTextureSize(128, 64);
		BowGear.mirror = true;
		setRotation(BowGear, -0.1115358F, -0.7807508F, 0.1115358F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Body.render(f5);
		// LLeg.render(f5);
		// RLeg.render(f5);
		// LFoot.render(f5);
		// RFoot.render(f5);
		Head.render(f5);
		LArm.render(f5);
		LArm2.render(f5);
		RArm.render(f5);
		RArm2.render(f5);
		LPad.render(f5);
		RPad.render(f5);
		Snout2.render(f5);
		Snout.render(f5);
		Nose.render(f5);
		FrontTeeth.render(f5);
		LTooth1.render(f5);
		RTooth1.render(f5);
		LTooth2.render(f5);
		RTooth2.render(f5);
		BottomJaw.render(f5);
		LEar.render(f5);
		REar.render(f5);
		// LMToe.render(f5);
		// LLToe.render(f5);
		// //LRToe.render(f5);
		// RMToe.render(f5);
		// RRToe.render(f5);
		// RLToe.render(f5);
		BowBody.render(f5);
		BowHandle.render(f5);
		BowCurve.render(f5);
		LBowCurve.render(f5);
		RBowCurve.render(f5);
		BowString.render(f5);
		BowGear.render(f5);
		FullLeftLeg.render(f5);
		FullRightLeg.render(f5);
		setRotation(RArm, 0F, 2.637386F, -0.5042062F);

	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		// /this.HeadFull.rotateAngleY = (f3 / (180F / (float) Math.PI));
		// this.HeadFull.rotateAngleX = (f4 / (170F / (float) Math.PI));
		this.FullLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * .3F * f1 * 0.5F;
		this.FullLeftLeg.rotateAngleY = 0.0f;

		this.FullRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * .3F * f1;
		this.FullRightLeg.rotateAngleY = 0.0F;

		// //this.FullLeftArm.rotateAngleX = MathHelper.cos((float) Math.PI) *
		// .24F * f1;
		// this.FullRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * .24F *
		// f1;

	}

}
