package com.hebe.gryn.server.tech;

import java.io.IOException;
import java.util.HashMap;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.hebe.gryn.server.addons.root.ServerAddonHelper;
import com.hebe.gryn.server.addons.root.protocols.Message;

public class GameServer extends Listener {

	public static boolean STARTED = false;
	public static final int SEED = 88;

	public static String IP = "";

	private Server server;
	private Kryo kryo;

	private HashMap<Integer, String> nicknames;

	private int defaultNicknameCounter = 0;
	
	private ServerAddonHelper serverAddonHelper;

	public GameServer() {
		serverAddonHelper = new ServerAddonHelper();
		serverAddonHelper.initialization();
		this.nicknames = new HashMap<Integer, String>();
		this.server = new Server(50000, 50000);
	}

	public void open() throws IOException {
		this.server.start();
		this.server.bind(25567, 25566);
		this.server.addListener(this);
		this.kryo = this.server.getKryo();

		this.kryo.register(Message.class);
		serverAddonHelper.registerClasses(this.kryo);
		
		this.kryo.register(Message.class);
		STARTED = true;
	}
	
	@Override
	public void connected(Connection connection) {
		super.connected(connection);
	}
	
	@Override
	public void disconnected(Connection connection) {
		super.disconnected(connection);
	}
	
	@Override
	public void received(Connection connection, Object object) {
		super.received(connection, object);
	}

	// Nickname Management
	public boolean addNickname(Integer id, String nick) {
		for (Connection con : this.server.getConnections()) {
			if (nick.equals(this.nicknames.get(con.getID()))) {
				return false;
			}
		}
		this.nicknames.put(id, nick);
		this.defaultNicknameCounter++;
		return true;
	}

	public void removeNickname(int id) {
		this.nicknames.remove(id);
	}

	// Getter
	public String getNickname(Integer id) {
		return this.nicknames.get(id);
	}

	public int getDefaultNicknameCounter() {
		return this.defaultNicknameCounter;
	}

	public Server getServer() {
		return this.server;
	}
	
	
}
