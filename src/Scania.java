import java.awt.*;

public class Scania extends Truck {

    public Scania(int x, int y){
        nrDoors = 2;
        color = Color.white;
        enginePower = 530;
        modelName = "Scania";
        flak=true;
        maxVinkel=70;
        changeVinkel=5;
        stopEngine();
        this.x = x;
        this.y = y;
    }


}


