package com.hebe.gryn.addons.gryn.world;

import com.hebe.gryn.addons.gryn.GrynAddonTextures;
import com.hebe.gryn.logic.World;
import com.hebe.gryn.logic.entity.tile.OffsetTile;
import com.hebe.gryn.logic.entity.tile.Tile;

public class HeBeTestWorld {

	public World world;
		
	public HeBeTestWorld(World world) {
		this.world = world;
		
		for(int x = 0; x < 30; x++) {
			for(int y = 0; y < 2; y++) {
				this.world.getLayer(1).add(new OffsetTile(x, y, GrynAddonTextures.ASPHALT.getTextureID(), 6, 6));
			}
		}
		
		for(int x = 0; x < 30; x++) {
			for(int y = 2; y < 7; y++) {
				this.world.getLayer(0).add(new Tile(x, y, GrynAddonTextures.GRASS.getTextureID()));
			}
		}
		
		for(int x = 0; x < 10; x++) {
			for(int y = 7; y < 14; y++) {
				this.world.getLayer(0).add(new Tile(x, y, GrynAddonTextures.GRASS.getTextureID()));
			}
		}
		
		for(int x = 10; x < 22; x++) {
			for(int y = 7; y < 14; y++) {
				this.world.getLayer(1).add(new Tile(x, y, GrynAddonTextures.WATER.getTextureID()));
			}
		}
	}
}
