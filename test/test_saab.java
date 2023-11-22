import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class test_saab {
    @Test
    public void nr_doors_saab95() {
        Saab95 s_doors = new Saab95();
        int doors = s_doors.getNrDoors();
        assertTrue(doors == 2);
    }


    @Test
    public void test_gas_saab95() {
        Saab95 saab95_speed = new Saab95();
        saab95_speed.startEngine();
        double current_speed_1 = saab95_speed.getCurrentSpeed();
        saab95_speed.gas(0.7);
        double current_speed_2 = saab95_speed.getCurrentSpeed();
        assertTrue(current_speed_2 > current_speed_1);

    }

    @Test
    public void test_break_saab95() {
        Saab95 saab95_speed = new Saab95();
        saab95_speed.startEngine();  // speed 0.1 always
        double current_speed_1 = saab95_speed.getCurrentSpeed();
        saab95_speed.brake(0.7);
        double current_speed_2 = saab95_speed.getCurrentSpeed();

        assertTrue(current_speed_2 < current_speed_1);
    }

    @Test
    public void test_break_saab95_amount_out_of_high_bound_saab95() {
        Saab95 saab95_speed = new Saab95();
        saab95_speed.startEngine();  // speed 0.1 always
        double current_speed_1 = saab95_speed.getCurrentSpeed();
        saab95_speed.brake(2);
        double current_speed_2 = saab95_speed.getCurrentSpeed();

        assertTrue(current_speed_2 == current_speed_1);
    }


    @Test
    public void test_break_saab95_amount_out_of_low_bound_saab95() {
        Saab95 saab95_speed = new Saab95();
        saab95_speed.startEngine();  // speed 0.1 always
        double current_speed_1 = saab95_speed.getCurrentSpeed();
        saab95_speed.brake(-1);
        double current_speed_2 = saab95_speed.getCurrentSpeed();

        assertTrue(current_speed_2 == current_speed_1);
    }

    @Test
    public void move_method_saab95() {
        Saab95 move_method = new Saab95();
        move_method.startEngine();  //speed 0.1 always
        double x0 = move_method.x; //0
        double y0 = move_method.y; //0
        move_method.move();
        double x1 = move_method.x; //another value
        double y1 = move_method.y; //another value

        assertTrue((x0 == x1) && (y1 > y0));

    }



    @Test
    public void turn_left_method_saab95() {
        Saab95 left = new Saab95();
        double d0 = left.direction;
        left.turnLeft();
        left.turnLeft();
        left.turnLeft();
        left.turnLeft();
        double d1 = left.direction;
        assertTrue(d1 == d0);
    }


    @Test
    public void turn_right_method_saab95() {
        Saab95 right = new Saab95();
        double d0 = right.direction;
        right.turnRight();
        right.turnRight();
        right.turnRight();
        right.turnRight();
        double d1 = right.direction;
        assertTrue(d0 == d1);
    }


    @Test
    public void road_trip_left_saab95() {
        Saab95 trip = new Saab95();
        trip.startEngine();//speed 0.1 always

        double x0 = trip.x;
        double y0 = trip.y;
        double d0 = trip.direction;

        for (int i = 0; i < 4; i++) {
            trip.move();
            trip.turnLeft();
        }

        double x1 = trip.x;
        double y1 = trip.y;
        double d1 = trip.direction;
        assertTrue((x0 == x1) && (y0 == y1) && (d0 == d1));
    }



    @Test
    public void road_trip_right_saab95 () {
        Saab95 trip = new Saab95();
        trip.startEngine(); //speed 0.1 always

        double x0 = trip.x;
        double y0 = trip.y;
        double d0 = trip.direction;

        for (int i = 0; i < 4; i++) {
            trip.move();
            trip.turnRight();

        }

        double x1 = trip.x;
        double y1 = trip.y;
        double d1 = trip.direction;

        assertTrue((x0 == x1) && (y0 == y1) && (d0 == d1));

    }

}

