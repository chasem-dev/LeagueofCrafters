package leagueofcrafters.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTristana extends ModelBase {
	// fields
	ModelRenderer Body;
	ModelRenderer LLeg;
	ModelRenderer RLeg;
	ModelRenderer LFoot;
	ModelRenderer RFoot;
	ModelRenderer Head;
	ModelRenderer LArm;
	ModelRenderer LArm2;
	ModelRenderer SkullCap;
	ModelRenderer RArm;
	ModelRenderer RArm2;
	ModelRenderer LEar;
	ModelRenderer REar;
	ModelRenderer CannonBase;
	ModelRenderer CannonBack;
	ModelRenderer CannonFront;
	ModelRenderer LGoggle;
	ModelRenderer RGoggle;
	ModelRenderer Backpack;
	ModelRenderer Backpack2;
	ModelRenderer LeftLeg;
	ModelRenderer RightLeg;

	public ModelTristana() {
		textureWidth = 64;
		textureHeight = 32;

		Body = new ModelRenderer(this, 26, 0);
		Body.addBox(0F, 0F, 0F, 4, 5, 3);
		Body.setRotationPoint(-2F, 15.5F, -1.5F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);

		LeftLeg = new ModelRenderer(this, "left Leg");

		LLeg = new ModelRenderer(this, 32, 8);
		LLeg.addBox(0F, 0F, 0F, 2, 4, 2);
		LLeg.setRotationPoint(0F, 20F, -1F);
		LLeg.setTextureSize(64, 32);
		LLeg.mirror = true;
		setRotation(LLeg, 0F, 0F, -0.2602503F);
		LFoot = new ModelRenderer(this, 30, 14);
		LFoot.addBox(0F, 0F, 0F, 2, 1, 3);
		LFoot.setRotationPoint(1.5F, 23F, -2.5F);
		LFoot.setTextureSize(64, 32);
		LFoot.mirror = true;
		setRotation(LFoot, 0F, -0.3717861F, 0F);
		LeftLeg.addChild(LLeg);
		LeftLeg.addChild(LFoot);
		
		RightLeg = new ModelRenderer(this, "Right Leg");
		RLeg = new ModelRenderer(this, 32, 8);
		RLeg.addBox(0F, 0F, 0F, 2, 4, 2);
		RLeg.setRotationPoint(-2F, 19.5F, -1F);
		RLeg.setTextureSize(64, 32);
		RLeg.mirror = true;
		setRotation(RLeg, 0F, 0F, 0.2230717F);
		RFoot = new ModelRenderer(this, 30, 14);
		RFoot.addBox(0F, 0F, 0F, 2, 1, 3);
		RFoot.setRotationPoint(-3.3F, 23F, -1.6F);
		RFoot.setTextureSize(64, 32);
		RFoot.mirror = true;
		setRotation(RFoot, 0F, 0.3717861F, 0F);
		RightLeg.addChild(RLeg);
		RightLeg.addChild(RFoot);
		
		
		Head = new ModelRenderer(this, 0, 0);
		Head.addBox(0F, 0F, 0F, 7, 6, 6);
		Head.setRotationPoint(-3.5F, 10.4F, -3.8F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0.1858931F, 0F, 0F);
		LArm = new ModelRenderer(this, 0, 12);
		LArm.addBox(0F, 0F, 0F, 1, 3, 1);
		LArm.setRotationPoint(1.7F, 16F, 0F);
		LArm.setTextureSize(64, 32);
		LArm.mirror = true;
		setRotation(LArm, -0.0743572F, 0.1487144F, -0.3717861F);
		LArm2 = new ModelRenderer(this, 5, 12);
		LArm2.addBox(0F, 0F, 0F, 1, 3, 1);
		LArm2.setRotationPoint(2.8F, 17.8F, -0.2F);
		LArm2.setTextureSize(64, 32);
		LArm2.mirror = true;
		setRotation(LArm2, -0.7435722F, 0F, 0.1858931F);
		SkullCap = new ModelRenderer(this, 0, 27);
		SkullCap.addBox(0F, 0F, 0F, 5, 1, 4);
		SkullCap.setRotationPoint(-2.5F, 9.7F, -3F);
		SkullCap.setTextureSize(64, 32);
		SkullCap.mirror = true;
		setRotation(SkullCap, 0.1858931F, 0F, 0F);
		RArm = new ModelRenderer(this, 0, 12);
		RArm.addBox(0F, 0F, 0F, 1, 3, 1);
		RArm.setRotationPoint(-2.7F, 15.6F, 0F);
		RArm.setTextureSize(64, 32);
		RArm.mirror = true;
		setRotation(RArm, 0.3717861F, 0F, 0.3717861F);
		RArm2 = new ModelRenderer(this, 5, 12);
		RArm2.addBox(0F, 0F, 0F, 1, 3, 1);
		RArm2.setRotationPoint(-2.9F, 17F, 1.5F);
		RArm2.setTextureSize(64, 32);
		RArm2.mirror = true;
		setRotation(RArm2, -1.189716F, 0.1487144F, 0.6251102F);
		LEar = new ModelRenderer(this, 14, 23);
		LEar.addBox(0F, 0F, 0F, 1, 3, 1);
		LEar.setRotationPoint(3.5F, 8.7F, 0F);
		LEar.setTextureSize(64, 32);
		LEar.mirror = true;
		setRotation(LEar, 0F, 0F, 0.3346075F);
		REar = new ModelRenderer(this, 14, 23);
		REar.addBox(0F, 0F, 0F, 1, 3, 1);
		REar.setRotationPoint(-4.6F, 9.1F, 0F);
		REar.setTextureSize(64, 32);
		REar.mirror = true;
		setRotation(REar, 0F, 0F, -0.3717861F);
		CannonBase = new ModelRenderer(this, 52, 22);
		CannonBase.addBox(0F, 0F, 0F, 3, 7, 3);
		CannonBase.setRotationPoint(-6F, 19F, -5F);
		CannonBase.setTextureSize(64, 32);
		CannonBase.mirror = true;
		setRotation(CannonBase, 1.003822F, 0F, 0F);
		CannonBack = new ModelRenderer(this, 48, 16);
		CannonBack.addBox(0F, 0F, 0F, 4, 2, 4);
		CannonBack.setRotationPoint(-6.5F, 22.8F, 0F);
		CannonBack.setTextureSize(64, 32);
		CannonBack.mirror = true;
		setRotation(CannonBack, 1.003822F, 0F, 0F);
		CannonFront = new ModelRenderer(this, 48, 16);
		CannonFront.addBox(0F, 0F, 0F, 4, 2, 4);
		CannonFront.setRotationPoint(-6.6F, 18.8F, -6F);
		CannonFront.setTextureSize(64, 32);
		CannonFront.mirror = true;
		setRotation(CannonFront, 1.003822F, 0F, 0F);
		LGoggle = new ModelRenderer(this, 0, 23);
		LGoggle.addBox(0F, 0F, 0F, 2, 2, 2);
		LGoggle.setRotationPoint(0.5F, 9F, -3.5F);
		LGoggle.setTextureSize(64, 32);
		LGoggle.mirror = true;
		setRotation(LGoggle, -0.3346075F, 0F, 0F);
		RGoggle = new ModelRenderer(this, 0, 23);
		RGoggle.addBox(0F, 0F, 0F, 2, 2, 2);
		RGoggle.setRotationPoint(-2.5F, 9F, -3.5F);
		RGoggle.setTextureSize(64, 32);
		RGoggle.mirror = true;
		setRotation(RGoggle, -0.3346075F, 0F, 0F);
		Backpack = new ModelRenderer(this, 18, 26);
		Backpack.addBox(0F, 0F, 0F, 3, 4, 2);
		Backpack.setRotationPoint(-1.5F, 15.7F, 0.5F);
		Backpack.setTextureSize(64, 32);
		Backpack.mirror = true;
		setRotation(Backpack, 0F, 0F, 0F);
		Backpack2 = new ModelRenderer(this, 22, 23);
		Backpack2.addBox(0F, 0F, 0F, 2, 2, 1);
		Backpack2.setRotationPoint(-1F, 17.3F, 2F);
		Backpack2.setTextureSize(64, 32);
		Backpack2.mirror = true;
		setRotation(Backpack2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Body.render(f5);
		LeftLeg.render(f5);
		RightLeg.render(f5);
		Head.render(f5);
		LArm.render(f5);
		LArm2.render(f5);
		SkullCap.render(f5);
		RArm.render(f5);
		RArm2.render(f5);
		LEar.render(f5);
		REar.render(f5);
		CannonBase.render(f5);
		CannonBack.render(f5);
		CannonFront.render(f5);
		LGoggle.render(f5);
		RGoggle.render(f5);
		Backpack.render(f5);
		Backpack2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * .1F * f1 * 0.5F;
		this.LeftLeg.rotateAngleY = 0.0f;

		this.RightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * .1F * f1;
		this.RightLeg.rotateAngleY = 0.0F;

	}

}
