package com.hebe.gryn.logic;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hebe.gryn.Gryn;
import com.hebe.gryn.logic.entity.Entity;
import com.hebe.gryn.logic.entity.Layer;

public class World {
	
	private List<Layer> layers;
	
	private float camX, camY;

	public World() {
		this.layers = new ArrayList<Layer>();
		this.camX = 0;
		this.camY = 0;
	}

	public void addToLayer(int layer, Entity entity){
		while(layer >= this.layers.size()) {
			this.layers.add(new Layer(false));
		}
		synchronized (this.layers) {
			this.layers.get(layer).add(entity);
		}		
	}
	
	public void setLayerSorting(int layer, boolean sorting){
		while(layer >= this.layers.size()) {
			this.layers.add(new Layer(false));
		}
		synchronized (this.layers.get(layer)) {
			this.layers.get(layer).setSorting(sorting);
		}
	}
	
	public void update(float delta) {
		synchronized (this.layers) {
			for (Layer layer : this.layers) {
				for (Entity entity : layer) {
					entity.update(delta);
				}
				layer.sort();
			}
		}
	}

	public void render(SpriteBatch batch) {	
		synchronized (this.layers) {
			for (Layer layer : this.layers) {
				for (Entity entity : layer) {
					if(isVisible(entity)) {
						entity.draw(batch);
					}
				}
			}
		}
	}
	
	public boolean isVisible(Entity entity){
		return this.camX - Gryn.GAME_WIDTH < entity.getX() && 
				entity.getX() < this.camX + Gryn.GAME_WIDTH &&
				this.camY - Gryn.GAME_HEIGHT < entity.getY() &&
				entity.getY() < this.camY + Gryn.GAME_HEIGHT;
	}
	
	public void setCam(float x, float y) {
		this.camX = x;
		this.camY = y;
	}

	public float getCamX() {
		return this.camX;
	}
	
	public float getCamY() {
		return this.camY;
	}

	public boolean movementValid(float x, float y, float tempX, float tempY) {
		for (Layer layer : this.layers) {
			for (Entity entity : layer) {
				if(isVisible(entity) && entity.hasCollision() && entity.getX() < tempX && entity.getY() < tempY && tempX < entity.getX() + entity.getWidth() && tempY < entity.getY() + entity.getHeight()) {
					return false;
				}
			}
		}
		return true;
	}
	
}
