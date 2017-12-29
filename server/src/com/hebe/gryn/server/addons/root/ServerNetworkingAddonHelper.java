package com.hebe.gryn.server.addons.root;

import java.util.HashMap;

import com.esotericsoftware.kryonet.Connection;
import com.hebe.gryn.server.tech.GameServer;

@SuppressWarnings("rawtypes")
public class ServerNetworkingAddonHelper {

	private HashMap<Class, ServerAddon> classForwarding;
	
	private GameServer gameServer; 
	
	public ServerNetworkingAddonHelper(GameServer gameServer) {
		this.gameServer = gameServer;
		this.classForwarding = new HashMap<Class, ServerAddon>();
	}
	
	public void registerClass(Class classToRegister, ServerAddon addon){
		this.gameServer.getKryo().register(classToRegister);
		this.classForwarding.put(classToRegister, addon);
	}
	
	public void received(Connection connection, Object object) {
		ServerAddon addon = this.classForwarding.get(object.getClass());
		if(addon != null) {
			addon.received(connection, object);
		}
	}
	
	public void sendToAllExceptTCP(int connectionID, Object object){
		this.gameServer.sendToAllExceptTCP(connectionID, object);
	}
	
	public void sendToAllExceptUDP(int connectionID, Object object){
		this.gameServer.sendToAllExceptUDP(connectionID, object);
	}
	
	public void sendToAllTCP(Object object){
		this.gameServer.sendToAllTCP(object);
	}
	
	public void sendToAllUDP(Object object){
		this.gameServer.sendToAllUDP(object);
	}
	
	public void sendToTCP(int connectionID, Object object){
		this.gameServer.sendToTCP(connectionID, object);
	}
	
	public void sendToUDP(int connectionID, Object object){
		this.gameServer.sendToUDP(connectionID, object);
	}
	
}
