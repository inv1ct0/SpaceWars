package com.inv1ct0.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.inv1ct0.base.BaseScreen;
import com.inv1ct0.math.Rect;
import com.inv1ct0.sprite.Background;
import com.inv1ct0.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture bg;
    private Logo logo;
    private Background background;


    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        bg = new Texture("textures/bg.png");
        logo = new Logo(new TextureRegion(img));
        logo.setHeightProportion(0.5f);
        background = new Background(new TextureRegion(bg));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();

    }

    private void update(float delta) {
        logo.update(delta);
    }

    private void draw() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
        bg.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        logo.touchDown(touch, pointer);
        return false;
    }
}
