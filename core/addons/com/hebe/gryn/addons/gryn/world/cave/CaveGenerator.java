package com.hebe.gryn.addons.gryn.world.cave;

import com.github.czyzby.noise4j.map.Grid;
import com.github.czyzby.noise4j.map.generator.room.dungeon.DungeonGenerator;
import com.hebe.gryn.addons.gryn.GrynAddonTextures;
import com.hebe.gryn.addons.gryn.tiles.ConditionTile;
import com.hebe.gryn.logic.World;

public class CaveGenerator {

	public World world;
	
	public int[][] cave;

	public CaveGenerator(World world) {
		this.world = world;
		
		final Grid grid = new Grid(128); // This algorithm likes odd-sized maps, although it works either way.

        final DungeonGenerator dungeonGenerator = new DungeonGenerator();
        dungeonGenerator.setRoomGenerationAttempts(500);
        dungeonGenerator.setMaxRoomSize(13);
        dungeonGenerator.setTolerance(10); // Max difference between width and height.
        dungeonGenerator.setMinRoomSize(5);
        dungeonGenerator.generate(grid);

        for(int c = 0; c < 2; c++) {
        	 for (int i = 0; i < grid.getWidth(); i++) {
             	grid.set(i, c, 1.0f);
             	grid.set(i, grid.getWidth() - 1 - c, 1.0f);
             	grid.set(c, i, 1.0f);
             	grid.set(grid.getHeight() - 1 - c, i, 1.0f);
             }
        }       
        
        for (int x = 1; x < grid.getWidth()-1; x++) {
            for (int y = 1; y < grid.getHeight()-1; y++) {
        		ConditionTile conditionTile = new ConditionTile(x, y, GrynAddonTextures.CAVE.getTextureID());
        		boolean[] next = new boolean[9];
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						next[i * 3 + (2-j)] = grid.get(x - 1 + i, y - 1 + j) <= 0.5;
					}
				}
				conditionTile.calcTileToUse(next);
        		this.world.addToLayer(1, conditionTile);
            }
        }		
	}
	
	
}
