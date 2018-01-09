package com.hebe.gryn.addons.gryn.tiles;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hebe.gryn.logic.entity.tile.Tile;
import com.hebe.gryn.util.texture.TextureHandler;

public class ConditionTile extends Tile {

	private enum Types {any, be, no}

	private static Types[][] conditions = new Types[][] {
		{//1
			Types.any, Types.any, Types.any,
			Types.any, Types.no, Types.no,
			Types.any, Types.no, Types.be
		},{//2
			Types.any, Types.any, Types.any,
			Types.no, Types.no, Types.no,
			Types.any, Types.be, Types.any
		},{//3
			Types.any, Types.any, Types.any,
			Types.no, Types.no, Types.any,
			Types.be, Types.no, Types.any
		},{//4
			Types.any, Types.no, Types.any,
			Types.any, Types.no, Types.be,
			Types.any, Types.no, Types.any
		},{//5
			Types.any, Types.any, Types.any,
			Types.any, Types.be, Types.any,
			Types.any, Types.any, Types.any
		},{//6
			Types.any, Types.no, Types.any,
			Types.be, Types.no, Types.any,
			Types.any, Types.no, Types.any
		},{//7
			Types.any, Types.no, Types.be,
			Types.any, Types.no, Types.no,
			Types.any, Types.any, Types.any
		},{//8
			Types.any, Types.be, Types.any,
			Types.no, Types.no, Types.no,
			Types.any, Types.any, Types.any
		},{//9
			Types.be, Types.no, Types.any,
			Types.no, Types.no, Types.any,
			Types.any, Types.any, Types.any
		},{//10
			Types.any, Types.no, Types.any,
			Types.no, Types.no, Types.be,
			Types.any, Types.be, Types.any
		},{//11
			Types.any, Types.no, Types.any,
			Types.be, Types.no, Types.no,
			Types.any, Types.be, Types.any
		},{//12
			Types.any, Types.be, Types.any,
			Types.no, Types.no, Types.be,
			Types.any, Types.no, Types.any
		},{//13
			Types.any, Types.be, Types.any,
			Types.be, Types.no, Types.no,
			Types.any, Types.no, Types.any
		},{//14
			Types.any, Types.be, Types.any,
			Types.no, Types.no, Types.be,
			Types.any, Types.be, Types.any
		},{//15
			Types.any, Types.be, Types.any,
			Types.be, Types.no, Types.no,
			Types.any, Types.be, Types.any
		},{//16
			Types.any, Types.be, Types.any,
			Types.be, Types.no, Types.be,
			Types.any, Types.no, Types.any
		},{//17
			Types.any, Types.no, Types.any,
			Types.be, Types.no, Types.be,
			Types.any, Types.be, Types.any
		},{//18
			Types.any, Types.be, Types.any,
			Types.be, Types.no, Types.be,
			Types.any, Types.be, Types.any
		}};
	
	private static final int width = 16;
	private static final int height = 16;
	
	private List<Integer> tX;
	private List<Integer> tY;
	
	private boolean center, empty;
	
	public ConditionTile(int x, int y, int textureID) {
		super(x, y, textureID);	
		this.tX = new ArrayList<Integer>();
		this.tY = new ArrayList<Integer>();
	}
	
	public void calcTileToUse(boolean[] next){
		for(int i = 0; i < conditions.length; i++) {
			boolean equals = true;
			for(int j = 0; j < conditions[i].length; j++) {
				if((conditions[i][j] == Types.be && !next[j]) || (conditions[i][j] == Types.no && next[j])) {
					equals = false;
				}
			}
			if(equals) {
				setTileToUse(i);
			}
		}
		
		if(tX.isEmpty()) {
			this.collision = false;
			this.empty = true;
		}
	}
	
	private void setTileToUse(int index) {
		int pos = tX.size();
		if(index % 3 == 2) {
			pos = 0;
		}
		if(index < 9) {
			tX.add(pos, index / 3);
			tY.add(pos, index % 3);
		}else if(index < 13) {
			tX.add((index - 9) / 2);
			tY.add(3 + (index - 9) % 2);
		} else if(index < 17){
			tX.add((index - 13) / 2);
			tY.add(5 + (index - 13) % 2);
		}else {
			tX.add(2);
			tY.add(3);
		}
		if(index != 4) {
			this.collision = true;
		}else {
			this.center = true;
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		for(int i = 0; i < tX.size(); i++) {
			batch.draw(TextureHandler.get(this.textureID), this.x - this.offsetX, this.y - this.offsetY, tX.get(i)*width, tY.get(i)*height, width, height);	
		}
	}

	public boolean isCenter() {
		return center;
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
}
