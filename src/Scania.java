import java.awt.*;

public class Scania extends Car {

    double vinkel = 0;
    boolean flak; //upp (kan köra) =false, ner=true

    public Scania() {
        nrDoors = 2;
        color = Color.white;
        enginePower = 530;
        modelName = "Scania";
        flak = false;
        stopEngine();
    }

    protected void check_flak() {
        if (getCurrentSpeed() != 0) {   //kör så är flak false
            flak = false;
        } else if (getCurrentSpeed() == 0) {
            flak = true;
        }
    }


    public void raise_flak(int x) {
        check_flak();
        if (flak == true) {
            vinkel += x;
            if (vinkel > 70) {
                vinkel = 70;
            }
        }
    }

    public void lower_flak(int x) {
        check_flak();
        if (flak == true) {
            vinkel -= x;
            if (vinkel < 0) {
                vinkel = 0;
                flak = false;
            }
        }
    }


    @Override
    protected void startEngine() {
        if (flak == false) {
            currentSpeed = 0.1;
        }
    }



    @Override
    public void gas(double gasamount) {
        if (flak == true) {
            currentSpeed = 0;
        } else {
            if (getCurrentSpeed() > 0 && gasamount >= 0 && gasamount <= 1) {
                incrementSpeed(gasamount);
                if (currentSpeed > enginePower) {
                    currentSpeed = enginePower;
                }
            }
        }
    }

    @Override
    public void brake(double brakeamount) {
        if (getCurrentSpeed() > 0 && brakeamount >= 0 && brakeamount <= 1) {
            decrementSpeed(brakeamount);
            if (currentSpeed < 0) {
                currentSpeed = 0;
            }
        }
    }

}



