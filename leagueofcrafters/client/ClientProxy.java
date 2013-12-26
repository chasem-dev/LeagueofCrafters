package leagueofcrafters.client;

import leagueofcrafters.CommonProxy;
import leagueofcrafters.client.models.ModelAnnie;
import leagueofcrafters.client.models.ModelBomb;
import leagueofcrafters.client.models.ModelKnife;
import leagueofcrafters.client.models.ModelKogmaw;
import leagueofcrafters.client.models.ModelMinion;
import leagueofcrafters.client.models.ModelMundo;
import leagueofcrafters.client.models.ModelNunu;
import leagueofcrafters.client.models.ModelTeemo;
import leagueofcrafters.client.models.ModelTristana;
import leagueofcrafters.client.models.ModelTristanaBomb;
import leagueofcrafters.client.models.ModelTwitch;
import leagueofcrafters.client.models.ModelZiggs;
import leagueofcrafters.client.renderer.RenderAnnie;
import leagueofcrafters.client.renderer.RenderBomb;
import leagueofcrafters.client.renderer.RenderChampion;
import leagueofcrafters.client.renderer.RenderDart;
import leagueofcrafters.client.renderer.RenderFire;
import leagueofcrafters.client.renderer.RenderFrozenArrow;
import leagueofcrafters.client.renderer.RenderKnife;
import leagueofcrafters.client.renderer.RenderKogmaw;
import leagueofcrafters.client.renderer.RenderLizard;
import leagueofcrafters.client.renderer.RenderMinion;
import leagueofcrafters.client.renderer.RenderMundo;
import leagueofcrafters.client.renderer.RenderPukeball;
import leagueofcrafters.client.renderer.RenderTeemo;
import leagueofcrafters.client.renderer.RenderTristana;
import leagueofcrafters.client.renderer.RenderTristanaBomb;
import leagueofcrafters.client.renderer.RenderTwitch;
import leagueofcrafters.client.renderer.RenderZiggs;
import leagueofcrafters.entity.EntityAnnie;
import leagueofcrafters.entity.EntityKogmaw;
import leagueofcrafters.entity.EntityLizard;
import leagueofcrafters.entity.EntityMinion;
import leagueofcrafters.entity.EntityMundo;
import leagueofcrafters.entity.EntityNuNu;
import leagueofcrafters.entity.EntityTeemo;
import leagueofcrafters.entity.EntityTristana;
import leagueofcrafters.entity.EntityTwitch;
import leagueofcrafters.entity.EntityZiggs;
import leagueofcrafters.entity.projectiles.EntityBomb;
import leagueofcrafters.entity.projectiles.EntityDart;
import leagueofcrafters.entity.projectiles.EntityFire;
import leagueofcrafters.entity.projectiles.EntityFrozenArrow;
import leagueofcrafters.entity.projectiles.EntityKnife;
import leagueofcrafters.entity.projectiles.EntityPukeball;
import leagueofcrafters.entity.projectiles.EntitySnowball;
import leagueofcrafters.entity.projectiles.EntityTristanaBomb;
import leagueofcrafters.handlers.SoundEvent;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.EnumCreatureType;
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
		RenderingRegistry.registerEntityRenderingHandler(EntityLizard.class, new RenderLizard(new ModelZombie(), 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityNuNu.class, new RenderChampion(new ModelNunu(), 1, "nunu"));
		RenderingRegistry.registerEntityRenderingHandler(EntitySnowball.class, new RenderPukeball(Item.snowball));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrozenArrow.class, new RenderFrozenArrow());

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

		EntityRegistry.addSpawn(EntityNuNu.class, 5000, 1, 1, EnumCreatureType.creature, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.frozenOcean,
				BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.iceMountains);

	}
}
