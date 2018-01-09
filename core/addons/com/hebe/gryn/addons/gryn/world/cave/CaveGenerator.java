package com.hebe.gryn.addons.gryn.world.cave;

import com.github.czyzby.noise4j.map.Grid;
import com.github.czyzby.noise4j.map.generator.room.dungeon.DungeonGenerator;
import com.github.czyzby.noise4j.map.generator.util.Generators;
import com.hebe.gryn.addons.gryn.GrynAddonTextures;
import com.hebe.gryn.addons.gryn.tiles.ConditionTile;
import com.hebe.gryn.logic.World;
import com.hebe.gryn.logic.entity.AnimatedEntity;

public class CaveGenerator {

	public World world;
	
	public int[][] cave;

	public CaveGenerator(World world) {
		this.world = world;
		
		final Grid grid = new Grid(128); // This algorithm likes odd-sized maps, although it works either way.

		//Generators.SEED = new Random().nextLong();
		Generators.SEED = 48;
		
        final DungeonGenerator dungeonGenerator = new DungeonGenerator();
        dungeonGenerator.setRoomGenerationAttempts(500);
        dungeonGenerator.setMaxRoomSize(13);
        dungeonGenerator.setTolerance(10); // Max difference between width and height.
        dungeonGenerator.setMinRoomSize(5);
        dungeonGenerator.generate(grid);
        
        for (int x = 0; x < grid.getWidth(); x++) {
            for (int y = 0; y < grid.getHeight(); y++) {
        		ConditionTile conditionTile = new ConditionTile(x, y, GrynAddonTextures.CAVE.getTextureID());
        		boolean[] next = new boolean[9];
				for(int i = 0 ; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						int gridX = x - 1 + i;
						int gridY = y - 1 + j;
						if(0 <= gridX && 0 <= gridY && gridX < grid.getWidth() && gridY < grid.getHeight()) {
							next[i * 3 + (2-j)] = grid.get(x - 1 + i, y - 1 + j) <= 0.5;
						}else {
							next[i * 3 + (2-j)] = false;
						}
					}
				}
				conditionTile.calcTileToUse(next);
				if(!conditionTile.isCenter() || conditionTile.isEmpty()) {
					this.world.addToLayer(0, new AnimatedEntity(x * 16, y * 16, GrynAddonTextures.LAVA.getTextureID()));
				}
        		this.world.addToLayer(1, conditionTile);
            }
        }
	}	
}