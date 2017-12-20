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
import com.hebe.gryn.logic.entity.tile.OffsetTile;
import com.hebe.gryn.logic.entity.tile.Tile;

public class HeBeTestWorld {

	public World world;

	public HeBeTestWorld(World world) {
		this.world = world;

		this.world.getLayer(0);
		this.world.getLayer(1);
		this.world.getLayer(2).setSorting(true);

		Random rand = new Random(45);

		try {
			BufferedReader br = new BufferedReader(
					new FileReader(Gdx.files.internal("../core/assets/world.txt").file()));
			String line = null;
			int y = 0;
			while ((line = br.readLine()) != null) {
				int x = 0;
				for (String tile : line.split(",")) {
					if (tile.equals("1")) {
						this.world.getLayer(0).add(new Tile(x, y, GrynAddonTextures.GRASS.getTextureID()));
						for (int i = 0; i < 3; i++) {
							int nX = x * 16 + rand.nextInt(16);
							int nY = y * 16 + rand.nextInt(16);
							this.world.getLayer(2).add(new BackAndForwardEntity(nX, nY, GrynAddonTextures.CULM.getTextureID()));
						}
					} else if (tile.equals("2")) {
						this.world.getLayer(0).add(new Tile(x, y, GrynAddonTextures.WATER.getTextureID()));
					} else if (tile.equals("3")) {
						this.world.getLayer(1).add(new OffsetTile(x, y, GrynAddonTextures.SAND.getTextureID(), 6, 6));
					} else if (tile.equals("4")) {
						this.world.getLayer(1)
								.add(new OffsetTile(x, y, GrynAddonTextures.ASPHALT.getTextureID(), 6, 6));
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
}