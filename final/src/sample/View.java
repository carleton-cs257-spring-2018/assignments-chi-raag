package sample;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class View extends Group {

    private int N;

    /* A set constructor for the size of the pendulum system.
     */
    public View(int N) {
        this.N = N;
        this.initializeView();
    }

    /* A get method for the size of the pendulum system.
    */
    public int getN() {
        return this.N;
    }

    /* Initializes the graphic of the pendulum system.
      * Graphic starts from the horizontal position.
      * Includes a timer to show the evolution of the system quantitatively.
    */
    public void initializeView() {

    }

    /* Initializes the data graph of the Kinetic energy of the pendulum system.
      * Graphic starts from the horizontal position.
      * Includes a timer to show the evolution of the system quantitatively.
    */
    public void initializeGraph() {

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
