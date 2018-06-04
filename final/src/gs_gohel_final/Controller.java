package gs_gohel_final;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Timer;
import java.util.TimerTask;


public class Controller
        //implements EventHandler<KeyEvent>
        {
    @FXML private Label timeLabel;
    @FXML private Label messageLabel;
    @FXML private View View;
    private Model model;
    @FXML private View view;
    private final int FRAMES_PER_SECOND = 20;
    Timer timer  = new Timer();

    /*
     * @constructor - Empty.
     */
    public Controller() {
        timeLabel=null;
        messageLabel=null;
        model = new Model();
        this.view = new View();
        //view.update(model);
    }

    /*
     Initializes a pendulum model. Default is a double pendulum (?)
     */
    public void initialize() {
        //this.Model = new Model();
        this.View = new View();
        //View.updateValues(Model);
        this.startTimer();
    }

    private void startTimer() {
        this.timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        update();
                    }
                });
            }
        };
        long frameTimeInMilliseconds = (long)(1000.0 / FRAMES_PER_SECOND);
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }

    /*
    Updates the pendulum model with the user demands - either works with the simulation visual or the KE graph.
     Allows the user to see the time at end of simulation.
     */
    public void update() {
        model.updateSim();
        this.View.update(this.model);

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
   // @Override
  /*  public void handle(KeyEvent keyEvent) {
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
    }*/
}