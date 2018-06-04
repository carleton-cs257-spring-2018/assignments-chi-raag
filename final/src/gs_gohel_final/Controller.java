package edu.carleton.ganjam;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;


public class Controller implements EventHandler<KeyEvent> {

    @FXML private Label timeLabel;
    @FXML private Label messageLabel;
    @FXML private View view;
    private Model model;
    private final int FRAMES_PER_SECOND = 20;
    EventHandler<ActionEvent> updater;
    Timeline timeline;

    /*
     * @constructor - Empty.
     */
    public Controller() {
        timeLabel=null;
        messageLabel=null;
        model = new Model();
    }

    /*
     Initializes a pendulum model. Default is a double pendulum (?)
     */
    public void initialize() {
       // this.startTimer();
    }

    private void startTimer(int nodes) {

        updater = event -> update(nodes);
        timeline = new Timeline(new KeyFrame(Duration.seconds(1.0/FRAMES_PER_SECOND), updater));
        timeline.setCycleCount(200);//Timeline.INDEFINITE);
        timeline.play();

    }

    /*
    Updates the pendulum model with the user demands - either works with the simulation visual or the KE graph.
     Allows the user to see the time at end of simulation.
     */
    public void update(int nodes) {
        model.updateSim(nodes);
        this.view.update(this.model);

        //Display total time of simulation
        //this.timeLabel = new Label(String.valueOf(this.Model.time));
        //if(this.Model.getviewtype())
        //  this.messageLabel = new Label("Simulation of the pendulum in space");
        // else
        // this.messageLabel = new Label("Kinetic Energy of Pendulum");
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
            System.out.print("what");
            if (timeline != null)
            timeline.stop();
            this.startTimer(1);
            this.model.startNewSimulation(1);
            this.view.keyPress(1);
            this.update(1);
        } else if (code == KeyCode.DIGIT2) {
            System.out.print("what2");
            if (timeline != null)
            timeline.stop();

            this.startTimer(2);
            this.model.startNewSimulation(2);
            this.view.keyPress(2);
            this.update(2);
        } else if (code == KeyCode.R) {
            System.out.println("reset");
            if (timeline != null)
            timeline.stop();
            this.startTimer(model.nodes);
            this.model.startNewSimulation(model.nodes);
            this.view.keyPress(model.nodes);

            this.update(model.nodes);
        } /*else if (code == KeyCode.G) {
            if (this.model.getviewtype()) {
                this.model.setviewtype(false);
            }
        } else if (code == KeyCode.S) {
            if (!(this.model.getviewtype())) {
                this.model.setviewtype(true);
            }
        } */else {
            keyRecognized = false;
        }

        if (keyRecognized) {
            System.out.println("hey");

           // this.update();
            keyEvent.consume();
        }
    }
}