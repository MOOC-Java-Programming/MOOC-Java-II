package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PracticeApplication extends Application{
    private Dictionary dictionary;

    @Override
    public void init() throws Exception{
        dictionary = new Dictionary();
    }

    @Override
    public void start(Stage window) throws Exception{
        InputView iv = new InputView(dictionary);
        PracticeView pv = new PracticeView(dictionary);

        BorderPane layout = new BorderPane();

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        Button saveButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

        menu.getChildren().addAll(saveButton, practiceButton);
        layout.setTop(menu);

        saveButton.setOnAction((event) -> layout.setCenter(iv.getView()));
        practiceButton.setOnAction((event) -> layout.setCenter(pv.getView()));

        layout.setCenter(iv.getView());

        Scene scene = new Scene(layout, 400, 300);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(PracticeApplication.class);
    }
}
