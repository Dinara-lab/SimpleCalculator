package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.controllers.HistoryController;

import java.util.Objects;

public class Main extends Application {

    private static Stage historyStage = null;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("resources/lineChart.fxml")));
        primaryStage.setTitle("LineChart");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        createHistoryStage();


    }

    public void createHistoryStage(){
        historyStage = new Stage();
        historyStage.setTitle("History");
        historyStage.setAlwaysOnTop(true);
        historyStage.setResizable(false);
        historyStage.initModality(Modality.APPLICATION_MODAL);
    }



    public static Stage getHistoryStage() {
        return historyStage;
    }



    public static void main(String[] args) {
        launch(args);
    }
}
