import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class test_scania {


    private Scania setscania;

    @Before
    public void init() {
        int x = 0;
        int y = 0;
        setscania = new Scania(x,y);
    }


    @Test
    public void nr_doors_scania () {
        int doors = setscania.getNrDoors();
        assertTrue(doors == 2);
    }


    @Test
    public void test_gas_scania() {
        setscania.startEngine();
        setscania.flak=false;
        double current_speed_1 = setscania.getCurrentSpeed();
        setscania.gas(0.7);
        double current_speed_2 = setscania.getCurrentSpeed();
        assertTrue(current_speed_2 > current_speed_1);
    }

/*
    @Test
    public void höj_flak_scania_stilla (){
        setscania.raise_flak(45);
        double upp_vinkel= setscania.vinkel;
        assertTrue(upp_vinkel == 45);
    }

    @Test
    public void sänk_flak_scania_stilla (){
        double vinkel = setscania.vinkel;
        setscania.lower_flak(100);
        double ny_vinkel= setscania.vinkel;
        assertTrue(ny_vinkel == vinkel);

    }

    @Test
    public void höj_flak_scania_över_70 (){
        for (int i = 0; i < 20; i++){
            setscania.raise_flak(10);}
        double ny_vinkel= setscania.vinkel;
        assertTrue(ny_vinkel == 70);
    }


    @Test
    public void start_engine_scania_flak_vinkel_större_noll (){
        setscania.raise_flak(10);
        setscania.startEngine();
        setscania.gas(0.7);
        double speed = setscania.getCurrentSpeed();
        assertTrue(speed==0);}





    @Test
    public void höj_flak_scania_if_speed_greater_than_zero(){
        setscania.flak=false;
        setscania.gas(0.7);
        setscania.raise_flak(10);
        double vinkel_flak = setscania.vinkel;
        assertTrue(vinkel_flak==0);
     }

 */

}
