package com.dkosko.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    protected static List<String> combineX0andZ(String x0, String z) {
        List<String> combinations = new ArrayList();
        combinations.add(x0 + z);
        combinations.add(x0.substring(0, x0.length() - 1) + z);
        return combinations;
    }

    protected static List<String> combineX00andY0andZ(String x00, String y0, String z) {
        List<String> combinations = new ArrayList();
        combinations.add(x00 + y0 + z);
        combinations.add(x00 + y0.substring(0, 1) + z);
        combinations.add(x00.substring(0, 1) + y0 + z);
        combinations.add(x00.substring(0, 1) + y0.substring(0, 1) + z);
        return combinations;
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
            possibleResults(combineX1Y(input.remove(0)));
        } else if (input.get(0).substring(2, 3).equals("0")) {
            possibleResults(combineXY0(input.remove(0)));
        } else {
            possibleResults(combineXYZ(input.remove(0)));
        }
    }

    protected static List<String> combineXYZ(String xyz) {
        List<String> combinations = new ArrayList();
        combinations.add(xyz);
        combinations.add(xyz.substring(0, 1) + "00" + xyz.substring(1, 2) + "0" + xyz.substring(2, 3));
        combinations.add(xyz.substring(0, 1) + "00" + xyz.substring(1, 3));
        combinations.add(xyz.substring(0, 2) + "0" + xyz.substring(2, 3));
        return combinations;
    }

    protected static List<String> combineXY0andZ(String xy0, String z) {
        List<String> combinations = new ArrayList();
        combinations.add(xy0.substring(0, 1) + "00" + xy0.substring(1, 3) + z);
        combinations.add(xy0 + z);
        combinations.add(xy0.substring(0, 1) + "00" + xy0.substring(1, 2) + z);
        combinations.add(xy0.substring(0, 1) + "00" + xy0.substring(1, 2) + "0" + z);
        return combinations;
    }

    protected static List<String> combineX1Y(String x1y) {
        List<String> combinations = new ArrayList();
        combinations.add(x1y.substring(0, 1) + "00" + x1y.substring(1, 3));
        combinations.add(x1y);
        return combinations;
    }
    
    protected static List<String> combineXY0(String xy0) {
        List<String> combinations = new ArrayList();
        combinations.add(xy0.substring(0, 1) + "00" + xy0.substring(1, 3));
        combinations.add(xy0);
        return combinations;
    }

    protected static List<String> combineXY(String xy) {
        List<String> combinations = new ArrayList();
        combinations.add(xy.substring(0, 1) + "0" + xy.substring(1, 2));
        combinations.add(xy);
        return combinations;
    }
    
    protected static List<String> combineX00andY0(String x00, String y0){
        List<String> combinations = new ArrayList();
        combinations.add(x00 + y0);
        combinations.add(x00.substring(0,1) + y0);
        return combinations;
    }
    
    protected static List<String> combineX00andYZ(String x00, String yz){
        List<String> combinations = new ArrayList();
        combinations.add(x00 + yz);
        combinations.add(x00 + yz.substring(0,1) + "0" + yz.substring(1,2));
        combinations.add(x00.substring(0,1) + yz);
        return combinations;
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
