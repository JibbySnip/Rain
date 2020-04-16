package com.NerdSpace.Rain.Level.Tile;

import com.NerdSpace.Rain.Graphics.Sprite;

public class VoidTile extends Tile {

    public VoidTile(Sprite sprite) {
        super(sprite);
    }

    public boolean solid() {
        return true;
    }
}
