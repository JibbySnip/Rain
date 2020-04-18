package com.NerdSpace.Rain.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    private String path;
    public int[] pixels;
    public final int SIZE;
    public final int WIDTH, HEIGHT;
    private Sprite[] sprites;

    public static SpriteSheet trainer = new SpriteSheet("/textures/players/trainer.png", 128);
    public static SpriteSheet tiles = new SpriteSheet("/textures/tiles.png", 256);
    public static SpriteSheet playerDown = new SpriteSheet(trainer, 0, 0, 4, 1, 32);
    public static SpriteSheet spawn = new SpriteSheet("/textures/spawn_textures_v2.png", 48);
    public static SpriteSheet projectilesTrainer = new SpriteSheet("/textures/projectiles/trainer_projectiles.png", 48);

    public SpriteSheet(SpriteSheet sheet, int x, int y, int width, int height, int spriteSize) {
        int xx = x * spriteSize; // the x-pos of the sprite
        int yy = y * spriteSize; // the y-pos of the sprite

        SIZE = -1;
        WIDTH = width * spriteSize; // pixel precision
        HEIGHT = height * spriteSize;
        pixels = new int[WIDTH * HEIGHT];
        sprites = new Sprite[width * height];

        for (int y0 = 0; y0 < HEIGHT; y0++) {
            int yp = yy + y0;
            for (int x0 = 0; x0 < WIDTH; x0++) {
                int xp = xx + x0;
                pixels[x0 + y0 * WIDTH] = sheet.pixels[xp + yp * sheet.WIDTH];
            }
        }
        int frame = 0;
        for (int y0 = 0; y0 < height; y0++) {
            for (int x0 = 0; x0 < width; x0++) { // this is in tile precision
                int[] spritePixels = new int[spriteSize * spriteSize];
                for (int yp = 0; yp < spriteSize; yp++) { // this is in pixel precision
                    for (int xp = 0; xp < spriteSize; xp++) {
                        spritePixels[xp + yp * spriteSize] = sheet.pixels[(xp + x0 * spriteSize) + (yp + y0 * spriteSize) * WIDTH];

                    }
                }
                sprites[frame] = new Sprite(spritePixels, spriteSize, spriteSize);
                frame++;

            }
        }
    }

    public SpriteSheet(String path, int size) {
        this.path = path;
        this.SIZE = size;
        WIDTH = HEIGHT = size;
        pixels = new int[SIZE * SIZE];
        load();
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Sprite[] getSprites() {
        return sprites;
    }
}
