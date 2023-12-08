import java.awt.*;

public class Vehicle implements Movable {

    protected int nrDoors;
    protected boolean turboOn;
    protected double vinkel;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;
    protected String modelName;
    protected int direction = 90;
    protected double x;
    protected double y;


    public double getXPos() {
        return x;
    }
    public double getYPos() {
        return y;
    }
    public int getNrDoors() {
        return nrDoors;
    }

    protected double getEnginePower() {
        return enginePower;
    }

    protected double getCurrentSpeed() {
        return currentSpeed;
    }

    protected double get_vinkel() {
        return vinkel;
    }

    protected Color getColor() {
        return color;
    }

    protected void setColor(Color clr) {
        color = clr;
    }

    protected double speed() {     // ?
        return currentSpeed;
    }

    protected void stopEngine() {
        currentSpeed = 0;
    }

    protected double speedFactor() {
        return enginePower * 0.01;      //Override in subclasses
    }

    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }


    public void brake(double amount) {
        if (amount>= 0 && amount <= 1) {
            decrementSpeed(amount);
            if (currentSpeed < 0) {
                currentSpeed = 0;
            }
        }
    }


    public void turnLeft() {
        direction = ((direction - 90)%360);
        if (direction < 0) {
            direction += 360;
        }
    }

    public void turnRight () {
        direction = (direction + 90)%360;
    }



    protected void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
            if (currentSpeed > enginePower){
                currentSpeed = enginePower;
            }
        }
    }
    public void move() {
        x = x + currentSpeed * (int)Math.sin(Math.toRadians(direction));
        y = y + currentSpeed * (int)Math.cos(Math.toRadians(direction));
    }
    protected void startEngine() {
        currentSpeed = 0.1;
    }
    protected void invertDierction(){
        currentSpeed=-currentSpeed;
    }


}
