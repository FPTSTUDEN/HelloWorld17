package e6_3;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

public class PetController implements MouseMotionListener, MouseListener {
    private final PetModel model;
    private final PetView view;
    private Timer gameTimer;

    public PetController(PetModel model, PetView view) {
        this.model = model;
        this.view = view;

        // Register mouse event listeners onto the view canvas
        view.addMouseMotionListener(this);
        view.addMouseListener(this);

        // A smooth 60 FPS update loop (~16ms intervals)
        gameTimer = new Timer(16, e -> {
            updatePetPosition();
            view.repaint();
        });
        gameTimer.start();
    }

    private void updatePetPosition() {
        // Condition: Stop moving if the mouse leaves the frame
        if (!model.isMousePresent()) {
            return; 
        }

        double dx = model.getMouseX() - model.getX();
        double dy = model.getMouseY() - model.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        // Condition: Stop moving if close enough to the cursor to prevent jittering
        if (distance < model.getSpeed()) {
            model.setX(model.getMouseX());
            model.setY(model.getMouseY());
            return;
        }

        // Trigonometry calculation for smooth movement heading directly to the cursor
        double angle = Math.atan2(dy, dx);
        
        double newX = model.getX() + (model.getSpeed() * Math.cos(angle));
        double newY = model.getY() + (model.getSpeed() * Math.sin(angle));

        model.setX(newX);
        model.setY(newY);
    }

    // MouseMotionListener events
    @Override
    public void mouseMoved(MouseEvent e) {
        model.setMousePresent(true);
        model.setMousePosition(e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        model.setMousePosition(e.getX(), e.getY());
    }

    // MouseListener events
    @Override
    public void mouseExited(MouseEvent e) {
        // Condition: Instantly stops movement when tracking is lost outside window boundaries
        model.setMousePresent(false); 
    }

    @Override public void mouseEntered(MouseEvent e) { model.setMousePresent(true); }
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}

    // Execution Entry Point
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Virtual Pet Walk");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            PetModel petModel = new PetModel(300, 300); // Start pet in center
            PetView petView = new PetView(petModel);
            new PetController(petModel, petView);

            frame.add(petView);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}