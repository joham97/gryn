package com.hebe.gryn.addons.gryn.entities.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.hebe.gryn.addons.gryn.entities.OrientationEntity;
import com.hebe.gryn.logic.World;
import com.hebe.gryn.server.addons.gryn.enums.Orientation;
import com.hebe.gryn.server.addons.gryn.protocols.PlayerPosition;

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
		float tempX = this.x;
		float tempY = this.y;
		if(Gdx.input.isKeyPressed(this.KEY_UP)) {
			this.orientation = Orientation.UP;
			tempY += delta * 48;
		}
		if(Gdx.input.isKeyPressed(this.KEY_DOWN)) {
			this.orientation = Orientation.DOWN;
			tempY -= delta * 48;
		}
		if(Gdx.input.isKeyPressed(this.KEY_LEFT)) {
			this.orientation = Orientation.LEFT;
			tempX -= delta * 48;
		}
		if(Gdx.input.isKeyPressed(this.KEY_RIGHT)) {
			this.orientation = Orientation.RIGHT;
			tempX += delta * 48;
		}
		if(this.world.movementValid(this.x, this.y, tempX, tempY)) {
			this.x = tempX;
			this.y = tempY;
		}
		
		
		this.world.setCam(this.x, this.y);
	}
	
	public Object toSendableObject() {
		PlayerPosition playerPosition = new PlayerPosition();
		playerPosition.x = this.x;
		playerPosition.y = this.y;
		playerPosition.orientation = this.orientation;
		return playerPosition;
	}
	
}
