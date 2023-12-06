import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ButtonAction extends VehicleController {

    public ArrayList<Vehicle> vehicles;
    int breakAmount;
    int gasAmount;
    DefButtons defButtons;
    VehicleView vv;
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    //VehicleController.TimerListener t;

    public ButtonAction(ArrayList<Vehicle> vehicles, int breakAmount, int gasAmount) {
        this.vehicles = vehicles;
        this.gasAmount = gasAmount;
        this.breakAmount = breakAmount;
        defButtons = new DefButtons(vehicles);
        vv = new VehicleView("CarSim 1.0", vehicles);
        //t = new VehicleController.TimerListener();

        vv.brakeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e) {
                defButtons.brake(breakAmount);
            }});

        vv.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defButtons.gas(gasAmount);
            }});

        vv.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defButtons.startEngine();}});

        vv.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defButtons.stopEngine();}});

        vv.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defButtons.setTurboOff();}});
        vv.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defButtons.setTurboOn();}});
        vv.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defButtons.liftBedButton();}});
        vv.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defButtons.lowerBedButton();}});

        timer.start();


    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            for (Map.Entry<Vehicle, BufferedImage> entry : vv.drawPanel.CarsAndPics.entrySet()) {
                Vehicle vehicle = entry.getKey();
                BufferedImage image = entry.getValue();
                if(vehicle.getXPos()+ image.getWidth()> vv.getFrameX()|| vehicle.getXPos()<0) {
                    vehicle.invertDierction();
                }
                vehicle.move();
                vv.drawPanel.repaint();   // repaint() calls the paintComponent method of the panel'
            }}
    }



}








