import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class lowerCaseA extends Application {

    @Override
    public void start(Stage primaryStage) {
        // --- 1. Create the Circle (The Bowl of the 'a') ---
        // Center: (100, 200), Radius: 50
        Circle bowl = new Circle(100, 200, 50);
//        bowl.setFill(Color.TRANSPARENT);
//        bowl.setStroke(Color.DARKSLATEBLUE);
//        bowl.setStrokeWidth(8);

        // --- 2. Create the Line (The Stem of the 'a') ---
        // To align with the right edge: X = CenterX + Radius = 100 + 50 = 150.
        // To align with the top edge: Y = CenterY - Radius = 200 - 50 = 150.
        // To align with the bottom edge: Y = CenterY + Radius = 200 + 50 = 250.

        double stemX = 150;
        double stemTopY = 150;
        double stemBottomY = 250;

        Line stem = new Line(stemX, stemTopY, stemX, stemBottomY);
        stem.setStrokeWidth(8);
        stem.setStroke(Color.DARKSLATEBLUE);

        // Add shapes to a Pane
        Pane root = new Pane();
        root.getChildren().addAll(bowl, stem);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("JavaFX Shape Alignment: Letter 'a'");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}