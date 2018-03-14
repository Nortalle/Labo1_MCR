/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : Subject.java
 Auteur(s)   : Samuel Mayor et Vincent Guidoux
 Date        : 04.03.2018

 But         : Subject of the Observable Model (GoF)

 Java : 1.8.0_161
 -----------------------------------------------------------------------------------
 */
package subject;

import observer.Observer;

public interface Subject {

   /**
    * Adds an observer to the set of observers for this subject
    *
    * @param o : Observer to add
    */
   public void attach(Observer o);

   /**
    * Removes an observer to the set of observers for this subject
    *
    * @param o : Observer to remove
    */
   public void detach(Observer o);

   /**
    * notify all of its observers and then call the clearChanged method to indicate
    * that this object has no longer changed.
    *
    */
   public void notifyObservers();
}
