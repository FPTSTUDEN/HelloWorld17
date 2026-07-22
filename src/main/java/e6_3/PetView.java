package e6_3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PetView extends Application {
    Canvas canvas;
    GraphicsContext gc;
    Pet pet;
    PetController controller = new PetController(this);

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(400, 300);
        gc = canvas.getGraphicsContext2D();
        pet = new Pet(200, 150); // Start pet in the center of the canvas

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Pet Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();

        canvas.setOnMouseMoved(e -> {
            controller.mouseX = e.getX();
            controller.mouseY = e.getY();
            controller.mouseInside = true;
        });
    }
}
