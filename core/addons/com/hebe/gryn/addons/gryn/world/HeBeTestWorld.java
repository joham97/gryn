package com.hebe.gryn.addons.gryn.world;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.hebe.gryn.addons.gryn.GrynAddonTextures;
import com.hebe.gryn.addons.gryn.entities.BackAndForwardEntity;
import com.hebe.gryn.logic.World;
import com.hebe.gryn.logic.entity.Entity;
import com.hebe.gryn.logic.entity.tile.Tile;

public class HeBeTestWorld {

	public World world;

	public HeBeTestWorld(World world) {
		this.world = world;

		this.world.setLayerSorting(2, true);

		Random rand = new Random();

		try {
			BufferedReader br = new BufferedReader(new FileReader(Gdx.files.internal("../core/assets/world.txt").file()));
			String line = null;
			int y = 0;
			while ((line = br.readLine()) != null) {
				int x = 0;
				for (String tile : line.split(",")) {
					if (tile.equals("1")) {
						this.world.addToLayer(0, new Tile(x, y, GrynAddonTextures.GRASS.getTextureID()));
						for (int i = 0; i < 3; i++) {
							int nX = x * 16 + rand.nextInt(16);
							int nY = y * 16 + rand.nextInt(16);
							Entity e = new BackAndForwardEntity(nX, nY, GrynAddonTextures.CULM.getTextureID());
							e.setOffset(2, 0);
							this.world.addToLayer(2, e);
						}
						//Tree
						if (rand.nextInt(10) == 2) {
							int nX = x * 16 + rand.nextInt(16);
							int nY = y * 16 + rand.nextInt(16);
							Entity e = new Entity(nX, nY, GrynAddonTextures.TREE.getTextureID());
							e.setOffset(15, 1);
							this.world.addToLayer(2, e);
						}
						//Flowers
						if (rand.nextInt(30) == 2) {
							int flowerTextureID = randomFlowerID(rand);
							for(int i = 0; i < 3; i++) {
								int nX = x * 16 + rand.nextInt(16);
								int nY = y * 16 + rand.nextInt(16);
								Entity e = new Entity(nX, nY, flowerTextureID);
								e.setOffset(2, 0);
								this.world.addToLayer(2, e);
							}							
						}
					} else if (tile.equals("2")) {
						this.world.addToLayer(0, new Tile(x, y, GrynAddonTextures.WATER.getTextureID(), true));
					} else if (tile.equals("3")) {
						Tile newTile = new Tile(x, y, GrynAddonTextures.SAND.getTextureID());
						newTile.setOffset(6, 6);
						this.world.addToLayer(1, newTile);
					} else if (tile.equals("4")) {
						Tile newTile = new Tile(x, y, GrynAddonTextures.ASPHALT.getTextureID());
						newTile.setOffset(6, 6);
						this.world.addToLayer(1, newTile);
					}
					x++;
				}
				y++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int randomFlowerID(Random rand){
		int f = rand.nextInt(6);
		if (f == 0){
			return GrynAddonTextures.FLOWER1.getTextureID();
		}else if (f == 1){
			return GrynAddonTextures.FLOWER2.getTextureID();
		}else if (f == 2){
			return GrynAddonTextures.FLOWER3.getTextureID();
		}else if (f == 3){
			return GrynAddonTextures.FLOWER4.getTextureID();
		}else if (f == 4){
			return GrynAddonTextures.FLOWER5.getTextureID();
		}else if (f == 5){
			return GrynAddonTextures.FLOWER6.getTextureID();
		}
		return -1;
	}
}
