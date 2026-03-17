package textstatistics;

import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window){
        BorderPane layout = new BorderPane();

        TextArea centreText = new TextArea("");

        Label lettersLabel = new Label("Letters: 0");
        Label wordsLabel = new Label("Words: 0");
        Label longestLabel = new Label("The longest word is: ");

        centreText.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" +");
            int words = newValue.isEmpty() ? 0 : parts.length;
            String longest = Arrays.stream(parts)
                                    .sorted((s1, s2) -> s2.length() - s1.length())
                                    .findFirst()
                                    .orElse("");

            lettersLabel.setText("Letters: " + characters);
            wordsLabel.setText("Words: " + words);
            longestLabel.setText("The longest word is: " + longest);
        });

        HBox texts = new HBox();
        texts.setSpacing(10);
        texts.getChildren().addAll(lettersLabel, wordsLabel, longestLabel);
        
        layout.setBottom(texts);
        layout.setCenter(centreText);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

}
