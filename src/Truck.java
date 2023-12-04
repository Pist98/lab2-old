public class Truck extends Vehicle {

    protected boolean flak;
    protected int maxVinkel;
    protected int changeVinkel;


    @Override
    public void move() {
        check_flak();
        if (flak){
            x=getXPos();
            y=getYPos();
        }
        else {
            x = x + currentSpeed * (int)Math.sin(Math.toRadians(direction));
            y = y + currentSpeed * (int)Math.cos(Math.toRadians(direction));
        }

    }

    @Override
    public void gas(double amount) {
        check_flak();
        if (flak){
            currentSpeed=0;
        }
        else {
            if (amount >= 0 && amount <= 1) {
                incrementSpeed(amount);
                if (currentSpeed > enginePower) {
                    currentSpeed = enginePower;}}
        }}


    public void check_flak() {
        if (get_vinkel()>0) {flak=true;}
        else {flak=false;}

    }

    public void raise_flak(){
        if (getCurrentSpeed()==0){
            vinkel += changeVinkel;
            flak=true;
            if (vinkel > maxVinkel) {vinkel = maxVinkel;}
        }
    }

    public void lower_flak(){
        if (getCurrentSpeed()==0){
            vinkel -= changeVinkel;
            flak=true;
            if (get_vinkel() < 0) {vinkel = 0;}}
    }
}
