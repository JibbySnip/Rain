package com.NerdSpace.Rain.Entity.Projectile;

import com.NerdSpace.Rain.Entity.Entity;
import com.NerdSpace.Rain.Entity.Particle.Particle;
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
        if (!level.tileCollision(x, y, dx, dy, 10)) {
            x += dx;
            y += dy;
            if (distance() > range) remove();
        } else {
            Particle p = new Particle((int) x, (int) y, 50, 10);
            level.add(p);
            remove();
        }
    }

    public void render(Screen screen) {
        screen.renderProjectile((int) x - 8, (int) y - 4, this);
    }

    private double distance() {
        return Math.hypot(x - launchX, y - launchY);
    }


}
