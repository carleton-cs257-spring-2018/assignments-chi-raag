package gs_gohel_final;

import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class Controller implements EventHandler<KeyEvent> {
    @FXML
    private Label timeLabel;
    @FXML
    private Label messageLabel;
    @FXML
    private View View;
    private Model Model;

    /**
     * @constructor
     */
    public Controller() {
    }

    /*
     Initializes a pendulum model. Default is a double pendulum (?)
     */
    public void initialize() {
        this.Model = new Model();
        this.View = new View(2);
        View.updateValues(Model);
    }

    /*
    Updates the pendulum model with the user demands - either works with the simulation visual or the KE graph.
     Allows the user to see the time at end of simulation.
     */
    public void update() {
        this.View.update(this.Model);
        //Display total time of simulation
        //this.timeLabel.setText(String.format("Time: ", this.Model.getTime()));
    }

    /*
     Allows the user to stop the current visual.
     Switch view between simulation and KE graph.
     Or stop the simulation and set a new pendulum size.
     User hits a specific key to stop current simulation, then inputs new size or demand for new view.
     Model updated appropriately.
     */
    @Override
    public void handle(KeyEvent keyEvent) {
        //Uses Model.setviewtype() to manipulate viewtype depending on user input

        boolean pressRecognized = true;
    }

}