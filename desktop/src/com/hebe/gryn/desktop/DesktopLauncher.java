package com.hebe.gryn.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hebe.gryn.Gryn;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 2500;
		config.height = 1440;
		config.x = 2736/2 - 2500/2;
		config.y = 1824/2 - 1440/2;
		new LwjglApplication(new Gryn(), config);
	}
}
