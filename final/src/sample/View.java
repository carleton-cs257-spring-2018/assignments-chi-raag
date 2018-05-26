package sample;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class View extends Group {

    /* A get method for the size of the pendulum system.
    */
    public int getN() {
        return this.N;
    }

    /* A set method for the size of the pendulum system.
    */
    public void setN(int N) {
        this.N = N;
        this.initializeView();
    }

    /* Initializes the graphic of the pendulum system.
      * Graphic starts from the horizontal position.
      * Includes a timer to show the evolution of the system quantitatively.
    */
    public initializeView() {

    }

    /* Initializes the data graph of the Kinetic energy of the pendulum system.
      * Graphic starts from the horizontal position.
      * Includes a timer to show the evolution of the system quantitatively.
    */
    public initializeGraph() {

    }

    /* Updates the graph view with information from model.
    * Will show different models as user inputs different demands.
    */
    public void updateGraph(Model model) {

    }

    /* Updates the pendulum visual with information from model.
    * Will show different system as user inputs different demands.
    */
    public void updateView(Model model) {

    }
}
