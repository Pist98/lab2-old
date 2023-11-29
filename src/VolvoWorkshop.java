import java.util.ArrayList;

public class VolvoWorkshop {

    int max=3;
    ArrayList<Volvo240> loaded_volvos = new ArrayList <>();
    ArrayList<Volvo240> unloaded_volvos = new ArrayList <>();



    public void load(Volvo240 car) {
        if (loaded_volvos.size() < max) {
            loaded_volvos.add(car);}
    }

    public void unload(){
        int last_car= loaded_volvos.size() -1;
        unloaded_volvos.add(loaded_volvos.remove(last_car));
        loaded_volvos.remove(last_car);
    }
}

