package application;

import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application{

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage window){
        NumberAxis xAxis = new NumberAxis(2007, 2017, 2);
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        HashMap<Integer, Integer> yearlyRanking = new HashMap<>();
        putAll(yearlyRanking);

        XYChart.Series data = new XYChart.Series<>();
        data.setName("HELS");

        yearlyRanking.keySet().stream().forEach(year -> {
            data.getData().add(new XYChart.Data(year, yearlyRanking.get(year)));
        });
        lineChart.getData().add(data);

        Scene scene = new Scene(lineChart, 640, 480);
        window.setScene(scene);
        window.show();

    }

    private HashMap<Integer, Integer> putAll(HashMap<Integer, Integer> hashMap){
        hashMap.put(2007, 73);
        hashMap.put(2008, 68);
        hashMap.put(2009, 72);
        hashMap.put(2010, 72);
        hashMap.put(2011, 74);
        hashMap.put(2012, 73);
        hashMap.put(2013, 76);
        hashMap.put(2014, 73);
        hashMap.put(2015, 67);
        hashMap.put(2016, 56);
        hashMap.put(2017, 56);

        return hashMap;
    }
}
