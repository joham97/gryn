package com.hebe.gryn.addons.root;

import com.hebe.gryn.logic.World;

public abstract class Addon implements Lifecycle{

	@Override
	public abstract void initialization();

	@Override
	public abstract void afterWorldInitialization(World world);
	
}
