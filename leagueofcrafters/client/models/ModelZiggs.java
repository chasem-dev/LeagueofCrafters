package leagueofcrafters.client.models;

import leagueofcrafters.entity.EntityZiggs;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelZiggs extends ModelBase {
	// fields
	ModelRenderer Body;
	ModelRenderer LLeg;
	ModelRenderer RLeg;
	ModelRenderer LLeg2;
	ModelRenderer RLeg2;
	ModelRenderer Head;
	ModelRenderer Head2;
	ModelRenderer RArm;
	ModelRenderer LArm;
	ModelRenderer LCheek;
	ModelRenderer RCheek;
	ModelRenderer Snout;
	ModelRenderer Nose;
	ModelRenderer LEye;
	ModelRenderer REye;
	ModelRenderer Goatee;
	ModelRenderer Plate;
	ModelRenderer Bomb;
	ModelRenderer BombBottom;
	ModelRenderer BombTop;
	ModelRenderer Shape1;
	ModelRenderer BombLeft;
	ModelRenderer BombRight;
	ModelRenderer LFoot;
	ModelRenderer RFoot;
	ModelRenderer Fuse;
	ModelRenderer LEar;
	ModelRenderer REar;
	ModelRenderer LEar2;
	ModelRenderer REar2;
	ModelRenderer HandBomb;
	ModelRenderer HandBombTop;
	ModelRenderer HandBombSide;
	ModelRenderer HandBombFront;
	ModelRenderer Fuse2;
	ModelRenderer Earring;
	ModelRenderer HeadFull;
	ModelRenderer LLegFull;
	ModelRenderer RLegFull;
	ModelRenderer RArmFull;
	ModelRenderer LArmFull;

	public ModelZiggs() {
		textureWidth = 64;
		textureHeight = 32;

		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(0F, 0F, 0F, 5, 6, 4);
		Body.setRotationPoint(-2.5F, 15F, -2F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0.1115358F, 0F, 0F);

		LLegFull = new ModelRenderer(this, "LEFTLEGFULL");
		LLeg = new ModelRenderer(this, 0, 10);
		LLeg.addBox(0F, 0F, 0F, 1, 3, 2);
		LLeg.setRotationPoint(2F, 19F, 0.5F);
		LLeg.setTextureSize(64, 32);
		LLeg.mirror = true;
		setRotation(LLeg, -0.7807508F, -0.6320364F, 0F);
		LLeg2 = new ModelRenderer(this, 0, 15);
		LLeg2.addBox(0F, 0F, 0F, 1, 3, 1);
		LLeg2.setRotationPoint(3F, 21.4F, -1.5F);
		LLeg2.setTextureSize(64, 32);
		LLeg2.mirror = true;
		setRotation(LLeg2, 0.5205006F, -0.2230717F, 0F);
		LFoot = new ModelRenderer(this, 0, 19);
		LFoot.addBox(0F, 0F, 0F, 1, 1, 2);
		LFoot.setRotationPoint(3.6F, 23F, -1.9F);
		LFoot.setTextureSize(64, 32);
		LFoot.mirror = true;
		setRotation(LFoot, 0F, -0.4833219F, 0F);
		LLegFull.addChild(LLeg);
		LLegFull.addChild(LLeg2);
		LLegFull.addChild(LFoot);

		RLegFull = new ModelRenderer(this, "RightLEGFULL");

		RLeg = new ModelRenderer(this, 0, 10);
		RLeg.addBox(0F, 0F, 0F, 1, 3, 2);
		RLeg.setRotationPoint(-3F, 19F, 0.5F);
		RLeg.setTextureSize(64, 32);
		RLeg.mirror = true;
		setRotation(RLeg, -0.7435722F, 0.6320364F, 0F);
		RLeg2 = new ModelRenderer(this, 0, 15);
		RLeg2.addBox(0F, 0F, 0F, 1, 3, 1);
		RLeg2.setRotationPoint(-4F, 21.2F, -1.5F);
		RLeg2.setTextureSize(64, 32);
		RLeg2.mirror = true;
		setRotation(RLeg2, 0.2602503F, 0.2731595F, 0F);
		RFoot = new ModelRenderer(this, 0, 19);
		RFoot.addBox(0F, 0F, 0F, 1, 1, 2);
		RFoot.setRotationPoint(-4.3F, 23F, -2.4F);
		RFoot.setTextureSize(64, 32);
		RFoot.mirror = true;
		setRotation(RFoot, 0F, 0.2974289F, 0F);
		RLegFull.addChild(RLeg);
		RLegFull.addChild(RLeg2);
		RLegFull.addChild(RFoot);

		Head = new ModelRenderer(this, 36, 0);
		Head.addBox(0F, 0F, 0F, 8, 5, 6);
		Head.setRotationPoint(-4F, 11.1F, -4F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0.2974289F, 0F, 0.0371786F);
		Head2 = new ModelRenderer(this, 44, 11);
		Head2.addBox(0F, 0F, 0F, 6, 1, 4);
		Head2.setRotationPoint(-3F, 10.2F, -3F);
		Head2.setTextureSize(64, 32);
		Head2.mirror = true;
		setRotation(Head2, 0.4089647F, 0F, 0F);
		LEar = new ModelRenderer(this, 36, 11);
		LEar.addBox(0F, 0F, 0F, 3, 5, 1);
		LEar.setRotationPoint(5F, 7F, 0F);
		LEar.setTextureSize(64, 32);
		LEar.mirror = true;
		setRotation(LEar, -0.2974289F, 0F, 0.669215F);
		REar = new ModelRenderer(this, 36, 11);
		REar.addBox(0F, 0F, 0F, 3, 5, 1);
		REar.setRotationPoint(-5F, 7F, 1F);
		REar.setTextureSize(64, 32);
		REar.mirror = true;
		setRotation(REar, 0.2974289F, 3.141593F, -0.669215F);
		LEar2 = new ModelRenderer(this, 30, 11);
		LEar2.addBox(0F, 0F, 0F, 2, 3, 1);
		LEar2.setRotationPoint(5F, 6.5F, 0.5F);
		LEar2.setTextureSize(64, 32);
		LEar2.mirror = true;
		setRotation(LEar2, -0.3346075F, -0.1487144F, 0F);
		REar2 = new ModelRenderer(this, 30, 11);
		REar2.addBox(0F, 0F, 0F, 2, 3, 1);
		REar2.setRotationPoint(-7F, 6.5F, 0.5F);
		REar2.setTextureSize(64, 32);
		REar2.mirror = true;
		setRotation(REar2, -0.2974289F, 0F, 0F);
		LCheek = new ModelRenderer(this, 52, 16);
		LCheek.addBox(0F, 0F, 0F, 2, 3, 4);
		LCheek.setRotationPoint(3F, 12F, -3F);
		LCheek.setTextureSize(64, 32);
		LCheek.mirror = true;
		setRotation(LCheek, 0.3346075F, 0F, 0F);
		RCheek = new ModelRenderer(this, 52, 16);
		RCheek.addBox(0F, 0F, 0F, 2, 3, 4);
		RCheek.setRotationPoint(-5F, 12F, -3F);
		RCheek.setTextureSize(64, 32);
		RCheek.mirror = true;
		setRotation(RCheek, 0.3717861F, 0F, 0F);
		Snout = new ModelRenderer(this, 12, 10);
		Snout.addBox(0F, 0F, 0F, 6, 2, 1);
		Snout.setRotationPoint(-3F, 13.7F, -4F);
		Snout.setTextureSize(64, 32);
		Snout.mirror = true;
		setRotation(Snout, 0.2974289F, 0F, 0F);
		Nose = new ModelRenderer(this, 60, 30);
		Nose.addBox(0F, 0F, 0F, 1, 1, 1);
		Nose.setRotationPoint(-0.5F, 15F, -3.5F);
		Nose.setTextureSize(64, 32);
		Nose.mirror = true;
		setRotation(Nose, 2.528146F, 0F, 0F);
		LEye = new ModelRenderer(this, 32, 0);
		LEye.addBox(0F, 0F, 0F, 2, 2, 1);
		LEye.setRotationPoint(0.3F, 11.5F, -4F);
		LEye.setTextureSize(64, 32);
		LEye.mirror = true;
		setRotation(LEye, 0F, 0F, 0F);
		REye = new ModelRenderer(this, 32, 0);
		REye.addBox(0F, 0F, 0F, 2, 2, 1);
		REye.setRotationPoint(-2.3F, 11.5F, -4F);
		REye.setTextureSize(64, 32);
		REye.mirror = true;
		setRotation(REye, 0F, 0F, 0F);
		Goatee = new ModelRenderer(this, 12, 13);
		Goatee.addBox(0F, 0F, 0F, 1, 1, 1);
		Goatee.setRotationPoint(-0.5F, 15F, -3.45F);
		Goatee.setTextureSize(64, 32);
		Goatee.mirror = true;
		setRotation(Goatee, 0F, 0F, 0F);
		Earring = new ModelRenderer(this, 26, 11);
		Earring.addBox(0F, 0F, 0F, 0, 2, 2);
		Earring.setRotationPoint(6F, 9F, -0.1F);
		Earring.setTextureSize(64, 32);
		Earring.mirror = true;
		setRotation(Earring, -0.7435722F, 0F, -0.1487144F);

		RArm = new ModelRenderer(this, 18, 0);
		RArm.addBox(0F, 0F, 0F, 4, 1, 1);
		RArm.setRotationPoint(-4.5F, 18F, -3F);
		RArm.setTextureSize(64, 32);
		RArm.mirror = true;
		setRotation(RArm, 0F, -0.5948578F, -0.5948578F);

		LArm = new ModelRenderer(this, 18, 0);
		LArm.addBox(0F, 0F, 0F, 4, 1, 1);
		LArm.setRotationPoint(1.8F, 15.6F, -1F);
		LArm.setTextureSize(64, 32);
		LArm.mirror = true;
		setRotation(LArm, 0F, 0.5948578F, 0.6320364F);
		// /LArm.addChild(HandBomb);
		// LArm.addChild(HandBombFront);
		// LArm.addChild(HandBombSide);
		// /LArm.addChild(HandBombTop);
		// LArm.addChild(Fuse2);

		Plate = new ModelRenderer(this, 16, 4);
		Plate.addBox(0F, 0F, 0F, 3, 4, 2);
		Plate.setRotationPoint(-1.5F, 16.5F, -2.5F);
		Plate.setTextureSize(64, 32);
		Plate.mirror = true;
		setRotation(Plate, 0.2974289F, 0F, 0F);
		Bomb = new ModelRenderer(this, 0, 24);
		Bomb.addBox(0F, 0F, 0F, 4, 4, 4);
		Bomb.setRotationPoint(-2F, 15F, 2F);
		Bomb.setTextureSize(64, 32);
		Bomb.mirror = true;
		setRotation(Bomb, 0.1487144F, 0F, 0F);
		BombBottom = new ModelRenderer(this, 32, 28);
		BombBottom.addBox(0F, 0F, 0F, 3, 1, 3);
		BombBottom.setRotationPoint(-1.5F, 18.6F, 2.8F);
		BombBottom.setTextureSize(64, 32);
		BombBottom.mirror = true;
		setRotation(BombBottom, 0.1487144F, 0F, 0F);
		BombTop = new ModelRenderer(this, 32, 28);
		BombTop.addBox(0F, 0F, 0F, 3, 1, 3);
		BombTop.setRotationPoint(-1.5F, 14.3F, 2.3F);
		BombTop.setTextureSize(64, 32);
		BombTop.mirror = true;
		setRotation(BombTop, 0.1487144F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 24, 28);
		Shape1.addBox(0F, 0F, 0F, 3, 3, 1);
		Shape1.setRotationPoint(-1.5F, 15F, 6F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0.1487144F, 0F, 0F);
		BombLeft = new ModelRenderer(this, 16, 26);
		BombLeft.addBox(0F, 0F, 0F, 1, 3, 3);
		BombLeft.setRotationPoint(1.7F, 15.4F, 2.4F);
		BombLeft.setTextureSize(64, 32);
		BombLeft.mirror = true;
		setRotation(BombLeft, 0.1487144F, 0F, 0F);
		BombRight = new ModelRenderer(this, 16, 26);
		BombRight.addBox(0F, 0F, 0F, 1, 3, 3);
		BombRight.setRotationPoint(-2.7F, 15.4F, 2.4F);
		BombRight.setTextureSize(64, 32);
		BombRight.mirror = true;
		setRotation(BombRight, 0.1487144F, 0F, 0F);
		Fuse = new ModelRenderer(this, 14, 19);
		Fuse.addBox(0F, 0F, 0F, 0, 4, 1);
		Fuse.setRotationPoint(0F, 11F, 5.6F);
		Fuse.setTextureSize(64, 32);
		Fuse.mirror = true;
		setRotation(Fuse, -0.6320364F, 0F, 0F);

		HandBomb = new ModelRenderer(this, 25, 22);
		HandBomb.addBox(0F, 0F, 0F, 3, 3, 3);
		HandBomb.setRotationPoint(3F, 16.7F, -4.5F);
		HandBomb.setTextureSize(64, 32);
		HandBomb.mirror = true;
		setRotation(HandBomb, 0F, 0F, 0F);
		HandBombTop = new ModelRenderer(this, 37, 22);
		HandBombTop.addBox(0F, 0F, 0F, 2, 4, 2);
		HandBombTop.setRotationPoint(3.5F, 16.2F, -4F);
		HandBombTop.setTextureSize(64, 32);
		HandBombTop.mirror = true;
		setRotation(HandBombTop, 0F, 0F, 0F);
		HandBombSide = new ModelRenderer(this, 45, 28);
		HandBombSide.addBox(0F, 0F, 0F, 4, 2, 2);
		HandBombSide.setRotationPoint(2.5F, 17.3F, -4F);
		HandBombSide.setTextureSize(64, 32);
		HandBombSide.mirror = true;
		setRotation(HandBombSide, 0F, 0F, 0F);
		HandBombFront = new ModelRenderer(this, 45, 24);
		HandBombFront.addBox(0F, 0F, 0F, 4, 2, 2);
		HandBombFront.setRotationPoint(3.53F, 17.3F, -1F);
		HandBombFront.setTextureSize(64, 32);
		HandBombFront.mirror = true;
		setRotation(HandBombFront, 0F, 1.59868F, 0F);
		Fuse2 = new ModelRenderer(this, 14, 19);
		Fuse2.addBox(0F, 0F, 0F, 0, 4, 1);
		Fuse2.setRotationPoint(6F, 14F, -2F);
		Fuse2.setTextureSize(64, 32);
		Fuse2.mirror = true;
		setRotation(Fuse2, -0.4089647F, -0.2230717F, 0.5948578F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.renderZiggs((EntityZiggs) entity, f, f1, f2, f3, f4, f5);
	}

	private void renderZiggs(EntityZiggs entity, float f, float f1, float f2, float f3, float f4, float f5) {
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		RLegFull.render(f5);
		LLegFull.render(f5);
		Body.render(f5);
		Head.render(f5);
		Head2.render(f5);
		RArm.render(f5);
		LArm.render(f5);
		LCheek.render(f5);
		RCheek.render(f5);
		Snout.render(f5);
		Nose.render(f5);
		LEye.render(f5);
		REye.render(f5);
		Goatee.render(f5);
		Plate.render(f5);
		Bomb.render(f5);
		BombBottom.render(f5);
		BombTop.render(f5);
		Shape1.render(f5);
		BombLeft.render(f5);
		BombRight.render(f5);
		Fuse.render(f5);
		LEar.render(f5);
		REar.render(f5);
		LEar2.render(f5);
		REar2.render(f5);
		Earring.render(f5);
		if (entity.timer <= 35) {
			HandBomb.render(f5);
			HandBombTop.render(f5);
			HandBombSide.render(f5);
			HandBombFront.render(f5);
			Fuse2.render(f5);
		}
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		this.LLegFull.rotateAngleX = MathHelper.cos(f * 0.6662F) * .24F * f1 * 0.5F;
		this.LLegFull.rotateAngleY = 0.0f;

		this.RLegFull.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * .24F * f1;
		this.RLegFull.rotateAngleY = 0.0F;

		this.LArm.rotateAngleX = MathHelper.cos((float) Math.PI) * .6F * f1;
		this.HandBomb.rotateAngleX = MathHelper.cos((float) Math.PI) * .3F * f1;
		this.HandBombSide.rotateAngleX = MathHelper.cos((float) Math.PI) * .3F * f1;
		this.HandBombTop.rotateAngleX = MathHelper.cos((float) Math.PI) * .3F * f1;
		this.HandBombFront.rotateAngleX = MathHelper.cos((float) Math.PI) * .3F * f1;
		this.Fuse2.rotateAngleX = MathHelper.cos((float) Math.PI) * .3F * f1;
		this.RArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;

	}

}
