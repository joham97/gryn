package com.hebe.gryn.networking;

import java.util.HashMap;

import com.hebe.gryn.addons.root.Addon;

@SuppressWarnings("rawtypes")
public class NetworkingAddonHelper {

	private HashMap<Class, Addon> classForwarding;
	
	private GameClient gameClient; 
	
	public NetworkingAddonHelper(GameClient gameClient) {
		this.gameClient = gameClient;
		this.classForwarding = new HashMap<Class, Addon>();
	}
	
	public void registerClass(Class classToRegister, Addon addon){
		this.gameClient.getClient().getKryo().register(classToRegister);
		this.classForwarding.put(classToRegister, addon);
	}
	
	public void received(Object object) {
		Addon addon = this.classForwarding.get(object.getClass());
		if(addon != null) {
			addon.received(object);
		}
	}

	public void sendTCP(Object object) {
		this.gameClient.sendTCP(object);
	}

	public void sendUDP(Object object) {
		this.gameClient.sendUDP(object);
	}
	
}

