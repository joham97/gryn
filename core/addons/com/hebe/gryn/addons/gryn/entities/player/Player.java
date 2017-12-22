package com.hebe.gryn.addons.gryn.entities.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.hebe.gryn.addons.gryn.entities.OrientationEntity;
import com.hebe.gryn.addons.gryn.enums.Orientation;
import com.hebe.gryn.logic.World;

public class Player extends OrientationEntity {

	protected int KEY_UP = Keys.W;
	protected int KEY_DOWN = Keys.S;
	protected int KEY_LEFT = Keys.A;
	protected int KEY_RIGHT = Keys.D;
	
	protected World world;
	
	public Player(float x, float y, int textureID, World world) {
		super(x, y, textureID);
		this.world = world;
		this.setOffset(8, 1);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if(Gdx.input.isKeyPressed(KEY_UP)) {
			orientation = Orientation.UP;
			this.y += delta * 48;
		}
		if(Gdx.input.isKeyPressed(KEY_DOWN)) {
			orientation = Orientation.DOWN;
			this.y -= delta * 48;
		}
		if(Gdx.input.isKeyPressed(KEY_LEFT)) {
			orientation = Orientation.LEFT;
			this.x -= delta * 48;
		}
		if(Gdx.input.isKeyPressed(KEY_RIGHT)) {
			orientation = Orientation.RIGHT;
			this.x += delta * 48;
		}
		this.world.setCam(this.x, this.y);
	}
	
}
