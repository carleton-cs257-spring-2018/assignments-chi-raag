Sharan GS, Chiraag Gohel

Our project simulates an n-tuple pendulum with varying dampers and starting positions. 
We will use simple Lagrangian Mechanics to model the physical system, and allow the user
to select the number of pendulums that are connected together. One visual will be the
evolution of the physical system with time, given a user-inputted initial position.
*Another will be a graph that shows the evolution of the velocities of each bob with time.

The MVC model is appropriate for this project as we have a clearly defined model (the n-tuple
pendulum) that is visualized virtually. The user can manipulate parameters of the model with
some controls, which in turn modifies the visual. This allows for a "core" model,
that is flexible to user-inputted adaptations and tweaks.

The core classes in our model are Main.java, Model.java, View.java and Controller.java
Note that View.java creates either of two different visuals depending on user input.

--------------
Final comments:

The single pendulum works very well.
And for both systems, the resets and the pause function perform well too.

We have issues with the double pendulum simulation. It starts off much faster than usual, and then the simulation breaks after ~3 seconds. We think this is an approximation error in our differential equations (model).
Following this, transitioning to the double pendulum from the single crashes the applet. However, the reverse is not true. The single pendulum runs without hiccups.

We were unable to implement changing colors for the pendulum.