package com.NerdSpace.Rain.Utils;

public class Vector2i {
    private int x, y;

    public Vector2i(Vector2i vector) {
        set(vector.getX(), vector.getY());
    }

    public Vector2i(int x, int y) {
        set(x, y);
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Vector2i add(Vector2i vector) {
        this.x += vector.getX();
        this.y += vector.getY();
        return this;
    }

    public Vector2i subtract(Vector2i vector) {
        this.x -= vector.getX();
        this.y -= vector.getY();
        return this;
    }

    public Vector2i setX(int x) {
        this.x = x;
        return this;
    }

    public Vector2i setY(int y) {
        this.y = y;
        return this;
    }
}
