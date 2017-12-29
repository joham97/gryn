package com.hebe.gryn.addons.gryn;

import com.hebe.gryn.addons.gryn.world.HeBeTestWorld;
import com.hebe.gryn.addons.root.Addon;
import com.hebe.gryn.logic.World;
import com.hebe.gryn.networking.NetworkingAddonHelper;
import com.hebe.gryn.screens.GameScreen;
import com.hebe.gryn.server.addons.gryn.protocols.PlayerPosition;

public class GrynAddon extends Addon{

	@Override
	public void initialization() {
		
	}

	@Override
	public void afterWorldInitialization(World world) {
		new HeBeTestWorld(world);
	}

	@Override
	public void afterScreenSetup(GameScreen gameScreen) {
		
	}

	@Override
	public void update(float delta) {
		
	}

	@Override
	public void registerNetworkingClasses(NetworkingAddonHelper networking) {
		networking.registerClass(PlayerPosition.class, this);
	}

	@Override
	public void received(Object object) {
		
	}	
}
