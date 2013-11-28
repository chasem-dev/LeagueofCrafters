package leagueofcrafters.handlers;

import leagueofcrafters.entity.ExtendedPlayer;
import leagueofcrafters.inventory.InventoryItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EntityPlayerEvent {
	public final InventoryItem inventory = new InventoryItem();

	@ForgeSubscribe
	public void onLivingUpdateEvent(LivingUpdateEvent event) {

		if (event.entity instanceof EntityPlayer) {

			// Write custom inventory to NBT
			// this.inventory.writeToNBT(properties);

			// Read custom inventory from NBT
			// this.inventory.readFromNBT(properties);
		}
	}

	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null)
			ExtendedPlayer.register((EntityPlayer) event.entity);
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
			event.entity.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer((EntityPlayer) event.entity));
	}
}