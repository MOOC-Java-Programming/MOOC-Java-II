package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application{

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage window){
        BorderPane layout = new BorderPane();

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        layout.setCenter(lineChart);
        lineChart.setAnimated(false);

        VBox vBox = new VBox();
        BorderPane bp1 = new BorderPane();
        bp1.setLeft(new Label("Monthly savings"));
        Slider monthlySlider = new Slider(25, 250, 25);
        monthlySlider.setShowTickMarks(true);
        monthlySlider.setShowTickLabels(true);
        bp1.setCenter(monthlySlider);
        Label monthlyLabel = new Label("25");
        bp1.setRight(monthlyLabel);
        
        BorderPane bp2 = new BorderPane();
        bp2.setLeft(new Label("Yearly interest rate"));
        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);
        bp2.setCenter(interestSlider);
        Label interestLabel = new Label("0");
        bp2.setRight(interestLabel);

        vBox.getChildren().addAll(bp1, bp2);
        layout.setTop(vBox);

        XYChart.Series<Number, Number> savings = new XYChart.Series<>();
        savings.setName("Savings");
        XYChart.Series<Number, Number> savingsAndInterests = new XYChart.Series<>();
        savingsAndInterests.setName("Savings and interest");

        lineChart.getData().add(savings);
        lineChart.getData().add(savingsAndInterests);

        monthlySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            monthlyLabel.setText(String.valueOf(newValue.intValue()));
            updateChart(monthlySlider.getValue(), interestSlider.getValue(), savings, savingsAndInterests);
        });

        interestSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            interestLabel.setText(String.format("%.2f", newValue));
            updateChart(monthlySlider.getValue(), interestSlider.getValue(), savings, savingsAndInterests);
        }); 

        Scene scene = new Scene(layout, 640, 640);
        window.setScene(scene);

        updateChart(monthlySlider.getValue(), interestSlider.getValue(), savings, savingsAndInterests);
        window.show();

    }

    public void updateChart(double monthlySavings, 
                            double interestRate, 
                            XYChart.Series<Number, Number> savings, 
                            XYChart.Series<Number, Number> savingsAndInterests) {
        savings.getData().clear();
        savingsAndInterests.getData().clear();

        double savingsTotal = 0;
        double compoundTotal = 0;

        for(int i = 0; i <= 30; i++) {
            savings.getData().add(new XYChart.Data<>(i, savingsTotal));
            savingsAndInterests.getData().add(new XYChart.Data<>(i, compoundTotal));
            savingsTotal += monthlySavings * 12;
            compoundTotal = (compoundTotal + (monthlySavings * 12)) * (1 + (interestRate / 100.0));
        }
    }
}
