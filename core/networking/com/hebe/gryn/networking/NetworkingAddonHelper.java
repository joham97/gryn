package com.hebe.gryn.networking;

import java.util.HashMap;

import com.esotericsoftware.kryo.Kryo;
import com.hebe.gryn.addons.root.Addon;

@SuppressWarnings("rawtypes")
public class NetworkingAddonHelper {

	private HashMap<Class, Addon> classForwarding;
	
	private Kryo kryo; 
	
	public NetworkingAddonHelper(Kryo kryo) {
		this.classForwarding = new HashMap<Class, Addon>();
	}
	
	public void registerClass(Class classToRegister, Addon addon){
		kryo.register(classToRegister);
		this.classForwarding.put(classToRegister, addon);
	}
	
	public void received(Object object) {
		Addon addon = this.classForwarding.get(object);
		if(addon != null) {
			addon.received(object);
		}
	}
	
}
