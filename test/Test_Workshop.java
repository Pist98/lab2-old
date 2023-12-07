import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test_Workshop {

    private Volvo240 volvo1;
    private Volvo240 volvo2;
    private Saab95 saab1;
    private Saab95 saab2;
    private Workshop<Car> wsc;


    @Before
    public void init() {
        int x = 0;
        int y = 0;
        volvo1 = new Volvo240(x,y);
        volvo2 = new Volvo240(x,y);
        saab1 = new Saab95(x,y);
        saab2 = new Saab95(x,y);
        wsc = new Workshop<Car>();
    }

/*
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
 */

    public void load_on_cars_all() {
        wsc.load(saab1);
        wsc.load(volvo2);
        wsc.load(saab2);
        System.out.println(wsc.loaded_vehicles);
        assertTrue(wsc.loaded_vehicles.size()==3);
    }


    /*
    @Test
    public void unload_on_cars() {
        wsc.load(volvo1);
        wsc.load(saab1);
        wsc.unload();

        assertTrue(wsc.loaded_vehicles.size()==1);
    }
    @Test
    public void check_unloaded_cars() {
        wsc.load(volvo1);
        wsc.load(saab1);
        Vehicle last_vehicle = wsc.loaded_vehicles.get(1);
        wsc.unload();
        System.out.println(wsc.unloaded_vehicle);

        assertTrue(last_vehicle == wsc.unloaded_vehicle.get(0));
    }

     */

    @Test
    public void load_more_than_limit() {
        for (int i = 0; i < 15; i++) {
            wsc.load(saab2);
        }
        assertTrue(wsc.loaded_vehicles.size()==8);
    }


}
