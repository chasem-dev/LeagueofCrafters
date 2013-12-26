package leagueofcrafters.blocks;

import leagueofcrafters.entity.EntityMinion;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityNexus extends TileEntity {

	public static int cooldown = 0;
	@SideOnly(Side.CLIENT)
	private long field_82137_b;
	@SideOnly(Side.CLIENT)
	private float field_82138_c;

	public TileEntityNexus() {
	}

	public void updateEntity() {
		if (cooldown > 0) {
			cooldown--;
		}
		if (!this.worldObj.isRemote) {
			if (cooldown == 0) {
				for (int i = 0; i < 4; i++) {
					EntityMinion minion = new EntityMinion(this.worldObj);
					minion.setPositionAndUpdate(this.xCoord + i, this.yCoord + 1, this.zCoord + i);
					this.worldObj.spawnEntityInWorld(minion);
				}
				cooldown = 6000;
				// this.worldObj.setBlockMetadataWithNotify(this.xCoord,
				// this.yCoord, this.zCoord, 0, 1);
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
	}

	public float func_82125_v_() {
		int i = (int) (this.worldObj.getTotalWorldTime() - this.field_82137_b);
		this.field_82137_b = this.worldObj.getTotalWorldTime();

		if (i > 1) {
			this.field_82138_c -= (float) i / 40.0F;

			if (this.field_82138_c < 0.0F) {
				this.field_82138_c = 0.0F;
			}
		}

		this.field_82138_c += 0.025F;

		if (this.field_82138_c > 1.0F) {
			this.field_82138_c = 1.0F;
		}

		return this.field_82138_c;
	}
}
