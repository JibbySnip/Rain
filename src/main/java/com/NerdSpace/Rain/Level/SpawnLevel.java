package com.NerdSpace.Rain.Level;

import com.NerdSpace.Rain.Entity.Mob.Chaser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpawnLevel extends Level {


    public SpawnLevel(String path) {
        super(path);
    }

    protected void loadLevel(String path) {
        try {
            BufferedImage levelImg = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = width = levelImg.getWidth();
            int h = height = levelImg.getHeight();
            tilesInt = new int[w * h];
            levelImg.getRGB(0, 0, w, h, tilesInt, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void generateLevel() {
//        for (int i = 0; i < 20; i++) {
//            add(new Ozzy(22,63));
//        }

        add(new Chaser(22, 63));
    }
}
