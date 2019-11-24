package com.inv1ct0.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.inv1ct0.base.Ship;
import com.inv1ct0.math.Rect;
import com.inv1ct0.pool.BulletPool;

public class Enemy extends Ship {

    private Vector2 startV = new Vector2(0, -0.2f);

    public Enemy(BulletPool bulletPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.v.set(v0);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(getTop() <= worldBounds.getTop()) {
            v.set(v0);
            if (getBottom() < worldBounds.getBottom()) {
                destroy();
            }
        }
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            TextureRegion bulletRegion,
            float bulletHeight,
            float bulletVY,
            int damage,
            float reloadInterval,
            Sound sound,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(0, bulletVY);
        this.damage = damage;
        this.reloadInterval = reloadInterval;
        this.reloadTimer = 2f;
        this.sound = sound;
        setHeightProportion(height);
        this.hp = hp;
        this.v.set(startV);
    }
}
