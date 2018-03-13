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
 */

package observer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JLabel;
import subject.PersonalTimer;

public class JClockTimer extends DisplayClock implements Observer {
    private final String image;
    private Image clock;
    private double angleSecond;
    private double angleMinute;
    private double angleHour;

    public JClockTimer(String image) {
        JLabel imageContainer = new JLabel();
        this.image = image;
        clock = Toolkit.getDefaultToolkit().getImage(image);
        clock = clock.getScaledInstance(getPreferredSize().width, getPreferredSize().height,
        Image.SCALE_SMOOTH);
        
        addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                resize();
            }

            @Override
            public void componentMoved(ComponentEvent e) {}

            @Override
            public void componentShown(ComponentEvent e) {}

            @Override
            public void componentHidden(ComponentEvent e) {}
        });
    }
    
    private void resize() {
        clock = clock.getScaledInstance(getWidth(), getWidth(), Image.SCALE_DEFAULT);
    }
    
    public Dimension getPreferredSize()
    {
        return new Dimension(300, 300);
    }

    @Override
    public void update(PersonalTimer time) {
        angleSecond = Math.PI * time.seconds() / 30;
        angleMinute = Math.PI * time.minutes() / 30;
        angleHour = Math.PI * (time.hours() + time.minutes() / 60.0) / 6;

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        if (clock == null) resize();
        g.drawImage(clock, 0, 0, this);
        
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
