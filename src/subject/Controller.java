/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : Controller.java
 Auteur(s)   : Samuel Mayor et Vincent Guidoux
 Date        : 04.03.2018

 But         : A class who represent a window with button to access different 
               Clocks, and can start, stop and reset the clocks

 Java : 1.8.0_161
 -----------------------------------------------------------------------------------
 */
package subject;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import observer.DisplayClock;
import observer.JClockTimer;
import observer.JNumericTimer;

public class Controller extends JFrame {

   JPanel pane = new JPanel(new GridBagLayout());
   GridBagConstraints grid = new GridBagConstraints();
   PersonalTimer subject = new PersonalTimer();

   ;

    /**
     * Constructor who sets different buttons and features we're going to use 
     */
    public Controller() {
      add(pane);
      grid.insets = new Insets(3, 3, 3, 3);
      grid.fill = GridBagConstraints.HORIZONTAL;

      /**
       * Button "Horloge Romaine"
       */
      JButton b = new JButton("Horloge romaine");
      grid.gridx = 0;
      grid.gridy = 0;
      pane.add(b, grid);
      b.addActionListener((ActionEvent e) -> {
         newFrame(500, 520, new JClockTimer("clock2.jpg"));
      });

      /**
       * Button "Horloge arabe"
       */
      b = new JButton("Horloge arabe");
      grid.gridx = 1;
      grid.gridy = 0;
      pane.add(b, grid);
      b.addActionListener((ActionEvent e) -> {
         newFrame(500, 520, new JClockTimer("clock1.jpg"));
      });

      /**
       * Button "Horloge numérique"
       */
      b = new JButton("Horloge numérique");
      grid.gridx = 2;
      grid.gridy = 0;
      pane.add(b, grid);
      b.addActionListener((ActionEvent e) -> {
         newFrame(300, 100, new JNumericTimer());
      });

      /**
       * Button "Horloge numérique"
       */
      b = new JButton("Horloge mixte");
      grid.gridx = 3;
      grid.gridy = 0;
      pane.add(b, grid);
      b.addActionListener((ActionEvent e) -> {
         newFrame(400, 700, new JClockTimer("clock2.jpg"),
                 new JClockTimer("clock1.jpg"),
                 new JNumericTimer());
      });

      /**
       * Button "Démarrer"
       */
      b = new JButton("Démarrer");
      grid.gridx = 0;
      grid.gridy = 1;
      pane.add(b, grid);
      b.addActionListener((ActionEvent e) -> {
         subject.start();
      });

      /**
       * Button "Arreter"
       */
      b = new JButton("Arreter");
      grid.gridx = 1;
      grid.gridy = 1;
      pane.add(b, grid);
      b.addActionListener((ActionEvent e) -> {
         subject.pause();
      });

      /**
       * Button "Réinitialiser"
       */
      b = new JButton("Réinitialiser");
      grid.gridx = 2;
      grid.gridy = 1;
      pane.add(b, grid);
      b.addActionListener((ActionEvent e) -> {
         subject.reset();
      });

      /**
       *
       */
      b = new JButton("Quitter");
      grid.gridx = 3;
      grid.gridy = 1;
      pane.add(b, grid);
      b.addActionListener((ActionEvent e) -> {
         System.exit(0);;
      });

      setSize(650, 200);
      setVisible(true);
   }

   /**
    * Create a new windows, with the given Clock(s) to display
    *
    * @param width : width of the new window
    * @param height : height of the new Window
    * @param clocks : Clocks to display
    */
   private void newFrame(int width, int height, DisplayClock... clocks) {
      JFrame clockFrame = new JFrame();
      clockFrame.setSize(width, height);
      clockFrame.setVisible(true);

      /**
       * If there are more than 1 clocks to display, we set a FlowLayout to align all
       * the clocks
       */
      if (clocks.length > 1) {
         clockFrame.setLayout(new FlowLayout());
      }

      /**
       * We had the given clocks to the new frame
       */
      for (DisplayClock clock : clocks) {
         clock.addMouseListener(new MouseAdapter() {

            /**
             * Adding the clock to the frame wasn't enough by clicking on it, we can
             * stop it or vice versa
             *
             * @param e : click event
             */
            public void mouseClicked(MouseEvent e) {
               if (subject.paused()) {
                  subject.start();
               } else {
                  subject.pause();
               }
            }
         });
         clockFrame.add(clock);

         //add the observer au subject
         subject.attach(clock);
      }
   }
}
