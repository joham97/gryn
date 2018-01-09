
package com.hebe.gryn.screens;

import java.io.IOException;
import java.net.UnknownHostException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hebe.gryn.Gryn;
import com.hebe.gryn.hud.HUD;
import com.hebe.gryn.logic.World;
import com.hebe.gryn.networking.GameClient;

public class GameScreen implements Screen{

	private Gryn game;

	private OrthographicCamera hudCam;
	private Viewport hudViewport;

	private OrthographicCamera cam;
	private Viewport viewport;
	private InputHandler inputHandler;
	
	private World world;
	
	private GameClient gameClient;
	
	private HUD hud;
	
	public GameScreen(Gryn game) {
		this.game = game;

		this.world = new World();
		this.game.getAddonHelper().afterWorldInitialization(this.world);		
		
		this.gameClient = new GameClient(this.game.getAddonHelper());
		try {
			this.gameClient.open(Gryn.IP, Gryn.TCP, Gryn.UDP);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.hud = new HUD();
		
		this.hudCam = new OrthographicCamera();
		this.hudCam.position.set(Gryn.GAME_WIDTH / 2, Gryn.GAME_HEIGHT / 2, 0);
		this.hudViewport = new FitViewport(Gryn.GAME_WIDTH, Gryn.GAME_HEIGHT, this.hudCam);
		this.hudViewport.apply();
		
		this.cam = new OrthographicCamera();
		this.viewport = new FitViewport(Gryn.GAME_WIDTH, Gryn.GAME_HEIGHT, this.cam);
		this.viewport.apply();
		
		this.inputHandler = new InputHandler(this.cam, this.viewport);
	}

	private void update(float delta) {
		this.world.update(delta);
		this.game.getAddonHelper().update(delta);
	}

	@Override
	public void render(float delta) {
		update(delta);

		// Camera Position
		this.viewport.getCamera().position.set(this.world.getCamX(), this.world.getCamY(), 0);
		this.cam.zoom = 1;
		this.viewport.apply();

		// Clean Display
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Attach Viewport to SpriteBatch and Shaperenderer
		this.game.getSpriteBatch().setProjectionMatrix(this.viewport.getCamera().combined);
		this.game.getShapeRenderer().setProjectionMatrix(this.viewport.getCamera().combined);
		
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);


		this.game.getSpriteBatch().begin();	
		
		this.world.render(this.game.getSpriteBatch());
		
		this.game.getSpriteBatch().end();
		
//		this.game.getShapeRenderer().begin(ShapeType.Filled);
//		for(Entity e : this.world.getLayer(2)){
//			this.game.getShapeRenderer().setColor(Color.RED);
//			this.game.getShapeRenderer().rect(e.getX(), e.getY(), 1, 1);
//		}
//		this.game.getShapeRenderer().end();
		

		// Attach Viewport to SpriteBatch and Shaperenderer
		this.game.getSpriteBatch().setProjectionMatrix(this.hudViewport.getCamera().combined);
		this.game.getShapeRenderer().setProjectionMatrix(this.hudViewport.getCamera().combined);

		this.game.getSpriteBatch().begin();	
		
		this.hud.draw(this.game.getSpriteBatch(), this.game.getFont());
		
		this.game.getSpriteBatch().end();
		
		Gdx.gl.glDisable(GL20.GL_BLEND);

	}
	
	public HUD getHUD() {
		return this.hud;
	}

	@Override
	public void resize(int width, int height) {
		this.viewport.update(width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void show() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}

}
