package com.hebe.gryn.server.addons.gryn.player;

import com.hebe.gryn.server.addons.gryn.enums.Orientation;
import com.hebe.gryn.server.addons.gryn.protocols.PlayerPosition;
import com.hebe.gryn.server.tech.Sendable;

public class Player implements Sendable{

	private int playerID;
	private float x, y;
	private Orientation orientation;

	public Player(int playerID) {
		this.playerID = playerID;
	}
	
	public float getX() {
		return this.x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return this.y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Orientation getOrientation() {
		return this.orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	public int getPlayerID() {
		return this.playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	@Override
	public void setReceivedObject(Object object) {
		PlayerPosition playerPosition = (PlayerPosition) object;
		this.x = playerPosition.x;
		this.y = playerPosition.y;
		this.orientation = playerPosition.orientation;
	}
	
	@Override
	public Object toSendableObject() {
		PlayerPosition playerPosition = new PlayerPosition();
		playerPosition.x = this.x;
		playerPosition.y = this.y;
		playerPosition.orientation = this.orientation;
		playerPosition.playerID = this.playerID;
		return playerPosition;
	}

}
