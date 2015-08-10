package org.unbiquitous.games.movepong;

import org.unbiquitous.uImpala.engine.asset.AssetManager;
import org.unbiquitous.uImpala.engine.core.GameObjectTreeScene;
import org.unbiquitous.uImpala.engine.core.GameSettings;
import org.unbiquitous.uImpala.engine.core.GameSingletons;
import org.unbiquitous.uImpala.engine.io.Screen;
import org.unbiquitous.uImpala.engine.io.ScreenManager;
import org.unbiquitous.uImpala.engine.time.DeltaTime;
import org.unbiquitous.uos.core.adaptabitilyEngine.Gateway;

public class StartScene extends GameObjectTreeScene {
	private Screen screen;

	public StartScene() {
		DeltaTime deltaTime = GameSingletons.get(DeltaTime.class);
		deltaTime.setUPS(30);

		screen = GameSingletons.get(ScreenManager.class).create();
		GameSettings settings = GameSingletons.get(GameSettings.class);

		if (settings.containsKey("movepong.width") && settings.containsKey("movepong.height")) {
			screen.open("Move Pong", settings.getInt("movepong.width"), settings.getInt("movepong.height"), false,
					null);
		} else {
			screen.open();
		}

		GameSingletons.put(Screen.class, screen);
		GameSingletons.put(AssetManager.class, assets());

		Gateway gateway = GameSingletons.get(Gateway.class);
		// gateway.addDriver(new USectDriver(settings, env));
	}

	@Override
	public void update() {
		if (screen.isCloseRequested()) {
			GameSingletons.get(org.unbiquitous.uImpala.engine.core.Game.class).quit();
		}
		super.update();
	}

	@Override
	public void render() {
		super.render();
	}
}
