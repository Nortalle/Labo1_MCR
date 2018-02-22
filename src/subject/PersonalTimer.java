/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subject;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import observer.Observer;

/**
 *
 * @author samuel
 */
public class PersonalTimer implements Subject {
    private final LinkedList<Observer> observers;
    private final Timer timer;
    private int seconds;
    private int minutes;
    private int hours;
    
    public PersonalTimer() {
        observers = new LinkedList<>();
        
        seconds = 0;
        minutes = 0;
        hours = 0;
        
        timer = new Timer();
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                seconds++;
                if (seconds == 59) seconds = 0;
            }
        }, 1000, 1000);
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                minutes++;
                if (minutes == 59) minutes = 0;
            }
        }, 60000, 60000);
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                hours++;
            }
        }, 3600000, 3600000);
    }
    
    @Override
    public String toString() {
        return String.format("%02dh %02dm %02ds", hours, minutes, seconds);
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
            o.update();
        });
    }
    
}