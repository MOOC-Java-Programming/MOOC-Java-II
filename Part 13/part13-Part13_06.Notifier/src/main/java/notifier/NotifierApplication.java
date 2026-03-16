package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application{


    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage window){
        VBox vBox = new VBox();

        TextField textField = new TextField();
        Button button = new Button("Update");
        Label pasted = new Label("");

        button.setOnAction((event) -> {
            pasted.setText(textField.getText());
        });

        vBox.getChildren().addAll(textField, button, pasted);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
}
