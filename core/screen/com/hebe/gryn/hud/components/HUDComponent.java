package com.hebe.gryn.hud.components;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class HUDComponent {

	protected int x;
	protected int y;
	
	public HUDComponent(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void draw(SpriteBatch batch, BitmapFont font);
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}
