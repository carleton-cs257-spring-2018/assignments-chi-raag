package sample;

public class Model {

    private int[] formulas;
    private boolean viewtype;
    private int totaltime;

    /** @constructor */
    public Model() {
        viewtype=true;
        startNewSimulation();
    }

    /*  Get method for viewtyp
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
    }
    /*  Initializes a simulation with appropriate math needed
     *   to define and visualize an n-tuple pendulum
     */
    public void startNewSimulation() {

    }

    /*  Initializes a graphical with appropriate math needed
     *   to visualize evolution of kinetic energy of an n-tuple pendulum
     */
    public void createGraph() {

    }

    /*  Defines the set of differential equations to be used based in the number of nodes in pendulum
     *   @param nodes: number of nodes in pendulum
     */
    public void setFormulasSim(int nodes) {

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


    /* Get method for the time that the simulation has run for.
        @return totaltime: totaltime of the simulation
     */
    public int getTime() {
        return totaltime;
    }


}
