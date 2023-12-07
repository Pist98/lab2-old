import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
//Skriva ett test för att kolla falk
public class test_MANTGX440 {


    private Volvo240 volvo1;
    private Volvo240 volvo2;



    @Before
    public void init() {
        int x = 0;
        int y = 0;
        volvo1 = new Volvo240(x,y);
        volvo2 = new Volvo240(x,y);
    }

/*
    @Test
    public void Move_when_flak_is_open(){
        MANTGX440 truck = new MANTGX440();
        truck.flak=true;
        truck.gas(0.7);
        assertTrue(truck.getCurrentSpeed()==0);
    }

 */




    @Test
    public void load_on_cars() {
        MANTGX440 truck = new MANTGX440();
        truck.load(volvo1);
        truck.load(volvo2);
        truck.unload();
        assertTrue(truck.loaded_vehicles.size()==1);
    }
    @Test
    public void Check_pos_for_the_loaded_cars() {
        MANTGX440 truck = new MANTGX440();
        truck.load(volvo1);
        truck.load(volvo2);
        truck.startEngine();
        truck.move();
        truck.move();
        double y1= truck.y;
        double y2= volvo1.y;
        double y3= volvo2.y;
        assertTrue(y1==y2& y2==y3);
    }
    @Test
    public void load_on_cars_then_move() {
        MANTGX440 truck = new MANTGX440();
        double y0=truck.getYPos();
        truck.load(volvo1);
        truck.startEngine();
        truck.move();
        assertTrue(truck.getYPos()>y0);
    }




}

