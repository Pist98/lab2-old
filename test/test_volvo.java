import org.junit.Test;

import static org.junit.Assert.*;

public class test_volvo {



    @Test
    public void enginePower_test_volvo240() {
        Volvo240 engine = new Volvo240();
        double x = engine.getEnginePower();
        assertTrue(x == 100);
    }


    @Test
    public void test_gas_volvo240() {
        Volvo240 volvo240_speed = new Volvo240();
        volvo240_speed.startEngine();
        double current_speed_1 = volvo240_speed.getCurrentSpeed();
        volvo240_speed.gas(0.7); // if amount were ex 0.7
        double current_speed_2 = volvo240_speed.getCurrentSpeed();
        assertTrue(current_speed_2 > current_speed_1);

    }

    @Test
    public void test_break_volvo240() {
        Volvo240 Volvo240_speed = new Volvo240();
        Volvo240_speed.startEngine();  // speed 0.1 always
        double current_speed_1 = Volvo240_speed.getCurrentSpeed();
        Volvo240_speed.brake(0.7);
        double current_speed_2 = Volvo240_speed.getCurrentSpeed();
        assertTrue(current_speed_2 < current_speed_1);
    }

    @Test
    public void turn_left_method_Volvo240() {
        Volvo240 left = new Volvo240();
        double d0= left.direction;
        left.turnLeft();
        left.turnLeft();
        double d1 = left.direction;
        assertTrue(d1 > d0);
    }

    @Test
    public void turn_right_method_volvo240() {
        Volvo240 right = new Volvo240();
        double d0 = right.direction;
        for (int i = 0; i < 4; i++) {
            right.turnRight();
        }
        double d1 = right.direction;
        assertTrue(d0 == d1);
    }


        @Test
        public void road_trip_Volvo240_alternative_solution () {
            Volvo240 trip = new Volvo240();
            trip.startEngine();//speed 0.1 always

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
