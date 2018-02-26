/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : DisplayClock.java
 Auteur(s)   : Samuel Mayoer et Vincent Guidoux
 Date        : 04.03.2018

 But         : <à compléter>

 Remarque(s) : <à compléter>

 Java : 1.8.0_161
 -----------------------------------------------------------------------------------
*/
package observer;

import javax.swing.JFrame;

public abstract class DisplayClock extends JFrame implements Observer {
    @Override
    public abstract void update(int time);
    
    public abstract void init();
    
}
