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
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import observer.DisplayClock;
import observer.JClockTimer;
import observer.JNumericTimer;
import observer.Observer;

public class Controller extends JFrame {
    private final GridBagConstraints constraints = new GridBagConstraints();

    public Controller() {
        getContentPane().setLayout(new GridBagLayout());
        constraints.insets = new Insets(3, 3, 3, 3);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        addButton("Horloge romaine", 0, 0, new JClockTimer("clock2.jpg"));
        addButton("Horloge arabe", 0, 1, new JClockTimer("clock1.jpg"));
        addButton("Horloge numérique", 0, 2, new JNumericTimer());
        
        setSize(400, 200);
        setVisible(true);
    }

    private void addButton(String name, int x, int y, DisplayClock timer) {
        JButton b = new JButton(name);
        constraints.gridx = x;
        constraints.gridy = y;
        getContentPane().add(b, constraints);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonalTimer pt = new PersonalTimer();
                pt.attach(timer);
                timer.init();
            }
        });
    }
}
