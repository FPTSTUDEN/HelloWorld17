package e6_3;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PetView extends JPanel {
    private final PetModel model;
    private Image petImage; // Using the java.awt.Image class as requested

    public PetView(PetModel model) {
        this.model = model;
        setPreferredSize(new Dimension(600, 600));
        setBackground(new Color(245, 245, 250));

        // Load the image file using ImageIO into our Image variable
        try {
            File imgFile = new File("pet.png");
            if (imgFile.exists()) {
                petImage = ImageIO.read(imgFile);
            } else {
                System.out.println("pet.png not found. Please place a pet.png image in the project directory.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the pet image file.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int drawX = (int) model.getX();
        int drawY = (int) model.getY();

        if (petImage != null) {
            // Draw the loaded Image centered over the pet's coordinate location
            // Assuming a standard size of 50x50 pixels for the pet
            g2d.drawImage(petImage, drawX - 25, drawY - 25, 50, 50, this);
        } else {
            // Backup visual indicator so you can still test code execution without an image asset present
            g2d.setColor(Color.ORANGE);
            g2d.fillOval(drawX - 20, drawY - 20, 40, 40);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Missing pet.png", drawX - 40, drawY - 25);
        }
    }
}