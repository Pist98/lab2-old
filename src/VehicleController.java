import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class VehicleController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    VehicleView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>(); //drawpanel ska komma åt bilerna i listan och rita dem

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        int y_change= 0;
        VehicleController cc = new VehicleController();
        cc.vehicles.add((new Scania()));
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Volvo240());
        for (int i = 0; i<cc.vehicles.size(); i+=1){
            cc.vehicles.get(i).y+=y_change;
            y_change+=100;

        }



        // Start a new view and send a reference of self
        cc.frame = new VehicleView("CarSim 1.0", cc.vehicles);

        // Start the timer
        cc.timer.start();
    }


    private class TimerListener implements ActionListener {      // Borde vara del av View
        public void actionPerformed(ActionEvent e) {

            for (Map.Entry<Vehicle,BufferedImage> entry : frame.drawPanel.CarsAndPics.entrySet()) {
                Vehicle vehicle = entry.getKey();
                BufferedImage image = entry.getValue();
                if(vehicle.getXPos()+ image.getWidth()> frame.getFrameX()|| vehicle.getXPos()<0) {
                    vehicle.invertDierction();
                }
                vehicle.move();
                frame.drawPanel.repaint();                // repaint() calls the paintComponent method of the panel'
            }}
    }
}









