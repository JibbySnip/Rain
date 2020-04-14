package com.NerdSpace.Rain.Entity.Mob;

import com.NerdSpace.Rain.Entity.Entity;
import com.NerdSpace.Rain.Graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int dir = 0;
    protected boolean moving = false;

    public void move() {

    }

    public void update() {

    }

    public boolean collision() {
        return false;
    }
}
