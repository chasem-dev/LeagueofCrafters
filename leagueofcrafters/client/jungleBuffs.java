package leagueofcrafters.client;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;

public class jungleBuffs {
	public static boolean hasLizardBuff;
	public static int lizardTimer;
	public static boolean hasGolemBuff;
	public static int golemTimer;

	public static void addLizardBuff(EntityPlayer player) {
		if (!(lizardTimer > 0)) {
			hasLizardBuff = true;
			lizardTimer = 100;
			System.out.println("has Buff");
			player.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(3.5F);
		} else {
			System.out.println("does not Buff");
			player.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(2);
		}
	}

	public static void addGolemBuff(EntityPlayer player) {

	}

}
