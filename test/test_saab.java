import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class test_saab {


    private Saab95 setsaab;

    @Before
    public void init() {
        int x = 0;
        int y = 0;
        setsaab = new Saab95(x,y);
    }


    @Test
    public void nr_doors_saab95() {
        int doors = setsaab.getNrDoors();
        assertTrue(doors == 2);
    }


    @Test
    public void test_gas_saab95() {
        setsaab.startEngine();
        double current_speed_1 = setsaab.getCurrentSpeed();
        setsaab.gas(0.7);
        double current_speed_2 = setsaab.getCurrentSpeed();
        assertTrue(current_speed_2 > current_speed_1);

    }

    @Test
    public void test_break_saab95() {
        setsaab.startEngine();  // speed 0.1 always
        double current_speed_1 = setsaab.getCurrentSpeed();
        setsaab.brake(0.7);
        double current_speed_2 = setsaab.getCurrentSpeed();

        assertTrue(current_speed_2 < current_speed_1);
    }

    @Test
    public void test_break_saab95_amount_out_of_high_bound_saab95() {
        setsaab.startEngine();  // speed 0.1 always
        double current_speed_1 = setsaab.getCurrentSpeed();
        setsaab.brake(2);
        double current_speed_2 = setsaab.getCurrentSpeed();

        assertTrue(current_speed_2 == current_speed_1);
    }


    @Test
    public void test_break_saab95_amount_out_of_low_bound_saab95() {
        setsaab.startEngine();  // speed 0.1 always
        double current_speed_1 = setsaab.getCurrentSpeed();
        setsaab.brake(-1);
        double current_speed_2 = setsaab.getCurrentSpeed();

        assertTrue(current_speed_2 == current_speed_1);
    }

    /*
    @Test
    public void move_method_saab95() {
        setsaab.startEngine();  //speed 0.1 always
        double x0 = setsaab.x; //0
        double y0 = setsaab.y; //0
        setsaab.move();
        double x1 = setsaab.x; //another value
        double y1 = setsaab.y; //another value

        assertTrue((x0 == x1) && (y1 > y0));

    }

     */



    @Test
    public void turn_left_method_saab95() {
        double d0 = setsaab.direction;
        setsaab.turnLeft();
        setsaab.turnLeft();
        setsaab.turnLeft();
        setsaab.turnLeft();
        double d1 = setsaab.direction;
        assertTrue(d1 == d0);
    }


    @Test
    public void turn_right_method_saab95() {
        double d0 = setsaab.direction;
        setsaab.turnRight();
        setsaab.turnRight();
        setsaab.turnRight();
        setsaab.turnRight();
        double d1 = setsaab.direction;
        assertTrue(d0 == d1);
    }


    @Test
    public void road_trip_left_saab95() {
        setsaab.startEngine();//speed 0.1 always

        double x0 = setsaab.x;
        double y0 = setsaab.y;
        double d0 = setsaab.direction;

        for (int i = 0; i < 4; i++) {
            setsaab.move();
            setsaab.turnLeft();
        }

        double x1 = setsaab.x;
        double y1 = setsaab.y;
        double d1 = setsaab.direction;
        assertTrue((x0 == x1) && (y0 == y1) && (d0 == d1));
    }



    @Test
    public void road_trip_right_saab95 () {
        setsaab.startEngine(); //speed 0.1 always

        double x0 = setsaab.x;
        double y0 = setsaab.y;
        double d0 = setsaab.direction;

        for (int i = 0; i < 4; i++) {
            setsaab.move();
            setsaab.turnRight();

        }

        double x1 = setsaab.x;
        double y1 = setsaab.y;
        double d1 = setsaab.direction;

        assertTrue((x0 == x1) && (y0 == y1) && (d0 == d1));

    }

}

