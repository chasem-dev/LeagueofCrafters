package leagueofcrafters.entity;

import leagueofcrafters.inventory.InventoryItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties {
	public final static String EXT_PROP_NAME = "LeagueSlot";

	// I always include the entity to which the properties belong for easy
	// access
	// It's final because we won't be changing which player it is
	private final EntityPlayer player;

	public static InventoryItem inventory = new InventoryItem();

	/*
	 * Also, it's best to initialize any other variables you may have added,
	 * just like in any constructor.
	 */
	public ExtendedPlayer(EntityPlayer player) {
		this.player = player;
	}

	/**
	 * Used to register these extended properties for the player during
	 * EntityConstructing event This method is for convenience only; it will
	 * make your code look nicer
	 */
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
	}

	/**
	 * Returns ExtendedPlayer properties for player This method is for
	 * convenience only; it will make your code look nicer
	 */
	public static final ExtendedPlayer get(EntityPlayer player) {
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}

	// Save any custom data that needs saving here
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		this.inventory.writeToNBT(properties);
		compound.setTag(EXT_PROP_NAME, properties);

	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.inventory.readFromNBT(properties);
	}

	@Override
	public void init(Entity entity, World world) {
	}

}