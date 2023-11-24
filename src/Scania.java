import java.awt.*;

public class Scania extends Car{

    double vinkel;
    boolean flak; //upp=false, ner=true

    public Scania(){
        nrDoors = 2;
        color = Color.white;
        enginePower = 530;
        modelName = "Scania";
        flak=true;
        stopEngine();
    }

    protected void check_flak() {
        if (getCurrentSpeed() !=0) {flak=false;}
    }

    public void raise_flak(int x){
        check_flak();
    if (flak){
         vinkel += x;
         if (vinkel > 70) {vinkel = 70;}
        }
    }

    public void lower_flak(int x){
        check_flak();
        if (flak){
            vinkel -= x;
            if (vinkel < 0) {vinkel = 0;}
            }
        }


    @Override
    public void gas(double amount) {
        if (flak){
            currentSpeed=0;
        }
        else {
        if (getCurrentSpeed() > 0 && amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
            if (currentSpeed > enginePower) {
                currentSpeed = enginePower;}
        }
        }
    }
}
