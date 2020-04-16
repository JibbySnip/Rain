package com.NerdSpace.Rain.Level.Tile;

import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Graphics.Sprite;
import com.NerdSpace.Rain.Level.Tile.SpawnTiles.*;

public class Tile {

    public Sprite sprite;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);
    public static Tile flower = new FlowerTile(Sprite.flower);
    public static Tile rock = new RockTile(Sprite.rock);

    //spawn tiles

    public static Tile spawnGrass = new SpawnGrassTile(Sprite.spawnGrass);
    public static Tile spawnFloor = new SpawnFloorTile(Sprite.spawnFloor);
    public static Tile spawnHedge = new SpawnHedgeTile(Sprite.spawnHedge);
    public static Tile spawnWall1 = new SpawnWallTile(Sprite.spawnWall1);
    public static Tile spawnWall2 = new SpawnWallTile(Sprite.spawnWall2);
    public static Tile spawnWater = new SpawnWaterTile(Sprite.spawnWater);

    public static final int colSpawnGrass = 0xFF00FF00;
    public static final int colSpawnFloor = 0xFF533000;
    public static final int colSpawnWall1 = 0xFF3C3C3C;
    public static final int colSpawnHedge = 0xFF175004;
    public static final int colSpawnWater = 0xFF0020ff;
    public static final int colSpawnWall2 = 0xFFBBC000;


    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }


    public boolean solid() {
        return false;
    }
}
