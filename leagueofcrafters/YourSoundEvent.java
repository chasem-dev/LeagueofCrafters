package leagueofcrafters;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class YourSoundEvent {
	@ForgeSubscribe
	public void onSoundLoad(SoundLoadEvent event) {
		event.manager.addSound("league:teemo.ogg");
	}
}
