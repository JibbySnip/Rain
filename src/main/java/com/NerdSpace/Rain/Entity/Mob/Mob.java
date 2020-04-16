package com.NerdSpace.Rain.Entity.Mob;

import com.NerdSpace.Rain.Entity.Entity;
import com.NerdSpace.Rain.Graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int dir = 0;
    protected boolean moving = false;

    public void move(int xa, int ya) {
        if (xa != 0 && ya != 0) {
            move(xa, 0);
            move(0, ya);
            return;
        }

        if (ya < 0) dir = 0;
        else if (xa > 0) dir = 1;
        else if (ya > 0) dir = 2;
        else if (xa < 0) dir = 3;

        if (!collision(xa, ya)) {
            x += xa;
            y += ya;
        }

    }

    public void update() {

    }

    public boolean collision(int xa, int ya) {
        boolean solid = false;
        for (int c = 0; c < 4; c++) {
            int xt = ((x + xa) + c % 2 *9 - 5) >> 4;
            int yt = ((y+ya) + c / 2 * 5 + 7)  >> 4;

            if (level.getTile(xt, yt).solid()) solid = true;
        }
        return solid;
    }


}
