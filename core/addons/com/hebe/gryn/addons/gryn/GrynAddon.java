package com.hebe.gryn.addons.gryn;

import com.hebe.gryn.addons.gryn.world.HeBeTestWorld;
import com.hebe.gryn.addons.root.Addon;
import com.hebe.gryn.logic.World;

public class GrynAddon extends Addon{

	@Override
	public void initialization() {
		
	}

	@Override
	public void afterWorldInitialization(World world) {
		new HeBeTestWorld(world);
	}	
}
