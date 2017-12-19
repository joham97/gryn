package com.hebe.gryn.logic.entity.tile;

import com.hebe.gryn.logic.entity.Entity;

public class Tile extends Entity{

	public Tile(int x, int y, int textureID) {
		this.x = x * 16;
		this.y = y * 16;
		this.textureID = textureID;
	}
	
	public int getTileX(){
		return (int) this.x / 16;
	}
	
	public int getTileY() {
		return (int) this.y / 16;
	}
	
}
