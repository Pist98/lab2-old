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
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.LinkedHashMap;



public class VehicleController extends JFrame {
    VehicleView frame;
    TimerListener timerListener;
    /*
    private final int delay = 50;

    private Timer timer = new Timer(delay, new TimerListener(frame));
*/
    ArrayList<Vehicle> vehicles = new ArrayList<>(); //drawpanel ska komma åt bilerna i listan och rita dem

    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();

    int gasAmount;
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
    JButton addCar = new JButton("Add car");
    JButton removeCar = new JButton("Remove car");


    protected void blala(VehicleController cc) {

        SpinnerModel spinnerModel = new SpinnerNumberModel(0, //initial value
                0, //min
                100, //max
                1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
                breakAmount = gasAmount;

            }
        });


        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        cc.frame.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 6));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addCar, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(lowerBedButton, 6);
        controlPanel.add(removeCar, 7);


        controlPanel.setPreferredSize(new Dimension((frame.getFrameX() / 2) + 6, 200));
        cc.frame.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(frame.getFrameX() / 5 - 15, 200));
        cc.frame.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(frame.getFrameX() / 5 - 15, 200));

        cc.frame.add(stopButton);
    }

    public void action(VehicleController cc) {


        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(breakAmount);
            }
        });

        gasButton.addActionListener(new ActionListener() { //Anropar gas.Amount
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startEngine();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopEngine();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOff();
            }
        });
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOn();
            }
        });
        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBedButton();
            }
        });
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBedButton();
            }
        });


        addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCar(cc.vehicles);
            }
        });


        removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCar(cc.vehicles);
            }
        });
    }

    public int randomGen(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) { //den var static
        // Instance of this class
        final int delay = 50;
        int y_change = 0;
        VehicleController cc = new VehicleController();

        for (int i = 0; i < cc.vehicles.size(); i += 1) {
            cc.vehicles.get(i).y += y_change;
            y_change += 100;
        }

        Timer timer = new Timer(delay, new TimerListener(cc));
        // Start a new view and send a reference of self
        cc.action(cc);
        cc.frame = new VehicleView("VehicleSim 1.0", cc.vehicles);
        cc.blala(cc);
        // Start the timer
        timer.start();
    }


    void gas(double amount) {
        double g = (amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(g);
        }
    }


    void brake(double amount) {
        double brake = (amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    void startEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    void setTurboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }


    void liftBedButton() {//open
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Truck) vehicle).raise_flak();
            }
        }
    }

    void lowerBedButton() {//close
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Truck) vehicle).lower_flak();
            }
        }
    }

    void addCar(ArrayList<Vehicle> vehicles) {
        int maxCarsToAdd = 10 - vehicles.size();

        Random r = new Random();
        int y = r.nextInt(0, 400);
        int x = r.nextInt(0, 400);

        if (vehicles.size() < 10) {
            int rand = r.nextInt(0, 3);

            if (rand == 0) {
                vehicles.add(new Saab95(x, y));
            } else if (rand == 1) {
                vehicles.add(new Scania(x, y));
            } else {
                vehicles.add(new Volvo240(x, y));
            }

            try {
                Vehicle newVehicle = vehicles.get(vehicles.size() - 1);
                BufferedImage newImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + newVehicle.modelName + ".jpg"));
                frame.drawPanel.Image.add(newImage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            frame.drawPanel.setListForPics();
            frame.drawPanel.repaint();

            System.out.println(rand);
            System.out.println(vehicles.size());

        }
    }


    void removeCar(ArrayList<Vehicle> vehicles) {
        if (vehicles.size() > 0) {

            int p = vehicles.size() - 1;
            vehicles.remove(p);
            frame.drawPanel.Image.remove(p);

            Vehicle lastVehicle = null;

            for (Vehicle vehicle : frame.drawPanel.CarsAndPics.keySet()) {
                lastVehicle = vehicle;
            }

            if (lastVehicle != null) {
                frame.drawPanel.CarsAndPics.remove(lastVehicle);
            }

            frame.drawPanel.setListForPics();
            frame.drawPanel.repaint();

        }

    }
}


























/*
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Map.Entry<Vehicle, BufferedImage> entry : frame.drawPanel.CarsAndPics.entrySet()) {
                Vehicle vehicle = entry.getKey();
                BufferedImage image = entry.getValue();
                if(vehicle.getXPos()+ image.getWidth()> frame.getFrameX()|| vehicle.getXPos()<0) {
                    vehicle.invertDierction();
                }
                vehicle.move();
                frame.drawPanel.repaint();  // repaint() calls the paintComponent method of the panel
            }}
    }
*/
