package leagueofcrafters.client;

import leagueofcrafters.CommonProxy;
import leagueofcrafters.LeagueofCrafters;
import leagueofcrafters.YourSoundEvent;
import leagueofcrafters.client.renderer.*;
import leagueofcrafters.entity.*;
import leagueofcrafters.items.ItemBomb;
import leagueofcrafters.client.models.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTeemo.class, new RenderTeemo(new ModelTeemo(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityZiggs.class, new RenderZiggs(new ModelZiggs(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDart.class, new RenderDart());
		RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class, new RenderBomb(new ModelBomb(), 0.5F));

	}

	@Override
	public void registerSound() {
		MinecraftForge.EVENT_BUS.register(new YourSoundEvent());
	}

	@Override
	public void registerSpawns() {
		EntityRegistry.addSpawn(EntityTeemo.class, 10000, 1, 1, EnumCreatureType.creature, BiomeGenBase.jungle, BiomeGenBase.forest, BiomeGenBase.forestHills,
				BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains);

		EntityRegistry.addSpawn(EntityZiggs.class, 10000, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge);

	}
}
