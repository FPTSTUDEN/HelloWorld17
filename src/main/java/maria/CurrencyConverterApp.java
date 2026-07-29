package maria;
// View + Main: CurrencyConverterApp.java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import maria.controller.ConverterController;
import maria.entity.Currency;

public class CurrencyConverterApp extends Application {
    private final ConverterController controller = new ConverterController();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Currency Converter");

        // --- Components ---
        Label title = new Label("Currency Converter");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField inputField = new TextField();
        TextField resultField = new TextField();
        resultField.setEditable(false);

        ChoiceBox<Currency> sourceBox = new ChoiceBox<>();
        ChoiceBox<Currency> targetBox = new ChoiceBox<>();

        Button convertBtn = new Button("Convert");

        // --- Layout ---
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Amount:"), 0, 0);
        grid.add(inputField, 1, 0);

        grid.add(new Label("From:"), 0, 1);
        grid.add(sourceBox, 1, 1);

        grid.add(new Label("To:"), 0, 2);
        grid.add(targetBox, 1, 2);

        grid.add(new Label("Result:"), 0, 3);
        grid.add(resultField, 1, 3);

        BorderPane root = new BorderPane();
        root.setTop(title);
        BorderPane.setMargin(title, new Insets(10));
        root.setCenter(grid);
        root.setBottom(convertBtn);
        BorderPane.setMargin(convertBtn, new Insets(10));

        // --- Data ---
        Currency usd = new Currency("USD", "US Dollar", 1.0);
        Currency eur = new Currency("EUR", "Euro", 0.9);
        Currency gbp = new Currency("GBP", "British Pound", 0.8);
        Currency jpy = new Currency("JPY", "Japanese Yen", 110.0);

        sourceBox.getItems().addAll(usd, eur, gbp, jpy);
        targetBox.getItems().addAll(usd, eur, gbp, jpy);

        sourceBox.setValue(usd);
        targetBox.setValue(eur);

        // --- Event Handling ---
        convertBtn.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(inputField.getText());
                Currency source = sourceBox.getValue();
                Currency target = targetBox.getValue();

                if (source.equals(target)) {
                    showAlert("Error", "Source and target currencies must be different.");
                    return;
                }

                double result = controller.convert(amount, source, target);
                resultField.setText(String.format("%.2f", result));
            } catch (NumberFormatException ex) {
                showAlert("Error", "Please enter a valid number.");
            }
        });

        // --- Scene ---
        Scene scene = new Scene(root, 400, 250);
        scene.getStylesheets().add("style.css"); // optional CSS
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
