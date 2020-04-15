package com.NerdSpace.Rain.Graphics;

import java.util.Arrays;

import static com.NerdSpace.Rain.Graphics.SpriteSheet.tiles;

public class Sprite {
    public static Sprite grass = new Sprite(16, 0, 0, tiles);
    public static Sprite flower = new Sprite(16, 3, 0, tiles);
    public static Sprite rock = new Sprite(16, 4, 0, tiles);
    public static Sprite voidSprite = new Sprite(16, 0x37176B);

    public static Sprite playerF = new Sprite(32, 0, 4, tiles);
    public static Sprite playerF_1 = new Sprite(32, 1, 4, tiles);
    public static Sprite playerF_2 = new Sprite(32, 2, 4, tiles);
    public static Sprite playerF_3 = new Sprite(32, 3, 4, tiles);
    public static Sprite playerB = new Sprite(32, 0, 1, tiles);
    public static Sprite playerB_1 = new Sprite(32, 1, 1, tiles);
    public static Sprite playerB_2 = new Sprite(32, 2, 1, tiles);
    public static Sprite playerB_3 = new Sprite(32, 3, 1, tiles);
    public static Sprite playerL = new Sprite(32, 0, 2, tiles);
    public static Sprite playerL_1 = new Sprite(32, 1, 2, tiles);
    public static Sprite playerL_2 = new Sprite(32, 2, 2, tiles);
    public static Sprite playerL_3 = new Sprite(32, 3, 2, tiles);
    public static Sprite playerR = new Sprite(32, 0, 3, tiles);
    public static Sprite playerR_1 = new Sprite(32, 1, 3, tiles);
    public static Sprite playerR_2 = new Sprite(32, 2, 3, tiles);
    public static Sprite playerR_3 = new Sprite(32, 3, 3, tiles);
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
