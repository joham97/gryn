package com.hebe.gryn.server.tech;

public interface Sendable {

	public Object toSendableObject();
	
	public void setReceivedObject(Object object);
	
}
