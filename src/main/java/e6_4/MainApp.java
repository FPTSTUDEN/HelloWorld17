package e6_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Load FXML - this automatically connects to NoteController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/notebook_view.fxml"));
        Parent root = loader.load();
        
        stage.setTitle("My JavaFX Notebook Application");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch(MainApp.class, args);
    }
}