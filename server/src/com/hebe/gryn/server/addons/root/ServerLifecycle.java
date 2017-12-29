package com.hebe.gryn.server.addons.root;

import com.esotericsoftware.kryonet.Connection;

public interface ServerLifecycle {

	public void initialization();
	
	public void registerNetworkingClasses(ServerNetworkingAddonHelper networkingAddonHelper);
	
	public void received(Connection connection, Object object);
	
	public void newConnection(Connection connection);
	
}
