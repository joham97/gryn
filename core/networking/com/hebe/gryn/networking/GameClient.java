package com.hebe.gryn.networking;

import java.io.IOException;
import java.net.UnknownHostException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.hebe.gryn.addons.root.AddonHelper;

public class GameClient extends Listener {

	private Client client = new Client(50000, 50000);
	private Kryo kryo;
	
	private AddonHelper addonHelper;
	
	public GameClient(AddonHelper addonHelper) {
		this.addonHelper = addonHelper;
	}

	public void open(String ip, int tcp, int udp) throws UnknownHostException, IOException {
		client.start();
		client.connect(5000, ip, tcp, udp);
		
		client.addListener(this);
		
		kryo = client.getKryo();

		addonHelper.registerNetworkingClasses(new NetworkingAddonHelper(kryo));		
	}

	@Override
	public void received(Connection connection, Object object) {
		
	}
	
	public Client getClient() {
		return client;
	}
}
