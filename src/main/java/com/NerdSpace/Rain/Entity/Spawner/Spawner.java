package com.NerdSpace.Rain.Entity.Spawner;

import com.NerdSpace.Rain.Entity.Entity;
import com.NerdSpace.Rain.Level.Level;

public class Spawner extends Entity {

    public enum Type {
        MOB, PARTICLE
    }

    public Spawner(int x, int y, Type type, int amount, Level level) {
        init(level);
        this.x = x;
        this.y = y;
    }

}
