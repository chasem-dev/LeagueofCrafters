package leagueofcrafters.client;

import leagueofcrafters.CommonProxy;
import leagueofcrafters.blocks.TileEntityNexus;
import leagueofcrafters.client.models.*;
import leagueofcrafters.client.renderer.*;
import leagueofcrafters.entity.*;
import leagueofcrafters.entity.projectiles.*;
import leagueofcrafters.handlers.SoundEvent;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.item.Item;
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
		RenderingRegistry.registerEntityRenderingHandler(EntityKnife.class, new RenderKnife(new ModelKnife(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class, new RenderBomb(new ModelBomb(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTristanaBomb.class, new RenderTristanaBomb(new ModelTristanaBomb(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTwitch.class, new RenderTwitch(new ModelTwitch(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTristana.class, new RenderTristana(new ModelTristana(), 0.5F, 1.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAnnie.class, new RenderAnnie(new ModelAnnie(), 0.5F, 1.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMundo.class, new RenderMundo(new ModelMundo(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMinion.class, new RenderMinion(new ModelMinion(), (float) 0.5, 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKogmaw.class, new RenderKogmaw(new ModelKogmaw(), (float) 1, 0.65F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPukeball.class, new RenderPukeball(Item.slimeBall));
		RenderingRegistry.registerEntityRenderingHandler(EntityTurretBeam.class, new RenderPukeball(Item.netherStar));

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

		EntityRegistry.addSpawn(EntityMundo.class, 10000, 1, 1, EnumCreatureType.creature, BiomeGenBase.desertHills, BiomeGenBase.extremeHills,
				BiomeGenBase.taigaHills, BiomeGenBase.plains, BiomeGenBase.jungleHills, BiomeGenBase.forestHills);

		EntityRegistry.addSpawn(EntityKogmaw.class, 15000, 1, 1, EnumCreatureType.creature, BiomeGenBase.swampland, BiomeGenBase.plains);

		EntityRegistry.addSpawn(EntityMinion.class, 5000, 1, 1, EnumCreatureType.creature, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.forest,
				BiomeGenBase.jungle, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.beach);

	}
}
