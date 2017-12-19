package com.hebe.gryn.util.texture;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

public class TextureHandler {

	private static HashMap<Integer, Texture> textures = new HashMap<Integer, Texture>();
	private static int idCounter = 0;
	
	public static int put(String path) {
		idCounter++;
		textures.put(idCounter, new Texture(path));
		return idCounter;
	}
	
	public static Texture get(Integer key) {
		return textures.get(key);
	}
	
	public static void dispose() {
		for(Texture texture : textures.values()) {
			texture.dispose();
		}
	}
	
}
