package com.jetblasters.main;

import java.awt.*;

public class Asteroid extends GameObject
{
    private int velX;
    private int velY;

    public Asteroid(int x, int y)
    {
        super(x, y, ObjectType.Asteroid);
        velX = 2;
        velY = 2;
    }

    public void tick()
    {
        x = x + velX;

        if (x <= 0 || x >= GameWindow.WIDTH)
        {
            x = 0;
            // velX *= -1;
        }
    }

    public void render(Graphics graphics, GameWindow win)
    {
        graphics.setColor(Color.white);
        graphics.fillRect(x, y, 16, 16);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x,y, 16, 16);
    }
}