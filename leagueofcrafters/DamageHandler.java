package leagueofcrafters;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class DamageHandler {

	public static float currentHealth;
	public static float damageDealt;
	public static String entityName;

	@ForgeSubscribe
	public void DamageCheck(LivingHurtEvent event) {

		if (event.source.getEntity() instanceof EntityPlayer) {
			if (event.entityLiving instanceof EntityLiving) {
				float currentHealth2;
				float damageDealt2;
				String entityName2;
				EntityLiving living = (EntityLiving) event.entityLiving;
				entityName = living.getTranslatedEntityName();
				damageDealt = event.ammount;
				currentHealth = living.getHealth();
				entityName2 = living.getTranslatedEntityName();
				damageDealt2 = living.getMaxHealth() - event.ammount;
				currentHealth2 = living.getHealth() - event.ammount;
				entityName2 = living.getTranslatedEntityName();

			}
		}

		else {
			return;
		}
	}
}