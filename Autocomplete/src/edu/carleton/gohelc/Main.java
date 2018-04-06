package edu.carleton.gohelc;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
       Autocompleter autocompleter = new Autocompleter(args[0]);
       autocompleter.getCompletions(args[1]);
       autocompleter.printActors();
       System.out.print("hayezhelen".compareTo("hunthelen"));
    }
}
