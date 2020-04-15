package com.NerdSpace.Rain.Entity.Mob;

import com.NerdSpace.Rain.Entity.Entity;
import com.NerdSpace.Rain.Graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int dir = 0;
    protected boolean moving = false;

    public void move(int vx, int vy) {
        if (vy < 0) dir = 0;
        else if (vx > 0) dir = 1;
        else if (vy > 0) dir = 2;
        else if (vx < 0) dir = 3;

        if (!collision()) {
            x += vx;
            y += vy;
        }

    }

    public void update() {

    }

    public boolean collision() {
        return false;
    }
}
