package subject;


import observer.Observer;

/**
 *
 * @author Vincent Guidoux
 */
public interface Subject {
   
   public void attach(Observer o);
   
   public void detach(Observer o);
   
   public void notifyObservers();
}
