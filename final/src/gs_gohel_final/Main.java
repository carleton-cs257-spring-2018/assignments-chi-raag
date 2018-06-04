/*
Chiraag Gohel, Sharan GS
CS 257, 18/SP
Adapted from Jeff Ondich's Daleks project
25 May 2018
 */
package edu.carleton.ganjam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gs_gohel_final.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setTitle("The Pendulum");
        primaryStage.setScene(scene);
        Controller controller = loader.getController();
        root.setOnKeyPressed(controller);
        controller.update();
        //double sceneWidth = controller.getBoardWidth() + 20.0;
        //double sceneHeight = controller.getBoardHeight() + 100.0;
        //primaryStage.setScene(new Scene(root, sceneWidth, sceneHeight));
        primaryStage.show();
        root.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}