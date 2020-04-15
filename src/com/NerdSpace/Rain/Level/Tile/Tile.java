package com.NerdSpace.Rain.Level.Tile;

import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Graphics.Sprite;

public class Tile {

    public Sprite sprite;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);
    public static Tile flower = new FlowerTile(Sprite.flower);
    public static Tile rock = new RockTile(Sprite.rock);

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
    }

    public boolean solid() {
        return false;
    }
}
