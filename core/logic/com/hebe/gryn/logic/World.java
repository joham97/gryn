package com.hebe.gryn.logic;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hebe.gryn.logic.entity.Entity;
import com.hebe.gryn.logic.entity.Layer;

public class World {

	private List<Layer> layers;

	public World() {
		this.layers = new ArrayList<Layer>();
	}

	public Layer getLayer(int layer) {
		while(layer >= layers.size()) {
			layers.add(new Layer(false));
		}
		return layers.get(layer);
	}

	public void update(float delta) {
		for (Layer entities : layers) {
			for (Entity entity : entities) {
				entity.update(delta);
			}
		}
	}

	public void render(SpriteBatch batch) {
		batch.begin();		
		for (Layer entities : layers) {
			for (Entity entity : entities) {				
				entity.draw(batch);
			}
		}
		batch.end();
	}

}
