/**
 * Autocompleter.java
 * Liz Nichols and Chiraag Gohel, 05 April 2018
 *
 * This class exposes a very simple interface for generating auto-completions of search strings.
 * The purpose of this class is to give the students in CS257 an opportunity to practice creating
 * unit tests.
 */
package edu.carleton.gohelc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.File;



public class Autocompleter {

    private List<String> nameList = new ArrayList<String>();
    private List<Actor> actors = new ArrayList<Actor>();

    /**
     * @param dataFilePath the path to the data file containing the set of items to
     *                     from which auto-completed results will be drawn. (In the context of this assignment,
     *                     this will be the path to the actors.txt file I provided you. But we'll also talk
     *                     later about how you might use inheritance to create subclasses of Autocompleter
     *                     to use different datasets and different approaches to doing the autocompletion.)
     */
    public Autocompleter(String dataFilePath) throws FileNotFoundException, IOException {
        Scanner s = new Scanner(new File(dataFilePath)).useDelimiter("\n");
        nameList = new ArrayList<String>();
        while (s.hasNext()) {
            nameList.add(s.next());
        }
        s.close();
    }

    /**
     * @param search the string whose autocompletions are sought
     * @return the list of potential completions that match the search string,
     * sorted in decreasing order of quality of the match (that is, the matches
     * are sorted from best match to weakest match)
     */
    public List<String> getCompletions(String search) {
        if (search.equals("")) {
            List<String> hello = new ArrayList<String>();
            return hello;
        }
        String realSearch = search.replace(" ", "").toLowerCase();
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            String compareName = name.replaceAll(" ", "").replaceAll("-", "").replaceAll("é", "e").replaceAll("í", "i").replaceAll("ö", "o").replaceAll("ü","u").toLowerCase();
            String first;
            String last;
            if (compareName.contains(",")) {
                String[] firstLast = compareName.split(",");
                if (firstLast.length > 1) {
                    last = firstLast[0];
                    first = firstLast[1];
                }
                else {
                    last = null;
                    first = null;
                }
            }
            else {
                last = compareName;
                first = null;
            }
            if (compareName.contains(realSearch)) {
                if (compareName.indexOf(realSearch) == 0) {
                    Actor newActor = new Actor(name, compareName, 1, 0);
                    actors.add(newActor);
                } else if (compareName.indexOf(realSearch) == compareName.indexOf(",") + 1) {
                    Actor newActor = new Actor(name, compareName, 2, compareName.indexOf(realSearch));
                    actors.add(newActor);
                } else if (last.contains(realSearch)) {
                    Actor newActor = new Actor(name, compareName, 3, compareName.indexOf(realSearch));
                    actors.add(newActor);
                } else if (first != null && first.contains(realSearch)) {
                    Actor newActor = new Actor(name, compareName, 4, compareName.indexOf(realSearch));
                    actors.add(newActor);
                } else {
                    Actor newActor = new Actor(name, compareName, 5, compareName.indexOf(realSearch));
                    actors.add(newActor);
                }
            }
        }
        Collections.sort(actors);
        ArrayList<String> actorNames = new ArrayList<String>();
        for (int i = 0; i < actors.size(); i++) {
            actorNames.add(actors.get(i).getName());
        }
        return actorNames;
    }


    /**
     * A method called by main to print out the actors in a list
     */
    public void printActors() {
        for (int i = 0; i < actors.size(); i++) {
            System.out.println(actors.get(i).getName());
        }
    }
}
