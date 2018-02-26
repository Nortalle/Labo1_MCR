
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import observer.JNumericTimer;
import subject.PersonalTimer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Vincent Guidoux
 */
public class Labo1 {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
       PersonalTimer timer = new PersonalTimer();
       JNumericTimer numTimer = new JNumericTimer();
       timer.attach(numTimer);
   }
   
}
