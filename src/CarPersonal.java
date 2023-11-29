import java.awt.*;

public class CarPersonal extends Car  {
    @Override
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
            if (currentSpeed > enginePower){
                currentSpeed = enginePower;
            }
        }
    }
    @Override
    public void move() {
        x = x + currentSpeed * (int)Math.sin(Math.toRadians(direction));
        y = y + currentSpeed * (int)Math.cos(Math.toRadians(direction));
    }
    @Override
    public void startEngine() {
        currentSpeed = 0.1;
    }


}