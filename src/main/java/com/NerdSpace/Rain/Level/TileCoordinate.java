package com.NerdSpace.Rain.Level;

public class TileCoordinate {
    private int x,y;

    public TileCoordinate(int x, int y) {
        int TILE_SIZE = 16;
        this.x = x * TILE_SIZE;
        this.y = y * TILE_SIZE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[] getXY() {
        int[] arr = new int[2];
        arr[0] = x;
        arr[1] = y;
        return arr;
    }
}
