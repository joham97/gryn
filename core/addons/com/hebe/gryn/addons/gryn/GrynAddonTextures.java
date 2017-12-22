package com.hebe.gryn.addons.gryn;

import com.hebe.gryn.util.texture.TextureHandler;

public enum GrynAddonTextures {

	GRASS("tiles/grasstile.png"), 
	SAND("tiles/sandtile.png"), 
	WATER("tiles/watertile.png"), 
	ASPHALT("tiles/asphalt.png"),
	
	CULM("entities/grass.png", 7, 0.8f),	
	TREE("entities/tree.png"),	
	FLOWER1("entities/flowers/flower1.png"),	
	FLOWER2("entities/flowers/flower2.png"),	
	FLOWER3("entities/flowers/flower3.png"),	
	FLOWER4("entities/flowers/flower4.png"),	
	FLOWER5("entities/flowers/flower5.png"),
	FLOWER6("entities/flowers/flower6.png"),
	
	CHILLI("npcs/chilli.png", 4, 0.6f),	
	GRYN("npcs/gryn.png", 4, 0.6f);

	private int textureID;

	GrynAddonTextures(String path) {
		this.textureID = TextureHandler.put(path);
	}
	
	GrynAddonTextures(String path, int countImages, float time) {
		this.textureID = TextureHandler.put(path, countImages, time);
	}

	public int getTextureID() {
		return this.textureID;
	}
}
