package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


import java.net.URL;
import java.util.ResourceBundle;

public class LineChartController implements Initializable {

    @FXML
    private javafx.scene.chart.LineChart<?, ?> LineChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @Override
    public  void initialize(URL url, ResourceBundle rb){

        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("1",23));
        series.getData().add(new XYChart.Data("2",13));
        series.getData().add(new XYChart.Data("3",43));
        series.getData().add(new XYChart.Data("4",55));
        series.getData().add(new XYChart.Data("5",22));
        series.getData().add(new XYChart.Data("6",67));
        series.getData().add(new XYChart.Data("7",12));

        XYChart.Series series2 = new XYChart.Series();
        series2.getData().add(new XYChart.Data("1",123));
        series2.getData().add(new XYChart.Data("2",113));
        series2.getData().add(new XYChart.Data("3",143));
        series2.getData().add(new XYChart.Data("4",155));
        series2.getData().add(new XYChart.Data("5",122));
        series2.getData().add(new XYChart.Data("6",167));
        series2.getData().add(new XYChart.Data("7",112));


        LineChart.getData().addAll(series,series2);

    }
}

