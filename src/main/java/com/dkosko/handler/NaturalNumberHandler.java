package com.dkosko.handler;

import java.util.ArrayList;
import java.util.List;
import static com.dkosko.handler.CombinationsUtility.*;

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
    
    

    public List<String> createNumbers(List<String> input) {
        while (!input.isEmpty()) {
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
