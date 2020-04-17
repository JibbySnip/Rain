package com.NerdSpace.Rain.Entity.Projectile;

import com.NerdSpace.Rain.Graphics.Sprite;

public class TrainerProjectile extends Projectile {
    public static final int RATE_OF_FIRE = 12;

    public TrainerProjectile(int launchX, int launchY, double angle) {
        super(launchX, launchY, angle);
        sprite = Sprite.projectileTrainer;
        range = random.nextInt(75) + 100;
        speed = 4;
        damage = 20;

        dx = speed * Math.cos(angle);
        dy = speed * Math.sin(angle);
    }


}
