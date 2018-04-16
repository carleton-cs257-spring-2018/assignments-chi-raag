package edu.carleton.gohelc;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Look up junit.org for (assert) objects

class AutocompleterTest {

    Autocompleter completer;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws FileNotFoundException, IOException {
        System.out.println("setUp");
        completer = new Autocompleter("subactors.txt");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tearDown");
        completer = null;
    }

    @Test
    public void getCompletions() {
        System.out.println("getCompletions test");
    }

    @Test
    public void completeEmptyString() {
        System.out.println("Test1");
        List<String> completions = completer.getCompletions("");
        assertEquals(0, completions.size(), "Empty string generated one or more completions");
    }

    /*
    Checks if /getCompletions/ returns a correct List with a searchString that contains a comma.
     */
    @Test
    public void searchWithComma() {
        System.out.println("Test2");
        List<String> completions = completer.getCompletions("e, c");
        String[] expected = {"Applegate, Christina"};
        String[] completionsArray = completions.toArray(new String[0]);
        assertArrayEquals(expected,completionsArray, "Search with comma did not work!");
    }

    /*
    Checks if getCompletions produces an empty list when a search string doesn't match any names in the provided text file.
     */
    @Test
    public void noResults() {
        List<String> completions = completer.getCompletions("sdfjlkfdslkjf");
        String[] expected = {};
        String[] completionsArray = completions.toArray(new String[0]);
        assertArrayEquals(expected, completionsArray, "getCompletion doesn't produce empty list when search string doesn't produce any results");
    }

    /*
    Checks if getCompletions sorts names correctly when given a searchString that matches to two or more last names.
     */
    @org.junit.jupiter.api.Test
    public void SameLastName() {
        List<String> getCompletions = completer.getCompletions("Jones");
        String[] expected = {"Jones, Jennifer", "Jones, Laura"};
        String[] completionsArray = getCompletions.toArray(new String[0]);
        assertArrayEquals(expected, completionsArray, "Last name search generated wrong results with two or more identical last names in a file.");
    }

    /*
    Checks if the number of results produced by getCompletions matches with the theoretically correct number of results.
     */
    @org.junit.jupiter.api.Test
    public void numberOfResults() {
        List<String> getCompletions = completer.getCompletions("f");
        int expected = 10;
        assertEquals(expected, getCompletions.size(), "Search generated wrong amount of results");
    }

    /*
    Checks if getCompletions functions correctly/sorts correctly when provided a searchString that matches with a middle name
     */
    @org.junit.jupiter.api.Test
    public void middleNameTest() {
        List<String> getCompletions = completer.getCompletions("Love");
        String[] expected = {"Love, Kevin", "Glover, Donald", "Hewitt, Jennifer Love"};
        String[] completionsArray = getCompletions.toArray(new String[0]);
        assertArrayEquals(expected, completionsArray, "Search generated wrong result order when middle names are involved");
    }

    /*
    Checks if getCompletions functions and sorts correclty when provided with a search string with funky capitalization.
     */
    @org.junit.jupiter.api.Test
    public void capsTest() {
        List<String> getCompletions = completer.getCompletions("lOvE");
        String[] expected = {"Love, Kevin", "Glover, Donald", "Hewitt, Jennifer Love"};
        String[] completionsArray = getCompletions.toArray(new String[0]);
        assertArrayEquals(expected, completionsArray, "Search generated a wrong results when search has non-normative casing");
    }

    /*
    Checks if getCompletions functions when given a searchString with a period.
     */
    @org.junit.jupiter.api.Test
    public void nameWithPeriod() {
        List<String> getCompletions = completer.getCompletions("c.");
        String[] expected = {"Scott, George C."};
        String[] completionsArray = getCompletions.toArray(new String[0]);
        assertArrayEquals(expected, completionsArray, "Search failed when search value has a period");
    }

    /*
    Checks if getCompletions functions correctly when given a searchString with no tildes that should match to a name with tildes.
     */
    @org.junit.jupiter.api.Test
    public void tildeEffect() {
        List<String> getCompletions = completer.getCompletions("Berenice");
        String[] expected = {"Bejo, Bérénice"};
        String[] completionsArray = getCompletions.toArray(new String[0]);
        assertArrayEquals(expected, completionsArray, "Search fails to produce correct results when lacking proper tilde use");
    }

    /*
    Checks if getCompletions functions correctly when provided a searchString whose results include a singleton name.
     */
    @org.junit.jupiter.api.Test
    public void onlyOneName() {
        List<String> getCompletions = completer.getCompletions("z");
        String[] expected = {"Zephyr", "Efron, Zac", "Waltz, Christoph", "Rodriguez, Michelle", "Banks, Elizabeth"};
        String[] completionsArray = getCompletions.toArray(new String[0]);
        assertArrayEquals(expected, completionsArray, "Search fails to produce correct results when results contain singleton names");
    }

    /*
    Checks if getCompletions sorts correctly when provided a search string with matches within two or more last names.
     */
    @org.junit.jupiter.api.Test
    public void checkIndex() {
        List<String> getCompletions = completer.getCompletions("ane");
        String[] expected = {"Danes, Claire", "MacFarlane, Seth"};
        String[] completionsArray = getCompletions.toArray(new String[0]);
        assertArrayEquals(expected, completionsArray, "getCompletions sorting is wrong for matches inside of a name (index error)");
    }

    //    Checks if getCompletions handles the case of an empty test string
    @org.junit.jupiter.api.Test
    public void givenAnEmptyString(){

        String searchString = "";
        List<String> completions = completer.getCompletions(searchString);

        String[] completionsArray = completions.toArray(new String[0]);

        String[] Expected = {};

        assertArrayEquals(Expected, completionsArray, "empty match didn't produce empty array");

    }
    //    Checks if getCompletions sorts in proper order given multiple matches
    @org.junit.jupiter.api.Test
    void properOrder() {
        String searchString = "es";
        String[] expected = {"Parsons, Estelle","Danes, Claire","Jones, Jennifer","Jones, Laura","Rhys-Davies, John","Teller, Miles"};
        List<String> completions = completer.getCompletions(searchString);

        String[] completionsArray = completions.toArray(new String[0]);
        assertArrayEquals(expected, completionsArray, "Sort order failed!");
    }
    /*    Checks if getCompletions matches across a comma
    @org.junit.jupiter.api.Test
    void matchesAcrossComma(){
        String searchString = "eb";
        String[] expected = {"White, Betty"};
        List<String> completions = completer.getCompletions(searchString);
        String[] completionsArray = completions.toArray(new String[0]);

        assertArrayEquals(expected, completionsArray, "does not match across comma");
    }
    */

    //    Checks if getCompletions matches across apostrophes
   @org.junit.jupiter.api.Test
   void takesCareofApostrophes(){
       String searchString = "one";
        String[] expected = {"O'Neal, Tatum","Jones, Jennifer","Jones, Laura"};
        List<String> completions = completer.getCompletions(searchString);
      String[] completionsArray = completions.toArray(new String[0]);

       assertArrayEquals(expected, completionsArray, "Didn't take care of apostrophes!");
    }

    //    Checks if getCompletions matches across hyphens
    @org.junit.jupiter.api.Test
    void takesCareofHyphens(){
        String searchString = "nf";
        String[] expected = {"Chow, Yun-Fat"};
        List<String> completions = completer.getCompletions(searchString);
        String[] completionsArray = completions.toArray(new String[0]);

        assertArrayEquals(expected, completionsArray, "Didn't take care of hyphens!");
    }

    //    Checks if getCompletions matches across multipart last names
    @org.junit.jupiter.api.Test
    void matchesAcrossTwoPartLastNames(){
        String searchString = "lt";
        String[] expected = {"Del Toro, Benicio","Waltz, Christoph"};
        List<String> completions = completer.getCompletions(searchString);
        String[] completionsArray = completions.toArray(new String[0]);

        assertArrayEquals(expected, completionsArray, "Did not handle matches across multipart last names!");
    }
    //    Checks if getCompletions treats umlaut u as a u
    @org.junit.jupiter.api.Test
    void umlautTester(){
        String searchString = "uh";
        String[] expected = {"Brühl, Daniel"};
        List<String> completions = completer.getCompletions(searchString);
        String[] completionsArray = completions.toArray(new String[0]);

        assertArrayEquals(expected, completionsArray, "Doesn't treat umlaut u as a u");
    }
    //    Checks if getCompletions handles a punctuated search string
    @org.junit.jupiter.api.Test
    void randomPunctuation(){
        String searchString = "!@#$%^&*";
        String[] expected = {};

        List<String> completions = completer.getCompletions(searchString);
        String[] completionsArray = completions.toArray(new String[0]);

        assertArrayEquals(expected, completionsArray, "Doesn't handle random punctuation");

    }
    /*

    This is more abstract testing that we made for fun!

    void chiraagTriesSorting() {

        List<String> completions = completer.getCompletions(s);
        List<Integer> sort = new ArrayList<Integer>();

        for (int i = 0; i < completions.size(); i++) {

            boolean first = completions.get(i).indexOf(",") == completions.indexOf(s) - 1;
            boolean last = completions.get(i).indexOf(s) == 0;

            String[] strArray = completions.get(i).split(",");

            boolean partOfLast = strArray[0].contains(s);
            boolean partOfFirst = strArray[1].contains(s);

            if (last) {
                sort.add(1);
            } else if (first) {
                sort.add(2);
            } else if (partOfLast) {
                sort.add(3);
            } else if (partOfFirst) {
                sort.add(4);
            } else {
                sort.add(5);
            }
        }

        int j = 1;
        int check = sort.get(0);
        int k = sort.get(j);

        while (j < sort.size()) {
            if (k < check) {
                fail("Search results out of order");
            } else {
                check = sort.get(j);
                j++;
                k = sort.get(j);
            }
        }
    }

    void checkOrder(String s) {
        List<String> check = completer.getCompletions(s);
        for (int i = 0; i < check.size() - 1; i++) {
            for (int j = 1; j < check.size(); j++) {
                if (check.get(i).compareTo(check.get(j)) > 0) {
                    fail("Sorting out of order");
                }
            }
        }
    }

     void checkMatch(String s) {
        List<String> completions = completer.getCompletions(s);
        for (int i = 0; i < completions.size(); i++) {
            if (!completions.get(i).contains(s)) {
                fail("List contained a string which did not contain substring s");
            }
        }
    }

    */

}