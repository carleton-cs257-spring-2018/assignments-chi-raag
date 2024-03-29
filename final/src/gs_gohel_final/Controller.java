/*
 * Pendulum JAVAFX project
 * Authors: Chiraag Gohel and Sharan Ganjam Seshachallam
 * CS 257, Spring 2018
 * Controller.java - a part of the Pendulum MVC project.

 */

package gs_gohel_final;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;


public class Controller implements EventHandler<KeyEvent> {

    private final int FRAMES_PER_SECOND = 20;
    EventHandler<ActionEvent> updater;
    Timeline timeline;
    //Switch to show if timeline is running or not
    boolean running;
    //@FXML private Label timeLabel;
    @FXML
    private View view;
    private Model model;

    /*
     * @constructor - Initializes model and running.
     */
    public Controller() {
        //timeLabel=null;
        model = new Model();
        running = false;
    }

    /* Starts the timer for the view Pane
        System runs indefinitely unless user overrides.
     */
    private void startTimer(int nodes) {

        updater = event -> update(nodes);
        timeline = new Timeline(new KeyFrame(Duration.seconds(1.0 / FRAMES_PER_SECOND), updater));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFromStart();
        running = true;

    }

    /*
    Updates the pendulum model with the new nodes in the simulation visual.
     */
    public void update(int nodes) {
        model.updateSim(nodes);
        this.view.update(this.model);
    }

    /*
     Allows the user to stop the current visual.
     Stop the simulation and set a new pendulum size, or pause/reset the simulation.
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
            if (timeline != null)
                timeline.stop();
            this.startTimer(1);
            this.model.startNewSimulation(1);
            this.view.keyPress(1);
            this.update(1);
        } else if (code == KeyCode.DIGIT2) {
            if (timeline != null)
                timeline.stop();
            this.startTimer(2);
            this.model.startNewSimulation(2);
            this.view.keyPress(2);
            this.update(2);
        } else if (code == KeyCode.P) {
            if (timeline != null) {
                timeline.pause();
            } else {
                this.startTimer(1);
                this.model.startNewSimulation(1);
                this.view.keyPress(1);
                this.update(1);
            }
        } else if (code == KeyCode.R) {
            if (timeline != null)
                timeline.stop();
            this.startTimer(model.nodes);
            this.model.startNewSimulation(model.nodes);
            this.view.keyPress(model.nodes);
            this.update(model.nodes);

        } else if (code == KeyCode.C) {

            if (model.getPendulumColor().equals("black")) {
                model.setPendulumColor("white");
            } else if (model.getPendulumColor().equals("white"))
                model.setPendulumColor("gold");
            else
                model.setPendulumColor("black");
            if (timeline != null) {
                timeline.stop();
            }

            this.startTimer(model.nodes);
            this.model.startNewSimulation(model.nodes);
            this.view.keyPress(model.nodes);
            this.update(model.nodes);
        } else {
            keyRecognized = false;
        }

        if (keyRecognized) {
            keyEvent.consume();
        }
    }
}
