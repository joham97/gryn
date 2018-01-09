package com.hebe.gryn.util.texture;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AnimatedTexture extends Texture {

	protected int countImages, width, height;
	protected float time;

	public AnimatedTexture(String internalPath, int countImages, float time) {
		super(internalPath);
		this.countImages = countImages;
		this.time = time;
		this.width = this.getWidth() / countImages;
		this.height = this.getHeight();
	}
	
	public float getTime() {
		return time;
	}

	public void draw(SpriteBatch batch, float x, float y, float percent) {
		batch.draw(this, x, y, width, height, ((int) ((percent / time) * countImages)) * width, 0, width, height, false, false);
	}

	public void draw(SpriteBatch batch, float x, float y, float percent, int srcX, int srcY, int width, int height) {
		batch.draw(this, x, y, width, height, srcX + ((int) ((percent / time) * countImages)) * width, srcY, width, height, false, false);
	}
	
	public int getSingleWidth() {
		return width;
	}

	public int getCountImages() {
		return countImages;
	}	
}
