package com.NerdSpace.Rain.Entity.Spawner;

import com.NerdSpace.Rain.Entity.Particle.Particle;
import com.NerdSpace.Rain.Level.Level;

public class ParticleSpawner extends Spawner {

    public ParticleSpawner(int x, int y, int life, int amount, Level level) {
        super(x, y, Type.PARTICLE, amount, level);
        for (int i = 0; i < amount; i++) {
            level.add(new Particle(x, y, life));
        }
    }

}
