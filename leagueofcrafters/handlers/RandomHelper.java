package leagueofcrafters.handlers;

import java.util.Random;

public class RandomHelper {
	static Random rand = new Random();

	/**
	 * Returns a random int between minNum and maxNum inclusive
	 */
	public static int getRandomNumberBetween(int minNum, int maxNum) {
		return rand.nextInt(maxNum - minNum + 1) + minNum;
	}

	public static float getRandomNumberBetween(float minNum, float maxNum) {
		return rand.nextFloat() * (maxNum - minNum) + minNum;
	}
}