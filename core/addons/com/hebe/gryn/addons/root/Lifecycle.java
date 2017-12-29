package com.hebe.gryn.addons.root;

import com.hebe.gryn.logic.World;
import com.hebe.gryn.networking.NetworkingAddonHelper;
import com.hebe.gryn.screens.GameScreen;

public interface Lifecycle {

	public void initialization();
	
	public void afterWorldInitialization(World world);
	
	public void afterScreenSetup(GameScreen gameScreen);
	
	public void update(float delta);
	
	public void registerNetworkingClasses(NetworkingAddonHelper networking);

	public void received(Object object);
}
