/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : Controller.java
 Auteur(s)   : Samuel Mayor et Vincent Guidoux
 Date        : 04.03.2018

 But         : <à compléter>

 Remarque(s) : <à compléter>

 Java : 1.8.0_161
 -----------------------------------------------------------------------------------
 */
package subject;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import observer.DisplayClock;
import observer.JClockTimer;
import observer.JNumericTimer;

public class Controller extends JFrame {

    JPanel pane = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    PersonalTimer pt = new PersonalTimer();

    public Controller() {
        add(pane);
        c.insets = new Insets(3, 3, 3, 3);
        c.fill = GridBagConstraints.HORIZONTAL;
        addButton("Horloge romaine", 0, 0, new JClockTimer("clock2.jpg"));
        addButton("Horloge arabe", 1, 0, new JClockTimer("clock1.jpg"));
        addButton("Horloge numérique", 2, 0, new JNumericTimer());
        addButton("Horloge mixte", 3, 0, new JClockTimer("clock2.jpg"), new JClockTimer("clock1.jpg"), new JNumericTimer());
        
        JButton b = new JButton("Démarrer");
        c.gridx = 0;
        c.gridy = 1;
        pane.add(b, c);
        b.addActionListener((ActionEvent e) -> {
            pt.start();
        });
        
        b = new JButton("Arreter");
        c.gridx = 1;
        c.gridy = 1;
        pane.add(b, c);
        b.addActionListener((ActionEvent e) -> {
            pt.pause();
        });
        
        b = new JButton("Réinitialiser");
        c.gridx = 2;
        c.gridy = 1;
        pane.add(b, c);
        b.addActionListener((ActionEvent e) -> {
            pt.reset();
        });
        
        b = new JButton("Quitter");
        c.gridx = 3;
        c.gridy = 1;
        pane.add(b, c);
        b.addActionListener((ActionEvent e) -> {
            System.exit(0);;
        });

        //FIXIT What's the problem?
        setSize(650, 200);
        setVisible(true);
    }
    
    //TODO ASK PROF HOW TO SET FRAME SIZE DEPENDING ON TIMER CHOICE
    private void addButton(String name, int x, int y, DisplayClock... timers) {
        JButton b = new JButton(name);
        c.gridx = x;
        c.gridy = y;
        pane.add(b, c);
        b.addActionListener((ActionEvent e) -> {
            JFrame clockFrame = new JFrame();
            clockFrame.setSize(400, 450);
            clockFrame.setVisible(true);
            GridBagConstraints cClock = new GridBagConstraints();
            cClock.insets = new Insets(3, 3, 3, 3);
            cClock.gridy = 0;
            for (int i = 0; i < timers.length; i++) {
                cClock.gridx = i;
                clockFrame.add(timers[i]);
                pt.attach(timers[i]);
            }
        });
    }
}
