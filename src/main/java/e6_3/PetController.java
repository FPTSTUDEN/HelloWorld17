package e6_3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class PetController {

    double mouseX = -1;
    double mouseY = -1;
    boolean mouseInside = false;
    private Pet pet;
    private PetView view;
    public PetController(PetView view) {
        this.view = view;
        this.pet = new Pet(200, 150); // Start pet in the center of the canvas
    }
    public void handleMouseMovement() {
        // this.mouseX = view.canvas.getMouseX();
        // this.mouseY = view.canvas.getMouseY();
        // this.mouseInside = view.canvas.isMouseInside();
        if (mouseInside) {
            pet.moveToward(mouseX, mouseY);
        }
    }
}

