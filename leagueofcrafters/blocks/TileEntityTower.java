package leagueofcrafters.blocks;

import leagueofcrafters.entity.EntityMundo;
import leagueofcrafters.entity.projectiles.EntityTurretBeam;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

public class TileEntityTower extends TileEntity {
	public int cooldown = 0;

	public TileEntityTower() {
	}

	public void updateEntity() {
		if (cooldown == 0) {
			EntityPlayer player = this.worldObj.getClosestPlayer(this.xCoord, this.yCoord, this.zCoord, 10);
			if (player != null) {
				EntityTurretBeam entityarrow = new EntityTurretBeam(this.worldObj, new EntityMundo(this.worldObj), 1.6F);
				entityarrow.setPosition(this.xCoord, this.yCoord + 2, this.zCoord);
				double d0 = player.posX - this.xCoord;
				double d1 = player.posY + (double) player.getEyeHeight() - this.yCoord - 2;
				double d2 = player.posZ - this.zCoord;
				float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.1F;
				entityarrow.setThrowableHeading(d0, d1 + (double) f1, d2, 1.6F, 12.0F);
				// entityarrow.setVelocity(1, 1, 1);
				this.worldObj.spawnEntityInWorld(entityarrow);

				// System.out.println("Fire!");
				cooldown = 50;
			}
		}
		if (cooldown > 0)
			cooldown--;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		// super.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		// super.readFromNBT(nbt);
	}
}
