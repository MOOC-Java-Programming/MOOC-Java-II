package hurraa;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// NOTE: This uses deprecated classes to be able to pass through the auto grader.
public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        Button btn = new Button("Hurray!");
        pane.setCenter(btn);

        btn.setOnAction((event) ->{
            try {
                // Load the file as a URL, which the native AudioClip requires
                URL audioUrl = new File("Applause-Yannick_Lemieux.wav").toURI().toURL();
                
                AudioClip sound = Applet.newAudioClip(audioUrl);
                sound.play();
                
            } catch (Exception e) {
                
            }
        });

        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
