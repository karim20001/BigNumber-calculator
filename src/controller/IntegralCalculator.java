package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IntegralCalculator implements Initializable {

    @FXML
    private Button BTCal;
    @FXML
    private GridPane InputArea;
    @FXML
    private TextField DegreeArea;
    @FXML
    private TextField UpperArea;
    @FXML
    private TextField LowerArea;
    @FXML
    private TextArea showResult;

    ArrayList<TextField> textFiledArray = new ArrayList<>();

    public void initialize(URL location, ResourceBundle resources) {

        BTCal.setOnMouseEntered(MouseEvent -> BTCal.setStyle("-fx-background-color: #303030"));
        BTCal.setOnMouseExited(MouseEvent -> BTCal.setStyle("-fx-background-color: black"));

        DegreeArea.textProperty().addListener(e -> createElements());

        BTCal.setOnAction(e -> calculate());

    }

    public void createElements(){

        InputArea.getChildren().clear();
        textFiledArray.clear();

        if (DegreeArea.getText().equals("") || DegreeArea.getText().length() > 1)
            return;


        int degree = Character.getNumericValue(DegreeArea.getText().charAt(0));

        if (degree < 0 || degree > 10)
            return;

        int j = 0;
        int k = 1;

        // add Label
        for (int i = degree * 2 + 1; i >= 0; i = i - 2){

            String temp = "";
            if (i == 3)
                temp = " x   +";

            else if (i > 3)
                temp = " x" + i / 2 + "  + ";
            temp = superscript(temp);

            Label label = new Label();
            label.setText(temp);

            label.setTextFill(Color.WHITE);
            label.setFont(new Font(18));
            InputArea.add(label, k, j, 1, 1);

            if (k == 9){
                j ++;
                k = -1;
            }

            if (j == 2)
                break;
            k += 2;

        }

        // add textField
        j = 0;
        k = 0;

        for (int i = 0; i < degree * 2 + 2; i = i + 2){

            javafx.scene.control.TextField textField = new javafx.scene.control.TextField();
            textFiledArray.add(textField);

            textField.getStylesheets().add(String.valueOf(this.getClass().getResource("../view/init.css")));

            InputArea.add(textField, k, j);

            if (i == 8){
                j ++;
                k = -2;
            }
            if (j == 2)
                break;
            k += 2;

        }
    }

    public void calculate(){

        String upperField = UpperArea.getText(), lowerField = LowerArea.getText();

        int j = textFiledArray.size();

        if (upperField.length() < 9  && lowerField.length() < 9)
        {
            double result = 0;

            for (TextField textField : textFiledArray) {

                //calculate pow then multiply
                double coefficient = Double.parseDouble(textField.getText()) / j;

                String[] temp = {upperField, Integer.toString(j), "3"};
                CalculatorController cc = new CalculatorController();
                cc.power(temp);

                result += Double.parseDouble(cc.getResult()) * coefficient;

                String[] temp1 = {lowerField, Integer.toString(j), "3"};
                cc.power(temp1);

                result -= Double.parseDouble(cc.getResult()) * coefficient;

                j--;

            }
            result *= 1000;
            result = Math.round(result);
            result = result / 1000;
            show(Double.toString(result));
        }

        else
        {
            String result = "0";
            String save;

            for (TextField textField : textFiledArray){

                int coefficient = Math.round(Float.parseFloat(textField.getText()) / j);

                String[] temp = {upperField, Integer.toString(j), "3"};
                CalculatorController cc = new CalculatorController();
                cc.power(temp);

                String[] temp1 = {cc.getResult(), Integer.toString(coefficient), "3"};
                cc.multiplyingProcess(temp1, '+');
                save = cc.getResult();

                String[] temp2 = {result, save, "3"};
                cc.addingProcess(temp2, '+');
                result = cc.getResult();

                String[] temp3 = {lowerField, Integer.toString(j), "3"};
                cc.power(temp3);

                String[] temp4 = {cc.getResult(), Integer.toString(coefficient), "3"};
                cc.multiplyingProcess(temp4, '+');
                save = cc.getResult();

                String[] temp5 = {result, save, "3"};
                cc.subtractionProcess(temp5, '+');
                result = cc.getResult();
            }
            show(result);
        }
    }

    public static String superscript(String str) {
        str = str.replaceAll("0", "⁰");
        str = str.replaceAll("1", "¹");
        str = str.replaceAll("2", "²");
        str = str.replaceAll("3", "³");
        str = str.replaceAll("4", "⁴");
        str = str.replaceAll("5", "⁵");
        str = str.replaceAll("6", "⁶");
        str = str.replaceAll("7", "⁷");
        str = str.replaceAll("8", "⁸");
        str = str.replaceAll("9", "⁹");
        return str;
    }

    public void show(String result){

        showResult.setVisible(true);
        showResult.setStyle("-fx-text-fill: green; -fx-font-size: 20");
        showResult.setText("Result = " + result);
    }
}
