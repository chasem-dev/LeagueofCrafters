package leagueofcrafters.client.models;

import leagueofcrafters.entity.projectiles.EntityBomb;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBomb extends ModelBase {
	// fields
	ModelRenderer Fuse;
	ModelRenderer Bomb;
	ModelRenderer TopandBottom;
	ModelRenderer Sides;
	ModelRenderer FrontandBack;
	ModelRenderer Body;

	public ModelBomb() {
		textureWidth = 64;
		textureHeight = 32;

		Body = new ModelRenderer(this, "body");
		Body.setRotationPoint(0, 0, 0);
		Fuse = new ModelRenderer(this, 0, 10);
		Fuse.addBox(0F, 0F, 0F, 0, 4, 1);
		Fuse.setRotationPoint(0F, 14F, 1.6F);
		Fuse.setTextureSize(64, 32);
		Fuse.mirror = true;
		setRotation(Fuse, -0.6320364F, 0F, 0F);
		Bomb = new ModelRenderer(this, 0, 0);
		Bomb.addBox(0F, 0F, 0F, 5, 5, 5);
		Bomb.setRotationPoint(-2.5F, 18F, -2.5F);
		Bomb.setTextureSize(64, 32);
		Bomb.mirror = true;
		setRotation(Bomb, 0F, 0F, 0F);
		TopandBottom = new ModelRenderer(this, 20, 0);
		TopandBottom.addBox(0F, 0F, 0F, 4, 7, 4);
		TopandBottom.setRotationPoint(-2F, 17F, -2F);
		TopandBottom.setTextureSize(64, 32);
		TopandBottom.mirror = true;
		setRotation(TopandBottom, 0F, 0F, 0F);
		Sides = new ModelRenderer(this, 36, 0);
		Sides.addBox(-3.5F, 1F, -2F, 7, 4, 4);
		Sides.setRotationPoint(0F, 17.5F, 0F);
		Sides.setTextureSize(64, 32);
		Sides.mirror = true;
		setRotation(Sides, 0F, 0F, 0F);
		FrontandBack = new ModelRenderer(this, 36, 8);
		FrontandBack.addBox(0F, 0F, 0F, 4, 4, 7);
		FrontandBack.setRotationPoint(-2F, 18.5F, -3.5F);
		FrontandBack.setTextureSize(64, 32);
		FrontandBack.mirror = true;
		setRotation(FrontandBack, 0F, 0F, 0F);

		Body.addChild(Fuse);
		Body.addChild(FrontandBack);
		Body.addChild(Bomb);
		Body.addChild(Sides);
		Body.addChild(TopandBottom);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		// /Fuse.render(f5);
		// Bomb.render(f5);
		// TopandBottom.render(f5);
		// /Sides.render(f5);
		// FrontandBack.render(f5);
		Body.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
