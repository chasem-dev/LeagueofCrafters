package leagueofcrafters;

import leagueofcrafters.blocks.BlockFreljordCrop;
import leagueofcrafters.blocks.BlockNexus;
import leagueofcrafters.items.ItemBlowdart;
import leagueofcrafters.items.ItemBomb;
import leagueofcrafters.items.ItemCannon;
import leagueofcrafters.items.ItemDart;
import leagueofcrafters.items.ItemDoransBlade;
import leagueofcrafters.items.ItemFreljordBerry;
import leagueofcrafters.items.ItemFreljordBow;
import leagueofcrafters.items.ItemFrozenArrow;
import leagueofcrafters.items.ItemLeagueArmor;
import leagueofcrafters.items.ItemLeagueDiscs;
import leagueofcrafters.items.ItemWarmogsArmor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LeagueItems {

	public static int doransBladeID;
	public static int dartID;
	public static int bombID;
	public static int cannonID;
	public static int blowdartID;
	public static int nexusID;
	public static int warmogsID;
	public static int towerID;
	public static CreativeTabs tabLeagueofCrafters = LeagueofCrafters.tabLeagueofCrafters;
	public static int freljordSeedsID;
	public static int freljordCropID;
	public static int freljordBerryID;
	public static int guardianAngelID;
	public static int record1ID;
	public static int frozenArrowID;
	public static int frozenBowID;

	@Mod.Item(name = "Bomb", typeClass = "leagueofcrafters.items.ItemBomb")
	public static Item bomb;

	@Mod.Item(name = "Dart", typeClass = "leagueofcrafters.items.ItemDart")
	public static Item dart;

	@Mod.Item(name = "Cannon", typeClass = "leagueofcrafters.items.ItemCannon")
	public static Item cannon;

	@Mod.Item(name = "Blowdart Gun", typeClass = "leagueofcrafters.items.ItemBlowdart")
	public static Item blowdart;

	@Mod.Item(name = "Doran's Blade", typeClass = "leagueofcrafters.items.ItemDoransBlade")
	public static Item doransblade;

	@Mod.Block(name = "Nexus", itemTypeClass = ItemBlock.class)
	public static Block nexus;

	@Mod.Item(name = "Warmog's Armor", typeClass = "leagueofcrafters.items.ItemWarmogs")
	public static Item warmogs;

	@Mod.Item(name = "Freljord Seeds", typeClass = "net.minecraft.items.ItemSeed")
	public static Item freljordSeeds;

	@Mod.Block(name = "Freljord Crop", itemTypeClass = ItemBlock.class)
	public static Block freljordCrop;

	@Mod.Item(name = "Freljord Berry", typeClass = "net.minecraft.items.ItemFood")
	public static Item freljordBerry;

	@Mod.Item(name = "Guardian Angel", typeClass = "net.minecraft.items.ItemFood")
	public static Item guardianAngel;

	@Mod.Item(name = "Record1", typeClass = "net.minecraft.items.ItemRecord")
	public static Item record1;

	@Mod.Item(name = "Frozen Arrow", typeClass = "net.minecraft.items.ItemArrow")
	public static Item frozenArrow;

	@Mod.Item(name = "Frozen Bow", typeClass = "net.minecraft.items.ItemBow")
	public static Item frozenBow;

	// @Mod.Block(name = "Tower", itemTypeClass = ItemBlock.class)
	// public static Block tower;

	public static void load(Configuration cfg) {
		bombID = cfg.getItem("Bomb", 5000).getInt(5000);
		dartID = cfg.getItem("Dart", 5001).getInt(5001);
		cannonID = cfg.getItem("Cannon", 5002).getInt(5002);
		blowdartID = cfg.getItem("Blowdart Gun", 5003).getInt(5003);
		doransBladeID = cfg.getItem("Doran's Blade", 5004).getInt(5004);
		warmogsID = cfg.getItem("Warmog's Armor", 5005).getInt(5005);
		freljordSeedsID = cfg.getItem("Freljord Seeds", 5006).getInt(5006);
		freljordBerryID = cfg.getItem("Freljord Berry", 5007).getInt(5007);
		guardianAngelID = cfg.getItem("Guardian Angel", 5008).getInt(5008);
	//	record1ID = cfg.getItem("Record1", 5009).getInt(5009);
		frozenArrowID = cfg.getItem("Frozen Arrow", 5010).getInt(5010);
		frozenBowID = cfg.getItem("Frozen Bow", 5011).getInt(5011);

		nexusID = cfg.getBlock("Nexus", 500).getInt(500);
		towerID = cfg.getBlock("Tower", 501).getInt(501);
		freljordCropID = cfg.getBlock("Freljord Crop", 502).getInt(502);

		bomb = (ItemBomb) new ItemBomb(bombID).setMaxStackSize(64).setUnlocalizedName("Bomb").setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(bomb, "Bomb");

		dart = (ItemDart) new ItemDart(dartID).setMaxStackSize(64).setUnlocalizedName("Dart").setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(dart, "Dart");

		cannon = (ItemCannon) new ItemCannon(cannonID).setMaxStackSize(1).setUnlocalizedName("Cannon").setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(cannon, "Cannon");

		blowdart = (ItemBlowdart) new ItemBlowdart(blowdartID).setMaxStackSize(1).setUnlocalizedName("Blowdart").setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(blowdart, "Blowdart Gun");

		doransblade = (ItemDoransBlade) new ItemDoransBlade(doransBladeID, LeagueofCrafters.League).setMaxStackSize(1).setUnlocalizedName("Doran's Blade")
				.setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(doransblade, "Doran's Blade");

		nexus = new BlockNexus(nexusID, Material.rock).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("nexus")
				.setCreativeTab(tabLeagueofCrafters);

		warmogs = new ItemWarmogsArmor(warmogsID, LeagueofCrafters.LeagueArmor, 2, 1, "warmogs").setUnlocalizedName("Warmogs").setCreativeTab(
				tabLeagueofCrafters);
		LanguageRegistry.addName(warmogs, "Warmog's Armor");

		freljordCrop = new BlockFreljordCrop(freljordCropID);

		freljordSeeds = new ItemSeeds(freljordSeedsID, freljordCrop.blockID, Block.tilledField.blockID).setTextureName("league:freljordSeed")
				.setUnlocalizedName("FrelhordSeeds");
		LanguageRegistry.addName(freljordSeeds, "Freljord Seed");

		freljordBerry = new ItemFreljordBerry(freljordBerryID, 2, false).setUnlocalizedName("freljordBerry").setTextureName("league:freljordBerry");
		LanguageRegistry.addName(freljordBerry, "Freljord Berry");

		guardianAngel = new ItemLeagueArmor(guardianAngelID, LeagueofCrafters.LeagueArmor, 2, 1, "guardianangel").setUnlocalizedName("GuardianAngel")
				.setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(guardianAngel, "Guardian Angel");

	//	record1 = new ItemLeagueDiscs(record1ID, "GetJinxed").setUnlocalizedName("record1");

		frozenArrow = (ItemFrozenArrow) new ItemFrozenArrow(frozenArrowID).setMaxStackSize(64).setUnlocalizedName("frozenArrow")
				.setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(frozenArrow, "Frozen Arrow");

		frozenBow = new ItemFreljordBow(frozenBowID).setMaxStackSize(1).setUnlocalizedName("frozenBow").setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(frozenBow, "Freljord Bow");

	}
}
