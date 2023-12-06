import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class VehicleController {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    VehicleView frame;
    //DefButtons defButtons;
    ButtonAction buttonAction;

    int gasAmount ;
    int breakAmount;

    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>(); //drawpanel ska komma åt bilerna i listan och rita dem


    //public VehicleController(ArrayList<Vehicle> vehicles){this.defButtons = new DefButtons(vehicles);}

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
            y_change+=100;}

        cc.frame = new VehicleView("CarSim 1.0", cc.vehicles);

        SpinnerModel spinnerModel = new SpinnerNumberModel(0, //initial value
                0, //min
                100, //max
                1);//step

        cc.frame.gasSpinner = new JSpinner(spinnerModel);

        cc.frame.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                System.out.println("cc.gasAmount körs");
                cc.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
                cc.breakAmount = cc.gasAmount;
            }});
        cc.buttonAction= new ButtonAction(cc.vehicles, cc.breakAmount, cc.gasAmount);


    }

        // Start a new view and send a reference of self

        // Start the timer
        //cc.timer.start();

/*
    public class TimerListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            for (Map.Entry<Vehicle, BufferedImage> entry : frame.drawPanel.CarsAndPics.entrySet()) {
                Vehicle vehicle = entry.getKey();
                BufferedImage image = entry.getValue();
                if(vehicle.getXPos()+ image.getWidth()> frame.getFrameX()|| vehicle.getXPos()<0) {
                    vehicle.invertDierction();
                }
                vehicle.move();
                frame.drawPanel.repaint();   // repaint() calls the paintComponent method of the panel'
            }}
    }


    /*private TimerListener timerListener = new TimerListener();

    public TimerListener getTimerListener() {
        return timerListener;
    }*/
}













