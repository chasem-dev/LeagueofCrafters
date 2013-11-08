package leagueofcrafters.client.models;

import leagueofcrafters.entity.EntityBomb;
import leagueofcrafters.entity.EntityZiggs;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelZiggs extends ModelBase {
	// fields
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer body;
	ModelRenderer head;
	ModelRenderer right_arm;
	ModelRenderer left_arm;
	ModelRenderer Shape1;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape2;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;
	ModelRenderer Shape12;
	ModelRenderer FullHead;

	public ModelZiggs() {
		textureWidth = 256;
		textureHeight = 128;

		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-2F, 0F, -2F, 3, 5, 3);
		rightleg.setRotationPoint(-2F, 19F, 0F);
		rightleg.setTextureSize(256, 128);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-2F, 0F, -2F, 3, 5, 3);
		leftleg.setRotationPoint(2F, 19F, 0F);
		leftleg.setTextureSize(256, 128);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-3.5F, -5.5F, -1.5F, 7, 11, 3);
		body.setRotationPoint(-0.5F, 13.5F, -0.5F);
		body.setTextureSize(256, 128);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		head = new ModelRenderer(this, 16, 31);
		head.addBox(-2.5F, -5F, -2.5F, 5, 5, 5);
		head.setRotationPoint(-0.5F, 8F, -0.5F);
		head.setTextureSize(256, 128);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		right_arm = new ModelRenderer(this, 40, 16);
		right_arm.addBox(-2F, -1F, -1F, 2, 8, 2);
		right_arm.setRotationPoint(-4F, 10F, -0.5F);
		right_arm.setTextureSize(256, 128);
		right_arm.mirror = true;
		setRotation(right_arm, 0F, 0F, 0.074351F);
		left_arm = new ModelRenderer(this, 40, 16);
		left_arm.addBox(0F, -1F, -1F, 2, 8, 2);
		left_arm.setRotationPoint(3F, 10F, -0.5F);
		left_arm.setTextureSize(256, 128);
		left_arm.mirror = true;
		setRotation(left_arm, 0F, 0F, -0.074351F);

		Shape1 = new ModelRenderer(this, 36, 29);
		Shape1.addBox(0F, 0F, 0F, 4, 3, 1);
		Shape1.setRotationPoint(-2.5F, 2F, -3.25F);
		Shape1.setTextureSize(256, 128);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 17, 24);
		Shape3.addBox(0F, 0F, 0F, 5, 1, 5);
		Shape3.setRotationPoint(-3F, 2F, -3F);
		Shape3.setTextureSize(256, 128);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 0);
		Shape4.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape4.setRotationPoint(0F, 10F, 1F);
		Shape4.setTextureSize(256, 128);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 20, 20);
		Shape2.addBox(0F, 0F, 0F, 4, 1, 5);
		Shape2.setRotationPoint(-2.5F, 1.5F, -3F);
		Shape2.setTextureSize(256, 128);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 20, 20);
		Shape5.addBox(0F, 0F, 0F, 6, 5, 2);
		Shape5.setRotationPoint(-3.5F, 1.9F, 0.35F);
		Shape5.setTextureSize(256, 128);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 39, 0);
		Shape6.addBox(0F, 0F, 0F, 6, 6, 3);
		Shape6.setRotationPoint(-3.5F, 10F, 1F);
		Shape6.setTextureSize(256, 128);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 39, 0);
		Shape7.addBox(0F, 0F, 0F, 4, 4, 1);
		Shape7.setRotationPoint(-2.5F, 11F, 4F);
		Shape7.setTextureSize(256, 128);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 39, 0);
		Shape8.addBox(0F, 0F, 0F, 7, 4, 1);
		Shape8.setRotationPoint(-4F, 11F, 2F);
		Shape8.setTextureSize(256, 128);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 42, 0);
		Shape9.addBox(0F, 0F, 0F, 5, 7, 2);
		Shape9.setRotationPoint(-3F, 9.5F, 1.5F);
		Shape9.setTextureSize(256, 128);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 24, 6);
		Shape10.addBox(0F, 1F, 4F, 1, 1, 1);
		Shape10.setRotationPoint(-1F, 10F, 3F);
		Shape10.setTextureSize(256, 128);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 24, 0);
		Shape11.addBox(0F, 2F, 2F, 1, 1, 1);
		Shape11.setRotationPoint(-1F, 10F, 3F);
		Shape11.setTextureSize(256, 128);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 24, 0);
		Shape12.addBox(0F, 1F, 3F, 1, 1, 1);
		Shape12.setRotationPoint(-1F, 10F, 3F);
		Shape12.setTextureSize(256, 128);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F);

		FullHead = new ModelRenderer(this, "Fullhead");
		FullHead.setRotationPoint(0, 0, 0);
		FullHead.addChild(head);
		FullHead.addChild(Shape5);
		FullHead.addChild(Shape4);
		FullHead.addChild(Shape3);
		FullHead.addChild(Shape2);
		FullHead.addChild(Shape1);

	}

	public void render(EntityZiggs entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		rightleg.render(f5);
		leftleg.render(f5);
		body.render(f5);
		right_arm.render(f5);
		left_arm.render(f5);
		FullHead.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);

	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		FullHead.rotateAngleY = f3 / 57.29578F;
		FullHead.rotateAngleX = f4 / 57.29578F;

		this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
		this.leftleg.rotateAngleY = 0.0f;

		this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		this.rightleg.rotateAngleY = 0.0F;

		this.left_arm.rotateAngleX = MathHelper.cos((float) Math.PI) * 1.4F * f1;
		this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;

	}
}
