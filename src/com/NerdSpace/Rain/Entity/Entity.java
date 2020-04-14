package com.NerdSpace.Rain.Entity;

import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Level.Level;

import java.util.Random;

public abstract class Entity {

    public int x, y;
    protected Level level;
    protected final Random random = new Random();
    private boolean removed = false;

    public void update() {
    }

    public void render(Screen screen) {
    }

    public void remove() {
        // Removes an entity from the level
        removed = true;
    }

    public boolean isRemoved() {
        return removed;
    }
}
