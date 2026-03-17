package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application{

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    public void start(Stage window){

        Label userNameLabel = new Label("Enter your name and start");
        TextField userName = new TextField();
        Button startButton = new Button("Start");

        GridPane layout1 = new GridPane();
        layout1.add(userNameLabel, 0, 0);
        layout1.add(userName, 0, 1);
        layout1.add(startButton, 0, 2);

        layout1.setPrefSize(300, 180);
        layout1.setAlignment(Pos.CENTER);
        layout1.setVgap(10);
        layout1.setHgap(10);
        layout1.setPadding(new Insets(20, 20, 20, 20));

        Scene scene1 = new Scene(layout1);

        Label welcomeLabel = new Label("");

        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(welcomeLabel);
        welcomeLayout.setAlignment(Pos.CENTER);

        Scene scene2 = new Scene(welcomeLayout);

        startButton.setOnAction((event) -> {
            welcomeLabel.setText("Welcome " + userName.getText() + "!");
            window.setScene(scene2);
        });

        window.setScene(scene1);
        window.show();
    }
}
