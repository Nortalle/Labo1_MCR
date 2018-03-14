/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : JNumericTimer.java
 Auteur(s)   : Samuel Mayor et Vincent Guidoux
 Date        : 04.03.2018

 But         : Class which represents a Numeric timer with hh:mm:ss

 Java : 1.8.0_161
 -----------------------------------------------------------------------------------
 */
package observer;

import javax.swing.*;
import subject.PersonalTimer;

public class JNumericTimer extends DisplayClock {

   JLabel labelTime;

   /**
    * Constructor who sets the initial value and the JLabel we're going to use
    */
   public JNumericTimer() {
      labelTime = new JLabel(formatTime(0, 0, 0));
      labelTime.setHorizontalAlignment(SwingConstants.CENTER);
      add(labelTime);
   }

   @Override
   public void update(PersonalTimer time) {
      labelTime.setText(formatTime(time));
   }

   /**
    * Format the time to a readable String hh:mm:ss
    *
    * @param time : time to display
    * @return : formated time to display
    */
   private String formatTime(PersonalTimer time) {
      return formatTime(time.hours(), time.minutes(), time.seconds());
   }

   /**
    * Format the time to a readable String hh:mm:ss
    *
    * @param hours : hours to display
    * @param minutes : minutes to display
    * @param seconds : seconds to display
    * @return : formated time to display
    */
   private String formatTime(int hours, int minutes, int seconds) {
      return String.format("%02dh %02dm %02ds", hours, minutes, seconds);
   }
}
