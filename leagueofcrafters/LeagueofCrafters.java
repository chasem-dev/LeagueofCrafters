package leagueofcrafters;

import java.io.File;

import leagueofcrafters.blocks.TileEntityNexus;
import leagueofcrafters.client.renderer.TileEntityNexusRender;
import leagueofcrafters.handlers.DamageHandler;
import leagueofcrafters.handlers.GuiHandler;
import leagueofcrafters.handlers.LeagueKeyBind;
import leagueofcrafters.handlers.PacketHandler;
import leagueofcrafters.handlers.TickHandler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "LoC", name = "League Of Crafters", version = "0.2.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { "league" }, packetHandler = PacketHandler.class)
public class LeagueofCrafters {

	public static CreativeTabs tabLeagueofCrafters = new tabLeagueofCrafters(CreativeTabs.getNextID(), "League of Crafters");
	public static EnumToolMaterial League = EnumHelper.addToolMaterial("League Tools", 2, 200, 6.5f, 2f, 14);
	public static EnumArmorMaterial LeagueArmor = EnumHelper.addArmorMaterial("LeagueArmor", 15, new int[] { 2, 6, 5, 2 }, 9);
	private static int modGuiIndex = 0;
	public static final int ItemInventoryGuiIndex = modGuiIndex++;
	private static int modItemIndex = 7000;
	// public static WorldType leagueWorld = new LeagueWorldType(15,
	// "LeagueWorld");

	@Instance(value = "LoC")
	public static LeagueofCrafters instance;

	@SidedProxy(clientSide = "leagueofcrafters.client.ClientProxy", serverSide = "leagueofcrafters.CommonProxy")
	public static CommonProxy proxy;
	public static File modDirectory;
	Configuration config;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new DamageHandler());
		TickRegistry.registerTickHandler(new TickHandler(), Side.SERVER);
		modDirectory = new File(event.getModConfigurationDirectory().getParent());
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		GameRegistry.registerTileEntity(TileEntityNexus.class, "Nexus");

		boolean[] repeat = { (boolean) false };
		// TickRegistry.registerTickHandler(new LeagueKeyBind(LeagueKeyBind.key,
		// repeat), Side.CLIENT);
		KeyBindingRegistry.registerKeyBinding(new LeagueKeyBind(LeagueKeyBind.key, repeat));
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		Config.loadConfig(config);
		LanguageRegistry.instance().addStringLocalization("generator.LeagueWorld", "en_US", "League World");

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		new LeagueChampions();
		MinecraftForge.EVENT_BUS.register(new leagueofcrafters.handlers.EventHandler());
		GameRegistry.registerBlock(LeagueItems.nexus, "Nexus");
		// GameRegistry.registerBlock(LeagueItems.tower, "Tower Block");
		// ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNexus.class,
		// new TileEntityNexusRender());
		proxy.registerRenderers();
		proxy.registerSpawns();
		proxy.registerSound();
		LeagueRecipes.addRecipes();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}
