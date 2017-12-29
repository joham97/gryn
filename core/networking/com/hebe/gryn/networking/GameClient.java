package com.hebe.gryn.networking;

import java.io.IOException;
import java.net.UnknownHostException;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.hebe.gryn.addons.root.AddonHelper;
import com.hebe.gryn.server.addons.root.protocols.Message;
import com.hebe.gryn.server.tech.GameServer;

public class GameClient extends Listener {

	private Client client = new Client(GameServer.writeBufferSize, GameServer.objectBufferSize);

	private AddonHelper addonHelper;
	private NetworkingAddonHelper networking;
	
	public GameClient(AddonHelper addonHelper) {
		this.addonHelper = addonHelper;
	}

	public void open(String ip, int tcp, int udp) throws UnknownHostException, IOException {
		this.client.start();
		this.client.connect(5000, ip, tcp, udp);
		
		this.client.getKryo().register(Message.class);
		
		this.networking = new NetworkingAddonHelper(this);
		this.addonHelper.registerNetworkingClasses(this.networking);
		
		this.client.addListener(this);
	}
		

	public void sendTCP(Object object) {
		this.client.sendTCP(object);
	}
	
	public void sendUDP(Object object) {
		this.client.sendUDP(object);
	}
	
	@Override
	public void received(Connection connection, Object object) {
		this.addonHelper.received(object);
	}
	
	public Client getClient() {
		return this.client;
	}
}












