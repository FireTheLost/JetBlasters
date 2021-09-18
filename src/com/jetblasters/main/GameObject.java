package com.jetblasters.main;

import java.awt.*;

public abstract class GameObject
{
    protected int x;
    protected int y;

    protected ObjectType id;

    public GameObject(int x, int y, ObjectType id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics, GameWindow win);

    public abstract Rectangle getBounds();

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public ObjectType getId()
    {
        return id;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }
}