/*
 * Pendulum JAVAFX project
 * Authors: Chiraag Gohel and Sharan Ganjam Seshachallam
 * CS 257, Spring 2018
 * Model.java - a part of the Pendulum MVC project.

 */

package gs_gohel_final;

import java.lang.Math;

public class Model {

    public double time;
    public int nodes;
    private String nodeColor;
    private double xCoordinate, xCoordinate2;
    private double yCoordinate, yCoordinate2;
    private double theta, theta2;
    private double gravityAcceleration;
    private double dt;
    private double KE_sys;

    private int m1, m2;
    private int l1, l2;

    private double angVelocity, angVelocity2;
    private double angaccel, angaccel2;


    /* Notes for the system:
     * Origin is at the pivot point - so at t=0, x is l1 and y is 0.
     * dt will be 0.1 to test
     * m1,m2,l1,l2 are parameters that Controller.java will have to provide. All other variables are calculated here.
     */

    /**
     * @constructor
     */
    public Model() {
        //default values
        l1 = 5;
        l2 = 5;
        m1 = 1;
        m2 = 1;
        theta = Math.toRadians(90);
        gravityAcceleration = 9.81;
        dt = 0.1;
        time = 0;
        nodes = 1;
        KE_sys = 0;
        nodeColor = "gold";
    }

    /*  Initializes a simulation with appropriate math needed
     *   to define and visualize an n-tuple pendulum
     *   @param nodes: number of nodes in pendulum
     */
    public void startNewSimulation(int nodes) {
        this.nodes = nodes;
        this.theta = Math.toRadians(90);
        this.time = 0;
        this.angaccel = -gravityAcceleration / this.l1;
        this.angVelocity = 0;
        this.xCoordinate = l1;
        this.yCoordinate = 0;
        this.KE_sys = 0;

        if (nodes == 2) {
            theta2 = Math.toRadians(90);
            this.angaccel2 = -gravityAcceleration / (this.l1 + this.l2);
            this.angVelocity2 = 0;
            this.xCoordinate2 = l1 + l2;
            this.yCoordinate2 = 0;
        }
    }

    /*  Defines the set of values that define the system at each time step based on the number of nodes in pendulum
     *   @param nodes: number of nodes in pendulum
     */

    public void updateSim(int nodes) {
        if (nodes == 1) {
            angaccel = -gravityAcceleration / this.l1 * Math.sin(theta);
            angVelocity += angaccel * dt;
            theta += angVelocity * dt;
            m2 = l2 = 0;

        } else if (nodes == 2) {
            angaccel = (-gravityAcceleration * (2 * m1 + m2) * Math.sin(theta) - m2 * gravityAcceleration * Math.sin(theta - 2 * theta2)
                    - 2 * Math.sin(theta - theta2) * m2 * (l2 * angVelocity2 * angVelocity2 + l1 * Math.cos(theta - theta2) * angVelocity * angVelocity))
                    / (l1 * (2 * m1 + m2 - m2 * Math.cos(2 * theta - 2 * theta2)));
            angVelocity += angaccel * dt;
            theta += angVelocity * dt;
            angaccel2 = (2 * Math.sin(theta - theta2) * ((m1 + m2) * l1 * angVelocity * angVelocity + gravityAcceleration * (m1 + m2) * Math.cos(theta)
                    + l2 * m2 * Math.cos(theta - theta2) * angVelocity2 * angVelocity2)) / (l2 * (2 * m1 + m2 - m2 * Math.cos(2 * theta - 2 * theta2)));
            angVelocity2 += angaccel2 * dt;
            theta2 += angVelocity2 * dt;
        }

        xCoordinate = l1 * Math.sin(theta);
        yCoordinate = l1 * Math.cos(theta);

        if (nodes == 2) {
            xCoordinate2 = xCoordinate + l2 * Math.sin(theta2);
            yCoordinate2 = yCoordinate + l2 * Math.cos(theta2);
        }
    }

    /*  Defines the KE equations to be used based in the number of nodes in pendulum
     *   @param nodes: number of nodes in pendulum
     */
    public void updateGraph(int nodes) {
        this.updateSim(nodes);
        double xVelocity = this.l1 * Math.cos(this.theta) * this.angVelocity;
        double yVelocity = -this.l1 * Math.sin(this.theta) * this.angVelocity;
        if (nodes == 1) {
            this.KE_sys = 0.5 * m1 * (xVelocity * xVelocity + yVelocity * yVelocity);
        } else if (nodes == 2) {
            double x2Velocity = this.l1 * Math.cos(this.theta) * this.angVelocity + this.l2 * Math.cos(this.theta2) * this.angVelocity2;
            double y2Velocity = -this.l1 * Math.sin(this.theta) * this.angVelocity - this.l2 * Math.sin(this.theta2) * this.angVelocity2;
            this.KE_sys = 0.5 * m1 * (xVelocity * xVelocity + yVelocity * yVelocity) + 0.5 * m2 * (x2Velocity * x2Velocity + y2Velocity * y2Velocity);
        }
        this.time += this.dt;
    }

    public String getPendulumColor() {
        return this.nodeColor;
    }

    public void setPendulumColor(String color) {
        this.nodeColor = color;
    }

    public double getxCoordinate() {
        return this.xCoordinate;
    }

    public double getyCoordinate() {
        return this.yCoordinate;
    }

    public double getxCoordinate2() {
        return this.xCoordinate2;
    }

    public double getyCoordinate2() {
        return this.yCoordinate2;
    }

    public int getNodes() {
        return this.nodes;
    }
}
