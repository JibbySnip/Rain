package com.NerdSpace.Rain.Level.Tile.SpawnTiles;

import com.NerdSpace.Rain.Graphics.Sprite;
import com.NerdSpace.Rain.Level.Tile.Tile;

public class SpawnWallTile extends Tile {
    public SpawnWallTile(Sprite sprite) {
        super(sprite);
    }

    public boolean solid() {
        return true;
    }
}
