/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : PersonalTimer.java
 Auteur(s)   : Samuel Mayoer et Vincent Guidoux
 Date        : 04.03.2018

 But         : <à compléter>

 Remarque(s) : <à compléter>

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
    private boolean paused;
    
    private void scheduleTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                time++;
                notifyObservers();
            }
        }, 1000, 1000);
    }
    
    public PersonalTimer() {
        observers = new LinkedList<>();
        
        time = 0;
        
        scheduleTimer();
        
        paused = false;
    }
    
    public int hours() {
        return time % 3600;
    }
    
    public int minutes() {
        return time % 60;
    }
    
    public int seconds() {
        return time;
    }
    
    public void reset() {
        time = 0;
        notifyObservers();
    }
    
    public void pause() {
        timer.cancel();
        paused = true;
    }
    
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
            o.update(time);
        });
    }
    
}
