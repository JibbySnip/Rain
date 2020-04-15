package com.NerdSpace.Rain;

import com.NerdSpace.Rain.Entity.Mob.Player;
import com.NerdSpace.Rain.Graphics.Screen;
import com.NerdSpace.Rain.Input.Keyboard;
import com.NerdSpace.Rain.Level.Level;
import com.NerdSpace.Rain.Level.RandomLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {
    public static int width = 300;
    public static int height = 168;
    public static int scale = 3;

    private int x=0,y=0;
    private boolean running;
    private Thread thread;
    private JFrame frame;
    private Screen screen;
    private Level level;
    private Player player;

    private Keyboard keyboard = new Keyboard();
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public Game() {
        Dimension size = new Dimension(width*scale,height*scale);
        setPreferredSize(size);
        screen = new Screen(width, height);
        frame = new JFrame();
        addKeyListener(keyboard);
        level = new RandomLevel(64, 64);
        player = new Player(keyboard);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(true);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();

    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Rain");
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tick() {
        keyboard.update();
        player.update();
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        int xScroll = player.x - screen.width / 2;
        int yScroll = player.y - screen.height / 2;

        level.render(xScroll, yScroll, screen);
        player.render(screen);

        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        int ticks = 0, frames = 0;
        long titleTimer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        requestFocus();
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                tick();
                ticks++;
                delta--;
            }
            frames++;
            render();
            if (System.currentTimeMillis() - titleTimer >= 1000) {
                titleTimer += 1000;
                String title = "Rain";
                frame.setTitle(title + " | "+ ticks + " tps, "+ frames + " fps");
                ticks = 0;
                frames = 0;
            }
        }
        stop();
    }
}
