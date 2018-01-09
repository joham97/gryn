package com.hebe.gryn.addons.cavetest;

import com.github.czyzby.noise4j.map.Grid;
import com.github.czyzby.noise4j.map.generator.room.dungeon.DungeonGenerator;
import com.hebe.gryn.addons.root.Addon;
import com.hebe.gryn.logic.World;
import com.hebe.gryn.logic.entity.Entity;
import com.hebe.gryn.networking.NetworkingAddonHelper;
import com.hebe.gryn.screens.GameScreen;
import com.hebe.gryn.util.texture.TextureHandler;

public class CaveTestAddon extends Addon{

	@Override
	public void afterScreenSetup(GameScreen gameScreen) {
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerNetworkingClasses(NetworkingAddonHelper networking) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialization() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterWorldInitialization(World world) {
		final Grid grid = new Grid(128); // This algorithm likes odd-sized maps, although it works either way.

        final DungeonGenerator dungeonGenerator = new DungeonGenerator();
        dungeonGenerator.setRoomGenerationAttempts(500);
        dungeonGenerator.setMaxRoomSize(13);
        dungeonGenerator.setTolerance(10); // Max difference between width and height.
        dungeonGenerator.setMinRoomSize(5);
        dungeonGenerator.generate(grid);
        
        int textureID = TextureHandler.put("dot.png");
        
        for (int x = 0; x < grid.getWidth(); x++) {
            for (int y = 0; y < grid.getHeight(); y++) {
            	if(grid.get(x, y) <= 0.5) {
        			world.addToLayer(0, new Entity(x, y, textureID));
            	}
            }
        }
	}

	@Override
	public void received(Object object) {
		// TODO Auto-generated method stub
		
	}

	
	
}
