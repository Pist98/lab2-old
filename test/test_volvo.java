import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class test_volvo {

    private Volvo240 setvolvo;

    @Before
    public void init() {
        int x = 0;
        int y = 0;
        setvolvo = new Volvo240(x,y);
    }


    @Test
    public void enginePower_test_volvo240() {
        double x = setvolvo.getEnginePower();
        assertTrue(x == 100);
    }


    @Test
    public void test_gas_volvo240() {
        setvolvo.startEngine();
        double current_speed_1 = setvolvo.getCurrentSpeed();
        setvolvo.gas(0.7); // if amount were ex 0.7
        double current_speed_2 = setvolvo.getCurrentSpeed();
        assertTrue(current_speed_2 > current_speed_1);

    }

    @Test
    public void test_break_volvo240() {
        setvolvo.startEngine();  // speed 0.1 always
        double current_speed_1 = setvolvo.getCurrentSpeed();
        setvolvo.brake(0.7);
        double current_speed_2 = setvolvo.getCurrentSpeed();
        assertTrue(current_speed_2 < current_speed_1);
    }

    @Test
    public void turn_left_method_Volvo240() {
        double d0= setvolvo.direction;
        setvolvo.turnLeft();
        setvolvo.turnLeft();
        double d1 = setvolvo.direction;
        assertTrue(d1 > d0);
    }

    @Test
    public void turn_right_method_volvo240() {
        double d0 = setvolvo.direction;
        for (int i = 0; i < 4; i++) {
            setvolvo.turnRight();
        }
        double d1 = setvolvo.direction;
        assertTrue(d0 == d1);
    }


        @Test
        public void road_trip_Volvo240_alternative_solution () {
            setvolvo.startEngine();//speed 0.1 always

            double x0 = setvolvo.x;
            double y0 = setvolvo.y;
            double d0 = setvolvo.direction;

            for (int i = 0; i < 4; i++) {
                setvolvo.move();
                setvolvo.turnRight();
            }

            double x1 = setvolvo.x;
            double y1 = setvolvo.y;
            double d1 = setvolvo.direction;
            assertTrue((x0 == x1) && (y0 == y1) && (d0 == d1));
        }
    }
