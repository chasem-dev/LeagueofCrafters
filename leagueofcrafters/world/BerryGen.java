package leagueofcrafters.world;

import java.util.Random;

import leagueofcrafters.LeagueItems;
import leagueofcrafters.handlers.RandomHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class BerryGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		//BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
		int x = chunkX * 16 + random.nextInt(16);
		int z = chunkZ * 16 + random.nextInt(16);
		int yblock = world.getTopSolidOrLiquidBlock(x, z);
		int block = world.getBlockId(x, yblock, z);
		int num = RandomHelper.getRandomNumberBetween(1, 10);
		BiomeGenBase b = world.getBiomeGenForCoords(x, z);
		if (b.getEnableSnow() == true) {
			if (num <= 6) {
				if (block != Block.tilledField.blockID & block != Block.sand.blockID)
					world.setBlock(x, yblock - 1, z, Block.tilledField.blockID);
				world.setBlock(x, yblock, z, LeagueItems.freljordCrop.blockID);
			}
		}
	}
}
