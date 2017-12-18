package com.hebe.gryn.logic;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hebe.gryn.logic.entity.Entity;

public class World {
	
	public List<List<Entity>> layers;
	
	public World() {
		this.layers = new ArrayList<List<Entity>>();
		
		
	}
	
	public void update(float delta) {
		for(List<Entity> entities: layers) {
			for(Entity entity: entities) {
				entity.update(delta);
			}
		}
	}

	public void draw(SpriteBatch batch, ShapeRenderer shape) {
		for(List<Entity> entities: layers) {
			for(Entity entity: entities) {
				entity.draw(batch, shape);
			}
		}
	}

}
