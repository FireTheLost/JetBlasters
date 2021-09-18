package com.jetblasters.main;

import java.awt.*;
import java.util.ArrayList;

public class ObjectHandler
{
    ArrayList<GameObject> objects;

    public ObjectHandler()
    {
        this.objects = new ArrayList<>();
    }

    public void tick()
    {
        for (int i = 0; i < objects.size(); i++)
        {
            objects.get(i).tick();
        }
    }

    public void render(Graphics graphics, GameWindow win)
    {
        for (int i = 0; i < objects.size(); i++)
        {
            objects.get(i).render(graphics, win);
        }
    }

    public void addObject(GameObject object)
    {
        objects.add(object);
    }

    public void removeObject(GameObject object)
    {
        objects.remove(object);
    }
}