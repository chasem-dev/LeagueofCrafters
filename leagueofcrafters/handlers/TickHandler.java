package leagueofcrafters.handlers;

import java.util.EnumSet;
import java.util.Map;

import leagueofcrafters.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPool;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.TickType;

public class TickHandler implements ITickHandler {
	boolean checkedForUsername = false;
	boolean musicCleared = false;
	boolean foundSounds = false;
	boolean screenOpen = false;
	public static Item item;
	public static EntityPlayer player2;

	public int HEALTH = 20;

	private void onPlayerTick(EntityPlayer player) {
		// if(player.inventory)
		if (LeagueKeyBind.keyPressed) {
			player.openGui(LeagueofCrafters.instance, 0, player.worldObj, 0, 0, 0);

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
				Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage("Couldn't find music");
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
