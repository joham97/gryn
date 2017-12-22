package com.hebe.gryn.server.addons.root;

import com.esotericsoftware.kryo.Kryo;

public interface ServerLifecycle {

	public void initialization();
	
	public void registerClasses(Kryo kryo);
	
}
