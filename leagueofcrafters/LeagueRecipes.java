package leagueofcrafters;

import leagueofcrafters.handlers.RandomHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class LeagueRecipes {

	public static void addRecipes() {

		GameRegistry.addRecipe(new ItemStack(LeagueItems.bomb, 1), new Object[] { " S ", "RGR", " S ", Character.valueOf('G'), new ItemStack(Item.gunpowder),
				Character.valueOf('S'), new ItemStack(Block.sand), Character.valueOf('R'), new ItemStack(Block.gravel) });

		GameRegistry.addRecipe(new ItemStack(LeagueItems.doransblade, 1), new Object[] { "  I", "AI ", "SA ", Character.valueOf('I'),
				new ItemStack(Item.ingotIron), Character.valueOf('A'), new ItemStack(Item.ingotGold), Character.valueOf('S'), new ItemStack(Item.stick) });

		GameRegistry.addRecipe(new ItemStack(LeagueItems.nexus, 1), new Object[] { "SDS", "SRS", "SSS", Character.valueOf('S'),
				new ItemStack(Block.stoneBrick), Character.valueOf('D'), new ItemStack(Block.blockDiamond), Character.valueOf('R'),
				new ItemStack(Block.blockRedstone) });

		GameRegistry.addRecipe(new ItemStack(LeagueItems.warmogs, 1), new Object[] { " G ", "GIG", " G ", Character.valueOf('G'),
				new ItemStack(Item.appleGold), Character.valueOf('I'), new ItemStack(Item.plateIron) });

		GameRegistry.addRecipe(new ItemStack(LeagueItems.guardianAngel, 1), new Object[] { " D ", "FIF", " D ", Character.valueOf('D'),
				new ItemStack(Item.diamond), Character.valueOf('I'), new ItemStack(Item.plateIron), Character.valueOf('F'), new ItemStack(Item.feather) });

		GameRegistry.addShapelessRecipe(new ItemStack(LeagueItems.freljordSeeds, 2), new Object[] { LeagueItems.freljordBerry });

		GameRegistry.addRecipe(new ItemStack(LeagueItems.frozenBow, 1), new Object[] { " D ", "DID", " D ", Character.valueOf('D'),
				new ItemStack(Block.blockSnow), Character.valueOf('I'), new ItemStack(Item.bow) });

		GameRegistry.addRecipe(new ItemStack(LeagueItems.frozenArrow, 1), new Object[] { " D ", "DID", " D ", Character.valueOf('D'),
				new ItemStack(Block.blockSnow), Character.valueOf('I'), new ItemStack(Item.arrow) });

	}
}
