package com.hebe.gryn.logic.entity.tile;

import com.hebe.gryn.logic.entity.Entity;

public class Tile extends Entity{

	public Tile(int x, int y, int textureID) {
		super(x * 16, y * 16, textureID);
		this.width = 16;
		this.height = 16;
	}
	
	public Tile(int x, int y, int textureID, boolean collision) {
		this(x, y, textureID);
		this.collision = collision;
	}
	
	public int getTileX(){
		return (int) this.x / 16;
	}
	
	public int getTileY() {
		return (int) this.y / 16;
	}	
}
