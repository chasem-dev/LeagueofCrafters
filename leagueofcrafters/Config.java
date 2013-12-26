package leagueofcrafters;

import net.minecraftforge.common.Configuration;

public class Config {
	public static Configuration config;

	public static void loadConfig(Configuration configuration) {
		config = configuration;
		LeagueItems.load(config);
		config.save();
		
	}

}
