import java.awt.*;

public class Saab95 extends Car {

    //subclass adds one more field


    protected Saab95(int x, int y){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
        this.x = x;
        this.y = y;
    }

    protected void setTurboOn(){
        turboOn = true;
    }

    protected void setTurboOff(){
        turboOn = false;
    }

    @Override protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

}

