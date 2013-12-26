package leagueofcrafters.handlers;

import leagueofcrafters.LeagueItems;
import leagueofcrafters.blocks.BlockFreljordCrop;
import leagueofcrafters.entity.EntityLizard;
import leagueofcrafters.entity.ExtendedPlayer;
import leagueofcrafters.inventory.LeagueInventory;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatMessageComponent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class EventHandler {
	public final LeagueInventory inventory = new LeagueInventory();

	@ForgeSubscribe
	public void onLivingUpdateEvent(LivingUpdateEvent event) {

		if (event.entity instanceof EntityPlayer) {

		}
	}

	@ForgeSubscribe
	public void onLivingUpdateEvent(LivingDeathEvent event) {
		if (event.entity instanceof EntityLizard) {
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			if (player != null)
				// System.out.println("[Killed by] " +
				// event.source.getEntity());
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 6000, 0));

		}
	}

	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null)
			ExtendedPlayer.register((EntityPlayer) event.entity);
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
			event.entity.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer((EntityPlayer) event.entity));
	}

	@ForgeSubscribe
	public void bonemealUsed(BonemealEvent event) {
		if (event.world.getBlockId(event.X, event.Y, event.Z) == LeagueItems.freljordCrop.blockID) {
			((BlockFreljordCrop) LeagueItems.freljordCrop).fertilize(event.world, event.X, event.Y, event.Z);
		}
	}

	/**
	 * @ForgeSubscribe public void onDeath(LivingDeathEvent event) { if
	 *                 (event.entity instanceof EntityPlayer &&
	 *                 !event.entity.worldObj.isRemote) { EntityPlayer killed =
	 *                 (EntityPlayer) event.entity; Entity killer =
	 *                 event.source.getEntity();
	 *                 killed.dropItem(Item.appleRed.itemID, 2); killed.isDead =
	 *                 false; killed.heal(10); event.setCanceled(true);
	 * 
	 *                 EntityPlayer killedafter = (EntityPlayer) event.entity;
	 * 
	 *                 } }
	 **/

	@ForgeSubscribe
	public void onPlayerHurt(LivingHurtEvent event) {
		Item item = null;
		if (event.entityLiving instanceof EntityPlayer && event.entityLiving.getHealth() - event.ammount <= 0) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			if (player.inventory.armorInventory[2] != null) {
				item = player.inventory.armorInventory[2].getItem();
				if (item.itemID == LeagueItems.guardianAngel.itemID) {
					event.setCanceled(true);
					player.sendChatToPlayer(new ChatMessageComponent().addText("You were saved by your Guardian Angel"));
					player.setHealth(8);
					player.inventory.armorInventory[2].stackSize--;
				}
			}
		}
	}

	public void PlayerRender(RenderPlayerEvent.SetArmorModel evt) {
		Minecraft mc;
		EntityPlayer player = evt.entityPlayer;
		if (evt.stack != null) {
			// modelbiped = ForgeHooksClient.getArmorModel(par1EntityLiving,
			// itemstack, par2, modelbiped);
			// this.setRenderPassModel(modelbiped);
		}
	}
}