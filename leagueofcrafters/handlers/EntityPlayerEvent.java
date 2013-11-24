package leagueofcrafters.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EntityPlayerEvent {
	@ForgeSubscribe
	public void onLivingUpdateEvent(LivingUpdateEvent event) {
		// This event has an Entity variable, access it like this:
		// event.entity;

		// do something to player every update tick:
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			ItemStack heldItem = player.getHeldItem();
		}
	}
}