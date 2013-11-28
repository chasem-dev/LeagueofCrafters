package leagueofcrafters.handlers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import leagueofcrafters.LeagueofCrafters;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {
	public static final byte EXTENDED_PROPERTIES = 1, OPEN_SERVER_GUI = 2;

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {

		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		byte packetType;
		try {
			// Read the packet type
			packetType = inputStream.readByte();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		// Now we check which channel, in case you have more than one registered
		if (packet.channel.equals("league")) {
			// Handle each case appropriately:
			switch (packetType) {
			case EXTENDED_PROPERTIES:
				//handleExtendedProperties(packet, player, inputStream);
				break;
			case OPEN_SERVER_GUI:
				handleOpenGuiPacket(packet, (EntityPlayer) player, inputStream);
				break;
			default:
				System.out.println("[PACKET][WARNING] Unknown packet type " + packetType);
			}
		}
	}

	// Notice that handleExtendedProperties now has a DataInputStream type
	// argument, so you can remove
	// the new instance of one in that method
	// As for handleOpenGuiPacket, here's that method:
	/**
	 * This method will open the appropriate server gui element for the player
	 */
	private void handleOpenGuiPacket(Packet250CustomPayload packet, EntityPlayer player, DataInputStream inputStream) {
		int guiID;
		// inputStream is already open, so we don't need to do anything other
		// than continue reading from it:
		try {
			guiID = inputStream.readInt();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		// Now we can open the server gui element, which will automatically open
		// the client element as well
		player.openGui(LeagueofCrafters.instance, guiID, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
	}

	// Here's the method we used in the last step to send the packet:
	/**
	 * Sends a packet to the server telling it to open gui for player
	 */
	public static final void sendOpenGuiPacket(int guiId) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream outputStream = new DataOutputStream(bos);

		try {
			outputStream.writeByte(OPEN_SERVER_GUI);
			outputStream.writeInt(guiId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket("league", bos.toByteArray()));
	}
}