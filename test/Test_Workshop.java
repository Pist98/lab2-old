import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test_Workshop {
    Volvo240 volvo1 = new Volvo240();
    Volvo240 volvo2 = new Volvo240();
    Saab95 saab1 = new Saab95();
    Saab95 saab2 = new Saab95();


    @Test
    public void load_on_cars_volvo() {
        Workshop<Volvo240> workshop = new Workshop<Volvo240>();
        workshop.load(saab1);
        workshop.load(volvo2);
        workshop.load(saab2);
        System.out.println(workshop.loaded_vehicles);
        assertTrue(workshop.loaded_vehicles.size()==3);
    }

    public void load_on_cars() {
        Workshop<Saab95> workshop = new Workshop<Saab95>();
        workshop.load(saab1);
        workshop.load(volvo2);
        workshop.load(saab2);
        System.out.println(workshop.loaded_vehicles);
        assertTrue(workshop.loaded_vehicles.size()==2);
    }

    public void load_on_cars_all() {
        Workshop<Vehicle> workshop = new Workshop<Vehicle>();
        workshop.load(saab1);
        workshop.load(volvo2);
        workshop.load(saab2);
        System.out.println(workshop.loaded_vehicles);
        assertTrue(workshop.loaded_vehicles.size()==3);
    }


    @Test
    public void unload_on_cars() {
        Workshop<Vehicle> car_workshop = new Workshop<Vehicle>();
        car_workshop.load(volvo1);
        car_workshop.load(saab1);
        car_workshop.unload();

        assertTrue(car_workshop.loaded_vehicles.size()==1);
    }
    @Test
    public void check_unloaded_cars() {
        Workshop<Vehicle> workshop = new Workshop<Vehicle>();
        workshop.load(volvo1);
        workshop.load(saab1);
        Vehicle last_vehicle = workshop.loaded_vehicles.get(1);
        workshop.unload();
        System.out.println(workshop.unloaded_vehicle);

        assertTrue(last_vehicle == workshop.unloaded_vehicle.get(0));
    }

    @Test
    public void load_more_than_limit() {
        Workshop workshop = new Workshop();
        for (int i = 0; i < 15; i++) {
            workshop.load(saab2);
        }
        assertTrue(workshop.loaded_vehicles.size()==8);
    }


}
