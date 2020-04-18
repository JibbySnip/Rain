package com.NerdSpace.Rain.Graphics;

import com.NerdSpace.Rain.Entity.Projectile.Projectile;
import com.NerdSpace.Rain.Level.RandomLevel;
import com.NerdSpace.Rain.Level.Tile.Tile;

public class Screen {
    public final int MAP_SIZE = 64;
    //    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int[] pixels;
    public int width, height;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    private int xOffset, yOffset;

    public Screen(int width, int height) {

        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            pixels[i] = RandomLevel.random.nextInt(0xffffff);
        }
    }

    public void clear() {
        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = 0;
        }
    }

    // This is for debugging
    public void renderSheet(int xp, int yp, SpriteSheet sheet, boolean fixed) {
        if (fixed) {
            xp -= xOffset;
            yp -= yOffset;
        }
        for (int y = 0; y < sheet.HEIGHT; y++) {
            int ya = y + yp;
            for (int x = 0; x < sheet.WIDTH; x++) {
                int xa = x + xp;
                if (xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
                int col = sheet.pixels[x + y * sheet.WIDTH];
                pixels[xa + ya * width] = col;
            }
        }
    }

    public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed, boolean filterColor) {
        if (fixed) {
            xp -= xOffset;
            yp -= yOffset;
        }
        for (int y = 0; y < sprite.getHeight(); y++) {
            int ya = y + yp;
            for (int x = 0; x < sprite.getWidth(); x++) {
                int xa = x + xp;
                if (xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
                int col = sprite.pixels[x + y * sprite.getWidth()];
                if (col != 0xFFFF00FF || !filterColor) pixels[xa + ya * width] = col;
            }
        }
    }

    public void renderTile(int xp, int yp, Tile tile) {
//        xp -= xOffset;
//        yp -= yOffset;
//        for (int y = 0; y < tile.sprite.SIZE; y++) {
//            int ya = y + yp;
//            for (int x = 0; x < tile.sprite.SIZE; x++) {
//                int xa = x + xp;
//                if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
//                if (xa < 0) xa = 0;
//                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
//            }
//        }
        renderSprite(xp, yp, tile.sprite, true, false);
    }

    public void renderProjectile(int xp, int yp, Projectile p) {
//        xp -= xOffset;
//        yp -= yOffset;
//        for (int y = 0; y < p.getSpriteSize(); y++) {
//            int ya = y + yp;
//            for (int x = 0; x < p.getSpriteSize(); x++) {
//                int xa = x + xp;
//                if (xa < -p.getSpriteSize() || xa >= width || ya < 0 || ya >= height) break;
//                if (xa < 0) xa = 0;
//                int col = p.getSprite().pixels[x + y * p.getSpriteSize()];
//                if (col != 0xFFFF00FF) pixels[xa + ya * width] = p.getSprite().pixels[x + y * p.getSpriteSize()];
//            }
//        }
        renderSprite(xp, yp, p.sprite, true, true);
    }

    public void renderPlayer(int xp, int yp, Sprite sprite) {
//        xp -= xOffset;
//        yp -= yOffset;
//        for (int y = 0; y < sprite.SIZE; y++) {
//            int ya = y + yp;
//            for (int x = 0; x < sprite.SIZE; x++) {
//                int xa = x + xp;
//                if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
//                if (xa < 0) xa = 0;
//                int col = sprite.pixels[x + y * sprite.SIZE];
//                if (col != 0xFFFF00FF) pixels[xa + ya * width] = col;
//            }
//        }
        renderSprite(xp, yp, sprite, true, true);
    }


    public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

}
