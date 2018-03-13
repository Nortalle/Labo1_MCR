/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : Subject.java
 Auteur(s)   : Samuel Mayer et Vincent Guidoux
 Date        : 04.03.2018

 But         : <à compléter>

 Remarque(s) : <à compléter>

 Java : 1.8.0_161
 -----------------------------------------------------------------------------------
*/package subject;


import observer.Observer;

public interface Subject {
   
   public void attach(Observer o);
   
   public void detach(Observer o);
   
   public void notifyObservers();
}
