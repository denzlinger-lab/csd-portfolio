/*
 * Abram Denzlinger
 * March 29, 2026
 * Assignment 1.3
 *
 * This program creates a window that displays four random playing cards
 * from a deck. It looks inside the "cards" folder, finds all the .png
 * images there, and picks four to show. The "Refresh" button shuffles
 * the deck and swaps the current cards for four new ones.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class cards extends Application {

    // These variables act as the "memory" for the deck of names and the 4 card slots
    private ArrayList<String> deck;
    private ImageView[] cardViews;

    @Override
    public void start(Stage primaryStage) {
        // Step 1: Look at the folder and make a list of all the cards available
        deck = initializeDeck();

        // Step 2: Create the 4 "frames" where the card images will sit
        cardViews = new ImageView[4];
        HBox cardContainer = new HBox(15); // Puts cards in a row with a small gap
        cardContainer.setAlignment(Pos.CENTER); // Keeps the row centered

        for (int i = 0; i < 4; i++) {
            ImageView frame = new ImageView();
            frame.setFitHeight(150); // Makes sure all cards are the same height
            frame.setPreserveRatio(true); // Keeps cards from looking stretched
            cardViews[i] = frame;
            cardContainer.getChildren().add(frame);
        }

        // Step 3: Put the first 4 random cards into the frames
        refreshCards();

        // Step 4: Create a button and tell it what to do when clicked
        Button refreshButton = new Button("Refresh");
        // This shortcut (Lambda) tells the button to run the refresh logic whenever clicked
        refreshButton.setOnAction(e -> refreshCards());

        // Step 5: Stack the cards on top of the button with some breathing room
        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(20));
        mainLayout.getChildren().addAll(cardContainer, refreshButton);

        // Step 6: Set up the window size and title, then show it on the screen
        Scene scene = new Scene(mainLayout, 600, 300);
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*
     * This section opens the "cards" folder and makes a list of every
     * image filename it finds that ends in .png.
     */
    private ArrayList<String> initializeDeck() {
        ArrayList<String> cardsList = new ArrayList<>();
        File folder = new File("cards");

        // This filter ignores hidden system files and only keeps the picture files
        File[] images = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));

        if (images != null) {
            for (File f : images) {
                cardsList.add(f.getName());
            }
        }
        return cardsList;
    }

    /*
     * This section shuffles the list of names and updates the 4
     * frames on the screen with the 4 new cards.
     */
    private void refreshCards() {
        Collections.shuffle(deck);

        for (int i = 0; i < 4; i++) {
            String cardFileName = deck.get(i);
            // Tells the frame exactly where to find the picture file on the computer
            cardViews[i].setImage(new Image("file:cards/" + cardFileName));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}