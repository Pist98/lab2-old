
import java.awt.*;
import java.util.ArrayList;

public class MANTGX440 extends Truck {

    int max_load;
    boolean flak;


    ArrayList<Vehicle> loaded_vehicles =new ArrayList<Vehicle>();


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


    public void load(Vehicle vehicle) {
        if (loaded_vehicles.size() < 8 && (vehicle.getXPos()==getXPos())) {
            loaded_vehicles.add(vehicle);}
    }
    public void unload(){
        int last_car= loaded_vehicles.size() -1;
        loaded_vehicles.remove(last_car);
    }

    @Override public void move(){
        if (vinkel>0){
            x= getXPos();
            y=getYPos();
        }
        else {
            x = x + currentSpeed * (int)Math.cos(Math.toRadians(direction));
            y = y + currentSpeed * (int)Math.sin(Math.toRadians(direction));
            for (Vehicle vehicle : loaded_vehicles){
                vehicle.x=x;
                vehicle.y=y;
            }
        }}

}










