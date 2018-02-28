/*
 -----------------------------------------------------------------------------------
 Laboratoire : 1
 Fichier     : JNumericTimer.java
 Auteur(s)   : Samuel Mayor et Vincent Guidoux
 Date        : 04.03.2018

 But         : <à compléter>

 Remarque(s) : <à compléter>

 Java : 1.8.0_161
 -----------------------------------------------------------------------------------
*/
package observer;
import javax.swing.*;

public class JNumericTimer extends DisplayClock {
    JLabel labelTime;
    
    public JNumericTimer() {
        labelTime = new JLabel(formatTime(0));
        labelTime.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelTime);
    }

    @Override
    public void update(int time) {
        labelTime.setText(formatTime(time));
    }
    
    private String formatTime(int time) {
        return String.format("%02dh %02dm %02ds", (time/3600), (time/60)%60, time%60);
    }
}
