package com.NerdSpace.Rain.Entity;

import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Graphics.Sprite;
import com.NerdSpace.Rain.Level.Level;

import java.util.Random;

public abstract class Entity {

    public double x, y;
    protected Level level;
    protected Sprite sprite;
    protected final Random random = new Random();
    private boolean removed = false;

    public void update() {
    }

    public void render(Screen screen) {
    }

    public void init(Level level) {
        this.level = level;
    }

    public void remove() {
        // Removes an entity from the level
        removed = true;
    }

    public boolean isRemoved() {
        return removed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
