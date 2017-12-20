package com.hebe.gryn.logic.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hebe.gryn.util.texture.TextureHandler;

public class Entity {

	protected float x;
	protected float y;
	
	protected int textureID;
		
	public Entity(float x, float y, int textureID) {
		this.x = x;
		this.y = y;
		this.textureID = textureID;
	}
	
	public void update(float delta) {
		
	}
	
	public void draw(SpriteBatch batch) {
		batch.draw(TextureHandler.get(this.textureID), x, y);
	}
	
}
