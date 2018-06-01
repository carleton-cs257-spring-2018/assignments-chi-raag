package gs_gohel_final;

import javafx.scene.Group;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Component;

public class View extends JPanel {

    //The number of nodes that defines the size of the pendulum system
    private int N;
    private boolean viewtype;
    private int totaltime;
    private int pendulumLength;
    private int nodeRadius;
    private Color[] nodeColors;
    private Color backgroundColor;
    private double theta;
    private Graphics g = getGraphics();


    /* A set constructor for the size of the pendulum system.
        @param nodes: The number of nodes in the pendulum
        @param viewtype: The view that the user wants.
     */

    /**
     * @constructor
     */
    public View(int N) {
        this.N = N;
        //initialize(boolean viewtype);
    }

    /* A get method for the size of the pendulum system.
     */
    public int getN() {
        return this.N;
    }

    /* Initializes a visual for the system depending on viewtype of model object
        @param model: the pendulum object
     */
    public void initialize(Model model) {
        if (model.getviewtype())
            this.initializeView();
        else
            this.initializeGraph();
    }

    /* Initializes the graphic of the pendulum system.
     * Graphic starts from the horizontal position.
     * Default view of the system
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 100, 100);
        g.setColor(Color.blue);
        int anchorX = JApplet.WIDTH / 2, anchorY = JApplet.HEIGHT / 4;
        int ballX = anchorX + (int) (Math.sin(theta) * pendulumLength);
        int ballY = anchorY + (int) (Math.cos(theta) * pendulumLength);
        g.drawLine(anchorX, anchorY, ballX, ballY);
        g.fillOval(anchorX - 3, anchorY - 4, 7, 7);
        g.fillOval(ballX - 7, ballY - 7, 14, 14);
    }

    public void updateValues(Model model) {
        viewtype = model.getviewtype();
        pendulumLength = model.getPendulumLength();
        nodeRadius = model.getNodeRadius();
        theta = model.getTheta();
        backgroundColor = model.getBackgroundColor();
        repaint();
    }

    public void update(Model model) {
        updateValues(model);
    }

    public void initializeView() {


    }

    /* Initializes the data graph of the Kinetic energy of the pendulum system.
     * Graphic starts from the horizontal position.
     * Includes a timer to show the evolution of the system quantitatively.
     */
    public void initializeGraph() {

    }

    /* Updates the graph view with information from model.
     * Will show different models as user inputs different demands.
     *     @param model: the pendulum object
     */
    public void updateGraph(Model model) {

    }

    /* Updates the pendulum visual with information from model.
     * Will show different system as user inputs different demands.
     *     @param model: the pendulum object
     */
    public void updateView(Model model) {

    }

    /* Implements a timer for the simulation/graph
     */
    public void timescale() {

    }
}
