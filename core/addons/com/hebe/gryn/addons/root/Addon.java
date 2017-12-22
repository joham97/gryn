package com.hebe.gryn.addons.root;

import com.hebe.gryn.logic.World;

public abstract class Addon implements Lifecycle {

	protected int addonID;

	public void setAddonID(int addonID) {
		this.addonID = addonID;
		System.out.println(this.getClass().getSimpleName() + " (ID: " + addonID + ") added");
	}

	@Override
	public abstract void initialization();

	@Override
	public abstract void afterWorldInitialization(World world);

}
