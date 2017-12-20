package com.hebe.gryn.addons.gryn;

import com.hebe.gryn.util.texture.TextureHandler;

public enum GrynAddonTextures {

	GRASS("tiles/grasstile.png"), 
	SAND("tiles/sandtile.png"), 
	WATER("tiles/watertile.png"), 
	ASPHALT("tiles/asphalt.png"),
	
	CULM("entities/grass.png", 7, 0.8f);

	private int textureID;

	GrynAddonTextures(String path) {
		this.textureID = TextureHandler.put(path);
	}
	
	GrynAddonTextures(String path, int countImages, float time) {
		this.textureID = TextureHandler.put(path, countImages, time);
	}

	public int getTextureID() {
		return textureID;
	}
}
