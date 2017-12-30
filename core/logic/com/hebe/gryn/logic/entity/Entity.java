package com.hebe.gryn.logic.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hebe.gryn.util.texture.TextureHandler;

public class Entity implements Comparable<Entity> {

	protected float x;
	protected float y;
	protected float offsetX;
	protected float offsetY;

	protected int textureID;

	public Entity(float x, float y, int textureID) {
		this.x = x;
		this.y = y;
		this.offsetX = 0.0f;
		this.offsetY = 0.0f;
		this.textureID = textureID;
	}

	public void update(float delta) {

	}

	public void draw(SpriteBatch batch) {
		batch.draw(TextureHandler.get(this.textureID), this.x - this.offsetX, this.y - this.offsetY);
	}

	public void setOffset(float offsetX, float offsetY) {
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}

	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public void setTextureID(int textureID) {
		this.textureID = textureID;
	}
	
	@Override
	public int compareTo(Entity other) {
		return Float.compare(other.y - other.offsetY, this.y - this.offsetY);
	}

}
