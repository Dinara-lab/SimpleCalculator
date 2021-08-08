package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import sample.Main;
import sample.utils.EvaluateString;

import java.io.IOException;
import java.util.ArrayList;

public class CalculatorController {

    @FXML
    private Label expr;

    @FXML
    private Label result;

    private ArrayList<String> calculation_history = new ArrayList<>();



    public void insertNumber(String number){
        expr.setText(expr.getText() + number);
    }
    public void insertOperator(String operator){
        expr.setText(expr.getText() + " " + operator + " ");
    }
    public void clearExpression(){
        expr.setText("");
    }

    public Label getExpr() {
        return expr;
    }

    public Label getResult() {
        return result;
    }

    public void setResult(String newResult) {

        this.result.setText("= " + newResult);
    }

    public void insertAnswer(String answer){
        expr.setText(expr.getText() + answer);
    }

    public void  deleteLast(){
        if (!getExpr().getText().isEmpty()){
            StringBuilder text = new StringBuilder(getExpr().getText());
            text.deleteCharAt(text.length() - 1);
            getExpr().setText(text.toString());
        }
    }
    public void addCalculation(String expression, String result){
        this.calculation_history.add(expression + " = " + result);

    }

    public void openHistoryWindow(){
        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/resources/history.fxml"));
            Parent root = loader.load();
            Main.getHistoryStage().setScene(new Scene(root));
            HistoryController historyController = loader.getController();
            historyController.initializeCalculations(calculation_history);
            Main.getHistoryStage().show();

        }catch (IOException e){
            System.out.println(e);
        }

    }

    public void onMouseClick(MouseEvent mouseEvent) {

        Button button = (Button) mouseEvent.getSource();
        String buttonText = button.getText();

        switch (buttonText){
            case "1" :
            case "2" :
            case "3" :
            case "4" :
            case "5" :
            case "6" :
            case "7" :
            case "8" :
            case "9" :
            case "0" :
                insertNumber(buttonText);
                break;
            case "-" :
            case "+" :
            case "/" :
            case "*" :
                insertOperator(buttonText);
                break;
            case "CLEAR" :
                clearExpression();
            case "=" :
                int result = EvaluateString.evaluate(this.getExpr().getText());
                addCalculation(this.expr.getText(), String.valueOf(result));
                setResult(String.valueOf(result));
                break;
            case "ANS":
                insertAnswer(getResult().getText().substring(2));
                break;
            case "DELETE" :
                deleteLast();
                break;
            case "HIST" :
                openHistoryWindow();
                break;

        }


    }
}
