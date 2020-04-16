package com.NerdSpace.Rain.Level.Tile.SpawnTiles;

import com.NerdSpace.Rain.Graphics.Sprite;
import com.NerdSpace.Rain.Level.Tile.Tile;

public class SpawnHedgeTile extends Tile {
    public SpawnHedgeTile(Sprite sprite) {
        super(sprite);
    }

    public boolean solid() {
        return true;
    }
}
