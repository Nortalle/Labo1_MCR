/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : PersonalTimer.java
 Auteur(s)   : Samuel Mayor et Vincent Guidoux
 Date        : 04.03.2018

 But         : Concret Subject of the Observable model (GoF)

 Java : 1.8.0_161
 -----------------------------------------------------------------------------------
*/
package subject;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import observer.Observer;

public class PersonalTimer implements Subject {
    private final LinkedList<Observer> observers;
    private Timer timer;
    private int time;
    private boolean paused = true;
    
    /**
     * Initialise the Iimer, and set the seconds time
     */
    private void scheduleTimer() {
        timer = new Timer();
        // Every schedule of the timer, one second is added and all the observers 
        // are notified
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                time++;
                notifyObservers();
            }
        }, 1000, 1000);
    }
    
    /**
     * Initialisation
     */
    public PersonalTimer() {
        observers = new LinkedList<>();
        
        time = 0;
    }
    
    /**
     * @return the number of hours passed
     */
    public int hours() {
        return time / 3600;
    }
    
    /**
     * @return the number of minutes passed
     */
    public int minutes() {
        return (time / 60) % 60;
    }
    
    /**
     * @return the number of seconds passed
     */
    public int seconds() {
        return time % 60;
    }
    
    /**
     * @return if the clock is paused
     */
    public boolean paused() {
        return paused;
    }
    
    /**
     * resets the clock to 0 and notify the observers
     */
    public void reset() {
        time = 0;
        notifyObservers();
    }
    
    /**
     * Pauses the clock if not already paused
     */
    public void pause() {
        if (!paused) {
            timer.cancel();
            paused = true;
        }
    }
    
    /**
     * Starts the clock if paused
     */
    public void start() {
        if (paused) {
            paused = false;
            scheduleTimer();
        }
    }
    
    
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }
    
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }
    
    @Override
    public void notifyObservers() {
        observers.stream().forEach((o) -> {
            o.update(this);
        });
    }
}
