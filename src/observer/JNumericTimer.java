/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;
import javax.swing.*;

/**
 *
 * @author samuel
 */
public class JNumericTimer extends JFrame implements Observer {
    JLabel labelTime;
    
    public JNumericTimer() {
        JFrame frame = new JFrame();
        labelTime = new JLabel(formatTime(0));
        labelTime.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(labelTime);
        frame.setSize(400,200);
        frame.setVisible(true);
    }

    @Override
    public void update(int time) {
        labelTime.setText(formatTime(time));
    }
    
    private String formatTime(int time) {
        return String.format("%02dh %02dm %02ds", (time/3600), (time/60)%60, time%60);
    }
}
