/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : JCloclTimer.java
 Auteur(s)   : Samuel Mayoer et Vincent Guidoux
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
import javax.swing.JPanel;

public class JClockTimer extends DisplayClock implements Observer {

   private final String image;
   private Image clock;
   private double AngleSeconde;
   private double AngleMinute;
   private double AngleHeure;

   public JClockTimer(String image) {
      this.image = image;
   }

   @Override
   public void update(int time) {
      //TODO Je pense qu'il faudrait recevoir l'objet Time plutôt qu'un int

      AngleSeconde = Math.PI * (time % 60) / 30;
      AngleMinute = Math.PI * ((time / 60) % 60) / 30;
      AngleHeure = Math.PI * ((time / 3600) + ((time / 60) % 60) / 60.0) / 6;

      repaint();
   }

   class DrawPane extends JPanel {

      public void paintComponent(Graphics g) {

         g.drawImage(clock, 0, 0, getWidth(), getWidth(), this);
         //aiguille secondes
         paintNeedle(AngleSeconde, 0.4, Color.RED, g);
         //aiguille minutes
         paintNeedle(AngleMinute, 0.6, Color.BLUE, g);
         //aiguille heures
         paintNeedle(AngleHeure, 0.8, Color.BLACK, g);
      }

      protected void paintNeedle(double angle, double size, Color coler, Graphics g) {
         int xCenter = getWidth() / 2;
         int yCenter = xCenter;
         double x = xCenter +  (xCenter * size * Math.sin(angle));
         double y = yCenter -  (yCenter * size * Math.cos(angle));

         g.setColor(coler);
         g.drawLine(xCenter, yCenter,(int) x, (int)y);
      }
   }

   @Override
   public void init() {
      clock = Toolkit.getDefaultToolkit().getImage(image);
      clock = clock.getScaledInstance(400, 400, 0);
      add(new JLabel(new ImageIcon(clock)));
      setSize(400, 400);
      setContentPane(new DrawPane());
      setVisible(true);
   }
}
