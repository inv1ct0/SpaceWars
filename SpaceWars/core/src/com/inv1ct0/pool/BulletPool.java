package com.inv1ct0.pool;

import com.inv1ct0.base.SpritesPool;
import com.inv1ct0.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
