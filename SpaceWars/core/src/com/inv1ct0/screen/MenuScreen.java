package com.inv1ct0.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.inv1ct0.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture backgroundTexture;
    private Sprite backgroundSprite;

    private Vector2 pos;
    private Vector2 v;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        backgroundTexture = new Texture("background.jpg");
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        pos = new Vector2();
        v = new Vector2(2,1);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        backgroundSprite.draw(batch);
        batch.draw(img, pos.x, pos.y);
        batch.end();
//        if (Gdx.graphics.getHeight() > pos.y + img.getHeight()
//        && Gdx.graphics.getWidth() > pos.x + img.getWidth()) {
//            pos.add(v);
//        }
        if(Gdx.input.isTouched()) {
            pos.set(Gdx.input.getX(), Gdx.graphics.getHeight()- Gdx.input.getY());
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            pos.x -= 250 * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            pos.x += 250 * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            pos.y += 250 * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            pos.y -= 250 * Gdx.graphics.getDeltaTime();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        backgroundTexture.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        System.out.println(screenX + "; " + (Gdx.graphics.getHeight() - screenY));
        return false;
    }
}
