package com.inv1ct0.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.inv1ct0.base.Sprite;

public class Logo extends Sprite {

    private static final float V_LEN = 0.005f;
    private Vector2 v = new Vector2();
    private Vector2 endPoint = new Vector2();
    private Vector2 buff = new Vector2();

    public Logo(TextureRegion region) {
        super(region);
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
}

