package com.hebe.gryn.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hebe.gryn.Gryn;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1244;
		config.height = 700;
		config.x = 70;
		config.y = 50;
		new LwjglApplication(new Gryn(), config);
	}
}
