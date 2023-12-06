import java.util.ArrayList;

public class Workshop < T extends Car> {

    int max=8;
    ArrayList<Car> loaded_vehicles = new ArrayList <>();
    ArrayList<Car> unloaded_vehicle = new ArrayList <>();



    public void load(Car vehicle) {
        if (loaded_vehicles.size() < max) {
            loaded_vehicles.add(vehicle);}
    }

    public void unload(){
        int last_car= loaded_vehicles.size() -1;
        unloaded_vehicle.add(loaded_vehicles.remove(last_car));
        loaded_vehicles.remove(last_car);
    }
}
