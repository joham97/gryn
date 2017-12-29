package com.hebe.gryn.addons.gryn;

import java.util.HashMap;

import com.hebe.gryn.addons.gryn.entities.player.OtherPlayer;
import com.hebe.gryn.addons.gryn.entities.player.Player;
import com.hebe.gryn.addons.gryn.world.HeBeTestWorld;
import com.hebe.gryn.addons.root.Addon;
import com.hebe.gryn.logic.World;
import com.hebe.gryn.networking.NetworkingAddonHelper;
import com.hebe.gryn.screens.GameScreen;
import com.hebe.gryn.server.addons.gryn.enums.Orientation;
import com.hebe.gryn.server.addons.gryn.protocols.PlayerPosition;

public class GrynAddon extends Addon{

	public static final float SENT_RATE = 0.015f;
	private float current_sent_rate = 0f;
	
	private NetworkingAddonHelper networking;
	private World world;
	
	private Player me;
	
	private HashMap<Integer, OtherPlayer> otherPlayers;
	
	@Override
	public void initialization() {
		this.otherPlayers = new HashMap<Integer, OtherPlayer>();
	}

	@Override
	public void afterWorldInitialization(World world) {
		this.world = world;
		new HeBeTestWorld(world);
		
		this.me = new Player(64, 64, GrynAddonTextures.CHILLI.getTextureID(), world);
		this.world.addToLayer(2, this.me);
	}

	@Override
	public void afterScreenSetup(GameScreen gameScreen) {
		
	}

	@Override
	public void update(float delta) {
		this.current_sent_rate += delta;
		if(this.current_sent_rate > SENT_RATE){
			this.current_sent_rate = 0;
			this.networking.sendTCP(this.me.toSendableObject());
		}
	}

	@Override
	public void registerNetworkingClasses(NetworkingAddonHelper networking) {
		this.networking = networking;
		networking.registerClass(PlayerPosition.class, this);
		networking.registerClass(Orientation.class, this);
	}

	@Override
	public void received(Object object) {
		if(object instanceof PlayerPosition){
			PlayerPosition playerPosition = (PlayerPosition) object;
			OtherPlayer otherPlayer = this.otherPlayers.get(playerPosition.playerID);
			if (otherPlayer != null) {
				otherPlayer.setPlayerPosition(playerPosition);
			}else{
				otherPlayer = new OtherPlayer(playerPosition.x, playerPosition.y, GrynAddonTextures.GRYN.getTextureID());
				this.otherPlayers.put(playerPosition.playerID, otherPlayer);
				this.world.addToLayer(2, otherPlayer);
			}
		}
	}	
}
