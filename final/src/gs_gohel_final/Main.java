/*
Chiraag Gohel, Sharan GS
CS 257, 18/SP
Adapted from Jeff Ondich's Daleks project
25 May 2018
 */
package gs_gohel_final;

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
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("The Pendulum");
        Controller controller = loader.getController();
        root.setOnKeyPressed(controller);
        primaryStage.setScene(scene);
        primaryStage.show();
        root.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}