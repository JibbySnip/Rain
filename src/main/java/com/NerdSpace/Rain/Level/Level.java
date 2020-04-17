package com.NerdSpace.Rain.Level;

import com.NerdSpace.Rain.Entity.Entity;
import com.NerdSpace.Rain.Entity.Particle.Particle;
import com.NerdSpace.Rain.Entity.Projectile.Projectile;
import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Level.Tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class Level {

    protected int width, height;
    protected int[] tilesInt;

    public static Level spawnLevel = new SpawnLevel("/levels/spawn_level.png");
    private final List<Entity> entities = new ArrayList<>();
    private final List<Projectile> projectiles = new ArrayList<>();
    private List<Particle> particles = new ArrayList<>();

    public Level(int width, int height) {
        this.width = width;
        this.height = height;

        tilesInt = new int[width * height];
        generateLevel();
    }

    public Level(String path) {
        loadLevel(path);
        generateLevel();

    }

    protected void loadLevel(String path) {

    }

    protected void generateLevel() {
    }

    public void update() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).update();
            if (entities.get(i).isRemoved()) entities.remove(i);
        }
        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).update();
            if (projectiles.get(i).isRemoved()) projectiles.remove(i);
        }
    }

    private void time() {

    }

    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll,yScroll);
        int x0 = xScroll >> 4;
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(x, y, screen);

            }
        }

        for (Entity entity : entities) {
            entity.render(screen);
        }
        for (Projectile p : projectiles) {
            p.render(screen);
        }
    }

    public void add(Entity e) {
        e.init(this);
        if (e instanceof Particle) {
            particles.add((Particle) e);

        } else if (e instanceof Projectile) {
            projectiles.add((Projectile) e);
        } else entities.add(e);
    }


    public Tile getTile(int x, int y) {
//        int grass = 0xff00ff00;
//        int flower = 0xffffff00;
//        int rock = 0xff007f00;

        if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
        if (tilesInt[x + y * width] == Tile.colSpawnGrass) return Tile.spawnGrass;
        if (tilesInt[x + y * width] == Tile.colSpawnFloor) return Tile.spawnFloor;
        if (tilesInt[x + y * width] == Tile.colSpawnHedge) return Tile.spawnHedge;
        if (tilesInt[x + y * width] == Tile.colSpawnWall1) return Tile.spawnWall1;
        if (tilesInt[x + y * width] == Tile.colSpawnWall2) return Tile.spawnWall2;
        if (tilesInt[x + y * width] == Tile.colSpawnWater) return Tile.spawnWater;
        return Tile.voidTile;
    }

    public boolean tileCollision(double x, double y, double dx, double dy, int size) {
        boolean solid = false;
        for (int c = 0; c < 4; c++) {
//            double xt = ((x + dx) + c % 2 * 6 - 4)/16;
//            double yt = ((y + dy) + c / 2.0 * 5 + 0)/16;
            double xt = ((x + dx) + c % 2.0 * size - size / 2.0) / 16;
            double yt = ((y + dy) + c / 2.0 * size - size / 2.0) / 16;
            if (getTile((int) xt, (int) yt).solid()) solid = true;
        }
        return solid;
    }
}
