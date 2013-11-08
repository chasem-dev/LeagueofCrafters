package leagueofcrafters;

import leagueofcrafters.entity.*;
import leagueofcrafters.items.*;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.client.registry.RenderingRegistry;
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

@Mod(modid = "LoC", name = "League Of Crafters", version = "0.0.1")
@NetworkMod(clientSideRequired = true)
public class LeagueofCrafters {

	public static ItemDart dart;
	public static ItemBomb bomb;
	public static ItemCannon cannon;

	@Instance(value = "LoC")
	public static LeagueofCrafters instance;

	@SidedProxy(clientSide = "leagueofcrafters.client.ClientProxy", serverSide = "leagueofcrafters.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		EntityRegistry.registerModEntity(EntityDart.class, "Dart", 1000, this, 80, 1, true);
		dart = (ItemDart) new ItemDart(5001).setMaxStackSize(64).setUnlocalizedName("Dart").setCreativeTab(CreativeTabs.tabCombat);
		LanguageRegistry.addName(dart, "Dart");

		EntityRegistry.registerModEntity(EntityBomb.class, "Bomb", 1003, this, 80, 1, true);
		bomb = (ItemBomb) new ItemBomb(5000).setMaxStackSize(64).setUnlocalizedName("Bomb").setCreativeTab(CreativeTabs.tabCombat);
		LanguageRegistry.addName(bomb, "Bomb");
		
		cannon = (ItemCannon) new ItemCannon(5002).setMaxStackSize(1).setUnlocalizedName("Cannon").setCreativeTab(CreativeTabs.tabCombat);
		LanguageRegistry.addName(cannon, "Cannon");


		EntityRegistry.registerGlobalEntityID(EntityTeemo.class, "Teemo", EntityRegistry.findGlobalUniqueEntityId(), 0 * 65536 + 255 * 256 + 0, (255 * 65536)
				+ (0 * 256) + 255);
		EntityRegistry.registerModEntity(EntityTeemo.class, "Teemo", 1001, this, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Teemo.name", "en_US", "Teemo");

		EntityRegistry.registerGlobalEntityID(EntityZiggs.class, "Ziggs", EntityRegistry.findGlobalUniqueEntityId(), 100000, 19992);
		EntityRegistry.registerModEntity(EntityZiggs.class, "Ziggs", 1002, this, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Ziggs.name", "en_US", "Ziggs");

		proxy.registerRenderers();
		proxy.registerSpawns();
		proxy.registerSound();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}
