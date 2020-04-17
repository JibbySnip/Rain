package com.NerdSpace.Rain.Entity.Mob;

import com.NerdSpace.Rain.Entity.Projectile.TrainerProjectile;
import com.NerdSpace.Rain.Game;
import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Graphics.Sprite;
import com.NerdSpace.Rain.Input.Keyboard;
import com.NerdSpace.Rain.Input.Mouse;
import com.NerdSpace.Rain.Level.TileCoordinate;

public class Player extends Mob {
    private Keyboard key;
    private int walkCount;
    private int currShots;
// Unused constructor
//    public Player(Keyboard key) {
//        this.key = key;
//    }

    public Player(TileCoordinate t, Keyboard key) {
        this.x = t.getX();
        this.y = t.getY();
        this.key = key;
        currShots = TrainerProjectile.RATE_OF_FIRE;
    }

    public void render(Screen screen) {
        doWalkAnimation();

        if (!moving || walkCount > 7500) walkCount = 0;
        else walkCount++;

        screen.renderPlayer(x - 16, y - 16, sprite);


    }

    public void update() {
        if (currShots != 0) currShots--;
        else currShots = TrainerProjectile.RATE_OF_FIRE;
        int vx = 0, vy = 0;
        if (key.up) vy--;
        if (key.down) vy++;
        if (key.left) vx--;
        if (key.right) vx++;
        if (vx != 0 || vy != 0) {
            moving = true;
            move(vx, vy);

        } else moving = false;

        updateShooting();
    }

    private void updateShooting() {
        if (Mouse.getButton() == 1 && currShots == 0) {
            double dx = Mouse.getX() - Game.getWindowWidth() / 2.0;
            double dy = Mouse.getY() - Game.getWindowHeight() / 2.0;
            double dir = Math.atan2(dy, dx);

            shoot(x, y, dir);

        }
    }

    private void doWalkAnimation() {
        if (dir == 0) {
            if (moving) {
                if (walkCount % 60 < 15) {
                    sprite = Sprite.playerF_1;
                } else if (walkCount % 60 < 30) {
                    sprite = Sprite.playerF_2;
                } else if (walkCount % 60 < 45) {
                    sprite = Sprite.playerF_3;
                } else {
                    sprite = Sprite.playerF;
                }
            } else sprite = Sprite.playerF;
        } else if (dir == 1) {
            if (moving) {
                if (walkCount % 60 < 15) {
                    sprite = Sprite.playerR_1;
                } else if (walkCount % 60 < 30) {
                    sprite = Sprite.playerR_2;
                } else if (walkCount % 60 < 45) {
                    sprite = Sprite.playerR_3;
                } else {
                    sprite = Sprite.playerR;
                }
            } else sprite = Sprite.playerR;
        } else if (dir == 2) {
            if (moving) {
                if (walkCount % 60 < 15) {
                    sprite = Sprite.playerB_1;
                } else if (walkCount % 60 < 30) {
                    sprite = Sprite.playerB_2;
                } else if (walkCount % 60 < 45) {
                    sprite = Sprite.playerB_3;
                } else {
                    sprite = Sprite.playerB;
                }
            } else sprite = Sprite.playerB;
        } else if (dir == 3) {
            if (moving) {
                if (walkCount % 60 < 15) {
                    sprite = Sprite.playerL_1;
                } else if (walkCount % 60 < 30) {
                    sprite = Sprite.playerL_2;
                } else if (walkCount % 60 < 45) {
                    sprite = Sprite.playerL_3;
                } else {
                    sprite = Sprite.playerL;
                }
            } else sprite = Sprite.playerL;
        }
    }
}
