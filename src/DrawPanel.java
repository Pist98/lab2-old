import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

    public class DrawPanel extends JPanel{
        private Car T; //

        /*
        // Just a single image, TODO: Generalize  //not neccersary
        // To keep track of a singel cars position     //not needed anymore, TA
        Point volvoPoint = new Point();
         */


        BufferedImage Image;

        // TODO: Make this genereal for all cars
        void moveit(int x, int y){
            T.x = x;
            T.y = y;
        }

        // Initializes the panel and reads the images
        public DrawPanel(int x, int y) {
            this.setDoubleBuffered(true);
            this.setPreferredSize(new Dimension(x, y));
            this.setBackground(Color.green);
            // Print an error message in case file is not found with a try/catch block
            try {
                Image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + T.modelName + ".jpg"));
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

        // This method is called each time the panel updates/refreshes/repaints itself
        // TODO: Change to suit your needs.
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(Image, (int)T.x, (int)T.y, null); // see javadoc for more info on the parameters
        }
    }

