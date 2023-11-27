import java.awt.*;

public class CarPersonal extends Car {

    @Override
    public void gas(double amount) {
        if (getCurrentSpeed() > 0 && amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
            if (currentSpeed > enginePower){
                currentSpeed = enginePower;
            }
        }
    }


}