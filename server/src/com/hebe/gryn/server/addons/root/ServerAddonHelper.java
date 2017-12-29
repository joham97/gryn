package com.hebe.gryn.server.addons.root;

import java.util.LinkedList;
import java.util.List;

import com.esotericsoftware.kryonet.Connection;
import com.hebe.gryn.server.addons.gryn.ServerGrynAddon;
import com.hebe.gryn.server.tech.GameServer;

public class ServerAddonHelper implements ServerLifecycle {
	
	public static final ServerAddon[] addonsArray = {
			new ServerGrynAddon()
	};

	private ServerNetworkingAddonHelper networkingAddonHelper;
	
	private List<ServerAddon> addons;
	private int addonID;
		
	public ServerAddonHelper(GameServer gameServer) {
		this.addonID = 1;
		this.addons = new LinkedList<ServerAddon>();
		for(ServerAddon addon : addonsArray) {
			addon.setGameServer(gameServer);
			this.add(addon);
		}
	}
	
	private void add(ServerAddon addon){
		addon.setAddonID(this.addonID++);
		this.addons.add(addon);
	}
	
	@Override
	public void initialization() {
		for(ServerAddon addon : this.addons) {
			addon.initialization();
		}
	}

	@Override
	public void registerNetworkingClasses(ServerNetworkingAddonHelper networking) {
		this.networkingAddonHelper = networking;
		for(ServerAddon addon : this.addons) {
			addon.registerNetworkingClasses(this.networkingAddonHelper);
		}
	}

	@Override
	public void received(Connection connection, Object object) {
		this.networkingAddonHelper.received(connection, object);
	}

	@Override
	public void newConnection(Connection connection) {
		for(ServerAddon addon : this.addons) {
			addon.newConnection(connection);
		}
	}
}