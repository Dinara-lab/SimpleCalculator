package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class HistoryController {

    @FXML
    private ListView list;

    public void initializeCalculations(ArrayList<String> history_list){
        history_list.forEach((calculation)->{
         list.getItems().add(calculation);
        });

    }
}
