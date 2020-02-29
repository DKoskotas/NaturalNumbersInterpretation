package com.dkosko.handler;

import java.util.ArrayList;
import java.util.List;
import static com.dkosko.handler.CombinationsUtility.*;

/*The role of this class is to get the input from the InputOutput class proccess 
it and the return it to the InputOutput class to handle it.*/
public class NaturalNumberHandler {

    private static List<String> combinations = new ArrayList<String>();

    public NaturalNumberHandler() {
    }

    public List<String> getCombinations() {
        return combinations;
    }

    public void setCombinations(List<String> combinations) {
        NaturalNumberHandler.combinations = combinations;
    }
    
    
    /*This method focuses on processing the input list as long as it is not 
    empty it fills the combinations list with appropriate results */
    public List<String> createNumbers(List<String> input) {
        while (!input.isEmpty()) {
            /*depending on the number of digits (one,two or three of each element
            the data handling differs so the following switch case handles that*/
            switch (input.get(0).length()) {
                case 1:
                    concatElementToList(input.remove(0));
                    break;
                case 2:
                    caseLengthTwo(input);
                    break;
                case 3:
                    caseLengthThree(input);
                    break;
            }
        }
        return combinations;
    }
    
    /*this method adds the input string to combinations if it is empty otherwise 
    concatinates the input string to each element of combinations. The method is
    used if the length of the string is 1*/
    protected static void concatElementToList(String elem) {
        if (combinations.isEmpty()) {
            combinations.add(elem);
        } else {
            List<String> temp = new ArrayList<>();
            while (!combinations.isEmpty()) {
                temp.add(combinations.remove(0) + elem);
            }
            combinations.addAll(temp);
        }

    }
    /*This method is called in case the string we want to check is 2. Additional
    checks are required since not all 2 digit numbers are pronounced the same 
    way. For example special cases like eleven twelve or ten need additional checks.
    Also depending of the fact that the element we are currenty checking is the
    last element of the list or not additional checks might be needed.*/
    protected static void caseLengthTwo(List<String> input) {
        if (input.get(0).substring(0, 1).equals("1")) {
            concatElementToList(input.remove(0));
        } else if (input.get(0).substring(1, 2).equals("0")) {
            if (1 < input.size() && input.get(1).length() == 1) {
                possibleResults(combineX0andZ(input.remove(0), input.remove(0)));
            } else {
                concatElementToList(input.remove(0));
            }
        } else {
            possibleResults(combineXY(input.remove(0)));
        }
    }
    /*Similar to caseLengthTwo this method is called when the input string's 
    length is 3. It matters if the input is followed by 1 or 2 elements and what
    length the following elements have(ex. 210 20 1 or 210 1 1 and so on.*/
    protected static void caseLengthThree(List<String> input) {
        if (input.get(0).substring(1, 3).equals("00")) {
            if (1 < input.size() && input.get(1).length() == 1) {
                possibleResults(combineX0andZ(input.remove(0), input.remove(0)));
            } else if (1 < input.size() && input.get(1).length() == 2) {
                if ((input.get(1).substring(1, 2).equals("0") || input.get(1).substring(1, 2).equals("1"))
                        && 2 < input.size() && input.get(2).length() == 1) {
                    possibleResults(
                            combineX00andY0andZ(input.remove(0), input.remove(0), input.remove(0))
                    );
                }else if(input.get(1).substring(1, 2).equals("0")){
                    possibleResults(combineX00andY0(input.remove(0), input.remove(0)));
                } else {
                    possibleResults(combineX00andYZ(input.remove(0), input.remove(0)));
                }
            } else {
                concatElementToList(input.remove(0));
            }
        } else if (input.get(0).substring(2, 3).equals("0")&& !input.get(0).substring(1,2).equals("1") 
                    && 1 < input.size() && input.get(1).length() == 1) {
            possibleResults(combineXY0andZ(input.remove(0), input.remove(0)));
        } else if (input.get(0).substring(1, 2).equals("1") && 1 <= input.size()) {
            possibleResults(combineXY0orX1Y(input.remove(0)));
        } else if (input.get(0).substring(2, 3).equals("0")) {
            possibleResults(combineXY0orX1Y(input.remove(0)));
        } else {
            possibleResults(combineXYZ(input.remove(0)));
        }
    }
    
    /*This method's purpose is to get proccess the input and add the result in
    the combinations variable. It also checks weather the input and the currect
    version of combinations is empty or not and what it does depends on these
    facts*/
    protected static void possibleResults(List<String> input) {
        List<String> result = new ArrayList();
        if (combinations.isEmpty() && !input.isEmpty()) {
            result.addAll(input);
        } else if (input.isEmpty() && !combinations.isEmpty()) {
            result.addAll(combinations);
        } else {
            for (String a : combinations) {
                for (String b : input) {
                    result.add(a + b);
                }
            }
        }
        combinations = result;
    }

}
