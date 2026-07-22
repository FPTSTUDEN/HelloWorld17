import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
public class HelloCanvas extends Application {
    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(400, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(50, 50, 200, 100);
        Label label = new Label("Hello, Canvas!");
        Scene scene = new Scene(new StackPane(canvas, label), 400, 300);
        primaryStage.setTitle("Hello, Canvas!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}