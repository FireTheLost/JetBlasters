package com.jetblasters.main;

import java.awt.*;

public class Display
{
    public int time;
    public int score;

    private ObjectHandler handler;

    private long last = System.currentTimeMillis();

    public static int MAX_TIME = 60;

    public Display(ObjectHandler handler)
    {
        this.time = 60;
        this.score = 0;
        this.handler = handler;
    }

    public void tick()
    {
        if (System.currentTimeMillis() - last >= 1000)
        {
            time--;
            last = System.currentTimeMillis();
        }

        time = JetBlasters.clamp(time, 0, 100);
    }

    public void render(Graphics graphics)
    {
        graphics.setColor(Color.white);
        graphics.fillRect(32, GameWindow.HIEGHT - 125, time * 4, 30);
        graphics.drawRect(32, GameWindow.HIEGHT - 125, MAX_TIME * 4, 30);

        graphics.drawString("Score: " + score, 32, GameWindow.HIEGHT - 160);
        graphics.drawString("FPS: " + JetBlasters.FRAMES, 32, GameWindow.HIEGHT - 140);
    }

    public int getTime()
    {
        return time;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
}