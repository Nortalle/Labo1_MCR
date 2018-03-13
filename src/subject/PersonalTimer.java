/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : PersonalTimer.java
 Auteur(s)   : Samuel Mayoer et Vincent Guidoux
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
    
    private void scheduleTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                time++;
                notifyObservers();
            }
        }, 10, 10);
    }
    
    public PersonalTimer() {
        observers = new LinkedList<>();
        
        time = 0;
    }
    
    public int hours() {
        return time / 3600;
    }
    
    public int minutes() {
        return (time / 60) % 60;
    }
    
    public int seconds() {
        return time % 60;
    }
    
    public boolean paused() {
        return paused;
    }
    
    public void reset() {
        time = 0;
        notifyObservers();
    }
    
    public void pause() {
        if (!paused) {
            timer.cancel();
            paused = true;
        }
        
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
            o.update(this);
        });
    }
}
