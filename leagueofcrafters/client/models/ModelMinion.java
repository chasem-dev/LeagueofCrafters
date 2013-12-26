package leagueofcrafters.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMinion extends ModelBase {
	ModelRenderer Body;
	ModelRenderer RobeRim;
	ModelRenderer RobeRim2;
	ModelRenderer NeckIsh;
	ModelRenderer Head;
	ModelRenderer LArm;
	ModelRenderer RArm;
	ModelRenderer Blade1;
	ModelRenderer Blade2;
	ModelRenderer Shield;
	ModelRenderer Hat1;
	ModelRenderer Hat2;
	ModelRenderer Hat3;
	ModelRenderer Hat4;

	public ModelMinion() {
		textureWidth = 128;
		textureHeight = 64;

		Body = new ModelRenderer(this, 0, 41);
		Body.addBox(0F, 0F, 0F, 10, 13, 10);
		Body.setRotationPoint(-5F, 10F, -6F);
		Body.setTextureSize(128, 64);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		RobeRim = new ModelRenderer(this, 0, 4);
		RobeRim.addBox(0F, 0F, 0F, 14, 1, 18);
		RobeRim.setRotationPoint(-7F, 23F, -8F);
		RobeRim.setTextureSize(128, 64);
		RobeRim.mirror = true;
		setRotation(RobeRim, 0F, 0F, 0F);
		RobeRim2 = new ModelRenderer(this, 0, 23);
		RobeRim2.addBox(0F, 0F, 0F, 12, 2, 16);
		RobeRim2.setRotationPoint(-6F, 21.5F, -7F);
		RobeRim2.setTextureSize(128, 64);
		RobeRim2.mirror = true;
		setRotation(RobeRim2, 0F, 0F, 0F);
		NeckIsh = new ModelRenderer(this, 62, 52);
		NeckIsh.addBox(0F, 0F, 0F, 6, 6, 6);
		NeckIsh.setRotationPoint(-3F, 6F, -4F);
		NeckIsh.setTextureSize(128, 64);
		NeckIsh.mirror = true;
		setRotation(NeckIsh, 0.2974289F, 0F, 0F);
		Head = new ModelRenderer(this, 86, 44);
		Head.addBox(0F, 0F, 0F, 11, 10, 10);
		Head.setRotationPoint(-5.5F, 3F, -11F);
		Head.setTextureSize(128, 64);
		Head.mirror = true;
		setRotation(Head, 0.2974289F, 0F, 0F);
		LArm = new ModelRenderer(this, 46, 56);
		LArm.addBox(0F, 0F, 0F, 3, 5, 3);
		LArm.setRotationPoint(6F, 13F, -5F);
		LArm.setTextureSize(128, 64);
		LArm.mirror = true;
		setRotation(LArm, 0.3717861F, -0.3717861F, 0F);
		RArm = new ModelRenderer(this, 46, 56);
		RArm.addBox(0F, 0F, 0F, 3, 5, 3);
		RArm.setRotationPoint(-8.8F, 13F, -5F);
		RArm.setTextureSize(128, 64);
		RArm.mirror = true;
		setRotation(RArm, 0.3717861F, 0.2974289F, 0F);
		Blade1 = new ModelRenderer(this, 68, 21);
		Blade1.addBox(0F, 0F, 0F, 4, 6, 4);
		Blade1.setRotationPoint(8.9F, 9F, -9F);
		Blade1.setTextureSize(128, 64);
		Blade1.mirror = true;
		setRotation(Blade1, 0.5576792F, -0.5205006F, 0.2230717F);
		Blade2 = new ModelRenderer(this, 68, 31);
		Blade2.addBox(0F, 0F, 0F, 3, 10, 3);
		Blade2.setRotationPoint(13.1F, 2F, -12.5F);
		Blade2.setTextureSize(128, 64);
		Blade2.mirror = true;
		setRotation(Blade2, 0.5576792F, -0.5205006F, 0.2230717F);
		Shield = new ModelRenderer(this, 68, 0);
		Shield.addBox(0F, 0F, 0F, 1, 12, 9);
		Shield.setRotationPoint(-11F, 11F, -9F);
		Shield.setTextureSize(128, 64);
		Shield.mirror = true;
		setRotation(Shield, 0.3665191F, 0.296706F, 0F);
		Hat1 = new ModelRenderer(this, 94, 33);
		Hat1.addBox(0F, 0F, 0F, 9, 3, 8);
		Hat1.setRotationPoint(-4.5F, 0F, -10F);
		Hat1.setTextureSize(128, 64);
		Hat1.mirror = true;
		setRotation(Hat1, 0F, 0F, 0F);
		Hat2 = new ModelRenderer(this, 98, 23);
		Hat2.addBox(0F, 0F, 0F, 8, 3, 7);
		Hat2.setRotationPoint(-4F, -2F, -9F);
		Hat2.setTextureSize(128, 64);
		Hat2.mirror = true;
		setRotation(Hat2, -0.1858931F, 0F, 0F);
		Hat3 = new ModelRenderer(this, 106, 15);
		Hat3.addBox(0F, 0F, 0F, 6, 3, 5);
		Hat3.setRotationPoint(-3F, -3F, -7F);
		Hat3.setTextureSize(128, 64);
		Hat3.mirror = true;
		setRotation(Hat3, -0.2974289F, 0F, 0F);
		Hat4 = new ModelRenderer(this, 114, 8);
		Hat4.addBox(0F, 0F, 0F, 4, 4, 3);
		Hat4.setRotationPoint(-2F, -5.6F, -3.5F);
		Hat4.setTextureSize(128, 64);
		Hat4.mirror = true;
		setRotation(Hat4, -0.669215F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		Body.render(f5);
		RobeRim.render(f5);
		RobeRim2.render(f5);
		NeckIsh.render(f5);
		Head.render(f5);
		LArm.render(f5);
		RArm.render(f5);
		Blade1.render(f5);
		Blade2.render(f5);
		Shield.render(f5);
		Hat1.render(f5);
		Hat2.render(f5);
		Hat3.render(f5);
		Hat4.render(f5);
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
