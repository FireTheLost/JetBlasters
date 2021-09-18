package com.jetblasters.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
    private ObjectHandler handler;

    public KeyInput(ObjectHandler handler)
    {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent event)
    {
        int key = event.getKeyCode();

        for (int i = 0;  i < handler.objects.size(); i++)
        {
            GameObject currentObject = handler.objects.get(i);

            if (currentObject.getId() == ObjectType.Spaceship)
            {
                if (key == KeyEvent.VK_UP)
                {
                    currentObject.setY(currentObject.getY() - 10);
                }
                if (key == KeyEvent.VK_DOWN)
                {
                    currentObject.setY(currentObject.getY() + 10);
                }
                if (key == KeyEvent.VK_LEFT)
                {
                    currentObject.setX(currentObject.getX() - 10);
                }
                if (key == KeyEvent.VK_RIGHT)
                {
                    currentObject.setX(currentObject.getX() + 10);
                }
            }
        }
    }

    public void keyReleased(KeyEvent event)
    {
        int key = event.getKeyCode();
    }
}