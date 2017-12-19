package com.hebe.gryn.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hebe.gryn.Gryn;
import com.hebe.gryn.logic.World;

public class GameScreen implements Screen{

	private Gryn game;

	private OrthographicCamera cam;
	private Viewport viewport;
	private InputHandler inputHandler;
	
	private World world;
	
	public GameScreen(Gryn game) {
		this.game = game;

		this.world = new World();
		this.game.getAddonHelper().afterWorldInitialization(world);		
		
		this.cam = new OrthographicCamera();
		this.cam.position.set(Gryn.GAME_WIDTH / 2, Gryn.GAME_HEIGHT / 2, 0);
		this.viewport = new FitViewport(Gryn.GAME_WIDTH, Gryn.GAME_HEIGHT, this.cam);
		this.inputHandler = new InputHandler(this.cam, this.viewport);
	}

	private void update(float delta) {
		this.world.update(delta);
	}

	@Override
	public void render(float delta) {
		update(delta);

		// Camera Position
//		this.viewport.getCamera().position.set(0, 0, 0);
//		this.cam.zoom = 1;
//		this.viewport.apply();

		// Clean Display
		Gdx.gl.glClearColor(1, 0, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Attach Viewport to SpriteBatch and Shaperenderer
		this.game.getSpriteBatch().setProjectionMatrix(this.viewport.getCamera().combined);
		this.game.getShapeRenderer().setProjectionMatrix(this.viewport.getCamera().combined);
		
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

		this.world.render(this.game.getSpriteBatch());

		Gdx.gl.glDisable(GL20.GL_BLEND);

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
