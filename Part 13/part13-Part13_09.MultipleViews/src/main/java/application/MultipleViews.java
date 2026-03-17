package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application{

    public static void main(String[] args){
        launch(MultipleViews.class);
    }

    public void start(Stage window){
        BorderPane first = new BorderPane();
        Button button1 = new Button("To the second view!");
        first.setTop(new Label("First view!"));
        first.setCenter(button1);

        VBox second = new VBox();
        Button button2 = new Button("To the third view!");
        Label secondSceneText = new Label("Second view!");
        second.getChildren().addAll(button2, secondSceneText);

        GridPane third = new GridPane();
        Label label3 = new Label("Third view!");
        Button button3 = new Button("To the first view");

        third.add(label3, 0, 0);
        third.add(button3, 1, 1);

        Scene firstScene = new Scene(first);
        Scene secondScene = new Scene(second);
        Scene thirdScene = new Scene(third);

        button1.setOnAction((event) -> {
            window.setScene(secondScene);
        });

        button2.setOnAction((event) -> {
            window.setScene(thirdScene);
        });

        button3.setOnAction((event) -> {
            window.setScene(firstScene);
        });

        window.setScene(firstScene);
        window.show();
    }

}
