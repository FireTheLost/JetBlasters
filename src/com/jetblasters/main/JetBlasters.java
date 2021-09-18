package com.jetblasters.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class JetBlasters extends Canvas
{
    private ObjectHandler handler;
    private GameWindow win;
    private Display hud;

    public static int FRAMES = 0;

    public static void main(String[] args)
    {
        new JetBlasters();
    }

    public JetBlasters()
    {
        this.handler = new ObjectHandler();
        this.addKeyListener(new KeyInput(handler));
        this.win = new GameWindow("JetBlasters", this);
        this.hud = new Display(handler);

        this.start();
    }

    public void start()
    {
        Random rand = new Random();
        handler.addObject(new Spaceship(win.getWidth() / 2, (int) (win.getHeight() * 0.75), handler, hud));
        for (int i = 0; i < 5; i++)
        {
            handler.addObject(new Asteroid(rand.nextInt(win.getWidth() / 2), rand.nextInt(win.getHeight() / 2)));
        }
        this.run();
    }

    public void run()
    {
        long lastTick = System.nanoTime();
        long now;
        long timeSinceLastTick;
        int frameRate = 0;

        long timer = System.currentTimeMillis();

        while (true)
        {
            now = System.nanoTime();
            timeSinceLastTick = now - lastTick;

            if (timeSinceLastTick >= 10000)
            {
                tick();
                lastTick = System.currentTimeMillis();
            }

            render();
            frameRate++;

            if (System.currentTimeMillis() - timer >= 1000)
            {
                timer = System.currentTimeMillis();
                FRAMES = frameRate;
                frameRate = 0;
            }
        }
    }

    private void tick()
    {
        handler.tick();
        hud.tick();
    }

    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bs.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, win.getWidth(), win.getHeight());

        handler.render(graphics, win);
        hud.render(graphics);

        graphics.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max)
    {
        if (var > max)
        {
            return var = max;
        }
        else if (var < min)
        {
            return var = min;
        }
        else
        {
            return var;
        }
    }
}