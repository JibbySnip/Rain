package com.NerdSpace.Rain.Entity.Mob;

import com.NerdSpace.Rain.Entity.Projectile.TrainerProjectile;
import com.NerdSpace.Rain.Game;
import com.NerdSpace.Rain.Graphics.AnimatedSprite;
import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Graphics.SpriteSheet;
import com.NerdSpace.Rain.Input.Keyboard;
import com.NerdSpace.Rain.Input.Mouse;
import com.NerdSpace.Rain.Utils.TileCoordinate;

public class Player extends Mob {
    private final Keyboard key;
    private int currShots;
    private final AnimatedSprite down = new AnimatedSprite(SpriteSheet.trainerDown, 32, 32, 3);
    private final AnimatedSprite left = new AnimatedSprite(SpriteSheet.trainerLeft, 32, 32, 3);
    private final AnimatedSprite right = new AnimatedSprite(SpriteSheet.trainerRight, 32, 32, 3);
    private final AnimatedSprite up = new AnimatedSprite(SpriteSheet.trainerUp, 32, 32, 3);
    private AnimatedSprite currAnimSprite = up;
    // Unused constructor
//    public Player(Keyboard key) {
//        this.key = key;
//    }

    public Player(TileCoordinate t, Keyboard key) {
        this.x = t.getX();
        this.y = t.getY();
        this.key = key;
        currShots = TrainerProjectile.RATE_OF_FIRE;
        speed = 1;
    }

    public void render(Screen screen) {
        sprite = currAnimSprite.getSprite();
        screen.renderMob((int) (x - 16), (int) (y - 16), this);


    }

    public void update() {
        if (moving) currAnimSprite.update();
        else currAnimSprite.setFrame(0);
        if (currShots != 0) currShots--; // tracks shots to make sure they don't exceed rate of fire
        else currShots = TrainerProjectile.RATE_OF_FIRE;
        double vx = 0, vy = 0;
        if (key.up) vy -= speed;
        if (key.down) vy += speed;
        if (key.left) vx -= speed;
        if (key.right) vx += speed;

        if (vx != 0 || vy != 0) {
            if (!moving) currAnimSprite.setFrame(0); // if they just started moving
            moving = true;
            if (dir == 0) currAnimSprite = up;
            else if (dir == 2) currAnimSprite = down;
            if (dir == 1) currAnimSprite = right;
            else if (dir == 3) currAnimSprite = left;
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
