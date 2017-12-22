package com.hebe.gryn.server;

import java.io.IOException;

import com.hebe.gryn.server.tech.GameServer;

public class ServerStart {

	public static void main(String[] args) {
		GameServer server = new GameServer();
		try {
			server.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
