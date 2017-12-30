package com.hebe.gryn.addons.gryn.entities.player;

import com.hebe.gryn.addons.gryn.entities.OrientationEntity;
import com.hebe.gryn.server.addons.gryn.protocols.PlayerPosition;

public class OtherPlayer extends OrientationEntity {

	public OtherPlayer(float x, float y, int textureID) {
		super(x, y, textureID);
		this.setOffset(8, 1);
	}
	
	public void setPlayerPosition(PlayerPosition pos){
		this.x = pos.x;
		this.y = pos.y;
		this.orientation = pos.orientation;
	}
	
	
	
}
