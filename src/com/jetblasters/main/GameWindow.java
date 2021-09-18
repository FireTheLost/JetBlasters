package com.jetblasters.main;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends Canvas
{
    private int width;
    private int height;

    public static int WIDTH;
    public static int HIEGHT;

    public String title;

    public GameWindow(String title, JetBlasters game)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.width = (int) screenSize.getWidth();
        this.height = (int) screenSize.getHeight();

        this.title = title;

        HIEGHT = height;
        WIDTH = width;

        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.add(game);
        frame.setVisible(true);
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }
}