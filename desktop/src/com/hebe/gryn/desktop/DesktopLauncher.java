package com.hebe.gryn.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hebe.gryn.Gryn;

public class DesktopLauncher {

	public static int WIDTH = 1920;
	public static int HEIGHT = 1080;

	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = WIDTH;
		config.height = HEIGHT;
		config.x = 2736 / 2 - WIDTH / 2;
		config.y = 1824 / 2 - HEIGHT / 2;
		config.fullscreen = false;
		config.vSyncEnabled = false; // Setting to false disables vertical sync
		config.foregroundFPS = 0; // Setting to 0 disables foreground fps throttling
		config.backgroundFPS = 0; // Setting to 0 disables background fps throttling
		LwjglApplicationConfiguration.disableAudio = true; // Disable audio
		new LwjglApplication(new Gryn(), config);
	}
}
