package gs_gohel_final;

import java.awt.*;
import java.time.Instant;

public class Model {

    private boolean viewtype;
    private int totaltime;
    private int pendulumLength;
    private int nodeRadius;
    private Color[] nodeColors;
    private Color backgroundColor;
    private double xCordinate;
    private double yCoordinate;
    private double damping;
    private double theta;
    private double gravityAcceleration = -9.81;
    public Instant time;

    private int m1,m2,m3;
    private int l1,l2,l3;



    /** @constructor */
    public Model() {
        viewtype=true;
        startNewSimulation();
    }

    /*  Get method for viewtype
        @returns viewtype: Boolean that determines type of view
     */
    public boolean getviewtype() {
        return viewtype;
    }

    /*  Set method for viewtyp
        @param viewtype: Boolean that determines type of view
     */
    public boolean setviewtype(boolean viewtype) {
        this.viewtype = viewtype;
        return viewtype;
    }
    /*  Initializes a simulation with appropriate math needed
     *   to define and visualize an n-tuple pendulum
     */
    public void startNewSimulation() {

    }

    /*  Initializes a graphical with appropriate math needed
     *   to visualize evolution of kinetic energy of an n-tuple pendulum
     */
    public void createGraph(int nodes) {

    }

    /*  Defines the set of differential equations to be used based in the number of nodes in pendulum
     *   @param nodes: number of nodes in pendulum
     */
    public void setFormulasSim(int nodes) {
        double angaccel, angvelocity = 0, dt = 0.1, angle;
        if (nodes == 1) {
            while (/* stepwise integration constraint */) {
                angaccel = -9.81 / this.length * Math.sin(angle);
                angvelocity += angaccel * dt;
                angle += angvelocity * dt;
            }
            m2=m3=l2=l3=0;
            return //values
        }
        else if(nodes == 2) {
            double angaccel2, angvelocity2 = 0, angle2;
            while (/* stepwise integration constraint */) {
                angaccel = gravityAcceleration / this.pendulumLength * Math.sin(angle);
                angvelocity += angaccel * dt;
                angle += angvelocity * dt;

                angaccel2 = gravityAcceleration / this.pendulumLength * Math.sin(angle);
                angvelocity2 += angaccel * dt;
                angle2 += angvelocity * dt;
            }
            m3=l3=0;
            return //values
        }
        else if(nodes == 3) {
            double angaccel2, angvelocity2 = 0, angle2;
            double angaccel3, angvelocity3 = 0, angle3;
            while (/* stepwise integration constraint */) {
                angaccel = gravityAcceleration / this.pendulumLength * Math.sin(angle);
                angvelocity += angaccel * dt;
                angle += angvelocity * dt;

                angaccel2 = gravityAcceleration / this.pendulumLength * Math.sin(angle);
                angvelocity2 += angaccel * dt;
                angle2 += angvelocity * dt;
            }
        }

    }

    /*  Defines the KE equations to be used based in the number of nodes in pendulum
     *   @param nodes: number of nodes in pendulum
     */
    public void setFormulasGraph(int nodes) {

    }

    /*  Modifies current view state as to stop
         current simulation
     */
    public void endCurrentSimulation() {

    }


    /*  Modifies current view state to reset
         the current graph simulation.
     */
    public void resetGraph() {

    }

    public void setPendulumLength(int pendulumLength) {
        this.pendulumLength = pendulumLength;
    }

    public int getPendulumLength() {
        return this.pendulumLength;
    }

    public void setNodeRadius(int nodeRadius) {
        this.nodeRadius = nodeRadius;
    }

    public int getNodeRadius() {
        return this.nodeRadius;
    }

    public void setPendulumColor(Color[] color) {
        this.nodeColors = color;
    }

    public Color[] getPendulumColor() {
        return this.nodeColors;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    public Color getBackgroundColor(Color color) {
        return backgroundColor;
    }

    public void setDamping(int damping) {
        this.damping = damping;
    }

    public void updateTheta(double theta) {

    }

    public double getTheta() {
        return this.theta;
    }

    public Instant getTime() {
        return this.time;
    }
}
