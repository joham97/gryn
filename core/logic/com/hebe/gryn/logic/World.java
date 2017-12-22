package com.hebe.gryn.logic;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

	public Layer getLayer(int layer) {
		while(layer >= this.layers.size()) {
			this.layers.add(new Layer(false));
		}
		return this.layers.get(layer);
	}

	public void update(float delta) {
		for (Layer layer : this.layers) {
			for (Entity entity : layer) {
				entity.update(delta);
			}
			layer.sort();
		}
	}

	public void render(SpriteBatch batch) {	
		for (Layer entities : this.layers) {
			for (Entity entity : entities) {				
				entity.draw(batch);
			}
		}
	}
	
	public void setCam(float x, float y) {
		this.camX = x;
		this.camY = y;
	}

	public float getCamX() {
		return camX;
	}
	
	public float getCamY() {
		return camY;
	}
	
}
