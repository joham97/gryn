package com.hebe.gryn.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.hebe.gryn.Gryn;

public class GameScreen implements Screen {

	private Gryn game;
	
	public GameScreen(Gryn game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen.
		game.getSpriteBatch().begin();
		
		game.getSpriteBatch().end();
		
		game.getShapeRenderer().begin(ShapeType.Filled);
		game.getShapeRenderer().setColor(Color.RED);
		game.getShapeRenderer().rect(100, 100, 100, 100);		
		game.getShapeRenderer().end();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
