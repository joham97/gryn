package com.hebe.gryn;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hebe.gryn.addons.root.AddonHelper;
import com.hebe.gryn.screens.GameScreen;
import com.hebe.gryn.server.tech.GameServer;

public class Gryn extends Game {

	public static final int GAME_WIDTH = 320;
	public static final int GAME_HEIGHT = 180;
	public static final String TITLE = "GRYN";
	
	public static String IP = "x.x.x.x";
	public static int TCP = GameServer.TCP_PORT;
	public static int UDP = GameServer.UDP_PORT;
	
	
	private SpriteBatch spriteBatch;
	private ShapeRenderer shapeRenderer;
	private BitmapFont font;
	
	private AddonHelper addonHelper;
		
	@Override
	public void create() {	
		try {
			IP = Inet4Address.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		this.spriteBatch = new SpriteBatch();
		this.shapeRenderer = new ShapeRenderer();
		this.font = new BitmapFont();

		this.addonHelper = new AddonHelper();
		this.addonHelper.initialization();
		
		GameScreen gameScreen = new GameScreen(this);
		setScreen(gameScreen);
		
		this.addonHelper.afterScreenSetup(gameScreen);	
	}
	
	public SpriteBatch getSpriteBatch() {
		return this.spriteBatch;
	}
	
	public ShapeRenderer getShapeRenderer() {
		return this.shapeRenderer;
	}
	
	public BitmapFont getFont() {
		return this.font;
	}
	
	public AddonHelper getAddonHelper() {
		return this.addonHelper;
	}
	
}
