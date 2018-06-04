package edu.carleton.ganjam;


import javafx.fxml.FXML;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.awt.*;

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
    @FXML Circle circle1;
    Circle circle2;
    Line line;
    double x;
    double y;


    /* A set constructor for the size of the pendulum system.
        @param nodes: The number of nodes in the pendulum
        @param viewtype: The view that the user wants.
     */

    /**
     * @constructor
     */
    public View() {
        Model model = new Model();

        line = new Line(150, 100, 300, model.getyCoordinate());
        line.setStrokeWidth(3);
        circle1 = new Circle(this.getMaxWidth()/2, this.getMaxHeight()/2, 14);

        // Create another circle
        circle2 = new Circle(300, model.getyCoordinate(), 5);

        // Binding the line and the circle1 together, so they move synchronized
        line.startXProperty().bind(circle1.centerXProperty().add(circle1.translateXProperty()));
        line.startYProperty().bind(circle1.centerYProperty().add(circle1.translateYProperty()));

        // Add circles and line to the pane
        getChildren().addAll(line, circle1, circle2);
    }

    public void moveCircle() {
        circle1.setTranslateX(x);
        circle1.setTranslateY(y);
    }

    /* Initializes a visual for the system depending on viewtype of model object
        @param model: the pendulum object
     */
    public void update(Model model) {
        x = model.getxCoordinate() * this.getScene().getWidth() * .03 + this.getScene().getWidth()*0.5;
        y = model.getyCoordinate() * this.getScene().getHeight() * .03;
        System.out.println(x);
        System.out.println(y);

        moveCircle();
    }





}
