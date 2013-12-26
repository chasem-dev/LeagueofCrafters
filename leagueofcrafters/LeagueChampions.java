package leagueofcrafters;

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
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LeagueChampions {
	public LeagueChampions() {
		EntityRegistry.registerModEntity(EntityDart.class, "Dart", 1000, LeagueofCrafters.instance, 80, 1, true);
		EntityRegistry.registerGlobalEntityID(EntityTeemo.class, "Teemo", EntityRegistry.findGlobalUniqueEntityId(), 0x185100, 0xFFAE7C);
		EntityRegistry.registerModEntity(EntityTeemo.class, "Teemo", 1001, LeagueofCrafters.instance, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Teemo.name", "en_US", "Teemo");

		EntityRegistry.registerGlobalEntityID(EntityZiggs.class, "Ziggs", EntityRegistry.findGlobalUniqueEntityId(), 0x4C2B15, 0x304656);
		EntityRegistry.registerModEntity(EntityZiggs.class, "Ziggs", 1002, LeagueofCrafters.instance, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Ziggs.name", "en_US", "Ziggs");

		EntityRegistry.registerModEntity(EntityBomb.class, "Bomb", 1003, LeagueofCrafters.instance, 80, 1, true);

		EntityRegistry.registerGlobalEntityID(EntityTwitch.class, "Twitch", EntityRegistry.findGlobalUniqueEntityId(), 0x164C00, 0xC4A300);
		EntityRegistry.registerModEntity(EntityTwitch.class, "Twitch", 1004, LeagueofCrafters.instance, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Twitch.name", "en_US", "Twitch");

		EntityRegistry.registerModEntity(EntityTristanaBomb.class, "tristanaBomb", 1005, LeagueofCrafters.instance, 80, 1, true);

		EntityRegistry.registerGlobalEntityID(EntityTristana.class, "Tristana", EntityRegistry.findGlobalUniqueEntityId(), 0x0094FF, 0xFFFFFF);
		EntityRegistry.registerModEntity(EntityTristana.class, "Tristana", 1006, LeagueofCrafters.instance, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Tristana.name", "en_US", "Tristana");

		EntityRegistry.registerGlobalEntityID(EntityAnnie.class, "Annie", EntityRegistry.findGlobalUniqueEntityId(), 0xD80AC4, 0x7F3EC1);
		EntityRegistry.registerModEntity(EntityAnnie.class, "Annie", 1007, LeagueofCrafters.instance, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Annie.name", "en_US", "Annie");

		EntityRegistry.registerModEntity(EntityFire.class, "Fire", 1008, LeagueofCrafters.instance, 80, 1, true);

		EntityRegistry.registerGlobalEntityID(EntityMundo.class, "Mundo", EntityRegistry.findGlobalUniqueEntityId(), 0x581AA8, 0x1E1E1E);
		EntityRegistry.registerModEntity(EntityMundo.class, "Mundo", 1009, LeagueofCrafters.instance, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Mundo.name", "en_US", "Mundo");

		EntityRegistry.registerModEntity(EntityKnife.class, "Knife", 1010, LeagueofCrafters.instance, 80, 1, true);

		EntityRegistry.registerGlobalEntityID(EntityMinion.class, "Minion", EntityRegistry.findGlobalUniqueEntityId(), 0xB2B2E5, 0xF29498);
		EntityRegistry.registerModEntity(EntityMinion.class, "Minion", 1011, LeagueofCrafters.instance, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Minion.name", "en_US", "Minion");

		EntityRegistry.registerGlobalEntityID(EntityKogmaw.class, "Kogmaw", EntityRegistry.findGlobalUniqueEntityId(), 0xB3BBF2, 0x5FF04F);
		EntityRegistry.registerModEntity(EntityKogmaw.class, "Kogmaw", 1012, LeagueofCrafters.instance, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Kogmaw.name", "en_US", "Kogmaw");

		LanguageRegistry.instance().addStringLocalization("tile.nexus.name", "en_US", "Nexus Block");

		EntityRegistry.registerModEntity(EntityPukeball.class, "Pukeball", 1013, LeagueofCrafters.instance, 80, 1, true);

		// EntityRegistry.registerModEntity(EntityTurretBeam.class, "Turret",
		// 1014, LeagueofCrafters.instance, 80, 1, true);

		// EntityRegistry.registerGlobalEntityID(EntityRammus.class, "Rammus",
		// EntityRegistry.findGlobalUniqueEntityId(), 0xB344F2, 0x54404F);
		// EntityRegistry.registerModEntity(EntityRammus.class, "Rammus", 1015,
		// LeagueofCrafters.instance, 80, 1, true);
		// LanguageRegistry.instance().addStringLocalization("entity.Rammus.name",
		// "en_US", "Rammus");

		EntityRegistry.registerGlobalEntityID(EntityLizard.class, "Lizard", EntityRegistry.findGlobalUniqueEntityId(), 0xB344F2, 0x54404F);
		EntityRegistry.registerModEntity(EntityLizard.class, "Lizard", 1015, LeagueofCrafters.instance, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.Lizard.name", "en_US", "Lizard");

		EntityRegistry.registerGlobalEntityID(EntityNuNu.class, "NuNu", EntityRegistry.findGlobalUniqueEntityId(), 0xB3FFF2, 0x2AC04F);
		EntityRegistry.registerModEntity(EntityNuNu.class, "NuNu", 1016, LeagueofCrafters.instance, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.NuNu.name", "en_US", "NuNu");

		EntityRegistry.registerModEntity(EntitySnowball.class, "Snowball", 1017, LeagueofCrafters.instance, 80, 1, true);
		EntityRegistry.registerModEntity(EntityFrozenArrow.class, "FrozenArrow", 1018, LeagueofCrafters.instance, 80, 1, true);

	}

}
