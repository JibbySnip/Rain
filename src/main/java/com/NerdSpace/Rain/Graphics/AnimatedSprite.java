package com.NerdSpace.Rain.Graphics;

public class AnimatedSprite extends Sprite {

    private int frame = 0;
    private Sprite sprite;
    private int rate = 10;
    private int time = 0;
    private int length;

    public AnimatedSprite(SpriteSheet sheet, int width, int height, int length) {
        super(sheet, width, height);
        this.sheet = sheet;
        this.length = length;
        sprite = sheet.getSprites()[0];
        if (length > sheet.getSprites().length)
            System.err.println("Error: Sprite frames are less than animation length");
    }

    public void update() {
        if (time % rate == 0) {
            if (frame >= length) frame = 0;
            else frame++;
            setSprite(frame);
        }
        time++;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Sprite getSprite(int index) {
        return sheet.getSprites()[index];
    }

    public void setFrameRate(int rate) {
        this.rate = rate;
    }

    public void setFrame(int frame) {
        if (frame > length - 1) System.err.println("Error: Frame is out of bounds");
        this.frame = frame;
        setSprite(frame);
    }

    private void setSprite(int frame) {
        sprite = sheet.getSprites()[frame];
    }
}
