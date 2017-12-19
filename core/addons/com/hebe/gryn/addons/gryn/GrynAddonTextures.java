package com.hebe.gryn.addons.gryn;

import com.hebe.gryn.util.texture.TextureHandler;

public enum GrynAddonTextures {

	GRASS("tiles/grasstile.png"), 
	SAND("tiles/sandtile.png"), 
	WATER("tiles/watertile.png"), 
	ASPHALT("tiles/asphalt.png");

	private int textureID;

	GrynAddonTextures(String path) {
		this.textureID = TextureHandler.put(path);
	}

	public int getTextureID() {
		return textureID;
	}
}
