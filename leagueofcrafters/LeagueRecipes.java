package leagueofcrafters;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class LeagueRecipes {

	public static void addRecipes() {
		GameRegistry.addRecipe(new ItemStack(LeagueofCrafters.bomb, 1), new Object[] { " S ", "RGR", " S ", Character.valueOf('G'),
				new ItemStack(Item.gunpowder), Character.valueOf('S'), new ItemStack(Block.sand), Character.valueOf('R'), new ItemStack(Block.gravel) });

		GameRegistry.addRecipe(new ItemStack(LeagueofCrafters.doransblade, 1), new Object[] { "  I", "AI ", "SA ", Character.valueOf('I'),
				new ItemStack(Item.ingotIron), Character.valueOf('A'), new ItemStack(Item.ingotGold), Character.valueOf('S'), new ItemStack(Item.stick) });

		GameRegistry.addRecipe(new ItemStack(LeagueofCrafters.nexus, 1), new Object[] { "SDS", "SRS", "SSS", Character.valueOf('S'),
				new ItemStack(Block.stoneBrick), Character.valueOf('D'), new ItemStack(Block.blockDiamond), Character.valueOf('R'), new ItemStack(Block.blockRedstone) });

	}
}
