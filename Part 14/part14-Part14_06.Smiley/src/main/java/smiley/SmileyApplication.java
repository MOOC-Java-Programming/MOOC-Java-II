package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application{


    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage window){
        BorderPane layout = new BorderPane();

        Canvas paintCanvas = new Canvas(640, 480);
        layout.setCenter(paintCanvas);
        GraphicsContext painter = paintCanvas.getGraphicsContext2D();
        painter.setFill(Color.BLACK);

        // Left eye
        painter.fillRect(150, 100, 50, 50);
        // Right eye
        painter.fillRect(300, 100, 50, 50);
        // Left corner of the smile
        painter.fillRect(100, 200, 50, 50);
        // Right corner of the smile
        painter.fillRect(350, 200, 50, 50);
        // Bottom line of the smile
        painter.fillRect(150, 250, 200, 50);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.setTitle("Smiley");
        window.show();
    }

}
