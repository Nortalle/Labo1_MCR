/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : Observer.java
 Auteur(s)   : Samuel Mayor et Vincent Guidoux
 Date        : 04.03.2018

 But         : Observer of the Observer model (GoF)

 Java : 1.8.0_161
 -----------------------------------------------------------------------------------
*/
package observer;

import subject.PersonalTimer;

public interface Observer {
   
   /**
    * This method is called whenever the observed object is changed.
    * 
    * @param time    : Subject who changed
    */
    public void update(PersonalTimer time);
}
