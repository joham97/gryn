package com.hebe.gryn.desktop;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.esotericsoftware.minlog.Log;
import com.hebe.gryn.Gryn;
import com.hebe.gryn.server.ServerStart;

public class DesktopLauncher {

	public static int WIDTH = 1920;
	public static int HEIGHT = 1080;
	
	public static void main(String[] arg) {
		try {
			ServerStart.main(null);
		} catch (IOException e) {
			Log.error("server", e.getMessage());
		}
				
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();

	    WIDTH = d.width*3/4;
	    HEIGHT = d.height*3/4;
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = WIDTH;
		config.height = HEIGHT;
		config.x = d.width / 2 - WIDTH / 2;
		config.y = d.height / 2 - HEIGHT / 2;
		config.fullscreen = false;
		config.vSyncEnabled = false; // Setting to false disables vertical sync
		config.foregroundFPS = 0; // Setting to 0 disables foreground fps throttling
		config.backgroundFPS = 0; // Setting to 0 disables background fps throttling
		LwjglApplicationConfiguration.disableAudio = true; // Disable audio
		new LwjglApplication(new Gryn(), config);
	}
}
