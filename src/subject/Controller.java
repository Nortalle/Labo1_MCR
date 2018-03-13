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

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
    GridBagConstraints c = new GridBagConstraints();
    PersonalTimer pt = new PersonalTimer();;

    public Controller() {
        add(pane);
        c.insets = new Insets(3, 3, 3, 3);
        c.fill = GridBagConstraints.HORIZONTAL;
        
        JButton b = new JButton("Horloge romaine");
        c.gridx = 0;
        c.gridy = 0;
        pane.add(b, c);
         b.addActionListener((ActionEvent e) -> {
             newFrame(500, 520, new JClockTimer("clock2.jpg"));
        });
        
        b = new JButton("Horloge arabe");
        c.gridx = 1;
        c.gridy = 0;
        pane.add(b, c);
        b.addActionListener((ActionEvent e) -> {
            newFrame(500, 520, new JClockTimer("clock1.jpg"));
        });
        
        b = new JButton("Horloge numérique");
        c.gridx = 2;
        c.gridy = 0;
        pane.add(b, c);
        b.addActionListener((ActionEvent e) -> {
            newFrame(300, 100, new JNumericTimer());
        });
        
        b = new JButton("Horloge mixte");
        c.gridx = 3;
        c.gridy = 0;
        pane.add(b, c);
        b.addActionListener((ActionEvent e) -> {
            newFrame(400, 700, new JClockTimer("clock2.jpg"), new JClockTimer("clock1.jpg"), new JNumericTimer());
        });
        
        b = new JButton("Démarrer");
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

        setSize(650, 200);
        setVisible(true);
    }
    
    private void newFrame(int width, int height, DisplayClock... clocks) {
        JFrame clockFrame = new JFrame();
        clockFrame.setSize(width, height);
        clockFrame.setVisible(true);
        if (clocks.length > 1) 
            clockFrame.setLayout(new FlowLayout());
            
        for (DisplayClock clock : clocks) {
            clock.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (pt.paused()) pt.start();
                else pt.pause();
            }
        });
            clockFrame.add(clock);
            pt.attach(clock);
        }
    }
}
