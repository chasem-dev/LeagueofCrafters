package leagueofcrafters;

import java.io.File;

import leagueofcrafters.blocks.*;
import leagueofcrafters.entity.*;
import leagueofcrafters.entity.projectiles.*;
import leagueofcrafters.handlers.*;
import leagueofcrafters.items.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
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
import cpw.mods.fml.common.registry.GameRegistry;
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
	private static int modGuiIndex = 0;
	private static int modItemIndex = 7000;
	public static final int ItemInventoryGuiIndex = modGuiIndex++;
	public static Block nexus;

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
		GameRegistry.registerTileEntity(TileEntityNexus.class, "Nexus");
		KeyBinding[] key = { new KeyBinding("League Items", Keyboard.KEY_F) };
		boolean[] repeat = { false };
		KeyBindingRegistry.registerKeyBinding(new LeagueKeyBind(key, repeat));

		nexus = new BlockNexus(500, Material.rock).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("nexus")
				.setCreativeTab(tabLeagueofCrafters);

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

		EntityRegistry.registerGlobalEntityID(EntityMinion.class, "Minion", EntityRegistry.findGlobalUniqueEntityId(), 0xB2B2E5, 0xF29498);
		EntityRegistry.registerModEntity(EntityMinion.class, "Minion", 1011, this, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Minion.name", "en_US", "Minion");

		EntityRegistry.registerGlobalEntityID(EntityKogmaw.class, "Kogmaw", EntityRegistry.findGlobalUniqueEntityId(), 0xB3BBF2, 0x5FF04F);
		EntityRegistry.registerModEntity(EntityKogmaw.class, "Kogmaw", 1012, this, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Kogmaw.name", "en_US", "Kogmaw");

		LanguageRegistry.instance().addStringLocalization("tile.nexus.name", "en_US", "Nexus Block");
		GameRegistry.registerBlock(nexus, "Nexus");

		EntityRegistry.registerModEntity(EntityPukeball.class, "Pukeball", 1013, this, 80, 1, true);

		
		MinecraftForge.EVENT_BUS.register(new leagueofcrafters.handlers.EventHandler());
		proxy.registerRenderers();
		proxy.registerSpawns();
		proxy.registerSound();
		LeagueRecipes.addRecipes();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}
