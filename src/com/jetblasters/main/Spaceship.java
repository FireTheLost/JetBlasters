package com.jetblasters.main;

import java.awt.*;

public class Spaceship extends GameObject
{
    private Display hud;
    private ObjectHandler handler;

    public Spaceship(int x, int y, ObjectHandler handler, Display hud)
    {
        super(x, y, ObjectType.Spaceship);
        this.hud = hud;
        this.handler = handler;
    }

    public void tick()
    {
        hit();

        if (y <= 0)
        {
            y = (int) (GameWindow.HIEGHT * 0.75);
            hud.setScore(hud.getScore() + 1);
        }
    }

    public void render(Graphics graphics, GameWindow win)
    {
        graphics.setColor(Color.white);
        graphics.fillRect(x, y, 32, 64);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x,y, 32, 64);
    }

    private void hit()
    {
        for (int i = 0; i < handler.objects.size(); i++)
        {
            GameObject temp = handler.objects.get(i);

            if (temp.getId() == ObjectType.Asteroid)
            {
                if (getBounds().intersects(temp.getBounds()))
                {
                    y = (int) (GameWindow.HIEGHT * 0.75);
                    x = GameWindow.WIDTH / 2;
                }
            }
        }
    }
}