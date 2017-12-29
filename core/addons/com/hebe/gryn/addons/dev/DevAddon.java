package com.hebe.gryn.addons.dev;

import com.hebe.gryn.addons.dev.fps.FPSCounter;
import com.hebe.gryn.addons.root.Addon;
import com.hebe.gryn.hud.components.HUDText;
import com.hebe.gryn.logic.World;
import com.hebe.gryn.networking.NetworkingAddonHelper;
import com.hebe.gryn.screens.GameScreen;

public class DevAddon extends Addon {

	private FPSCounter fps;
	private HUDText fpsText;
	
	public DevAddon() {
		this.fps = new FPSCounter(1f);
		this.fpsText = new HUDText(0, 12, "FPS: "); 
	}
	
	@Override
	public void initialization() {

	}

	@Override
	public void afterWorldInitialization(World world) {
		
	}

	@Override
	public void afterScreenSetup(GameScreen gameScreen) {
		gameScreen.getHUD().add(this.fpsText);
	}

	@Override
	public void update(float delta) {
		this.fps.add(delta);
		this.fpsText.setText("FPS: " + this.fps.getFPS());
	}

	@Override
	public void registerNetworkingClasses(NetworkingAddonHelper networking) {
		
	}

	@Override
	public void received(Object object) {
		
	}

}
