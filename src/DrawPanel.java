import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

    public class DrawPanel extends JPanel{
        public ArrayList<Car> cars;
        ArrayList<BufferedImage> image = new ArrayList<BufferedImage>();
        HashMap<BufferedImage,Car> carpictures = new HashMap<>();

        void setCarsPics(){
            if (cars.size() == image.size()) {
                for (int i = 0; i < cars.size(); i++){
                    carpictures.put(image.get(i), cars.get(i));
                }
            }
        }

        /*
        // Just a single image, TODO: Generalize  //not neccersary
        // To keep track of a singel cars position     //not needed anymore, TA
        Point volvoPoint = new Point();
         */


        // TODO: Make this genereal for all cars
       /* void moveit(int x, int y){  // for loop through list
            for(Car car :cars) {
                car.x = x;
                car.y = y;
            }
        }*/

        // Initializes the panel and reads the images
        public DrawPanel(int x, int y, ArrayList<Car> cars) {
            this.cars = cars;
            this.setDoubleBuffered(true);
            this.setPreferredSize(new Dimension(x, y));
            this.setBackground(Color.green);
            // Print an error message in case file is not found with a try/catch block
            try {
                for(Car car :cars) {
                    image.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + car.modelName + ".jpg")));
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // This method is called each time the panel updates/refreshes/repaints itself
        // TODO: Change to suit your needs.
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setCarsPics();
            for (Map.Entry<BufferedImage,Car> entry : carpictures.entrySet()){
                BufferedImage image = entry.getKey();
                Car car = entry.getValue();
                g.drawImage(image, (int) car.getXPos(), (int) car.getYPos(), null);
            }
        }
    }

