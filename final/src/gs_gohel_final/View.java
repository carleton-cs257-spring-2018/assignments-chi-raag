/*
 * Pendulum JAVAFX project
 * Authors: Chiraag Gohel and Sharan Ganjam Seshachallam
 * CS 257, Spring 2018
 * View.java - a part of the Pendulum MVC project.
 */

package gs_gohel_final;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class View extends Pane {

    private final int Y_BUFFER = 200;
    private final int X_BUFFER = -30;
    Circle pivotPoint;
    @FXML
    Circle secondNode;
    @FXML
    Circle firstNode;
    Line firstLine;
    Line secondLine;
    double firstNodeXCoordinate;
    double firstNodeYCoordinate;
    double secondNodeXCoordinate;
    double secondNodeYCoordinate;


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

        firstNode = new Circle(this.getMaxWidth() / 2, this.getMaxHeight() / 2, 14, Paint.valueOf(model.getPendulumColor()));
        pivotPoint = new Circle(270, 200 + model.getyCoordinate(), 5, Paint.valueOf(model.getPendulumColor()));
        secondNode = new Circle(firstNode.getCenterX(), firstNode.getCenterY(), 14, Paint.valueOf(model.getPendulumColor()));

        firstLine = new Line(firstNode.getCenterX(), firstNode.getCenterY(), pivotPoint.getCenterX(), pivotPoint.getCenterY());
        firstLine.setStrokeWidth(3);
        firstLine.startXProperty().bind(firstNode.centerXProperty().add(firstNode.translateXProperty()));
        firstLine.startYProperty().bind(firstNode.centerYProperty().add(firstNode.translateYProperty()));

        secondLine = new Line(secondNode.getCenterX(), secondNode.getCenterY(), firstNode.getCenterX(), firstNode.getCenterY());
        secondLine.startXProperty().bind(secondNode.centerXProperty().add(secondNode.translateXProperty()));
        secondLine.startYProperty().bind(secondNode.centerYProperty().add(secondNode.translateYProperty()));
        secondLine.endXProperty().bind(firstNode.centerXProperty().add(firstNode.translateXProperty()));
        secondLine.endYProperty().bind(firstNode.centerYProperty().add(firstNode.translateYProperty()));
    }

    /* A method that updates the positions of the pendulum nodes. */
    public void moveCircle(int nodes) {
        if (nodes == 1) {
            firstNode.setTranslateX(firstNodeXCoordinate);
            firstNode.setTranslateY(firstNodeYCoordinate);
        } else if (nodes == 2) {
            firstNode.setTranslateX(firstNodeXCoordinate);
            firstNode.setTranslateY(firstNodeYCoordinate);
            secondNode.setTranslateY(secondNodeYCoordinate);
            secondNode.setTranslateX(secondNodeYCoordinate);
        }
    }

    /* A method that resets the pane at use input
        @param nodes: The number of nodes in the pendulum
        Removes previously inputted children in the pane and allows a reset of the system.
     */
    public void keyPress(int nodes) {
        if (nodes == 1) {
            if (!getChildren().contains(pivotPoint)) {
                getChildren().addAll(firstLine, firstNode, pivotPoint);
            } else {
                int i = getChildren().size();
                getChildren().remove(0, i);
                getChildren().addAll(firstLine, firstNode, pivotPoint);
            }
        } else if (nodes == 2) {
            if (!getChildren().contains(pivotPoint)) {
                getChildren().addAll(secondLine, firstLine, secondNode, firstNode, pivotPoint);
            } else {
                int i = getChildren().size();
                getChildren().remove(0, i);
                getChildren().addAll(firstLine, secondLine, firstNode, pivotPoint, secondNode);
            }
        }
    }

    /* Gets the updated positions of the nodes for the given model object, then assigns them using another method.
        @param model: the pendulum object
     */
    public void update(Model model) {
        firstNode.setFill(javafx.scene.paint.Paint.valueOf(model.getPendulumColor()));

        firstNodeXCoordinate = X_BUFFER + model.getxCoordinate() * this.getScene().getWidth() * .03 + this.getScene().getWidth() * 0.5;
        firstNodeYCoordinate = Y_BUFFER + model.getyCoordinate() * this.getScene().getHeight() * .03;

        secondNodeXCoordinate = X_BUFFER + model.getxCoordinate2() * this.getScene().getWidth() * .03 + this.getScene().getWidth() * 0.5;
        secondNodeYCoordinate = Y_BUFFER + model.getyCoordinate2() * this.getScene().getHeight() * .03;

        moveCircle(model.getNodes());
    }

}
