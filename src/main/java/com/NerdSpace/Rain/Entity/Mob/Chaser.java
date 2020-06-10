package com.NerdSpace.Rain.Entity.Mob;

import com.NerdSpace.Rain.Graphics.AnimatedSprite;
import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Graphics.SpriteSheet;

public class Chaser extends Mob {


    private double xa, ya;
    private int FOLLOW_DIST = 50;
    Player player;
    private final AnimatedSprite up = new AnimatedSprite(SpriteSheet.ozzyUp, 16, 16, 3);
    private final AnimatedSprite down = new AnimatedSprite(SpriteSheet.ozzyDown, 16, 16, 3);
    private final AnimatedSprite left = new AnimatedSprite(SpriteSheet.ozzyLeft, 16, 16, 3);
    private final AnimatedSprite right = new AnimatedSprite(SpriteSheet.ozzyRight, 16, 16, 3);
    private AnimatedSprite currAnimSprite = down;

    public Chaser(int x, int y) {
        this.x = x << 4;
        this.y = y << 4;
        speed = 0.8;
    }

    private void move() {
        xa = ya = 0;
        player = level.getNearestPlayer(this, FOLLOW_DIST);
        if (player != null) {
            if (x < player.getX()) xa += speed;
            if (x > player.getX()) xa -= speed;
            if (y < player.getY()) ya += speed;
            if (y > player.getY()) ya -= speed;
            if (Math.floor(x) == Math.floor(player.getX())) xa = 0;
            if (Math.floor(y) == Math.floor(player.getY())) ya = 0;

        }
        if (xa != 0 || ya != 0) {
            move(xa, ya);
            if (!moving) currAnimSprite.setFrame(0);
            moving = true;
        } else moving = false;

    }

    @Override
    public void update() {
        move();

        if (dir == 0) currAnimSprite = up;
        else if (dir == 2) currAnimSprite = down;
        if (dir == 1) currAnimSprite = right;
        else if (dir == 3) currAnimSprite = left;

        if (moving) currAnimSprite.update();
        else currAnimSprite.setFrame(0);
    }

    @Override
    public void render(Screen screen) {
        sprite = currAnimSprite.getSprite();
        sprite.replaceColor(0xffdaf4fa, 0xe00b0b);

        screen.renderMob((int) x - 8, (int) y - 8, this);
    }
}
