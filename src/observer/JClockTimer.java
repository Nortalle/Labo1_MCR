/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author samuel
 */
public class JClockTimer extends DisplayClock implements Observer {
    private final String image;
    private Image clock;

    public JClockTimer(String image) {
        this.image = image;
    }

    @Override
    public void update(int time) {
        
    }

    @Override
    public void init() {
        clock = Toolkit.getDefaultToolkit().getImage(image);
        clock = clock.getScaledInstance(400, 400, 0);
        add(new JLabel(new ImageIcon(clock)));
        setSize(400, 400);
        setVisible(true);
    }
}
