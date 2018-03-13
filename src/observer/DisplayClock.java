/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : DisplayClock.java
 Auteur(s)   : Samuel Mayor et Vincent Guidoux
 Date        : 04.03.2018

 But         : <à compléter>

 Java : 1.8.0_161
 -----------------------------------------------------------------------------------
*/
package observer;

import javax.swing.JPanel;

public abstract class DisplayClock extends JPanel implements Observer {
    @Override
    public abstract void update(int time);
}
