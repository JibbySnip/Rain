package com.NerdSpace.Rain.Graphics;

import java.util.Arrays;

public class Sprite {
    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
    public static Sprite flower = new Sprite(16, 3, 0, SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16, 4, 0, SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(16, 0x37176B);

    // spawn level sprites

    public static Sprite spawnGrass = new Sprite(16, 0, 0, SpriteSheet.spawn);
    public static Sprite spawnWall1 = new Sprite(16, 0, 1, SpriteSheet.spawn);
    public static Sprite spawnWall2 = new Sprite(16, 0, 2, SpriteSheet.spawn);
    public static Sprite spawnHedge = new Sprite(16, 1, 0, SpriteSheet.spawn);
    public static Sprite spawnFloor = new Sprite(16, 1, 1, SpriteSheet.spawn);
    public static Sprite spawnWater = new Sprite(16, 2, 0, SpriteSheet.spawn);

    // projectile sprites

    public static Sprite projectileTrainer = new Sprite(16, 0, 0, SpriteSheet.projectilesTrainer);

    // particle sprites

    public static Sprite normalParticle = new Sprite(3, 0xaaaaaa);
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
    public static Sprite blue = new Sprite(1, 0xff0000ff);
    public static Sprite green = new Sprite(1, 0xff00ff00);

    public final int SIZE;
    public int[] pixels;
    private int x, y;
    private final int width, height;
    protected SpriteSheet sheet;

    protected Sprite(SpriteSheet sheet, int width, int height) {
        SIZE = (width == height) ? width : -1;
        this.width = width;
        this.height = height;
        this.sheet = sheet;
    }

    public Sprite(int[] pixels, int width, int height) {
        SIZE = width == height ? width : -1;
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        width = height = size;
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int color) {
        width = height = size;
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        setColor(color);
    }

    public Sprite(int width, int height, int color) {
        SIZE = -1;
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        setColor(color);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void load() {
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                pixels[x + y * width] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }

    private void setColor(int color) {
        Arrays.fill(pixels, color);
    }
}
