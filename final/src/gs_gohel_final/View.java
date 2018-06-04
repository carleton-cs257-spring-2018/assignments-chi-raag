package gs_gohel_final;


import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.embed.swing.JFXPanel;

import javafx.fxml.FXML;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Component;

public class View extends Pane {

    //The number of nodes that defines the size of the pendulum system
    private int N;
    @FXML private int summin;
    private boolean viewtype;
    private int totaltime;
    private int pendulumLength;
    private int nodeRadius;
    private Color[] nodeColors;
    private Color backgroundColor;
    private double theta;
    private Model model = new Model();


    /* A set constructor for the size of the pendulum system.
        @param nodes: The number of nodes in the pendulum
        @param viewtype: The view that the user wants.
     */

    /**
     * @constructor
     */
    public View() {
        Line line = new Line(150, 100, 250, 100);
        line.setStrokeWidth(3);

        Circle circle1 = new Circle(550, 100, 14);

        // Create another circle
        Circle circle2 = new Circle(250, 100, 5);

        // Binding the line and the circle1 together, so they move synchronized
        line.startXProperty().bind(circle1.centerXProperty().add(circle1.translateXProperty()));
        line.startYProperty().bind(circle1.centerYProperty().add(circle1.translateYProperty()));

        // Add circles and line to the pane
        getChildren().addAll(line, circle1, circle2);
        Arc path = new Arc(250,100,200,200,200,140);
        path.setType(ArcType.OPEN);

        // Create a path transition and set specifications
        PathTransition pt = new PathTransition();
        pt.setRate(.1);
        pt.setPath(path);
        pt.setNode(circle1);
        pt.setOrientation(
                PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

    }

    /* Initializes a visual for the system depending on viewtype of model object
        @param model: the pendulum object
     */
    public void initialize() {

    }





}
