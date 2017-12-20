package com.hebe.gryn.logic.entity.tile;

import com.hebe.gryn.logic.entity.Entity;

public class Tile extends Entity{

	public Tile(int x, int y, int textureID) {
		super(x * 16, y * 16, textureID);
	}
	
	public int getTileX(){
		return (int) this.x / 16;
	}
	
	public int getTileY() {
		return (int) this.y / 16;
	}
	
}
