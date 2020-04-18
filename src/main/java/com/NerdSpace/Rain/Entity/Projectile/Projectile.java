package com.NerdSpace.Rain.Entity.Projectile;

import com.NerdSpace.Rain.Entity.Entity;
import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Graphics.Sprite;

public abstract class Projectile extends Entity {
    protected final int launchX, launchY;
    protected double angle;
    public Sprite sprite;
    protected double x, y;
    protected double speed, range, damage;
    protected double dx, dy;

    public Projectile(int launchX, int launchY, double angle) {

        this.launchX = launchX;
        this.launchY = launchY;
        this.angle = angle;
        this.x = launchX;
        this.y = launchY;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getSpriteSize() {
        return sprite.SIZE;
    }

    public void update() {
        move();
    }

    private void move() {
        if (!level.tileCollision((int) (x + dx), (int) (y + dy), 9, 3, 3)) {
            x += dx;
            y += dy;
            if (distance() > range) remove();
        } else {
            collide();
            remove();
        }
    }

    public void render(Screen screen) {
        screen.renderProjectile((int) x, (int) y, this);
    }

    private double distance() {
        return Math.hypot(x - launchX, y - launchY);
    }

    protected void collide() {

    }


}
