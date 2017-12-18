package com.hebe.gryn.util.texture;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

public class TextureHandler {

	private static HashMap<Integer, Texture> textures = new HashMap<Integer, Texture>();
	
	public static void put(Integer key, Texture texture) {
		textures.put(key, texture);
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
