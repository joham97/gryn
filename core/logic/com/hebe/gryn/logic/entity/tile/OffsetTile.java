package com.hebe.gryn.logic.entity.tile;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hebe.gryn.util.texture.TextureHandler;

public class OffsetTile extends Tile {

	private int offsetX;
	private int offsetY;

	public OffsetTile(int x, int y, int textureID, int offsetX, int offsetY) {
		super(x, y, textureID);
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(TextureHandler.get(this.textureID), x - offsetX, y - offsetY);
	}

}
