package com.NerdSpace.Rain.Entity.Projectile;

import com.NerdSpace.Rain.Entity.Spawner.ParticleSpawner;
import com.NerdSpace.Rain.Graphics.Sprite;

public class TrainerProjectile extends Projectile {
    public static final int RATE_OF_FIRE = 12;

    public TrainerProjectile(double launchX, double launchY, double angle) {
        super(launchX, launchY, angle);
        sprite = Sprite.projectileTrainer;
        range = random.nextInt(75) + 100;
        speed = 4;
        damage = 20;

        dx = speed * Math.cos(angle);
        dy = speed * Math.sin(angle);
    }

    protected void collide() {
        level.add(new ParticleSpawner((int) x + sprite.getWidth() / 2, (int) y + sprite.getHeight() / 2, 45, 50, level));
    }


}
