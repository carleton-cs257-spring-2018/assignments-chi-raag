/*
 * Pendulum JAVAFX project
 * Authors: Chiraag Gohel and Sharan Ganjam Seshachallam
 * CS 257, Spring 2018
 * View.java - a part of the Pendulum MVC project.

 */

package gs_gohel_final;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.awt.*;

public class View extends Pane {

    //The number of nodes that defines the size of the pendulum system
    private int N;
    private boolean viewtype;
    private int totaltime;
    private int pendulumLength;
    private int nodeRadius;
    private Color[] nodeColors;
    private Color backgroundColor;
    private double theta;
    @FXML Circle circle1;
    Circle circle2;
    Circle circle3;
    Line line;
    Line line2;
    double x;
    double y;
    double x2;
    double y2;


    /* A set constructor for the size and setup of the pendulum system.
        @param nodes: The number of nodes in the pendulum
        @param viewtype: The view that the user wants.
        Builds the base pendulum, including the nodes and the connecting string.
     */

    /**
     * @constructor
     */
    public View() {
        Model model = new Model();
        System.out.println(model.getPendulumColor());

        circle1 = new Circle(this.getMaxWidth()/2, this.getMaxHeight()/2, 14, javafx.scene.paint.Paint.valueOf(model.getPendulumColor()));


        // Create another circle
        circle2 = new Circle(270, 200+model.getyCoordinate(), 5, javafx.scene.paint.Paint.valueOf(model.getPendulumColor()));
        //circle3 = new Circle(this.getMaxWidth()/1.5, this.getMaxHeight()/1.5, 14);
        circle3 = new Circle(circle1.getCenterX(), circle1.getCenterY(),14, javafx.scene.paint.Paint.valueOf(model.getPendulumColor()));

        line = new Line(circle1.getCenterX(), circle1.getCenterY(), circle2.getCenterX(), circle2.getCenterY());
        line.setStrokeWidth(3);
        // Binding the line and the circle1 together, so they move synchronized
        line.startXProperty().bind(circle1.centerXProperty().add(circle1.translateXProperty()));
        line.startYProperty().bind(circle1.centerYProperty().add(circle1.translateYProperty()));
        line2 = new Line(circle3.getCenterX(), circle3.getCenterY(), circle1.getCenterX(), circle1.getCenterY());
        line2.startXProperty().bind(circle3.centerXProperty().add(circle3.translateXProperty()));
        line2.startYProperty().bind(circle3.centerYProperty().add(circle3.translateYProperty()));
        line2.endXProperty().bind(circle1.centerXProperty().add(circle1.translateXProperty()));
        line2.endYProperty().bind(circle1.centerYProperty().add(circle1.translateYProperty()));
    }

    /* A method that updates the positions of the pendulum nodes. */
    public void moveCircle() {
        circle1.setTranslateX(x);
        circle1.setTranslateY(y);
        circle3.setTranslateY(y2);
        circle3.setTranslateX(x2);
    }
    /* A method that resets the pane at use input
        @param nodes: The number of nodes in the pendulum
        Removes previously inputted children in the pane and allows a reset of the system.
     */
    public void keyPress(int nodes) {
        if (nodes == 1) {
            if (!getChildren().contains(circle2)) {
                getChildren().addAll(line, circle1, circle2);
            } else {
                System.out.println(getChildren().toString());
                int i = getChildren().size();
                getChildren().remove(0, i);
                getChildren().addAll(line, circle1, circle2);
            }
        }
        else if (nodes == 2) {
            if (!getChildren().contains(circle2)) {
                getChildren().addAll(line, line2, circle1, circle2, circle3);
            } else {
                int i = getChildren().size();
                getChildren().remove(0, i);
                circle1.setCenterX(this.getMaxWidth()/2);
                circle1.setCenterY(this.getMaxHeight()/2);
                circle3.setCenterX(circle1.getCenterX());
                circle3.setCenterY(circle1.getCenterY());
                getChildren().addAll(line, line2, circle1, circle2, circle3);
            }
        }
    }

    /* Gets the updated positions of the nodes for the given model object, then assigns them using another method.
        @param model: the pendulum object
     */
    public void update(Model model) {
        //System.out.println(model.getxCoordinate2());
        x = -30+model.getxCoordinate() * this.getScene().getWidth() * .03 + this.getScene().getWidth()*0.5;
        y = 200+ model.getyCoordinate() * this.getScene().getHeight() * .03;
        x2 = -30+model.getxCoordinate2() * this.getScene().getWidth() * .03 + this.getScene().getWidth()*0.5;
        y2 = 200+ model.getyCoordinate2() * this.getScene().getHeight() * .03;
        //System.out.println(x2);
        //System.out.println(y2);

        moveCircle();
    }

}
