import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
public class HelloWorldGUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello, World!");
        Scene scene = new Scene(label, 300, 200);
        // boolean isDarkMode = false; // Set to true for dark mode, false for light mode
        final boolean buttonToggled = false; // Set to true if the button is toggled, false otherwise
        primaryStage.setTitle("Hello, World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        Button button = new Button("Click Me");
        FlowPane flowPane = new FlowPane();
        // Add button to scene or handle button click event
        flowPane.getChildren().add(button);
        button.setOnAction(e -> {
            buttonToggled = !buttonToggled;
            label.setText("Button Clicked! Toggled: " + buttonToggled);
        });
        scene.setRoot(flowPane);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
