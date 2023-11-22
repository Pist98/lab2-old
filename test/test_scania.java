import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class test_scania {

    @Test
    public void nr_doors_scania () {
        Scania S_doors = new Scania();
        int doors = S_doors.getNrDoors();
        assertTrue(doors == 2);
    }


    @Test
    public void test_gas_scania() {
        Scania scania_speed = new Scania();
        scania_speed.startEngine();
        scania_speed.flak=false;
        double current_speed_1 = scania_speed.getCurrentSpeed();
        scania_speed.gas(0.7);
        double current_speed_2 = scania_speed.getCurrentSpeed();
        assertTrue(current_speed_2 > current_speed_1);
    }


    @Test
    public void höj_flak_scania_stilla (){
        Scania car= new Scania();
        car.raise_flak(45);
        double upp_vinkel= car.vinkel;
        assertTrue(upp_vinkel == 45);
    }

    @Test
    public void sänk_flak_scania_stilla (){
        Scania car= new Scania();
        double vinkel = car.vinkel;
        car.lower_flak(100);
        double ny_vinkel= car.vinkel;
        assertTrue(ny_vinkel == vinkel);

    }

    @Test
    public void höj_flak_scania_över_70 (){
        Scania höj= new Scania();
        for (int i = 0; i < 20; i++){
        höj.raise_flak(10);}
        double ny_vinkel= höj.vinkel;
        assertTrue(ny_vinkel == 70);
    }


    @Test
    public void start_engine_scania_flak_vinkel_större_noll (){
        Scania scania_flak= new Scania();
        scania_flak.raise_flak(10);
        scania_flak.startEngine();
        scania_flak.gas(0.7);
        double speed = scania_flak.getCurrentSpeed();
        assertTrue(speed==0);}



    @Test
    public void höj_flak_scania_if_speed_greater_than_zero(){
        Scania car = new Scania();
        car.flak=false;
        car.gas(0.7);
        car.raise_flak(10);
        double vinkel_flak = car.vinkel;
        assertTrue(vinkel_flak==0);
     }

}
