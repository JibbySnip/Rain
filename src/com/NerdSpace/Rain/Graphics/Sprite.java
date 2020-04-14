package com.NerdSpace.Rain.Graphics;

import java.util.Arrays;

import static com.NerdSpace.Rain.Graphics.SpriteSheet.tiles;

public class Sprite {
    public final int SIZE;
    public int[] pixels;
    private int x, y;
    private SpriteSheet sheet;

    public static Sprite grass = new Sprite(16,0,0,tiles);
    public static Sprite voidSprite = new Sprite(16, 0x37176B);

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
