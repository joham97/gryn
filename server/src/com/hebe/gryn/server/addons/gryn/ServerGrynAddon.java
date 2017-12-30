package com.hebe.gryn.server.addons.gryn;

import java.util.HashMap;

import com.esotericsoftware.kryonet.Connection;
import com.hebe.gryn.server.addons.gryn.enums.Orientation;
import com.hebe.gryn.server.addons.gryn.player.Player;
import com.hebe.gryn.server.addons.gryn.protocols.PlayerPosition;
import com.hebe.gryn.server.addons.gryn.protocols.PlayerSkin;
import com.hebe.gryn.server.addons.root.ServerAddon;
import com.hebe.gryn.server.addons.root.ServerNetworkingAddonHelper;

public class ServerGrynAddon extends ServerAddon {

	private HashMap<Integer, Player> players = new HashMap<Integer, Player>();
	
	private ServerNetworkingAddonHelper networkingAddonHelper;
	
	@Override
	public void initialization() {
		
	}

	@Override
	public void registerNetworkingClasses(ServerNetworkingAddonHelper networkingAddonHelper) {
		this.networkingAddonHelper = networkingAddonHelper;
		networkingAddonHelper.registerClass(PlayerPosition.class, this);
		networkingAddonHelper.registerClass(Orientation.class, this);
		networkingAddonHelper.registerClass(PlayerSkin.class, this);
	}

	@Override
	public void received(Connection connection, Object object) {
		//Player Position Update
		if(object instanceof PlayerPosition){
			this.players.get(connection.getID()).setReceivedObject(object);
			this.networkingAddonHelper.sendToAllExceptTCP(connection.getID(), this.players.get(connection.getID()).toSendableObject());
		}else if(object instanceof PlayerSkin) {
			PlayerSkin playerSkin = (PlayerSkin) object;
			playerSkin.playerID = connection.getID();
			this.networkingAddonHelper.sendToAllExceptTCP(connection.getID(), playerSkin);
		}
	}

	@Override
	public void newConnection(Connection connection) {
		this.players.put(connection.getID(), new Player(connection.getID()));
	}
	
}
