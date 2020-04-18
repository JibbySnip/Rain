package com.NerdSpace.Rain.Entity.Particle;

import com.NerdSpace.Rain.Entity.Entity;
import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Graphics.Sprite;

public class Particle extends Entity {

    private int life;
    private int time;
    private final Sprite sprite;
    protected double xPrecise, yPrecise, zPrecise;
    protected double dx, dy, dz;
    private boolean collided = false;

    public Particle(int x, int y, int life) {
        this.x = x;
        this.y = y;
        xPrecise = x;
        yPrecise = y;
        this.life = life + (random.nextInt(20) - 10);
        this.sprite = Sprite.normalParticle;
        dx = random.nextGaussian();
        dy = random.nextGaussian();
        zPrecise = random.nextFloat() + 3;
    }

    public void update() {
        dz -= 0.1;
        if (life == 0) remove();
        else life--;

        if (zPrecise <= 0) {
            zPrecise = 0;
            dz *= -0.75;
            dx *= 0.5;
            dy *= 0.5;
        }
        move(xPrecise + dx, (yPrecise + dy) + (zPrecise + dz) - 1);
    }

    protected void move(double x, double y) {
        if (collision(x, y)) {
            dx *= -0.5;
            dy *= -0.5;
            dz *= -0.5;
            collided = true;
        }
        xPrecise += dx;
        yPrecise += dy;
        zPrecise += dz;

    }

    protected boolean collision(double x, double y) {
        boolean solid = false;
        for (int c = 0; c < 4; c++) {
            double xt = (x - c % 2.0 * 3) / 16.0;
            double yt = (y - Math.floorDiv(c, 2) * 3) / 16.0;
            int ix = (int) xt;
            int iy = (int) yt;
//            int ix = (int) Math.ceil(xt);
//            int iy = (int) Math.ceil(yt);
//            if (c % 2 == 0) ix = (int) Math.floor(xt);
//            if (c / 2 == 0) iy = (int) Math.floor(yt);
            if (level.getTile(ix, iy).solid()) solid = true;
        }
        return solid;
    }

    public void render(Screen screen) {
        screen.renderSprite((int) xPrecise, (int) (yPrecise - zPrecise), sprite, true, false);
    }

}
