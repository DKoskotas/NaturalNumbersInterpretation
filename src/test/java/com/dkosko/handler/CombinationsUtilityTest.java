
package com.dkosko.handler;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


public class CombinationsUtilityTest {
    
    @Test
    public void testCombineX0andZ() {
        String x0 = "X0";
        String z = "Z";
        List<String> combinations = CombinationsUtility.combineX0andZ(x0, z);
        assertTrue(combinations.contains("X0Z") && combinations.contains("XZ"));
        assertEquals(2, combinations.size());
    }
    
    @Test
    public void testCombineX00andY0andZ(){
        String x00 = "X00";
        String y0 = "Y0";
        String z = "Z";
        List<String> combinations = CombinationsUtility.combineX00andY0andZ(x00, y0, z);
        assertTrue(combinations.contains("X00Y0Z"));
        assertTrue(combinations.contains("X00YZ"));
        assertTrue(combinations.contains("XY0Z"));
        assertTrue(combinations.contains("XYZ"));
        assertEquals(4, combinations.size());
    }
    
    @Test
    public void testCombineXYZ(){
        String xyz = "XYZ";
        List<String> combinations = CombinationsUtility.combineXYZ(xyz);
        assertTrue(combinations.contains("XYZ"));
        assertTrue(combinations.contains("X00Y0Z"));
        assertTrue(combinations.contains("X00YZ"));
        assertTrue(combinations.contains("XY0Z"));
        assertEquals(4, combinations.size());
    }
    
    @Test
    public void testCombineXY0andZ(){
        String xy0 = "XY0";
        String z = "Z";
        List<String> combinations = CombinationsUtility.combineXY0andZ(xy0, z);
        assertTrue(combinations.contains("X00Y0Z"));
        assertTrue(combinations.contains("XY0Z"));
        assertTrue(combinations.contains("X00YZ"));
        assertEquals(3, combinations.size());
    }
    
    @Test
    public void testCombineXY0orX1Y(){
        String xy0 = "XY0";
        String x1y = "X1Y";
        List<String> combinationsXY0 = CombinationsUtility.combineXY0orX1Y(xy0);
        assertTrue(combinationsXY0.contains("X00Y0"));
        assertTrue(combinationsXY0.contains("XY0"));
        assertEquals(2, combinationsXY0.size());
        List<String> combinationsX1Y = CombinationsUtility.combineXY0orX1Y(x1y);
        assertTrue(combinationsX1Y.contains("X001Y"));
        assertTrue(combinationsX1Y.contains("X1Y"));
        assertEquals(2, combinationsX1Y.size());        
    }
    
    @Test
    public void testCombineXY(){
       String xy = "XY";
       List<String> combinations = CombinationsUtility.combineXY(xy);
       assertTrue(combinations.contains("X0Y"));
       assertTrue(combinations.contains("XY"));
       assertEquals(2, combinations.size());
    }
    
    @Test
    public void testCombineX00andY0(){
       String x00 = "X00";
       String y0 = "Y0";
       List<String> combinations = CombinationsUtility.combineX00andY0(x00, y0);
       assertTrue(combinations.contains("X00Y0"));
       assertTrue(combinations.contains("XY0"));
       assertEquals(2, combinations.size());
    }
    
    @Test
    public void testCombineX00andYZ(){
        String x00 = "X00";
        String yz = "YZ";
        List<String> combinations = CombinationsUtility.combineX00andYZ(x00, yz);
        assertTrue(combinations.contains("X00YZ"));
        assertTrue(combinations.contains("XYZ"));
        assertTrue(combinations.contains("X00Y0Z"));
        assertEquals(3, combinations.size());
    }
}
