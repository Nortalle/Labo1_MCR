/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : DisplayClock.java
 Auteur(s)   : Samuel Mayor et Vincent Guidoux
 Date        : 04.03.2018

 But         : A class who implements Observer and exdents Jpanel
               So it makes a diplayable and observer clock 

 Java : 1.8.0_161
 -----------------------------------------------------------------------------------
*/
package observer;

import javax.swing.JPanel;
import subject.PersonalTimer;

public abstract class DisplayClock extends JPanel implements Observer {
   
    @Override
    public abstract void update(PersonalTimer time);
}
