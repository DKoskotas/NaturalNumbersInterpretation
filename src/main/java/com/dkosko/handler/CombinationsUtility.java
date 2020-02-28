
package com.dkosko.handler;

import java.util.ArrayList;
import java.util.List;


public class CombinationsUtility {
    
    protected List<String> combineX0andZ(String x0, String z) {
        List<String> combinations = new ArrayList();
        combinations.add(x0 + z);
        combinations.add(x0.substring(0, x0.length() - 1) + z);
        return combinations;
    }

    protected List<String> combineX00andY0andZ(String x00, String y0, String z) {
        List<String> combinations = new ArrayList();
        combinations.add(x00 + y0 + z);
        combinations.add(x00 + y0.substring(0, 1) + z);
        combinations.add(x00.substring(0, 1) + y0 + z);
        combinations.add(x00.substring(0, 1) + y0.substring(0, 1) + z);
        return combinations;
    }

    protected List<String> combineXYZ(String xyz) {
        List<String> combinations = new ArrayList();
        combinations.add(xyz);
        combinations.add(xyz.substring(0, 1) + "00" + xyz.substring(1, 2) + "0" + xyz.substring(2, 3));
        combinations.add(xyz.substring(0, 1) + "00" + xyz.substring(1, 3));
        combinations.add(xyz.substring(0, 2) + "0" + xyz.substring(2, 3));
        return combinations;
    }

    protected List<String> combineXY0andZ(String xy0, String z) {
        List<String> combinations = new ArrayList();
        combinations.add(xy0.substring(0, 1) + "00" + xy0.substring(1, 3) + z);
        combinations.add(xy0 + z);
        combinations.add(xy0.substring(0, 1) + "00" + xy0.substring(1, 2) + z);
        combinations.add(xy0.substring(0, 1) + "00" + xy0.substring(1, 2) + "0" + z);
        return combinations;
    }

    protected List<String> combineXY0orX1Y(String xy0) {
        List<String> combinations = new ArrayList();
        combinations.add(xy0.substring(0, 1) + "00" + xy0.substring(1, 3));
        combinations.add(xy0);
        return combinations;
    }

    protected List<String> combineXY(String xy) {
        List<String> combinations = new ArrayList();
        combinations.add(xy.substring(0, 1) + "0" + xy.substring(1, 2));
        combinations.add(xy);
        return combinations;
    }

    protected List<String> combineX00andY0(String x00, String y0){
        List<String> combinations = new ArrayList();
        combinations.add(x00 + y0);
        combinations.add(x00.substring(0,1) + y0);
        return combinations;
    }

    protected List<String> combineX00andYZ(String x00, String yz){
        List<String> combinations = new ArrayList();
        combinations.addAll(combineX00andY0(x00, yz));
        combinations.add(x00 + yz.substring(0,1) + "0" + yz.substring(1,2));
        return combinations;
    }
}

