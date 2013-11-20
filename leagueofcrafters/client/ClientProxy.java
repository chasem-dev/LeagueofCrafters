package leagueofcrafters.client;

import leagueofcrafters.CommonProxy;
import leagueofcrafters.LeagueofCrafters;
import leagueofcrafters.SoundEvent;
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
		RenderingRegistry.registerEntityRenderingHandler(EntityTeemo.class, new RenderTeemo(new ModelTeemo(), 0.5F, 1.25F));
		RenderingRegistry.registerEntityRenderingHandler(EntityZiggs.class, new RenderZiggs(new ModelZiggs(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDart.class, new RenderDart());
		RenderingRegistry.registerEntityRenderingHandler(EntityFire.class, new RenderFire(0.01F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class, new RenderBomb(new ModelBomb(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTristanaBomb.class, new RenderTristanaBomb(new ModelTristanaBomb(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTwitch.class, new RenderTwitch(new ModelTwitch(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTristana.class, new RenderTristana(new ModelTristana(), 0.5F, 1.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAnnie.class, new RenderAnnie(new ModelAnnie(), 0.5F, 1.2F));

	}

	@Override
	public void registerSound() {
		MinecraftForge.EVENT_BUS.register(new SoundEvent());
	}

	@Override
	public void registerSpawns() {
		EntityRegistry.addSpawn(EntityTeemo.class, 10000, 1, 1, EnumCreatureType.creature, BiomeGenBase.jungle, BiomeGenBase.forest, BiomeGenBase.forestHills,
				BiomeGenBase.jungleHills, BiomeGenBase.plains);

		EntityRegistry.addSpawn(EntityZiggs.class, 10000, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge);

		EntityRegistry.addSpawn(EntityTwitch.class, 10000, 1, 1, EnumCreatureType.creature, BiomeGenBase.swampland, BiomeGenBase.plains,
				BiomeGenBase.mushroomIsland);

		EntityRegistry.addSpawn(EntityTristana.class, 10000, 1, 1, EnumCreatureType.creature, BiomeGenBase.forest, BiomeGenBase.plains,
				BiomeGenBase.extremeHills, BiomeGenBase.forestHills);

		EntityRegistry.addSpawn(EntityAnnie.class, 10000, 1, 1, EnumCreatureType.creature, BiomeGenBase.hell, BiomeGenBase.plains, BiomeGenBase.desert,
				BiomeGenBase.forestHills);

	}
}
