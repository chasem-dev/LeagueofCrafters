package leagueofcrafters;

import leagueofcrafters.entity.EntityAnnie;
import leagueofcrafters.entity.EntityBomb;
import leagueofcrafters.entity.EntityDart;
import leagueofcrafters.entity.EntityFire;
import leagueofcrafters.entity.EntityKnife;
import leagueofcrafters.entity.EntityMundo;
import leagueofcrafters.entity.EntityTeemo;
import leagueofcrafters.entity.EntityTristana;
import leagueofcrafters.entity.EntityTristanaBomb;
import leagueofcrafters.entity.EntityTwitch;
import leagueofcrafters.entity.EntityZiggs;
import leagueofcrafters.items.ItemBlowdart;
import leagueofcrafters.items.ItemBomb;
import leagueofcrafters.items.ItemCannon;
import leagueofcrafters.items.ItemDart;
import leagueofcrafters.items.ItemDoransBlade;
import leagueofcrafters.items.ItemMissle;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "LoC", name = "League Of Crafters", version = "0.0.1")
@NetworkMod(clientSideRequired = true)
public class LeagueofCrafters {

	public static CreativeTabs tabLeagueofCrafters = new tabLeagueofCrafters(CreativeTabs.getNextID(), "League of Crafters");
	public static ItemDoransBlade doransblade;
	public static EnumToolMaterial DORANS = EnumHelper.addToolMaterial("DORANS", 2, 200, 6.5f, 2f, 14);
	public static ItemDart dart;
	public static ItemBomb bomb;
	public static ItemCannon cannon;
	public static ItemBlowdart blowdart;
	public static ItemMissle missle;

	@Instance(value = "LoC")
	public static LeagueofCrafters instance;

	@SidedProxy(clientSide = "leagueofcrafters.client.ClientProxy", serverSide = "leagueofcrafters.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new DamageHandler());
		TickRegistry.registerTickHandler(new TickHandler(), Side.SERVER);

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		dart = (ItemDart) new ItemDart(5001).setMaxStackSize(64).setUnlocalizedName("Dart").setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(dart, "Dart");
		bomb = (ItemBomb) new ItemBomb(5000).setMaxStackSize(64).setUnlocalizedName("Bomb").setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(bomb, "Bomb");

		cannon = (ItemCannon) new ItemCannon(5002).setMaxStackSize(1).setUnlocalizedName("Cannon").setCreativeTab(tabLeagueofCrafters);
		LanguageRegistry.addName(cannon, "Cannon");

		doransblade = (ItemDoransBlade) new ItemDoransBlade(5004, DORANS).setMaxStackSize(1).setUnlocalizedName("Doran's Blade")
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

		proxy.registerRenderers();
		proxy.registerSpawns();
		proxy.registerSound();
		LeagueRecipes.addRecipes();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}
