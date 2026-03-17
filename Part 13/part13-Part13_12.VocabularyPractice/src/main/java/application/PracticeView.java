package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {
    private Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary){
        this.dictionary = dictionary;
        word = dictionary.getRandomWord();
    }

    public Parent getView(){
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Label wordQuestion = new Label("Translate the word '" + this.word + "'");
        TextField translationAnswer = new TextField();
        Button addButton = new Button("Check");
        Label feedback = new Label("");

        layout.add(wordQuestion, 0, 0);
        layout.add(translationAnswer, 0, 1);
        layout.add(addButton, 0, 2);
        layout.add(feedback, 0, 3);

        addButton.setOnMouseClicked((event) -> {
            String translation = translationAnswer.getText();
            if(dictionary.get(word).equals(translation)){
                feedback.setText("Correct!");
            } else{
                feedback.setText("Incorrect! The translation for the word '" + word + "' is '" + dictionary.get(word) + "'.");
                return;
            }

            word = dictionary.getRandomWord();
            wordQuestion.setText("Translate the word '" + word + "'");
            translationAnswer.clear();
        });
        return layout;
    }
}
