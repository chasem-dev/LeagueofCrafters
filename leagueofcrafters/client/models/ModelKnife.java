package leagueofcrafters.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKnife extends ModelBase {
	// fields
	ModelRenderer AxeHandle;
	ModelRenderer Axeblade;

	public ModelKnife() {
		textureWidth = 128;
		textureHeight = 64;

		AxeHandle = new ModelRenderer(this, 50, 61);
		AxeHandle.addBox(0F, 0F, -3F, 12, 2, 1);
		AxeHandle.setRotationPoint(3F, 10F, -2F);
		AxeHandle.setTextureSize(128, 64);
		AxeHandle.mirror = true;
		setRotation(AxeHandle, 0F, 1.59868F, -0.3346075F);
		Axeblade = new ModelRenderer(this, 50, 52);
		Axeblade.addBox(0F, 0F, 0F, 15, 8, 0);
		Axeblade.setRotationPoint(0.5F, 5.2F, -11F);
		Axeblade.setTextureSize(128, 64);
		Axeblade.mirror = true;
		setRotation(Axeblade, 0F, 1.59868F, -0.3346075F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		AxeHandle.render(f5);
		Axeblade.render(f5);
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
