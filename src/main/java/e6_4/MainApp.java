package e6_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("--- JavaFX Resource Debugging ---");

        // 1. Print the actual classpath directory where Java is looking for root '/' resources
        java.net.URL rootUrl = getClass().getResource("/");
        System.out.println("Root resource folder path: " + rootUrl);

        // 2. Test if it can find your specific file (will print 'null' if it fails)
        java.net.URL fileUrl = getClass().getResource("/resources/notebook_view.fxml");
        System.out.println("Target file URL: " + fileUrl);

System.out.println("---------------------------------");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/notebook_view.fxml"));
        Parent root = loader.load();
        
        stage.setTitle("My JavaFX Notebook Application");
        stage.setScene(new Scene(root));
        stage.show();
    }

    // public static void main(String[] args) {
    //     launch(MainApp.class, args);
    // }
}
