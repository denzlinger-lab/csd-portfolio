import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/*
 * Abram Denzlinger
 * May 2, 2026
 * Module 7.2 - JavaFX Program
 *
 * This is a JavaFX program that displays four circles and uses a
 * CSS stylesheet. The stylesheet "defines a class for white fill
 * and black stroke color and an ID for red and green color."
 */

public class StyledCircles extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Layout container with some spacing
        HBox pane = new HBox(20);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(20));

        // Create four circles
        Circle c1 = new Circle(40);
        Circle c2 = new Circle(40);
        Circle c3 = new Circle(40);
        Circle c4 = new Circle(40);

        // Circle 1 & 2: Using the 'plaincircle' class
        c1.getStyleClass().add("plaincircle");
        c2.getStyleClass().add("plaincircle");

        // Circle 3: Using the 'redcircle' ID
        c3.setId("redcircle");

        // Circle 4: Using the 'greencircle' ID
        c4.setId("greencircle");

        // Add all circles to the pane
        pane.getChildren().addAll(c1, c2, c3, c4);

        // Create the scene and link the CSS file
        Scene scene = new Scene(pane);
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        primaryStage.setTitle("My JavaFX Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}