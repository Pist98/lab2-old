import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    protected ArrayList<Car> cars;
    protected ArrayList<BufferedImage> Image= new ArrayList<>();
    protected Map<Car, BufferedImage> CarsAndPics = new HashMap<>();


    protected void setListForPics(){
        if (cars.size() == Image.size()) {
            for (int i = 0; i < Image.size(); i++) {
                CarsAndPics.put(cars.get(i), Image.get(i));
            }
        }}



    public DrawPanel(int x, int y, ArrayList<Car> cars) {
        this.cars=cars;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            for (Car car:cars){
                Image.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+car.modelName+".jpg")));
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

        for (Map.Entry<Car,BufferedImage> entry : CarsAndPics.entrySet()) {
            Car car = entry.getKey();
            BufferedImage image = entry.getValue();
            g.drawImage(image,(int)car.getXPos(), (int)car.getYPos(), null);}
    }
}


