package com.hebe.gryn.addons.gryn;

import com.hebe.gryn.util.texture.TextureHandler;

public enum GrynAddonTextures {

	GRASS("tiles/grasstile.png"), 
	SAND("tiles/sandtile.png"), 
	WATER("tiles/watertile.png"), 
	ASPHALT("tiles/asphalt.png"),
	CAVE("tiles/cave.png"),
	
	CULM("entities/grass.png", 7, 0.8f),	
	TREE("entities/tree.png"),	
	FLOWER1("entities/flowers/flower1.png"),	
	FLOWER2("entities/flowers/flower2.png"),	
	FLOWER3("entities/flowers/flower3.png"),	
	FLOWER4("entities/flowers/flower4.png"),	
	FLOWER5("entities/flowers/flower5.png"),
	FLOWER6("entities/flowers/flower6.png"),
	
	GRYN("npcs/gryn.png", 4, 0.6f, 1),
	CHILLI("npcs/chilli.png", 4, 0.6f, 2);

	private int textureID;
	private int skinID;

	GrynAddonTextures(String path) {
		this.textureID = TextureHandler.put(path);
	}

	GrynAddonTextures(String path, int countImages, float time) {
		this.textureID = TextureHandler.put(path, countImages, time);
	}

	GrynAddonTextures(String path, int countImages, float time, int skinID) {
		this.textureID = TextureHandler.put(path, countImages, time);
		this.skinID = skinID;
	}
	
	public int getTextureID() {
		return this.textureID;
	}
	
	public int getSkinID() {
		return skinID;
	}
}
