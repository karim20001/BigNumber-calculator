package BignumberCalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("../view/Calculator.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Calculator");
        primaryStage.show();

    }
}

