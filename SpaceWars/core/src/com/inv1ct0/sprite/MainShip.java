package com.inv1ct0.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.inv1ct0.base.Sprite;
import com.inv1ct0.math.Rect;

public class MainShip extends Sprite {


    private static final float V_LEN = 0.005f;
    private Vector2 v = new Vector2();
    private Vector2 endPoint = new Vector2();
    private Vector2 buff = new Vector2();

    public MainShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
    }

    @Override
    public void update(float delta) {
        buff.set(endPoint);
        if(buff.sub(pos).len() > V_LEN) {
            pos.add(v);
        } else {
            pos.set(endPoint);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        endPoint.set(touch);
        v.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }

    //TODO попытка сделать управление с клавиатуры

    @Override
    public boolean keyDown(int keycode) {
//        if(keycode == 21) {
//            pos.x -= V_LEN;
//        }
//        if(keycode == 22) {
//            pos.x += V_LEN;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//            pos.x -= 0.5 * Gdx.graphics.getDeltaTime();
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//            pos.x += 0.5 * Gdx.graphics.getDeltaTime();
//        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.18f);
        setLeft(worldBounds.getLeft() + 0.05f);
        setBottom(worldBounds.getBottom() + 0.05f);
    }
}
