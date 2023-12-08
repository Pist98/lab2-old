import java.awt.*;

public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;  // subclass adds one more field

    protected Volvo240(int x, int y) {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
        this.x = x;
        this.y = y;
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }


}

