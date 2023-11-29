import javax.swing.*;
import java.awt.*;
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

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>(); //drawpanel ska komma åt bilerna i listan och rita dem

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        int y_change= 0;
        CarController cc = new CarController();
        cc.cars.add((new Scania()));
        cc.cars.add(new Saab95());
        cc.cars.add(new Volvo240());
        for (int i=0; i<cc.cars.size();i+=1){
            cc.cars.get(i).y+=y_change;
            y_change+=100;

        }



        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc, cc.cars);

        // Start the timer
        cc.timer.start();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (Map.Entry<Car,BufferedImage> entry : frame.drawPanel.CarsAndPics.entrySet()) {
                Car car = entry.getKey();
                BufferedImage image = entry.getValue();
                if(car.getXPos()+ image.getWidth()> frame.getFrameX()|| car.getXPos()<0) {
                    car.invertDierction();
                }
                car.move();
                frame.drawPanel.repaint();                // repaint() calls the paintComponent method of the panel'
            }}
    }

    void gas(double amount) {
        double g = ( amount) / 100;
        for (Car car : cars) {
            car.gas(g);}}


    void brake(double amount){
        double brake = (amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    void startEngine() {
        for (Car car:cars) {
            car.startEngine();}
    }

    void stopEngine() {
        for (Car car:cars){
            car.stopEngine();}
    }


    void setTurboOn(){
        for (Car car : cars) {
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();}}
    }

    void setTurboOff(){
        for (Car car : cars) {
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();}}
    }


    void liftBedButton() {//open
        for (Car car : cars) {
            if (car instanceof Scania) {
                car.raise_flak();}}
    }

    void lowerBedButton() {//close
        for (Car car : cars) {
            if (car instanceof Scania) {
                car.lower_flak();}}
    }
}









