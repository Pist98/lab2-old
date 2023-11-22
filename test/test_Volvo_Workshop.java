import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class test_Volvo_Workshop {
    Volvo240 volvo1 = new Volvo240();
    Volvo240 volvo2 = new Volvo240();
    Saab95 saab1 = new Saab95();

    @Test
    public void load_on_cars() {
        VolvoWorkshop volvo_workshop = new VolvoWorkshop();
        volvo_workshop.load(volvo1);
        volvo_workshop.load(volvo2);
        assertTrue(volvo_workshop.loaded_volvos.size()==2);
    }
    @Test
    public void unload_on_cars() {
        VolvoWorkshop volvo_workshop = new VolvoWorkshop();
        volvo_workshop.load(volvo1);
        volvo_workshop.load(volvo2);
        volvo_workshop.unload();
        assertTrue(volvo_workshop.loaded_volvos.size()==1);
    }
    @Test
    public void check_unloaded_cars() {
        VolvoWorkshop volvo_workshop = new VolvoWorkshop();
        volvo_workshop.load(volvo1);
        volvo_workshop.load(volvo2);
        Volvo240 last_car= volvo_workshop.loaded_volvos.get(1);
        volvo_workshop.unload();
        assertTrue(last_car==volvo_workshop.unloaded_volvos.get(0));
    }

}
