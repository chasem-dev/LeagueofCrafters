package leagueofcrafters;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.AbstractResourcePack;
import cpw.mods.fml.client.FMLClientHandler;

public class LeagueSounds {

	private static final String[] MusicList = { "GetJinxed", "SummonersCall", "SurprisePartyFiddlesticks" };

	public static boolean installMusic() {
		AbstractResourcePack resourcePack = (AbstractResourcePack) FMLClientHandler.instance().getResourcePackFor("LoC");
		for (String songName : MusicList) {
			Minecraft.getMinecraft().sndManager.addMusic("league:league/" + songName + ".ogg");
		}
		return true;
	}
}
