package com.NerdSpace.Rain.Graphics;

import java.util.Arrays;

public class Sprite {
    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
    public static Sprite flower = new Sprite(16, 3, 0, SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16, 4, 0, SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(16, 0x37176B);

    // spawn level sprites

    public static Sprite spawnGrass = new Sprite(16,0,0, SpriteSheet.spawn);
    public static Sprite spawnWall1 = new Sprite(16,0,1, SpriteSheet.spawn);
    public static Sprite spawnWall2 = new Sprite(16,0,2, SpriteSheet.spawn);
    public static Sprite spawnHedge = new Sprite(16,1,0, SpriteSheet.spawn);
    public static Sprite spawnFloor = new Sprite(16,1,1, SpriteSheet.spawn);
    public static Sprite spawnWater = new Sprite(16,2,0, SpriteSheet.spawn);


    // player sprites

    public static Sprite playerF = new Sprite(32, 0, 4, SpriteSheet.tiles);
    public static Sprite playerF_1 = new Sprite(32, 1, 4, SpriteSheet.tiles);
    public static Sprite playerF_2 = new Sprite(32, 2, 4, SpriteSheet.tiles);
    public static Sprite playerF_3 = new Sprite(32, 3, 4, SpriteSheet.tiles);
    public static Sprite playerB = new Sprite(32, 0, 1, SpriteSheet.tiles);
    public static Sprite playerB_1 = new Sprite(32, 1, 1, SpriteSheet.tiles);
    public static Sprite playerB_2 = new Sprite(32, 2, 1, SpriteSheet.tiles);
    public static Sprite playerB_3 = new Sprite(32, 3, 1, SpriteSheet.tiles);
    public static Sprite playerL = new Sprite(32, 0, 2, SpriteSheet.tiles);
    public static Sprite playerL_1 = new Sprite(32, 1, 2, SpriteSheet.tiles);
    public static Sprite playerL_2 = new Sprite(32, 2, 2, SpriteSheet.tiles);
    public static Sprite playerL_3 = new Sprite(32, 3, 2, SpriteSheet.tiles);
    public static Sprite playerR = new Sprite(32, 0, 3, SpriteSheet.tiles);
    public static Sprite playerR_1 = new Sprite(32, 1, 3, SpriteSheet.tiles);
    public static Sprite playerR_2 = new Sprite(32, 2, 3, SpriteSheet.tiles);
    public static Sprite playerR_3 = new Sprite(32, 3, 3, SpriteSheet.tiles);
    public final int SIZE;
    public int[] pixels;
    private int x, y;
    private SpriteSheet sheet;


    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int color) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        Arrays.fill(pixels, color);

    }

    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }
}
