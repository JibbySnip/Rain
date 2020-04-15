package com.NerdSpace.Rain.Level.Tile;

import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Graphics.Sprite;

public class RockTile extends Tile {
    public RockTile(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
}
