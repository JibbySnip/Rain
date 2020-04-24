package com.NerdSpace.Rain.Level;

import com.NerdSpace.Rain.Entity.Entity;
import com.NerdSpace.Rain.Entity.Mob.Player;
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
    private final List<Particle> particles = new ArrayList<>();
    private final List<Player> players = new ArrayList<>();

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
        for (Entity entity : entities) {
            entity.update();
        }
        for (Projectile projectile : projectiles) {
            projectile.update();
        }
        for (Particle particle : particles) {
            particle.update();
        }
        for (Player player : players) {
            player.update();
        }
        remove();
    }

    private void remove() {
        entities.removeIf(Entity::isRemoved);
        projectiles.removeIf(Entity::isRemoved);
        particles.removeIf(Entity::isRemoved);
    }

    private void time() {

    }

    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll);
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
        for (Particle p : particles) {
            p.render(screen);
        }
        for (Player player : players) {
            player.render(screen);
        }
    }

    public void add(Entity e) {
        e.init(this);
        if (e instanceof Particle) {
            particles.add((Particle) e);
        } else if (e instanceof Projectile) {
            projectiles.add((Projectile) e);
        } else if (e instanceof Player) {
            players.add((Player) e);
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

    public boolean tileCollision(int x, int y, int size, int xMargin, int yMargin) {
        boolean solid = false;
        for (int c = 0; c < 4; c++) {
            int xt = (x + c % 2 * size + xMargin) >> 4;
            int yt = (y + c / 2 * size + yMargin) >> 4;
            if (getTile(xt, yt).solid()) solid = true;
        }

        return solid;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayerAt(int index) {
        return players.get(index);
    }

    public Player getClientPlayer() {
        return players.size() > 0 ? players.get(0) : null;
    }

    public List<Entity> getEntitiesInRadius(Entity e, int radius) {
        List<Entity> results = new ArrayList<>();
        for (Entity entity : entities) {
            if (Math.hypot(e.getX() - entity.getX(), e.getY() - entity.getY()) <= radius) results.add(entity);
        }
        return results;
    }

    public List<Player> getPlayersInRadius(Entity e, int radius) {
        List<Player> results = new ArrayList<>();
        for (Player p : players) {
            if (Math.hypot(e.getX() - p.getX(), e.getY() - p.getY()) <= radius) results.add(p);
        }
        return results;
    }

    public Player getNearestPlayer(Entity e, int radius) {
        Player currPlayer = null;
        double currDist = 0;
        for (Player p : getPlayersInRadius(e, radius)) {
            if (Math.hypot(p.getX() - e.getX(), p.getY() - e.getY()) >= currDist) {
                currDist = Math.hypot(p.getX() - e.getX(), p.getY() - e.getY());
                currPlayer = p;
            }
        }
        return currPlayer;
    }
}
