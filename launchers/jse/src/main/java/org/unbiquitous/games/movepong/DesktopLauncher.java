package org.unbiquitous.games.movepong;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.util.logging.Level;

import org.unbiquitous.uImpala.engine.core.GameSettings;
import org.unbiquitous.uImpala.engine.core.GameSingletons;
import org.unbiquitous.uImpala.engine.io.KeyboardManager;
import org.unbiquitous.uImpala.engine.io.MouseManager;
import org.unbiquitous.uImpala.engine.io.ScreenManager;
import org.unbiquitous.uImpala.jse.impl.core.Game;
import org.unbiquitous.uos.core.UOSLogging;

public class DesktopLauncher {
	public static void main(String[] args) {
		processArgs(args);

		GameSingletons.get(null);
		Game.run(createGameSettings());
	}

	private static void processArgs(String[] args) {
		for (String arg : args) {
			if (arg.equals("--debug"))
				UOSLogging.setLevel(Level.ALL);
		}
	}

	@SuppressWarnings({ "serial", "unchecked" })
	private static GameSettings createGameSettings() {
		GameSettings settings = new GameSettings() {
			{
				put("first_scene", StartScene.class);
				put("game_id", "MovePong");
				put("input_managers", Arrays.asList(MouseManager.class, KeyboardManager.class));
				put("output_managers", Arrays.asList(ScreenManager.class));
				// put("usect.speed.value", 5);
				// put("usect.devicestats", new DeviceStatsJSE());
				// put("usect.player.id",UUID.randomUUID().toString());
			}
		};
		setProperMonitorSize(settings);

		return settings;
	}

	private static void setProperMonitorSize(GameSettings settings) {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		final int width = gd.getDisplayMode().getWidth();
		final int height = gd.getDisplayMode().getHeight() - 60;
		settings.put("movepong.width", width);
		settings.put("movepong.height", height);
	}
}
