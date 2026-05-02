import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Random;

/*
 * Abram Denzlinger
 * May 2, 2026
 * Assignment 8.2
 * 
 * This program uses 3 threads, each outputting a different
 * character type to a text area for display.
 */

public class AbramThreeThreads extends Application {
    private TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        // Setup the UI
        textArea.setWrapText(true);
        StackPane root = new StackPane(textArea);
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.setTitle("Abram's Multithreaded Output");
        primaryStage.show();

        // Create and start three threads
        new Thread(() -> generateChars("abcdefghijklmnopqrstuvwxyz")).start();
        new Thread(() -> generateChars("0123456789")).start();
        new Thread(() -> generateChars("!@#$%&*")).start();
    }

    private void generateChars(String pool) {
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            char c = pool.charAt(rand.nextInt(pool.length()));

            // Collect generated character and queue it for display on the UI thread
            Platform.runLater(() -> textArea.appendText(String.valueOf(c)));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}