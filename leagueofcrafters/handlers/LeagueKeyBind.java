package leagueofcrafters.handlers;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class LeagueKeyBind extends KeyHandler {
	private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
	private boolean keyHasBeenPressed;
	public static boolean key1Pressed = false;
	public static boolean key2Pressed = false;
	public static KeyBinding spell1 = new KeyBinding("Spell 1", Keyboard.KEY_C);
	public static KeyBinding spell2 = new KeyBinding("Spell 2", Keyboard.KEY_V);
	public static KeyBinding[] key = { spell1, spell2 };

	public LeagueKeyBind(KeyBinding[] keyBindings, boolean[] repeatings) {
		super(keyBindings, repeatings);
	}

	@Override
	public String getLabel() {
		return "Key";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		if (tickEnd) {
			Minecraft mc = Minecraft.getMinecraft();
			if (mc.currentScreen == null) {
				keyHasBeenPressed = true;
			}
		}
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		if (tickEnd) {
			if (keyHasBeenPressed) {
				keyHasBeenPressed = false;
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return tickTypes;
	}
}