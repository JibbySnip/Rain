package com.NerdSpace.Rain.Entity.Mob;

import com.NerdSpace.Rain.Graphics.AnimatedSprite;
import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Graphics.SpriteSheet;

public class Ozzy extends Mob {

    private final AnimatedSprite up = new AnimatedSprite(SpriteSheet.ozzyUp, 16, 16, 3);
    private final AnimatedSprite down = new AnimatedSprite(SpriteSheet.ozzyDown, 16, 16, 3);
    private final AnimatedSprite left = new AnimatedSprite(SpriteSheet.ozzyLeft, 16, 16, 3);
    private final AnimatedSprite right = new AnimatedSprite(SpriteSheet.ozzyRight, 16, 16, 3);
    private AnimatedSprite currAnimSprite = down;

    private int time;
    private int xa, ya;


    public Ozzy(int x, int y) {
        this.x = x << 4;
        this.y = y << 4;
        xa = 0;
        ya = 0;
    }

    @Override
    public void update() {
        time++;
        if (time % (random.nextInt(50) + 30) == 0) {
            xa = random.nextInt(3) - 1;
            ya = random.nextInt(3) - 1;
            if (random.nextInt(3) == 0) {
                xa = ya = 0;
            }
        }


        if (xa != 0 || ya != 0) {
            move(xa, ya);
            if (!moving) currAnimSprite.setFrame(0);
            moving = true;
            if (dir == 0) currAnimSprite = up;
            else if (dir == 2) currAnimSprite = down;
            if (dir == 1) currAnimSprite = right;
            else if (dir == 3) currAnimSprite = left;
            currAnimSprite.update();
        } else moving = false;
        if (!moving) currAnimSprite.setFrame(0);
    }

    @Override
    public void render(Screen screen) {
        sprite = currAnimSprite.getSprite();
        screen.renderMob((int) x, (int) y, this);
    }
}
