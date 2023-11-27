import java.awt.*;

public class Car implements Movable  {

    protected int nrDoors;
    protected double vinkel;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;
    protected String modelName;
    protected int direction=90;
    public double x;
    public double y;
    boolean flak= true;
    protected int last;
    public double getXPos() {
        return x;
    }
    public double getYPos() {
        return y;
    }


    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double get_vinkel() {
        return vinkel;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    protected double speed() {     // ?
        return currentSpeed;
    }

    protected void startEngine() {
        currentSpeed = 0.1;
    }

    protected void stopEngine() {
        currentSpeed = 0;
    }

    protected double speedFactor() {
        return enginePower * 0.01;      //Override in subclasses
    }

    protected void incrementSpeed(double gasamount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * gasamount, enginePower);
    }
    protected void decrementSpeed(double brakeamount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * brakeamount, 0);
    }

    public void gas(double gasamount) {
        if (getCurrentSpeed() > 0 && gasamount >= 0 && gasamount <= 1) {
            incrementSpeed(gasamount);
            if (currentSpeed > enginePower){
                currentSpeed = enginePower;
            }
        }
    }

    public void brake(double brakeamount) {
        if (brakeamount>= 0 && brakeamount <= 1) {
            decrementSpeed(brakeamount);
            if (currentSpeed < 0) {
                currentSpeed = 0;
            }
        }
    }
    public void move() {
        x = x + currentSpeed * (int)Math.cos(Math.toRadians(direction));
        y = y + currentSpeed * (int)Math.sin(Math.toRadians(direction));
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

}