package com.hebe.gryn.server.addons.root;

import com.esotericsoftware.minlog.Log;
import com.hebe.gryn.server.tech.GameServer;

public abstract class ServerAddon implements ServerLifecycle {

	protected int addonID;
	
	protected GameServer gameServer;
	
	public void setAddonID(int addonID) {
		this.addonID = addonID;
		Log.info("server", this.getClass().getSimpleName() + " (ID: " + addonID + ") added");
	}
	
	public void setGameServer(GameServer gameServer) {
		this.gameServer = gameServer;
	}

	@Override
	public abstract void initialization();

}
