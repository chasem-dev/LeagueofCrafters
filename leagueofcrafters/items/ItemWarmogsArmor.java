package leagueofcrafters.items;

import leagueofcrafters.LeagueItems;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWarmogsArmor extends ItemArmor {

	public static String textureName;

	public ItemWarmogsArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String texture) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.textureName = texture;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("league:" + textureName);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return "league:armor/" + textureName + ".png";

	}
}
