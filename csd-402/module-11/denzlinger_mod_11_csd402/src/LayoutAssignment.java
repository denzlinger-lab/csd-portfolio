import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Abram Denzlinger
 * March 15, 2026
 * CSD402 - Module 11
 *
 * LayoutAssignment.java
 * This program demonstrates HBox and VBox usage as outlined in the module 11 paper.
 * It uses colored borders and labeling to demonstrate the behavior of HBox and VBox
 * containers, and the effects of nesting and growth constraints.
 */
public class LayoutAssignment extends Application {

    @Override
    public void start(Stage primaryStage) {

        // --- THE HBOX (Red Border) ---
        HBox headerHBox = new HBox(15);
        headerHBox.setPadding(new Insets(10));
        headerHBox.setStyle("-fx-border-color: red; -fx-border-width: 2; -fx-background-color: #fffafa;");

        Label hBoxLabel = new Label("HBox Container (Red Border):");
        hBoxLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: red;");

        Button btn1 = new Button("Horizontal Item 1");
        Button btn2 = new Button("Horizontal Item 2");

        // Nodes are on a single row
        headerHBox.getChildren().addAll(hBoxLabel, btn1, btn2);


        // --- THE VBOX (Blue Border) ---
        VBox contentVBox = new VBox(10);
        contentVBox.setPadding(new Insets(10));
        contentVBox.setStyle("-fx-border-color: blue; -fx-border-width: 2; -fx-background-color: #f0f8ff;");

        Label vBoxLabel = new Label("VBox Container (Blue Border):");
        vBoxLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: blue;");

        Label instructionLabel = new Label("Items are vertically stacked. " +
                "\nThe TextArea uses Vgrow to fill remaining space:");

        TextArea demoArea = new TextArea();
        demoArea.setPromptText("As you resize the window vertically, this box grows...");

        // Demonstrating Vgrow: the VBox expands the TextArea to fill empty space
        VBox.setVgrow(demoArea, Priority.ALWAYS);

        contentVBox.getChildren().addAll(vBoxLabel, instructionLabel, demoArea);


        // --- NESTING ---
        // The HBox and the VBox inside a "Master" VBox to create the layout.
        VBox rootStack = new VBox(5);
        rootStack.setPadding(new Insets(5));

        rootStack.setFillWidth(true); // Ensures children stretch horizontally
        VBox.setVgrow(contentVBox, Priority.ALWAYS); // Tells the root to give the Blue Box all extra vertical space

        // Adding the HBox (header) and VBox (content) to the root VBox
        rootStack.getChildren().addAll(headerHBox, contentVBox);


        // Final Scene setup
        Scene scene = new Scene(rootStack, 600, 450);
        primaryStage.setTitle("JavaFX Layout Demonstration: HBox and VBox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}