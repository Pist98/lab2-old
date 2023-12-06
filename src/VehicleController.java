import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;
public class VehicleController extends JFrame {

    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    VehicleView frame;
    // A list of vehicles, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>(); //drawpanel ska komma åt bilerna i listan och rita dem

    //methods:
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount ;
    int breakAmount;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");



    public static void main(String[] args) {
        // Instance of this class
        int y_change= 0;
        VehicleController cc = new VehicleController();
        cc.vehicles.add((new Scania()));
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Volvo240());
        for (int i=0; i<cc.vehicles.size();i+=1){
            cc.vehicles.get(i).y+=y_change;
            y_change+=100;
        }



        // Start a new view and send a reference of self
        cc.frame = new VehicleView("VehicleSim 1.0", cc, cc.vehicles);

        // Start the timer
        cc.timer.start();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (Map.Entry<Vehicle, BufferedImage> entry : frame.drawPanel.CarsAndPics.entrySet()) {
                Vehicle vehicle = entry.getKey();
                BufferedImage image = entry.getValue();
                if(vehicle.getXPos()+ image.getWidth()> frame.getFrameX()|| vehicle.getXPos()<0) {
                    vehicle.invertDierction();
                }
                vehicle.move();
                frame.drawPanel.repaint();                // repaint() calls the paintComponent method of the panel'
            }}
    }


    void gas(double amount) {
        double g = ( amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(g);}}


    void brake(double amount){
        double brake = (amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }
    void startEngine() {
        for (Vehicle vehicle:vehicles) {
            vehicle.startEngine();}
    }

    void stopEngine() {
        for (Vehicle vehicle:vehicles){
            vehicle.stopEngine();}
    }


    void setTurboOn(){
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOn();}}
    }

    void setTurboOff(){
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOff();}}
    }


    void liftBedButton() {//open
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Truck)vehicle).raise_flak();}}
    }

    void lowerBedButton() {//close
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Truck)vehicle).lower_flak();}}
    }






}



