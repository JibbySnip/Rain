package com.NerdSpace.Rain.Level;

import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Level.Tile.Tile;

public class Level {

    protected int width, height;
    protected int[] tiles;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;

        tiles = new int[width * height];
        generateLevel();
    }

    public Level(String path) {
        loadLevel();
    }

    private void loadLevel() {
    }

    protected void generateLevel() {
    }

    public void update() {

    }

    private void time() {

    }

    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll,yScroll);
        int x0 = xScroll >> 4;
        int x1 = (xScroll + screen.getWidth()) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.getHeight()) >> 4;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x,y).render(x,y,screen);
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (tiles[x+y*width] == 0) return Tile.grass;
        return Tile.voidTile;
    }
}
