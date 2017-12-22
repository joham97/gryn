package com.hebe.gryn.server.addons.root;

import java.util.LinkedList;
import java.util.List;

import com.esotericsoftware.kryo.Kryo;

public class ServerAddonHelper implements ServerLifecycle {
	
	public static final ServerAddon[] addonsArray = {

	};
	
	private List<ServerAddon> addons;
	private int addonID;
	
	public ServerAddonHelper() {
		this.addonID = 1;
		this.addons = new LinkedList<ServerAddon>();
		for(ServerAddon addon : addonsArray) {
			this.add(addon);
		}
	}
	
	private void add(ServerAddon addon){
		addon.setAddonID(addonID++);
		this.addons.add(addon);
	}
	
	@Override
	public void initialization() {
		for(ServerAddon addon : this.addons) {
			addon.initialization();
		}
	}

	@Override
	public void registerClasses(Kryo kryo) {
		for(ServerAddon addon : this.addons) {
			addon.registerClasses(kryo);
		}
	}
}