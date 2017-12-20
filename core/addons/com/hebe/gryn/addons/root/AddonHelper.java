package com.hebe.gryn.addons.root;

import java.util.LinkedList;
import java.util.List;

import com.hebe.gryn.addons.dev.DevAddon;
import com.hebe.gryn.addons.gryn.GrynAddon;
import com.hebe.gryn.logic.World;
import com.hebe.gryn.screens.GameScreen;

public class AddonHelper implements Lifecycle {
	
	private List<Addon> addons;
	
	public AddonHelper() {
		this.addons = new LinkedList<Addon>();
		this.addons.add(new GrynAddon());
		this.addons.add(new DevAddon());
	}
	
	@Override
	public void initialization() {
		for(Addon addon : this.addons) {
			addon.initialization();
		}
	}

	@Override
	public void afterWorldInitialization(World world) {
		for(Addon addon : this.addons) {
			addon.afterWorldInitialization(world);
		}
	}

	@Override
	public void afterScreenSetup(GameScreen gameScreen) {
		for(Addon addon : this.addons) {
			addon.afterScreenSetup(gameScreen);
		}
	}

	@Override
	public void update(float delta) {
		for(Addon addon : this.addons) {
			addon.update(delta);
		}
	}
}