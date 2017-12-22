package com.hebe.gryn.server.addons.gryn;

import com.esotericsoftware.kryo.Kryo;
import com.hebe.gryn.server.addons.gryn.protocols.PlayerPosition;
import com.hebe.gryn.server.addons.root.ServerAddon;

public class ServerGrynAddon extends ServerAddon {

	@Override
	public void initialization() {
		
	}

	@Override
	public void registerClasses(Kryo kryo) {
		kryo.register(PlayerPosition.class);
	}

}
