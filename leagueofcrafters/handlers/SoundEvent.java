package leagueofcrafters.handlers;

import java.util.Map;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPool;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundEvent {
	@ForgeSubscribe
	public void onSoundLoad(SoundLoadEvent event) {
		event.manager.addMusic("league:league/SummonersCall.ogg");
		event.manager.addMusic("league:league/GetJinxed.ogg");
		event.manager.addMusic("league:league/SurprisePartyFiddlesticks.ogg");
		event.manager.addSound("league:ziggs.ogg");
	}
}
