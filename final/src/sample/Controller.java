package sample;

import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller implements EventHandler<KeyEvent> {
    @FXML private Label timeLabel;
    @FXML private Label messageLabel;
    @FXML private View View;
    private Model Model;

    public Controller() {
    }

    /*
     Initializes a pendulum model.
     */
    public void initialize() {
        this.Model = new Model();
        this.update();
    }


    /*
    Updates the pendulum model with the user demands.
     Allows the user to see the time of simulation.
     */
    private void update() {
        this.View.update(this.Model);
        this.timeLabel.setText(String.format("Time: ", this.Model.getScore()));
    }

    /*
     Allows the user to stop the current simulation and set a new pendulum size.
     User hits a specific key to stop current simulation, then inputs new size.
     Model updated appropriately.
     */
    @Override
    public void handle(KeyEvent keyEvent) {

    }
}