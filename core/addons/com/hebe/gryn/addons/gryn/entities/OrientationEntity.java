package com.hebe.gryn.addons.gryn.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hebe.gryn.logic.entity.AnimatedEntity;
import com.hebe.gryn.server.addons.gryn.enums.Orientation;
import com.hebe.gryn.util.texture.AnimatedTexture;
import com.hebe.gryn.util.texture.TextureHandler;

public class OrientationEntity extends AnimatedEntity {
	
	protected Orientation orientation;

	public OrientationEntity(float x, float y, int textureID) {
		super(x, y, textureID);
		orientation = Orientation.DOWN;
		this.height = TextureHandler.get(this.textureID).getHeight() / 4;
	}
	
	 @Override
	public void draw(SpriteBatch batch) {
		AnimatedTexture animText = ((AnimatedTexture)TextureHandler.get(this.textureID));
		int drawY = 0;
		if(orientation == Orientation.LEFT){
			drawY = this.height;
		}else if(orientation == Orientation.RIGHT){
			drawY = this.height*2;
		}else if(orientation == Orientation.UP){
			drawY = this.height*3;
		}
		
		animText.draw(batch, this.x - this.offsetX, this.y - this.offsetY, this.percent, 0, drawY, animText.getSingleWidth(), this.height);
	}
	
	 @Override
	public void setTextureID(int textureID) {
		super.setTextureID(textureID);
		this.height = TextureHandler.get(this.textureID).getHeight() / 4;
	}
	 
}
