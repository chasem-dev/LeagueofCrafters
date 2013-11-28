package leagueofcrafters;

import java.io.File;

import leagueofcrafters.entity.*;
import leagueofcrafters.handlers.*;
import leagueofcrafters.items.*;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "LoC", name = "League Of Crafters", version = "0.2.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { "league" }, packetHandler = PacketHandler.class)
public class LeagueofCrafters {

	public static CreativeTabs tabLeagueofCrafters = new tabLeagueofCrafters(CreativeTabs.getNextID(), "League of Crafters");
	public static ItemDoransBlade doransblade;
	public static EnumToolMaterial League = EnumHelper.addToolMaterial("LeagueArmor", 2, 200, 6.5f, 2f, 14);
	// public static EnumArmorMaterial LeagueArmor =
	// EnumHelper.addArmorMaterial("LeagueArmor", 15, new int[] { 2, 6, 5, 2 },
	// 9);

	public static ItemDart dart;
	public static ItemBomb bomb;
	public static ItemCannon cannon;
	public static ItemBlowdart blowdart;
	// public static ItemMissle missle;
	// public static ItemLeague league;
	// public static ItemLeague doransshield;
	// public static ItemLeagueArmor warmogs;
	// public static ItemLeagueArmor spiritVisage;
	// public static ItemLeague frozenmallet;
	private static int modGuiIndex = 0;
	private static int modItemIndex = 7000;
	public static final int ItemInventoryGuiIndex = modGuiIndex++;

	@Instance(value = "LoC")
	public static LeagueofCrafters instance;

	@SidedProxy(clientSide = "leagueofcrafters.client.ClientProxy", serverSide = "leagueofcrafters.CommonProxy")
	public static CommonProxy proxy;
	public static File modDirectory;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new DamageHandler());
		TickRegistry.registerTickHandler(new TickHandler(), Side.SERVER);
		modDirectory = new File(event.getModConfigurationDirectory().getParent());
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());

		KeyBinding[] key = { new KeyBinding("League Items", Keyboard.KEY_F) };
		boolean[] repeat = { false };
		KeyBindingRegistry.registerKeyBinding(new LeagueKeyBind(key, repeat));

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		dart = (ItemDart) new ItemDart(5001).setMaxStackSize(64).setUnlocalizedName("Dart").setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(dart, "Dart");
		bomb = (ItemBomb) new ItemBomb(5000).setMaxStackSize(64).setUnlocalizedName("Bomb").setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(bomb, "Bomb");

		cannon = (ItemCannon) new ItemCannon(5002).setMaxStackSize(1).setUnlocalizedName("Cannon").setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(cannon, "Cannon");

		blowdart = (ItemBlowdart) new ItemBlowdart(5003).setMaxStackSize(1).setUnlocalizedName("Blowdart").setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(blowdart, "Blowdart Gun");

		doransblade = (ItemDoransBlade) new ItemDoransBlade(5004, League).setMaxStackSize(1).setUnlocalizedName("Doran's Blade")
				.setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(doransblade, "Doran's Blade");

		// warmogs = (ItemLeagueArmor) new ItemLeagueArmor(5005, LeagueArmor, 5,
		// 1, "warmogs", 10).setMaxStackSize(1).setUnlocalizedName("Warmogs");
		// LanguageRegistry.addName(warmogs, "Warmog's Armor");

		// spiritVisage = (ItemLeagueArmor) new ItemLeagueArmor(5006,
		// LeagueArmor, 5, 1, "spiritVisage",
		// 10).setMaxStackSize(1).setUnlocalizedName("spiritVisage");
		// LanguageRegistry.addName(spiritVisage, "Spirit Visage");

		// doransshield = (ItemLeague) new ItemLeague(5005,
		// "doransShield").setMaxStackSize(1).setUnlocalizedName("Doran's Shield")
		// .setCreativeTab(tabLeagueofCrafters);
		// LanguageRegistry.addName(doransshield, "Doran's Shield");

		// /warmogs = (ItemLeague) new ItemLeague(5005, "warmogs",
		// 10).setMaxStackSize(1).setUnlocalizedName("Warmogs").setCreativeTab(tabLeagueofCrafters);
		// LanguageRegistry.addName(warmogs, "Warmogs Armor");

		// frozenmallet = (ItemLeague) new ItemLeague(5006, "frozenmallet",
		// 5).setMaxStackSize(1).setUnlocalizedName("frozenmallet")
		// .setCreativeTab(tabLeagueofCrafters);
		// LanguageRegistry.addName(frozenmallet, "frozenmallet");

		// league = (ItemLeague) new ItemLeague(5007, "league",
		// 0).setMaxStackSize(1).setUnlocalizedName("League").setCreativeTab(tabLeagueofCrafters);
		// LanguageRegistry.addName(league, "League");

		EntityRegistry.registerModEntity(EntityDart.class, "Dart", 1000, this, 80, 1, true);
		EntityRegistry.registerGlobalEntityID(EntityTeemo.class, "Teemo", EntityRegistry.findGlobalUniqueEntityId(), 0x185100, 0xFFAE7C);
		EntityRegistry.registerModEntity(EntityTeemo.class, "Teemo", 1001, this, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Teemo.name", "en_US", "Teemo");

		EntityRegistry.registerGlobalEntityID(EntityZiggs.class, "Ziggs", EntityRegistry.findGlobalUniqueEntityId(), 0x4C2B15, 0x304656);
		EntityRegistry.registerModEntity(EntityZiggs.class, "Ziggs", 1002, this, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Ziggs.name", "en_US", "Ziggs");

		EntityRegistry.registerModEntity(EntityBomb.class, "Bomb", 1003, this, 80, 1, true);

		EntityRegistry.registerGlobalEntityID(EntityTwitch.class, "Twitch", EntityRegistry.findGlobalUniqueEntityId(), 0x164C00, 0xC4A300);
		EntityRegistry.registerModEntity(EntityTwitch.class, "Twitch", 1004, this, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Twitch.name", "en_US", "Twitch");

		EntityRegistry.registerModEntity(EntityTristanaBomb.class, "tristanaBomb", 1005, this, 80, 1, true);

		EntityRegistry.registerGlobalEntityID(EntityTristana.class, "Tristana", EntityRegistry.findGlobalUniqueEntityId(), 0x0094FF, 0xFFFFFF);
		EntityRegistry.registerModEntity(EntityTristana.class, "Tristana", 1006, this, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Tristana.name", "en_US", "Tristana");

		EntityRegistry.registerGlobalEntityID(EntityAnnie.class, "Annie", EntityRegistry.findGlobalUniqueEntityId(), 0xD80AC4, 0x7F3EC1);
		EntityRegistry.registerModEntity(EntityAnnie.class, "Annie", 1007, this, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Annie.name", "en_US", "Annie");

		EntityRegistry.registerModEntity(EntityFire.class, "Fire", 1008, this, 80, 1, true);

		EntityRegistry.registerGlobalEntityID(EntityMundo.class, "Mundo", EntityRegistry.findGlobalUniqueEntityId(), 0x581AA8, 0x1E1E1E);
		EntityRegistry.registerModEntity(EntityMundo.class, "Mundo", 1009, this, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Mundo.name", "en_US", "Mundo");

		EntityRegistry.registerModEntity(EntityKnife.class, "Knife", 1010, this, 80, 1, true);

		MinecraftForge.EVENT_BUS.register(new EntityPlayerEvent());
		proxy.registerRenderers();
		proxy.registerSpawns();
		proxy.registerSound();
		LeagueRecipes.addRecipes();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}
