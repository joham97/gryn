package com.hebe.gryn;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hebe.gryn.addons.root.AddonHelper;
import com.hebe.gryn.screens.GameScreen;

public class Gryn extends Game {

	public static final int GAME_WIDTH = 320;
	public static final int GAME_HEIGHT = 180;
	public static final String TITLE = "GRYN";
	
	private SpriteBatch spriteBatch;
	private ShapeRenderer shapeRenderer;
	
	private AddonHelper addonHelper;
		
	@Override
	public void create() {	
		this.spriteBatch = new SpriteBatch();
		this.shapeRenderer = new ShapeRenderer();

		this.addonHelper = new AddonHelper();
		addonHelper.initialization();
		
		GameScreen gameScreen = new GameScreen(this);
		setScreen(gameScreen);
	}
	
	public SpriteBatch getSpriteBatch() {
		return spriteBatch;
	}
	
	public ShapeRenderer getShapeRenderer() {
		return shapeRenderer;
	}
	
	public AddonHelper getAddonHelper() {
		return addonHelper;
	}
	
}
