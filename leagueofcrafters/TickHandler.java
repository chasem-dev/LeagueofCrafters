package leagueofcrafters;

import java.util.EnumSet;
import java.util.Map;

import paulscode.sound.SoundSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.audio.SoundPool;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;

public class TickHandler implements ITickHandler {
	int ticksSinceSentLogin = 0;
	boolean checkedForUsername = false;
	boolean musicCleared = false;
	boolean foundSounds = false;
	boolean createdWatcher = false;
	boolean screenOpen = false;
	boolean initialised = false;

	private void onPlayerTick(EntityPlayer player) {
		if (player.inventory.hasItem(LeagueofCrafters.doransblade.itemID)) {
			((EntityLivingBase) player).getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(22.0D);
		} else {
			((EntityLivingBase) player).getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
		}

	}

	@Override
	public void tickStart(EnumSet<TickType> types, Object... tickData) {

		if (types.equals(EnumSet.of(TickType.PLAYER))) {
			onPlayerTick((EntityPlayer) tickData[0]);
		}

		for (TickType type : types) {
			checkedForUsername = true;
			if (type == TickType.RENDER) {
			}
			if (true && !musicCleared) {
				Map l = ObfuscationReflectionHelper.getPrivateValue(SoundPool.class, Minecraft.getMinecraft().sndManager.soundPoolMusic, 1);
				if (l.size() != 0) {
					l.clear();
					foundSounds = LeagueSounds.installMusic();
					musicCleared = true;
				}
			}
			if (musicCleared && !foundSounds) {
				foundSounds = true;
				Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(
						"Couldn't find music at " + Minecraft.getMinecraft().mcDataDir + "/resources/music/league");
			}
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> types, Object... tickData) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.RENDER, TickType.WORLD, TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		return "League Of Crafters Ticker";
	}

}
