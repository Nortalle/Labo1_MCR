
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
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
       PersonalTimer pt = new PersonalTimer();
       Timer timer = new Timer();
       timer.schedule(new TimerTask() {
           @Override
           public void run() {
               System.out.println(pt); 
           }
       }, 0, 1000);
   }
   
}
