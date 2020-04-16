package com.NerdSpace.Rain.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    private String path;
    public int[] pixels;
    public final int SIZE;

    public static SpriteSheet tiles = new SpriteSheet("/textures/tiles.png",256);
    public static SpriteSheet spawn = new SpriteSheet("/textures/spawn_textures.png",48);

    public SpriteSheet(String path, int size) {
        this.path = path;
        this.SIZE = size;
        pixels = new int[SIZE*SIZE];
        load();
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels,0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
