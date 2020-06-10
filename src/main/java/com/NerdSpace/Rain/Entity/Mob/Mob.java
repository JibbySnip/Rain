package com.NerdSpace.Rain.Entity.Mob;

import com.NerdSpace.Rain.Entity.Entity;
import com.NerdSpace.Rain.Entity.Projectile.Projectile;
import com.NerdSpace.Rain.Entity.Projectile.TrainerProjectile;
import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Graphics.Sprite;

public abstract class Mob extends Entity {

    protected int dir = 0;
    protected boolean moving = false;
    protected double speed;

    public void move(double xa, double ya) {
        if (xa != 0 && ya != 0) {
            move(xa, 0);
            move(0, ya);
            return;
        }

        if (ya < 0) dir = 0;
        else if (xa > 0) dir = 1;
        else if (ya > 0) dir = 2;
        else if (xa < 0) dir = 3;

//        for (int xt = 0; xt < Math.abs(xa); xt++) {
//            if (!collision(signum(xa),0)) x += signum(xa);
//        }
//
//        for (int yt = 0; yt < Math.abs(ya); yt++) {
//            if (!collision(0, signum(ya))) y += signum(ya);
//        }

        while (xa != 0) {
            if (Math.abs(xa) >= 1) {
                if (!collision(Math.signum(xa), 0)) {
                    this.x += Math.signum(xa);
                }
                xa -= Math.signum(xa);
            } else {
                this.x += xa;
                xa = 0;
            }
        }
        while (ya != 0) {
            if (Math.abs(ya) >= 1) {
                if (!collision(0, Math.signum(ya))) {
                    this.y += Math.signum(ya);
                }
                ya -= Math.signum(ya);
            } else {
                this.y += ya;
                ya = 0;
            }
        }

    }

    private int signum(int x) {
        if (x < 0) return -1;
        else return 1;
    }

    public abstract void update();

    public abstract void render(Screen screen);

    protected void shoot(double x, double y, double dir) {
        Projectile p = new TrainerProjectile(x, y, dir);
        level.add(p);
    }

    public boolean collision(double xa, double ya) {
        boolean solid = false;
        for (int c = 0; c < 4; c++) {
            int xt = ((int) (x + xa) + c % 2 * 9 - 5) >> 4;
            int yt = ((int) (y + ya) + c / 2 * 7 + 5) >> 4;

            if (level.getTile(xt, yt).solid()) solid = true;
        }
        return solid;
    }


    public Sprite getSprite() {
        return sprite;
    }
}
