package com.NerdSpace.Rain.Level;

import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Level.Tile.Tile;

public class Level {

    protected int width, height;
    protected int[] tilesInt;

    public static Level spawnLevel = new SpawnLevel("/levels/spawn_level.png");

    public Level(int width, int height) {
        this.width = width;
        this.height = height;

        tilesInt = new int[width * height];
        generateLevel();
    }

    public Level(String path) {
        loadLevel(path);
        generateLevel();

    }

    protected void loadLevel(String path) {

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
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(x, y, screen);

            }
        }
    }

    public Tile getTile(int x, int y) {
//        int grass = 0xff00ff00;
//        int flower = 0xffffff00;
//        int rock = 0xff007f00;

        if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
        if (tilesInt[x + y * width] == Tile.colSpawnGrass) return Tile.spawnGrass;
        if (tilesInt[x + y * width] == Tile.colSpawnFloor) return Tile.spawnFloor;
        if (tilesInt[x + y * width] == Tile.colSpawnHedge) return Tile.spawnHedge;
        if (tilesInt[x + y * width] == Tile.colSpawnWall1) return Tile.spawnWall1;
        if (tilesInt[x + y * width] == Tile.colSpawnWall2) return Tile.spawnWall2;
        if (tilesInt[x + y * width] == Tile.colSpawnWater) return Tile.spawnWater;
        return Tile.voidTile;
    }
}
