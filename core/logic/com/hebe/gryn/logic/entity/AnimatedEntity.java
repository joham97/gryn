package com.hebe.gryn.logic.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hebe.gryn.util.texture.AnimatedTexture;
import com.hebe.gryn.util.texture.TextureHandler;

public class AnimatedEntity extends Entity{
		
	protected float time, percent;
	protected int countImages;
	
	public AnimatedEntity(float x, float y, int textureID) {
		super(x, y, textureID);
		this.time = ((AnimatedTexture)TextureHandler.get(textureID)).getTime();
		this.countImages = ((AnimatedTexture)TextureHandler.get(textureID)).getCountImages();
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		this.percent += delta;
		while(this.percent > this.time) {
			this.percent -= this.time;
		}
	}
	
	
	@Override
	public void draw(SpriteBatch batch) {
		((AnimatedTexture)TextureHandler.get(this.textureID)).draw(batch, this.x - this.offsetX, this.y - this.offsetY, this.percent);
	}
	
	@Override
	public void setTextureID(int textureID) {
		super.setTextureID(textureID);
		this.time = ((AnimatedTexture)TextureHandler.get(textureID)).getTime();
		this.countImages = ((AnimatedTexture)TextureHandler.get(textureID)).getCountImages();
	}
	
}
