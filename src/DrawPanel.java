import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    protected ArrayList<Vehicle> vehicles;
    protected ArrayList<BufferedImage> Image= new ArrayList<>();
    protected Map<Vehicle, BufferedImage> CarsAndPics = new HashMap<>();


    protected void setListForPics(){
        if (vehicles.size() == Image.size()) {
            for (int i = 0; i < Image.size(); i++) {
                CarsAndPics.put(vehicles.get(i), Image.get(i));
            }
        }}



    public DrawPanel(int x, int y, ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            for (Vehicle vehicle : vehicles){
                Image.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+ vehicle.modelName+".jpg")));
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setListForPics();
        for (Map.Entry<Vehicle,BufferedImage> entry : CarsAndPics.entrySet()) {
            Vehicle vehicle = entry.getKey();
            BufferedImage image = entry.getValue();
            g.drawImage(image,(int) vehicle.getXPos(), (int) vehicle.getYPos(), null);}
    }
}


