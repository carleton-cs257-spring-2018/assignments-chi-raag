package edu.carleton.ganjam;

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

    /*
     * @constructor - Empty.
     */
    public Controller() {
        timeLabel=null;
        messageLabel=null;
    }

    /*
     Initializes a pendulum model. Default is a double pendulum (?)
     */
    public void initialize() {
        this.Model = new Model();
        this.View = new View(1);
        View.updateValues(Model);
    }

    /*
    Updates the pendulum model with the user demands - either works with the simulation visual or the KE graph.
     Allows the user to see the time at end of simulation.
     */
    public void update() {
        this.View.update(this.Model);

        //Display total time of simulation
        this.timeLabel = new Label(String.valueOf(this.Model.time));
        if(this.Model.getviewtype())
            this.messageLabel = new Label("Simulation of the pendulum in space");
        else
            this.messageLabel = new Label("Kinetic Energy of Pendulum");
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

        //boolean pressRecognized = true;
        boolean keyRecognized = true;
        KeyCode code = keyEvent.getCode();
        if (code == KeyCode.DIGIT1) {
            this.Model.startNewSimulation(1);
        } else if (code == KeyCode.DIGIT2) {
            this.Model.startNewSimulation(2);
        } else if (code == KeyCode.R) {
            //Default 1 for now
            this.Model.startNewSimulation(1);
        } else if (code == KeyCode.G) {
            if (this.Model.getviewtype()) {
                this.Model.setviewtype(false);
            }
        } else if (code == KeyCode.S) {
            if (!(this.Model.getviewtype())) {
                this.Model.setviewtype(true);
            }
        } else {
            keyRecognized = false;
        }

        if (keyRecognized) {
            this.update();
            keyEvent.consume();
        }
    }
}