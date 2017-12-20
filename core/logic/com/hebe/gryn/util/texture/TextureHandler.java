package com.hebe.gryn.util.texture;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

public class TextureHandler {
	
	private static HashMap<Integer, Texture> textures = new HashMap<Integer, Texture>();
	private static HashMap<Integer, AnimatedTexture> animatedTextures = new HashMap<Integer, AnimatedTexture>();
	private static int idCounter = 0;

	public static int put(String path) {
		idCounter++;
		textures.put(idCounter, new Texture(path));
		return idCounter;
	}
		
	public static int put(String path, int countImages, float time) {
		idCounter++;
		animatedTextures.put(idCounter, new AnimatedTexture(path, countImages, time));
		return idCounter;
	}

	public static Texture get(Integer key) {
		if(textures.containsKey(key)) {
			return textures.get(key);
		}else {
			return animatedTextures.get(key);
		}
	}

	public static void dispose() {
		for (Texture texture : textures.values()) {
			texture.dispose();
		}
		for (AnimatedTexture texture : animatedTextures.values()) {
			texture.dispose();
		}
	}

}
