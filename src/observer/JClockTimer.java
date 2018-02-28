/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : JCloclTimer.java
 Auteur(s)   : Samuel Mayor et Vincent Guidoux
 Date        : 04.03.2018

 But         : <à compléter>

 Remarque(s) : <à compléter>

 Java : 1.8.0_161
 -----------------------------------------------------------------------------------
 */package observer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JClockTimer extends DisplayClock implements Observer {

    private final String image;
    private Image clock;
    private double angleSecond;
    private double angleMinute;
    private double angleHour;

    public JClockTimer(String image) {
        this.image = image;
    }

    @Override
    public void update(int time) {
        //TODO Je pense qu'il faudrait recevoir l'objet Time plutôt qu'un int

        angleSecond = Math.PI * (time % 60) / 30;
        angleMinute = Math.PI * ((time / 60) % 60) / 30;
        angleHour = Math.PI * ((time / 3600) + ((time / 60) % 60) / 60.0) / 6;

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        clock = Toolkit.getDefaultToolkit().getImage(image);
        clock = clock.getScaledInstance(400, 400, 0);
        add(new JLabel(new ImageIcon(clock)));
        g.drawImage(clock, 0, 0, getWidth(), getWidth(), this);
        //seconds needle
        paintNeedle(angleSecond, 0.8, Color.RED, g);
        //minutes needle
        paintNeedle(angleMinute, 0.6, Color.BLUE, g);
        //hours needle
        paintNeedle(angleHour, 0.4, Color.BLACK, g);
    }

    private void paintNeedle(double angle, double size, Color color, Graphics g) {
        int xCenter = getWidth() / 2;
        int yCenter = xCenter;
        double x = xCenter + (xCenter * size * Math.sin(angle));
        double y = yCenter - (yCenter * size * Math.cos(angle));

        g.setColor(color);
        g.drawLine(xCenter, yCenter, (int) x, (int) y);
    }
}
