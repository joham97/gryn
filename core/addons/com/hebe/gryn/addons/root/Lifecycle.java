package com.hebe.gryn.addons.root;

import com.hebe.gryn.logic.World;

public interface Lifecycle {

	public void initialization();
	
	public void afterWorldInitialization(World world);
	
}
