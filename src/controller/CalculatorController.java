package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;

import javafx.stage.Stage;

import java.io.IOException;

import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class  CalculatorController implements Initializable {
    @FXML
    private Button BTN1;
    @FXML
    private Button BTN2;
    @FXML
    private Button BTN3;
    @FXML
    private Button BTN4;
    @FXML
    private Button BTN5;
    @FXML
    private Button BTN6;
    @FXML
    private Button BTN7;
    @FXML
    private Button BTN8;
    @FXML
    private Button BTN9;
    @FXML
    private Button BTN0;
    @FXML
    private Button BTSin;
    @FXML
    private Button BTNcos;
    @FXML
    private Button BTPositive;
    @FXML
    private Button BTEqual;
    @FXML
    private Button BTMulti;
    @FXML
    private Button BTDiv;
    @FXML
    private Button BTClear;
    @FXML
    private Button BTFact;
    @FXML
    private Button BTMinus;
    @FXML
    private Button BTPow;
    @FXML
    private Button BTIntegral;
    @FXML
    private TextArea area1;
    @FXML
    private TextArea area2;


    boolean checkZero_beforeNumber = true;

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    String result = "0";

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //BTN1 action
        BTN1.setOnAction(e -> inputNumber_afterZero('1'));
        BTN1.setOnMouseEntered(MouseEvent -> BTN1.setStyle("-fx-background-color: #303030"));
        BTN1.setOnMouseExited(MouseEvent -> BTN1.setStyle("-fx-background-color: black"));

        //BTN2
        BTN2.setOnAction(e -> inputNumber_afterZero('2'));
        BTN2.setOnMouseEntered(MouseEvent -> BTN2.setStyle("-fx-background-color: #303030"));
        BTN2.setOnMouseExited(MouseEvent -> BTN2.setStyle("-fx-background-color: black"));

        //BTN3
        BTN3.setOnAction(e -> inputNumber_afterZero('3'));
        BTN3.setOnMouseEntered(MouseEvent -> BTN3.setStyle("-fx-background-color: #303030"));
        BTN3.setOnMouseExited(MouseEvent -> BTN3.setStyle("-fx-background-color: black"));

        //BTN4
        BTN4.setOnAction(e -> inputNumber_afterZero('4'));
        BTN4.setOnMouseEntered(MouseEvent -> BTN4.setStyle("-fx-background-color: #303030"));
        BTN4.setOnMouseExited(MouseEvent -> BTN4.setStyle("-fx-background-color: black"));

        //BTN5
        BTN5.setOnAction(e -> inputNumber_afterZero('5'));
        BTN5.setOnMouseEntered(MouseEvent -> BTN5.setStyle("-fx-background-color: #303030"));
        BTN5.setOnMouseExited(MouseEvent -> BTN5.setStyle("-fx-background-color: black"));

        //BTN6
        BTN6.setOnAction(e -> inputNumber_afterZero('6'));
        BTN6.setOnMouseEntered(MouseEvent -> BTN6.setStyle("-fx-background-color: #303030"));
        BTN6.setOnMouseExited(MouseEvent -> BTN6.setStyle("-fx-background-color: black"));

        //BTN7
        BTN7.setOnAction(e -> inputNumber_afterZero('7'));
        BTN7.setOnMouseEntered(MouseEvent -> BTN7.setStyle("-fx-background-color: #303030"));
        BTN7.setOnMouseExited(MouseEvent -> BTN7.setStyle("-fx-background-color: black"));

        //BTN8
        BTN8.setOnAction(e -> inputNumber_afterZero('8'));
        BTN8.setOnMouseEntered(MouseEvent -> BTN8.setStyle("-fx-background-color: #303030"));
        BTN8.setOnMouseExited(MouseEvent -> BTN8.setStyle("-fx-background-color: black"));

        //BTN9
        BTN9.setOnAction(e -> inputNumber_afterZero('9'));
        BTN9.setOnMouseEntered(MouseEvent -> BTN9.setStyle("-fx-background-color: #303030"));
        BTN9.setOnMouseExited(MouseEvent -> BTN9.setStyle("-fx-background-color: black"));

        //BTN0
        BTN0.setOnAction(e -> checkZero());
        BTN0.setOnMouseEntered(MouseEvent -> BTN0.setStyle("-fx-background-color: #303030"));
        BTN0.setOnMouseExited(MouseEvent -> BTN0.setStyle("-fx-background-color: black"));

        //BTSin
        BTSin.setOnAction(e -> area1.setText(area1.getText() + "sin("));
        BTSin.setOnMouseEntered(MouseEvent -> BTSin.setStyle("-fx-background-color: #303030"));
        BTSin.setOnMouseExited(MouseEvent -> BTSin.setStyle("-fx-background-color: black"));

        //BTNcos
        BTNcos.setOnAction(e -> area1.setText("cos("));
        BTNcos.setOnMouseEntered(MouseEvent -> BTNcos.setStyle("-fx-background-color: #303030"));
        BTNcos.setOnMouseExited(MouseEvent -> BTNcos.setStyle("-fx-background-color: black"));

        //BTPositive
        BTPositive.setOnAction(e ->{
            if (area1.getText().length() != 0)
                checkDouble('+');
        });
        BTPositive.setOnMouseEntered(MouseEvent -> BTPositive.setStyle("-fx-background-color: #303030"));
        BTPositive.setOnMouseExited(MouseEvent -> BTPositive.setStyle("-fx-background-color: black"));

        //BTMin
        BTMinus.setOnAction(e -> checkDouble('-'));
        BTMinus.setOnMouseEntered(MouseEvent -> BTMinus.setStyle("-fx-background-color: #303030"));
        BTMinus.setOnMouseExited(MouseEvent -> BTMinus.setStyle("-fx-background-color: black"));

        //BTMulti
        BTMulti.setOnAction(e -> checkDouble('x'));
        BTMulti.setOnMouseEntered(MouseEvent -> BTMulti.setStyle("-fx-background-color: #303030"));
        BTMulti.setOnMouseExited(MouseEvent -> BTMulti.setStyle("-fx-background-color: black"));

        //BTDiv
        BTDiv.setOnAction(e -> checkDouble('÷'));
        BTDiv.setOnMouseEntered(MouseEvent -> BTDiv.setStyle("-fx-background-color: #303030"));
        BTDiv.setOnMouseExited(MouseEvent -> BTDiv.setStyle("-fx-background-color: black"));

        //BTClear
        BTClear.setOnAction(e -> {
            area2.setText("");
            area2.setVisible(false);
            area1.setText("");
            setResult("0");
        });
        BTClear.setOnMouseEntered(MouseEvent -> BTClear.setStyle("-fx-background-color: #303030"));
        BTClear.setOnMouseExited(MouseEvent -> BTClear.setStyle("-fx-background-color: black"));

        //BTPower
        BTPow.setOnAction(e -> checkDouble('^'));
        BTPow.setOnMouseEntered(MouseEvent -> BTPow.setStyle("-fx-background-color: #303030"));
        BTPow.setOnMouseExited(MouseEvent -> BTPow.setStyle("-fx-background-color: black"));

        //BTFact
        BTFact.setOnAction(e -> fact());
        BTFact.setOnMouseEntered(MouseEvent -> BTFact.setStyle("-fx-background-color: #303030"));
        BTFact.setOnMouseExited(MouseEvent -> BTFact.setStyle("-fx-background-color: black"));

        //BTEqual
        BTEqual.setOnAction(e -> checkDouble('='));
        BTEqual.setStyle("-fx-background-color: darkgreen");
        BTEqual.setOnMouseEntered(MouseEvent -> BTEqual.setStyle("-fx-background-color: #303030"));
        BTEqual.setOnMouseExited(MouseEvent -> BTEqual.setStyle("-fx-background-color: darkgreen"));

        //BTIntegral
        BTIntegral.setOnAction(e -> {
            Stage integralStage = new Stage();

            try {
                Parent root = FXMLLoader.load(this.getClass().getResource("../view/Integral.fxml"));

                integralStage.setScene(new Scene(root));
                integralStage.setTitle("Integral");
                integralStage.show();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });
        BTIntegral.setOnMouseEntered(MouseEvent -> BTIntegral.setStyle("-fx-background-color: #303030"));
        BTIntegral.setOnMouseExited(MouseEvent -> BTIntegral.setStyle("-fx-background-color: black"));

        //keyDownPressed
        area1.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.DIGIT0 || e.getCode() == KeyCode.NUMPAD0){
                keyPressedZero();
            }


        });
    }
    public void checkDouble (char a) {
        if (area1.getText().length() != 0) {
            char check = area1.getText().charAt(area1.getText().length() - 1);
            int i = Character.getNumericValue(check);

            if ((a == '+' && check == '-') || (a == '-' && check == '+')) {
                area1.setText(area1.getText().substring(0, area1.getText().length() - 1) + "-");
                checkZero_beforeNumber = true;

            }

            if (i > -1 && i < 10) {
                area1.setText(area1.getText() + a);
                checkZero_beforeNumber = true;
            }
            if ((check == '÷' || check == 'x' || check == '^' || check == '(') && a == '-'){
                area1.setText(area1.getText() + a);

            }
        }
        else
        if (a != 'x' && a != '÷') {
            area1.setText(area1.getText() + a);

        }
        if (a == '='){
            showResult();
        }


    }
    public void checkZero(){
        if (area1.getText().length() == 0)
            checkZero_beforeNumber = true;
        if (checkZero_beforeNumber) {

            if (area1.getText().length() != 0) {
                int checkZero = Character.getNumericValue(area1.getText().charAt(area1.getText().length() - 1));

                if (((checkZero > -1 && checkZero < 10) || checkZero == -1 || checkZero == 33) && (area1.getText().charAt(0) != '+')) {
                    area1.setText(area1.getText() + "0");
                    if (checkZero == -1 || checkZero == 33)
                        checkZero_beforeNumber = false;
                }
            } else {
                area1.setText(area1.getText() + "0");
                checkZero_beforeNumber = false;
            }
        }
    }
    public void inputNumber_afterZero(char digit){
        if (area1.getText().length() == 0)
            checkZero_beforeNumber = true;
        if (checkZero_beforeNumber){
            area1.setText(area1.getText() + digit);
        }

    }
    public void keyPressedZero(){

        if (checkZero_beforeNumber) {

            if (area1.getText().length() != 0) {

                int checkZero = Character.getNumericValue(area1.getText().charAt(area1.getText().length() - 1));

                if (((checkZero > -1 && checkZero < 10) || checkZero == -1 || checkZero == 33) && (area1.getText().charAt(0) != '+' && area1.getText().charAt(0) != '-' )) {
                    if (checkZero == -1 || checkZero == 33)
                        checkZero_beforeNumber = false;
                }
                else
                    area1.setText(area1.getText().substring(0, area1.getText().length() -1));
            } else {
                checkZero_beforeNumber = false;
            }
        }
        else
            area1.setText(area1.getText().substring(0, area1.getText().length() - 1));
    }
    public void showResult() {

        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<Character> signs = new ArrayList<>();

        char sign;
        String number2 = "";

        String areaText = area1.getText();

        CharSequence temp = "cos";
        boolean cos = areaText.contains(temp);

        CharSequence temp1 = "sin";
        boolean sin = areaText.contains(temp1);

        int i = 0;
        for (; i < areaText.length(); i++) {

            if (cos) {
                calculateCos();
                return;
            }

            if (sin) {
                calculateSin();
                return;
            }

            if (i > 0 && ((Character.getNumericValue(areaText.charAt(i)) == -1) || Character.getNumericValue(areaText.charAt(i)) == 33)) {

                sign = areaText.charAt(i);

                numbers.add(number2);
                signs.add(sign);
                i = i + 1;
                number2 = "";

            }

            if (i != areaText.length())
                number2 += areaText.charAt(i);
        }
        signs.remove(signs.size() - 1);

        char e = '^';
        for (int t = 0; t < 3; t++) {

            if (cos || sin)
                break;

            boolean m = false;

            if ( t == 1)
                e = 'x';

            if (t == 2)
                m = true;

            int k = 0;
            for (int r = 0; r < signs.size(); r++) {

                char ch = signs.get(r);


                char underZero = '2';

                if (ch == e || m) {

                    String[] number = new String[3];
                    number[0] = numbers.get(r);
                    number[1] = numbers.get(r + 1);

                    if ((t == 2 && k == signs.size() - 1) || numbers.size() == 2) {
                        number[2] = "false";
                    }

                    else
                        number[2] = "3";

                    if (signs.get(r) == '-' && number[0].charAt(0) == '-') {

                        underZero = '-';
                        signs.set(r, '+');

                    } else if (signs.get(r) == '+' && number[0].charAt(0) == '-') {
                        signs.set(r, '-' );
                        underZero = '-';
                    }

                    if ((signs.get(r) == 'x' || signs.get(r) == '÷') && number[0].charAt(0) == '-' && number[1].charAt(0) == '-') {
                        number[0] = number[0].substring(1);
                        number[1] = number[1].substring(1);
                        underZero = '+';
                    }

                    if ((signs.get(r) == 'x' || signs.get(r) == '÷') && number[0].charAt(0) == '-' && number[1].charAt(0) != '-') {
                        number[0] = number[0].substring(1);
                        underZero = '-';
                    }

                    if ((signs.get(r) == 'x' || signs.get(r) == '÷') && number[0].charAt(0) != '-' && number[1].charAt(0) == '-') {
                        number[1] = number[1].substring(1);
                        underZero = '-';
                    }

                    switch (signs.get(r)) {
                        case '+':
                            addingProcess(number, underZero);
                            break;
                        case '-':
                            subtractionProcess(number, underZero);
                            break;
                        case 'x':
                            multiplyingProcess(number, underZero);
                            break;
                        case '÷':
                            dividingProcess(number, underZero);
                            break;
                        case '^':
                            power(number);
                            break;

                    }

                    numbers.remove(r);
                    numbers.remove(r);
                    numbers.add(r, result);
                    signs.remove(r);
                    r = -1;

                }

            }

        }

    }
    public void addingProcess(String[] numbers, char underZero){
        String a,b;

        if (underZero == '-')
            numbers[0] = numbers[0].substring(1);

        if (numbers[0].length() > numbers[1].length()) {
            a = numbers[0];
            b = numbers[1];
        }
        else {
            a = numbers[1];
            b = numbers[0];
        }
        int counter = 0;
        StringBuilder u = new StringBuilder();

        int d;
        int j = b.length() - 1;
        for (int i = a.length() - 1; i >= 0; i--){

            int c = Character.getNumericValue(a.charAt(i));
            if (j >= 0) {
                d = c + Character.getNumericValue(b.charAt(j)) + counter;
                j--;
            }
            else {
                d = c + counter;
            }
            if (d > 9) {
                counter = 1;
            }
            else {
                counter = 0;
            }
            u.append(d % 10);
        }

        if (counter > 0)
            u.append(counter);

        if (underZero == '-')
            u.append('-');

        StringBuilder h = new StringBuilder();
        for (int i = u.length() -1; i >= 0; i--){
            h.append(u.charAt(i));
        }
        setResult(h.toString());
        if (!numbers[2].equals("3"))
            clearText_area1_set_area2('+');

    }

    public void multiplyingProcess (String[] numbers, char underZero){
        String a,b;

        if (numbers[0].length() > numbers[1].length()){
            a = numbers[0];
            b = numbers[1];
        }
        else {
            a = numbers[1];
            b = numbers[0];
        }

        int counter = 0;
        StringBuilder u = new StringBuilder();
        String g = "0";
        StringBuilder m = new StringBuilder();
        int y = 0;
        int counter_plus = 0;

        for (int i = b.length() - 1; i >= 0; i--){

            int c = Character.getNumericValue(b.charAt(i));
            for (int j = a.length() - 1;j >= 0; j--){
                int d = counter + (c * Character.getNumericValue(a.charAt(j)));
                if (d > 9)
                    counter = d / 10;
                else
                    counter = 0;
                u.append(d % 10);
            }
            if (counter > 0)
                u.append(counter);
            StringBuilder s = new StringBuilder();
            counter = 0;
            for (int k = u.length() - 1; k >= 0; k--){
                s.append(u.charAt(k));
            }
            for (int x = y; x > 0; x--){
                s.append("0");
            }

            int l = g.length() - 1;

            for (int j = s.length() - 1; j>=0; j--){
                int p = Character.getNumericValue(s.charAt(j));
                int d;
                if (l >= 0) {
                    d = p + counter_plus + Character.getNumericValue(g.charAt(l));
                    l--;
                }
                else
                    d = p + counter_plus;
                if (d > 9)
                    counter_plus = 1;
                else
                    counter_plus = 0;
                m.append(d % 10);
            }
            if (counter_plus > 0)
                m.append(counter_plus);
            StringBuilder e = new StringBuilder();
            counter_plus = 0;
            for (int o = m.length() - 1; o >= 0; o--){
                e.append(m.charAt(o));
            }
            m = new StringBuilder();
            u = new StringBuilder();
            g = e.toString();
            y++;
        }

        if (underZero == '-')
            g = underZero + g;

        setResult(g);
        if (numbers[0].equals("0") || numbers[1].equals("0"))
            setResult("0");

        if (!numbers[2].equals("3"))
            clearText_area1_set_area2('x');

    }

    public void subtractionProcess(String[] numbers, char underZero){

        String a="",b="";
        String bigRightNumber= "";

        boolean equal = true;

        if (underZero == '-'){
            numbers[0] = numbers[0].substring(1);

        }

        if (numbers[0].length() == numbers[1].length()){

            for (int i = 0; i < numbers[0].length(); i++ ){

                if (Character.getNumericValue(numbers[0].charAt(i)) > Character.getNumericValue(numbers[1].charAt(i))){
                    a = numbers[0];
                    b = numbers[1];
                    if (underZero == '-')
                        bigRightNumber = "-";
                    equal = false;
                    break;
                }
                else if (Character.getNumericValue(numbers[0].charAt(i)) < Character.getNumericValue(numbers[1].charAt(i))){
                    a = numbers[1];
                    b = numbers[0];
                    if (underZero != '-')
                        bigRightNumber = "-";
                    equal = false;
                    break;
                }
            }
        }

        if (numbers[0].length() > numbers[1].length() ) {
            a = numbers[0];
            b = numbers[1];
            if (underZero == '-')
                bigRightNumber = "-";
            equal = false;
        }
        else if (numbers[0].length() < numbers[1].length() || equal){
            a = numbers[1];
            b = numbers[0];
            if (underZero != '-')
                bigRightNumber = "-";
        }
        int counter = 0;
        StringBuilder u = new StringBuilder();

        int d;
        int j = b.length() - 1;

        for (int i = a.length() - 1; i >= 0; i--){
            int c = Character.getNumericValue(a.charAt(i));

            if (j >= 0) {

                int e = Character.getNumericValue(b.charAt(j));
                if (e > c || (c + counter < e)){

                    c = c + 10;
                    d = c - e + counter;
                    counter = -1;
                }

                else {
                    d = c - e + counter;

                    counter = 0;
                }
                j--;
            }
            else {

                if (counter != 0 && c == 0){

                    c = c + 10;
                    d = c + counter;
                    counter = -1;

                }
                else {
                    d = c + counter;
                    counter = 0;
                }

            }

            u.append(d % 10);

        }

        StringBuilder h = new StringBuilder();
        boolean check = false;
        u.append(bigRightNumber);

        for (int i = u.length() -1; i >= 0; i--){
            if (a.equals(b)) {
                h = new StringBuilder("0");
                break;
            }

            if (  u.charAt(i) == '-' || check || Character.getNumericValue(u.charAt(i)) != 0 ){
                h.append(u.charAt(i));
                if (u.charAt(i) != '-')
                    check = true;
            }
        }

        setResult(h.toString());
        if (!numbers[2].equals("3"))
            clearText_area1_set_area2('-');

    }

    public void dividingProcess(String[] numbers, char underZero){
        String a,b;
        a = numbers[0];
        b = numbers[1];
        StringBuilder res = new StringBuilder();
        String r ="";
        setResult("1");
        String saver = "";
        int j = 0;

        for (int i = 0; i < a.length() ;){

            if (numbers[1].equals("0")){
                setResult("Error");
                clearText_area1_set_area2('÷');
                return;
            }
            if (a.length() < b.length()){
                r = a;
                res = new StringBuilder("0");
                break;
            }

            for (; j < b.length() ; j++){

                saver += a.charAt(i);
                i++;
            }

            j = b.length() - 1;

            if (i == a.length() && saver.length() == b.length()){
                String[] check = {saver, b, "3"};
                subtractionProcess(check, '4');

                if (result.charAt(0) == '-'){
                    res.append("0");
                    r = saver;

                    break;
                }
            }

            else if (i < a.length() && saver.length() == b.length()){

                String[] check = {saver, b, "3"};
                subtractionProcess(check,'3');

                if (result.charAt(0) == '-'){

                    if (!saver.equals("0")) {
                        saver += a.charAt(i);
                        if (res.length() != 0)
                            res.append("0");
                        i++;
                    }
                }

            }

            if (saver.length() < b.length()) {


                for (int k = 0; k < b.length(); k++) {

                    if ( i < a.length() && !r.equals("0")) {



                        saver += a.charAt(i);
                        i++;
                        res.append("0");
                        break;

                    }
                }
            }

            int multi = 0;

            result = saver;

            while (true){


                if (saver.equals("0") && r.equals("0") && i < a.length()){

                    res.append("0");
                    saver="";
                    break;
                }

                r = result;
                String[] mi_number = {result,b,"3"};
                subtractionProcess(mi_number, '3');

                if (result.charAt(0) == '-'){
                    res.append(multi);
                    break;
                }
                else
                    multi++;

            }

            if (r.equals("0"))
                saver = "";
            else
                saver = r;

        }
        if (underZero == '-' && !r.equals("0")){
            String[] mx_number = {r, b, "3"};
            subtractionProcess(mx_number, '3');
            r = result;
            r = r.substring(1);

            mx_number = new String[]{res.toString(), "1", "3"};
            addingProcess(mx_number, '+');
            res = new StringBuilder("-" + result);
        }

        if (underZero == '-' && r.equals("0"))
            res.insert(0, "-");

        if (!r.equals("0") ) {
            while (r.charAt(0) == '0') {
                r = r.substring(1);

                if (r.length() == 1)
                    break;
            }
        }

        setResult(res + "  r: " + r);
        if (!numbers[2].equals("3"))
            clearText_area1_set_area2('÷');
    }

    public void power(String[] numbers){

        boolean num1_underZero = false, num2_underZero = false;

        if (numbers[0].charAt(0) == '-'){

            if (Character.getNumericValue(numbers[1].charAt(numbers[1].length() - 1)) % 2 != 0)
                num1_underZero = true;
            numbers[0] = numbers[0].substring(1);

        }

        if (numbers[1].charAt(0) == '-'){
            num2_underZero = true;
            numbers[1] = numbers[1].substring(1);
        }

        String n = numbers[0], n1 = numbers[0];
        setResult(numbers[0]);

        while (!numbers[1].equals("1")){

            if (numbers[0].equals("0")){
                n = "0";
                break;
            }

            if (numbers[1].equals("0")){
                n = "1";
                break;
            }

            String[] temp = {n, n1, "3"};
            multiplyingProcess(temp, '+');
            n = result;

            String[] temp1 = {numbers[1], "1", "3"};
            subtractionProcess(temp1, '+');
            numbers[1] = result;
        }

        if (!num1_underZero && !num2_underZero)
            setResult(n);

        if (num1_underZero && !num2_underZero)
            setResult("-" + n);

        if (!num1_underZero && num2_underZero)
            setResult("1/" + n);

        if (num1_underZero && num2_underZero)
            setResult("-1/" + n);

        if (!numbers[2].equals("3"))
            clearText_area1_set_area2('^');


    }

    public void fact(){

        String save = area1.getText();
        String number = "1";

        if (save.equals("0") || save.equals("1"))
            save = "1";

        else {
            String[] temp2 = {save, "1", "3"};
            subtractionProcess(temp2, '+');
            number = result;
        }

        while (!number.equals("1") && !number.equals("0")){

            String[] temp1 = {save, number, "3"};
            multiplyingProcess(temp1, '+');
            save = result;

            String[] temp = {number, "1", "3"};
            subtractionProcess(temp, '+');
            number = result;

        }

        setResult(save);
        clearText_area1_set_area2('!');
    }

    public void calculateCos(){

        String input = area1.getText(4, area1.getText().length() - 1);
        input += "0000";

        int piNumber = 360 * 10000;

        String[] temp = {input, Integer.toString(piNumber), "3"};
        dividingProcess(temp, '+');
        int r = result.indexOf(':');
        StringBuilder tempN = new StringBuilder();

        for (int i = r + 1; i < result.length(); i++)
            tempN.append(result.charAt(i));

        double number =  Float.parseFloat(String.valueOf(tempN)) / 10000;
        boolean check = false;

        if (number == 90 || number == 270)
            check = true;

        number = number * 2 * Math.PI / 360;
        double output = 1;

        int j = -1, pow = 2, fact = 2;
        for (int i = 0; i < 8; i++, pow += 2, fact += 2, j *= -1){

            if (check)
            {
                output = 0;
                break;
            }

            double temp2 = Math.pow(number, pow);

            for (int k = 1; k <= fact; k++)
                temp2 = temp2 / k;

            output = output + temp2 * j;
        }

        output = Math.round(output * 100000);
        output = output / 100000;

        area2.setVisible(true);
        area2.setText(area1.getText().substring(0, area1.getText().length() - 1) + ")=");
        area1.setText(String.valueOf(output));

    }

    public void calculateSin(){

        String input = area1.getText(4, area1.getText().length() - 1);
        input += "0000";

        int piNumber = 360 * 10000;

        String[] temp = {input, Integer.toString(piNumber), "3"};
        dividingProcess(temp, '+');
        int r = result.indexOf(':');
        StringBuilder tempN = new StringBuilder();

        for (int i = r + 1; i < result.length(); i++)
            tempN.append(result.charAt(i));

        double number =  Float.parseFloat(String.valueOf(tempN)) / 10000;

        number = number * 2 * Math.PI / 360;
        double output = number;

        int j = -1, pow = 3, fact = 3;
        for (int i = 0; i < 8; i++, pow += 2, fact += 2, j *= -1){

            double temp2 = Math.pow(number, pow);

            for (int k = 1; k <= fact; k++)
                temp2 = temp2 / k;

            output = output + temp2 * j;
        }

        output = Math.round(output * 100000);
        output = output / 100000;

        area2.setVisible(true);
        area2.setText(area1.getText().substring(0, area1.getText().length() - 1) + ")=");
        area1.setText(String.valueOf(output));

    }

    public void clearText_area1_set_area2(char sign){

        area2.setVisible(true);
        String newSign = String.valueOf(sign);
        String[] clear_equal = new String[2];
        if(area2.getText().length() == 0)
            clear_equal[1] =  area1.getText();
        String clear_equal2 = "";

        if (sign == '+')
            newSign = "\\+";
        else if (sign == '^')
            newSign = "\\^";

        if (area2.getText().length() != 0) {
            clear_equal2 = area2.getText().substring(0, area2.getText().length() - 1);
            clear_equal = area1.getText().split(newSign);
            area2.setText(clear_equal2 + sign + clear_equal[1].substring(0, clear_equal[1].length() - 1) + "=");
        }
        else
            area2.setText(clear_equal2 + clear_equal[1].substring(0, clear_equal[1].length() - 1) + "=");


        if (sign == '!'){
            area2.setText(area1.getText() + "!" + "=");
        }
        area1.setText(result);

    }

}
