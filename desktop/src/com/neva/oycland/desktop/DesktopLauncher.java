package com.neva.oycland.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.neva.oycland.game.OyclandGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = 1280;
        config.height = 800;
        config.title = "Oycland";
        config.samples = 2;

		new LwjglApplication(new OyclandGame(), config);
	}
}
