package e6_1;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.application.Application;
public class DictionaryView extends Application {
    FlowPane flowPane = new FlowPane();
    Button addButton = new Button("Add Word");
    Button searchButton = new Button("Search Word");
    DictionaryController controller = new DictionaryController(this);
    // text input
    javafx.scene.control.TextField textInput = new javafx.scene.control.TextField();
    javafx.scene.control.TextField definitionInput = new javafx.scene.control.TextField();
    javafx.scene.control.Label resultLabel = new javafx.scene.control.Label();
    Scene scene = new Scene(flowPane, 400, 300);
    public void start(javafx.stage.Stage primaryStage) {
        primaryStage.setTitle("Dictionary View");
        flowPane.getChildren().addAll(addButton, searchButton, textInput, definitionInput, resultLabel);
        addButton.setOnAction(e -> {
            controller.handleAddWord();
        });
        searchButton.setOnAction(e -> {
            controller.handleSearchWord();
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
