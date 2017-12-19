package com.hebe.gryn.addons.root;

import java.util.LinkedList;
import java.util.List;

import com.hebe.gryn.addons.gryn.GrynAddon;
import com.hebe.gryn.logic.World;

public class AddonHelper implements Lifecycle {
	
	private List<Addon> addons;
	
	public AddonHelper() {
		addons = new LinkedList<Addon>();
		addons.add(new GrynAddon());
	}
	
	@Override
	public void initialization() {
		for(Addon addon : addons) {
			addon.initialization();
		}
	}

	@Override
	public void afterWorldInitialization(World world) {
		for(Addon addon : addons) {
			addon.afterWorldInitialization(world);
		}
	}
}