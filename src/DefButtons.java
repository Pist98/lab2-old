import java.util.ArrayList;

public class DefButtons{

    public ArrayList<Vehicle> vehicles;

    public DefButtons(ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
    }


    void gas(double amount) {
        double gas = ( amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);}}


    void brake(double amount){
        double brake = (amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }
    void startEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();}
    }

    void stopEngine() {
        for (Vehicle vehicle : vehicles){
            vehicle.stopEngine();}
    }


    void setTurboOn(){
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOn();}}
    }

    void setTurboOff(){
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOff();}}
    }


    void liftBedButton() {//open
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Truck)vehicle).raise_flak();}}
    }

    void lowerBedButton() {//close
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Truck)vehicle).lower_flak();}}
    }

}
