
import java.awt.*;
import java.util.ArrayList;

public class MANTGX440 extends Car {

    int max_load;
    boolean flak;


    ArrayList<Car> loaded_cars =new ArrayList<Car>();


    public MANTGX440() {
        nrDoors = 2;
        color = Color.black;
        enginePower = 530;
        modelName = "MANTGX440";
        max_load = 8;
        changeVinkel=120;
        maxVinkel=120;
        stopEngine();

    }


    public void load(Car car) {
        if (loaded_cars.size() < 8 && (car.getXPos()==getXPos())) {
            loaded_cars.add(car);}
    }
    public void unload(){
        int last_car= loaded_cars.size() -1;
        loaded_cars.remove(last_car);
    }

    @Override public void move(){
        if (vinkel>0){
            x= getXPos();
            y=getYPos();
        }
        else {
            x = x + currentSpeed * (int)Math.cos(Math.toRadians(direction));
            y = y + currentSpeed * (int)Math.sin(Math.toRadians(direction));
            for (Car car :loaded_cars){
                car.x=x;
                car.y=y;
            }
        }}

}










