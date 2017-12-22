package com.hebe.gryn.server.addons.root;

import com.esotericsoftware.kryo.Kryo;

public abstract class ServerAddon implements ServerLifecycle {

	protected int addonID;

	public void setAddonID(int addonID) {
		this.addonID = addonID;
		System.out.println(this.getClass().getSimpleName() + " (ID: " + addonID + ") added");
	}

	@Override
	public abstract void initialization();

	@Override
	public abstract void registerClasses(Kryo kryo);

}
