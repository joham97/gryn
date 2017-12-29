package com.hebe.gryn.server.tech;

import java.io.IOException;
import java.util.HashMap;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.hebe.gryn.server.addons.root.ServerAddonHelper;
import com.hebe.gryn.server.addons.root.ServerNetworkingAddonHelper;
import com.hebe.gryn.server.addons.root.protocols.Message;

public class GameServer extends Listener {

	public static final int TCP_PORT = 33233;
	public static final int UDP_PORT = 33234;
	
	public static final int writeBufferSize  = 50000;
	public static final int objectBufferSize = 50000;
	
	public static boolean STARTED = false;
	public static final int SEED = 88;

	public static String IP = "";

	private Server server;

	private HashMap<Integer, String> nicknames;

	private ServerAddonHelper serverAddonHelper;
	private ServerNetworkingAddonHelper networkingAddonHelper;

	public GameServer() {
		this.serverAddonHelper = new ServerAddonHelper(this);
		this.serverAddonHelper.initialization();
		this.nicknames = new HashMap<Integer, String>();
		this.server = new Server(writeBufferSize, objectBufferSize);
	}

	public void open() throws IOException {
		this.server.start();
		this.server.bind(TCP_PORT, UDP_PORT);

		this.server.getKryo().register(Message.class);
		
		this.networkingAddonHelper = new ServerNetworkingAddonHelper(this);
		this.serverAddonHelper.registerNetworkingClasses(this.networkingAddonHelper);
		
		this.server.addListener(this);
		
		STARTED = true;
	}
	
	@Override
	public void connected(Connection connection) {
		this.nicknames.put(connection.getID(), connection.getRemoteAddressTCP().toString());
		this.serverAddonHelper.newConnection(connection);
	}
	
	@Override
	public void disconnected(Connection connection) {
		this.nicknames.remove(connection.getID());
	}
	
	@Override
	public void received(Connection connection, Object object) {
		this.serverAddonHelper.received(connection, object);
	}
	
	public Kryo getKryo() {
		return this.server.getKryo();
	}
	
	public void sendToAllExceptTCP(int connectionID, Object object){
		this.server.sendToAllExceptTCP(connectionID, object);
	}
	
	public void sendToAllExceptUDP(int connectionID, Object object){
		this.server.sendToAllExceptUDP(connectionID, object);
	}
	
	public void sendToAllTCP(Object object){
		this.server.sendToAllTCP(object);
	}
	
	public void sendToAllUDP(Object object){
		this.server.sendToAllUDP(object);
	}
	
	public void sendToTCP(int connectionID, Object object){
		this.server.sendToTCP(connectionID, object);
	}
	
	public void sendToUDP(int connectionID, Object object){
		this.server.sendToUDP(connectionID, object);
	}
	
}
