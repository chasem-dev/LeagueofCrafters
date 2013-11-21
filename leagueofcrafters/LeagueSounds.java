package leagueofcrafters;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.AbstractResourcePack;
import cpw.mods.fml.client.FMLClientHandler;

public class LeagueSounds {

	private static final String[] MusicList = { "SummonersCall" };

	public static boolean installMusic() {
		AbstractResourcePack resourcePack = (AbstractResourcePack) FMLClientHandler.instance().getResourcePackFor("LoC");
		// String min = (Minecraft.getMinecraft().mcDataDir +
		// "/resources/sound/league/").toString();
		for (String songName : MusicList) {
			Minecraft.getMinecraft().sndManager.addMusic("league:league/" + songName + ".ogg");
		}
		return true;
	}
}
