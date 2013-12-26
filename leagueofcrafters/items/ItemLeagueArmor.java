package leagueofcrafters.items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLeagueArmor extends ItemArmor {

	public ItemLeagueArmor(int i, EnumArmorMaterial enumArmorMaterial, int k, int l, String textureName) {
		super(i, enumArmorMaterial, k, l);
		this.setMaxDamage(enumArmorMaterial.getDurability(l));
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.textureName = textureName;
		// this.healthBoost = health;
	}

	String textureName;
	public static int healthBoost;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("league:" + textureName);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return "league:armor/" + textureName + ".png";
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {

	}

}
