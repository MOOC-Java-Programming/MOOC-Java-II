package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application{

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    public void start(Stage window){
        BorderPane layout = new BorderPane();

        HBox buttons = new HBox();
        buttons.setPadding(new Insets(20, 20, 20, 20));
        buttons.setSpacing(10);

        Button jokeButton =  new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        buttons.getChildren().addAll(jokeButton, answerButton, explanationButton);
        layout.setTop(buttons);

        // Add subviews and add them to the menu buttons
        // Create subview layout
        StackPane jokePane = createView("What do you call a bear with no teeth?");
        StackPane answerPane = createView("A gummy bear.");
        StackPane explanationPane = createView("This is a play on words, combining \"gum\" (the tissue in the mouth) and \"bear,\" referencing the popular chewy candy of the same name. It is a classic joke.");

        // Add subviews to button. Pressing the buttons will change the view
        jokeButton.setOnAction((event) -> layout.setCenter(jokePane));
        answerButton.setOnAction((event) -> layout.setCenter(answerPane));
        explanationButton.setOnAction((event) -> layout.setCenter(explanationPane));

        layout.setCenter(jokePane);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();

    }

    private StackPane createView(String text){
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
