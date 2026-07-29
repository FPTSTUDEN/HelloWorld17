package maria.view;

import maria.controller.ConverterController;
import maria.entity.Currency;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

import java.sql.SQLException;
import java.util.List;

public class CurrencyConverterApp extends Application {
    private final ConverterController controller = new ConverterController();
    private ChoiceBox<Currency> sourceBox;
    private ChoiceBox<Currency> targetBox;
    private TextField inputField;
    private TextField resultField;
    private Label statusLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Currency Converter");

        // --- Components ---
        Label title = new Label("Currency Converter");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        inputField = new TextField();
        resultField = new TextField();
        resultField.setEditable(false);

        sourceBox = new ChoiceBox<>();
        targetBox = new ChoiceBox<>();
        
        Button convertBtn = new Button("Convert");
        Button refreshBtn = new Button("Refresh Currencies");
        
        statusLabel = new Label("Ready");
        statusLabel.setStyle("-fx-text-fill: #006400;");

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

        // Buttons layout
        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(10));
        buttonBox.getChildren().addAll(convertBtn, refreshBtn);

        BorderPane root = new BorderPane();
        root.setTop(title);
        BorderPane.setMargin(title, new Insets(10));
        root.setCenter(grid);
        root.setBottom(buttonBox);
        // root.setBottom(statusLabel);
        // set status label to another position
        BorderPane.setMargin(statusLabel, new Insets(10));
        

        // --- Load currencies from database ---
        loadCurrencies();

        // --- Event Handling ---
        convertBtn.setOnAction(e -> handleConversion());
        refreshBtn.setOnAction(e -> loadCurrencies());

        // --- Scene ---
        Scene scene = new Scene(root, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadCurrencies() {
        try {
            List<Currency> currencies = controller.getAllCurrencies();
            
            sourceBox.getItems().clear();
            targetBox.getItems().clear();
            
            sourceBox.getItems().addAll(currencies);
            targetBox.getItems().addAll(currencies);
            
            if (!currencies.isEmpty()) { // Set default selections if currencies are available
                sourceBox.setValue(currencies.get(0));
                targetBox.setValue(currencies.size() > 1 ? currencies.get(1) : currencies.get(0)); // Set to second currency if available, otherwise first
            }
            
            statusLabel.setText("Currencies loaded successfully");
            statusLabel.setStyle("-fx-text-fill: #006400;");
            resultField.clear();
            
        } catch (SQLException e) {
            showError("Database Error", "Could not load currencies from database: " + e.getMessage());
            statusLabel.setText("Failed to load currencies");
            statusLabel.setStyle("-fx-text-fill: #ff0000;");
        }
    }

    private void handleConversion() {
        try {
            double amount = Double.parseDouble(inputField.getText());
            Currency source = sourceBox.getValue();
            Currency target = targetBox.getValue();

            if (source == null || target == null) {
                showError("Error", "Please select both source and target currencies.");
                return;
            }

            if (source.equals(target)) {
                showError("Error", "Source and target currencies must be different.");
                return;
            }

            double result = controller.convert(amount, source, target);
            resultField.setText(String.format("%.2f", result));
            statusLabel.setText("Conversion successful");
            statusLabel.setStyle("-fx-text-fill: #006400;");
            
        } catch (NumberFormatException ex) {
            showError("Error", "Please enter a valid number.");
            statusLabel.setText("Invalid input");
            statusLabel.setStyle("-fx-text-fill: #ff0000;");
        } catch (SQLException ex) {
            showError("Database Error", "Could not perform conversion: " + ex.getMessage());
            statusLabel.setText("Conversion failed - database error");
            statusLabel.setStyle("-fx-text-fill: #ff0000;");
        }
    }

    private void showError(String title, String message) {
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