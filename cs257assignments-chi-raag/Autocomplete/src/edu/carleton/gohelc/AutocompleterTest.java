package edu.carleton.gohelc;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

//Look up junit.org for (assert) objects

class AutocompleterTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("setUp");
        completer = new Autocompleter("actors.txt");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("tearDown");
        completer = null;
    }

    @org.junit.jupiter.api.Test
    void getCompletions() {
        System.out.println("getCompletions test");
    }


    void noSpaces() {

        List<String> getCompletions = getCompletions();

        boolean containsSpace;

        for (int i = 0; i < getCompletions.size(); i++) {
            if (getCompletions.get(i).indexOf(" ") > 0);
            fail("Completion contained a space");
        }
    }

    void isLower() {

        List<String> getCompletions = getCompletions();

        for (int i = 0; i < getCompletions.size(); i++) {
            for (int j = 0; j < getCompletions.get(i).length(); j++) {
                String test = getCompletions.get(i);
                if (Character.isUpperCase(test.charAt(j))) {
                    fail("String contained an uppercase");
                }
                else if (test.charAt(j+1) == ',') {
                    j++;
                }
            }
        }
    }
    void isNotEmpty(String s) {
        assertFalse(s.isEmpty());
    }

    void checkMatch(String s) {
        List<String> completions = completer.getCompletions(s);
        for (int i = 0; i < completions.size(); i++) {
            if (!completions.get(i).contains(s)) {
                fail("List contained a string which did not contain substring s");
            }
        }
    }

    void completeEmptyString() {
        List<String> completions = completer.getcompletions("");
        assertEquals(0, completions.size(), "Empty string generated one or more completions");
    }

    //TODO
    void noBreak() {

    }

    void WhereDoesItMatch_ForBeginningOfLastNameReturnsBeginningOfLastName{

        //if match starts at index 0, matches at last name

        String matchString = "abcdef,ghi";

        String subString = "abc";

        int theIndex = matchString.indexOf(subString);

        assertEquals(0, theIndex);



    }

    void WhereDoesItMatch_BeginFirstNameReturnsBeginFirstName{
        //if match starts at index[comma]+1. matches at first name
    }

    void WhereDoesItMatch_inFirstNamebutnotAtBeginning() {
        //if match in indeces (comma+1)<[x,y]<=endOfString
    }

    void WhereDoesItMatch_inLastNamebutNotAtBeginning() {
        //if match in
    }
}