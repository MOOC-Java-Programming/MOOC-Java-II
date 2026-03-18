package application;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application{

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage window){
        NumberAxis xAxis = new NumberAxis(1968, 2008, 1);
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        ArrayList<String> lines = new ArrayList<>();
        String file = "partiesdata.tsv";
        try(Scanner fileScanner = new Scanner(Paths.get(file))) {
            while (fileScanner.hasNextLine()) {
                lines.add(fileScanner.nextLine());
            }
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        String[] firstLine = lines.get(0).split("\t");

        for(int i = 1; i < lines.size(); i++){
            String[] pieces = lines.get(i).split("\t");

            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            series.setName(pieces[0]);

            for(int j = 1; j < pieces.length; j++){
                if(!pieces[j].equals("-")){
                    int year = Integer.parseInt(firstLine[j]);
                    double value = Double.parseDouble(pieces[j]);
                    series.getData().add(new XYChart.Data<>(year, value));
                }
            }
            lineChart.getData().add(series);
        }

        Scene scene = new Scene(lineChart, 640, 480);
        window.setScene(scene);
        window.show();
    }
}
