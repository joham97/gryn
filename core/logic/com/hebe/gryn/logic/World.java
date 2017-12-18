package com.hebe.gryn.logic;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hebe.gryn.logic.entity.Entity;
import com.hebe.gryn.logic.entity.tile.Tile;
import com.hebe.gryn.util.texture.TextureHandler;

public class World {
	
	public List<List<Entity>> layers;
	
	public World() {
		this.layers = new ArrayList<List<Entity>>();
		
		TextureHandler.put(0, new Texture("tiles/grasstile.png"));
		
		layers.add(new ArrayList<Entity>());
		layers.get(0).add(new Tile(0, 0, 0));
	}
	
	public void update(float delta) {
		for(List<Entity> entities: layers) {
			for(Entity entity: entities) {
				entity.update(delta);
			}
		}
	}

	public void render(SpriteBatch batch, ShapeRenderer shape) {
		for(List<Entity> entities: layers) {
			for(Entity entity: entities) {
				entity.draw(batch, shape);
			}
		}
	}
	
}
