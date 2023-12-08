import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;
import java.util.random.RandomGenerator;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.awt.event.ActionListener;


public class TimerListener implements ActionListener {
    VehicleController cc;


    public TimerListener(VehicleController cc){
        this.cc=cc;
    }
        public void actionPerformed(ActionEvent e) {
            for (Map.Entry<Vehicle, BufferedImage> entry : cc.frame.drawPanel.CarsAndPics.entrySet()) {
                Vehicle vehicle = entry.getKey();
                BufferedImage image = entry.getValue();
                if(vehicle.getXPos()+ image.getWidth()> cc.frame.getFrameX()|| vehicle.getXPos()<0) {
                    vehicle.invertDierction();
                }
                vehicle.move();
                cc.frame.drawPanel.repaint();  // repaint() calls the paintComponent method of the panel
            }}
    }

