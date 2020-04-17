package com.NerdSpace.Rain.Entity.Particle;

import com.NerdSpace.Rain.Entity.Entity;
import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Graphics.Sprite;

import java.util.ArrayList;

public class Particle extends Entity {

    private int life;
    private Sprite sprite;
    private ArrayList<Particle> particles = new ArrayList<>();
    private double xPrecise, yPrecise, dx, dy;

    public Particle(int x, int y, int life) {
        this.x = x;
        this.y = y;
        xPrecise = x;
        yPrecise = y;
        this.life = life;
        this.sprite = Sprite.normalParticle;
        dx = random.nextGaussian();
        dy = random.nextGaussian();
    }

    public Particle(int x, int y, int life, int amount) {
        this(x, y, life);
        particles.add(this);
        for (int i = 0; i < amount - 1; i++) {
            particles.add(new Particle(x, y, life));
        }
    }

    public void update() {
        xPrecise += dx;
        yPrecise += dy;
    }

    public void render(Screen screen) {
        screen.renderSprite((int) xPrecise, (int) yPrecise, sprite, true, false);
    }

}
