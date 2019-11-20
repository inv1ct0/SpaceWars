package com.inv1ct0.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.inv1ct0.base.BaseScreen;
import com.inv1ct0.math.Rect;
import com.inv1ct0.sprite.Background;
import com.inv1ct0.sprite.MainShip;
import com.inv1ct0.sprite.Star;

public class GameScreen extends BaseScreen {

    private static final int STAR_COUNT = 128;
    private Texture bg;
    private TextureAtlas atlas;

    private Star[] stars;
    private MainShip mainShip;
//    private Texture ship;
//    private Sprite region;

    private Background background;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < STAR_COUNT; i++) {
            stars[i] = new Star(atlas);
        }

        mainShip = new MainShip(atlas);
        //TODO попытка разрезать корабль на две части
//        ship = new Texture(Gdx.files.internal("textures/mainAtlas.png"));
//        region = new Sprite(ship, 916,95, 195,287);
//        region.setPosition(10,10);
        mainShip.setHeightProportion(0.5f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        mainShip.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        mainShip.keyDown(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        mainShip.touchDown(touch, pointer);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        return super.touchUp(touch, pointer);
    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
        mainShip.update(delta);
    }

    private void draw() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        mainShip.draw(batch);
//        region.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        batch.end();
    }
}
