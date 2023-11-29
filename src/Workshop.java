import java.util.ArrayList;

public class Workshop < T extends Car> {

    int max=8;
    ArrayList<Car> loaded_cars = new ArrayList <>();
    ArrayList<Car> unloaded_car = new ArrayList <>();



    public void load(Car car) {
        if (loaded_cars.size() < max) {
            loaded_cars.add(car);}
    }

    public void unload(){
        int last_car= loaded_cars.size() -1;
        unloaded_car.add(loaded_cars.remove(last_car));
        loaded_cars.remove(last_car);
    }
}
