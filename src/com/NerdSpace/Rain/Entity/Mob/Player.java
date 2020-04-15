package com.NerdSpace.Rain.Entity.Mob;

import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Graphics.Sprite;
import com.NerdSpace.Rain.Input.Keyboard;

public class Player extends Mob {
    private Keyboard key;
    private int walkCount;

    public Player(Keyboard key) {
        this.key = key;
    }

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void render(Screen screen) {
        if (dir == 0) {
            if (moving) {
                if (walkCount % 80 < 20) {
                    sprite = Sprite.playerF;
                } else if (walkCount % 80 < 40) {
                    sprite = Sprite.playerF_1;
                } else if (walkCount % 80 < 60) {
                    sprite = Sprite.playerF_2;
                } else {
                    sprite = Sprite.playerF_3;
                }
            } else sprite = Sprite.playerF;
        } else if (dir == 1) {
            if (moving) {
                if (walkCount % 60 < 15) {
                    sprite = Sprite.playerR;
                } else if (walkCount % 60 < 30) {
                    sprite = Sprite.playerR_1;
                } else if (walkCount % 60 < 45) {
                    sprite = Sprite.playerR_2;
                } else {
                    sprite = Sprite.playerR_3;
                }
            } else sprite = Sprite.playerR;
        } else if (dir == 2) {
            if (moving) {
                if (walkCount % 80 < 20) {
                    sprite = Sprite.playerB;
                } else if (walkCount % 80 < 40) {
                    sprite = Sprite.playerB_1;
                } else if (walkCount % 80 < 60) {
                    sprite = Sprite.playerB_2;
                } else {
                    sprite = Sprite.playerB_3;
                }
            } else sprite = Sprite.playerB;
        } else if (dir == 3) {
            if (moving) {
                if (walkCount % 60 < 15) {
                    sprite = Sprite.playerL;
                } else if (walkCount % 60 < 30) {
                    sprite = Sprite.playerL_1;
                } else if (walkCount % 60 < 45) {
                    sprite = Sprite.playerL_2;
                } else {
                    sprite = Sprite.playerL_3;
                }
            } else sprite = Sprite.playerL;
        }
        ;

        if (!moving || walkCount > 7500) walkCount = 0;
        else walkCount++;

        screen.renderPlayer(x - 16, y - 16, sprite);


    }

    public void update() {
        int vx = 0, vy = 0;
        if (key.up) vy--;
        if (key.down) vy++;
        if (key.left) vx--;
        if (key.right) vx++;
        if (vx != 0 || vy != 0) {
            moving = true;
            move(vx, vy);
        } else moving = false;

    }
}
