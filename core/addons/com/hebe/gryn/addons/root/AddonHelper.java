package com.hebe.gryn.addons.root;

import java.util.LinkedList;
import java.util.List;

import com.hebe.gryn.addons.dev.DevAddon;
import com.hebe.gryn.addons.gryn.GrynAddon;
import com.hebe.gryn.logic.World;
import com.hebe.gryn.networking.NetworkingAddonHelper;
import com.hebe.gryn.screens.GameScreen;

public class AddonHelper implements Lifecycle {
	
	public static final Addon[] addonsArray = {
			//new CaveTestAddon(),
			new GrynAddon(),
			new DevAddon()
	};
	
	private List<Addon> addons;
	private int addonID;
	
	private NetworkingAddonHelper networkingAddonHelper;
	
	public AddonHelper() {
		this.addonID = 1;
		this.addons = new LinkedList<Addon>();
		for(Addon addon : addonsArray) {
			this.add(addon);
		}
	}
	
	private void add(Addon addon){
		addon.setAddonID(addonID++);
		this.addons.add(addon);
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

	@Override
	public void registerNetworkingClasses(NetworkingAddonHelper networking) {
		this.networkingAddonHelper = networking;
		for(Addon addon : this.addons) {
			addon.registerNetworkingClasses(networkingAddonHelper);
		}
	}

	@Override
	public void received(Object object) {
		networkingAddonHelper.received(object);
	}
}