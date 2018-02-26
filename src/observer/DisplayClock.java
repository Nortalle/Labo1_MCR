/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import javax.swing.JFrame;

/**
 *
 * @author samuel
 */
public abstract class DisplayClock extends JFrame implements Observer {

    @Override
    public abstract void update(int time);
    
    public abstract void init();
    
}
