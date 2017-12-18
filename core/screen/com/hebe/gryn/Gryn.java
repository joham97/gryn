package com.hebe.gryn;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hebe.gryn.screens.GameScreen;

public class Gryn extends Game {

	public static final int GAME_WIDTH = 320;
	public static final int GAME_HEIGHT = 180;
	public static final String TITLE = "GRYN";
	
	private SpriteBatch spriteBatch;
	private ShapeRenderer shapeRenderer;
		
	@Override
	public void create() {	
		spriteBatch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		
		GameScreen gameScreen = new GameScreen(this);
		setScreen(gameScreen);
	}
	
	public SpriteBatch getSpriteBatch() {
		return spriteBatch;
	}
	
	public ShapeRenderer getShapeRenderer() {
		return shapeRenderer;
	}
	
}
