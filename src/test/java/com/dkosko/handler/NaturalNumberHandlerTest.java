
package com.dkosko.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


public class NaturalNumberHandlerTest {
    
    
    public NaturalNumberHandlerTest() {
    }
    
    @Test
    public void testConcatElementToList_addsElementToEmptyList() {
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        String testElement = "x";
        NaturalNumberHandler.concatElementToList(testElement);
        assertTrue(naturalNumberHandler.getCombinations().contains(testElement));
    }

    @Test
    public void testConcatElementToList_concatsElementToAllListElements() {
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> testCombinations = new ArrayList();
        testCombinations.addAll(Arrays.asList("a", "b", "c"));
        naturalNumberHandler.setCombinations(testCombinations);
        String testElement = "x";
        NaturalNumberHandler.concatElementToList(testElement);
        assertTrue(naturalNumberHandler.getCombinations().contains("a" + testElement));
        assertTrue(naturalNumberHandler.getCombinations().contains("b" + testElement));
        assertTrue(naturalNumberHandler.getCombinations().contains("b" + testElement));
        assertEquals(testCombinations.size(), naturalNumberHandler.getCombinations().size());
    }
    
    @Test
    public void testCaseLengthTwo_input1X(){
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> testCombinations = new ArrayList();
        testCombinations.add("1X");
        naturalNumberHandler.setCombinations(testCombinations);
        naturalNumberHandler.caseLengthTwo(testCombinations);
        assertTrue(naturalNumberHandler.getCombinations().contains("1X"));
        assertEquals(testCombinations.size(), naturalNumberHandler.getCombinations().size());
    }
    
    @Test
    public void testCaseLengthTwo_inputX0andY(){
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> testCombinations = new ArrayList();
        testCombinations.addAll(Arrays.asList("X0", "Y"));
        naturalNumberHandler.setCombinations(testCombinations);
        naturalNumberHandler.caseLengthTwo(testCombinations);
        assertTrue(naturalNumberHandler.getCombinations().contains("X0Y"));
    }
    
    @Test
    public void testCaseLengthTwo_inputXY(){
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> testCombinations = new ArrayList();
        testCombinations.addAll(Arrays.asList("XY"));
        naturalNumberHandler.setCombinations(testCombinations);
        naturalNumberHandler.caseLengthTwo(testCombinations);
        assertTrue(naturalNumberHandler.getCombinations().contains("XY"));
        assertTrue(naturalNumberHandler.getCombinations().contains("X0Y"));
    }
    
    @Test
    public void testCaseLengthThree_inputX00andZ(){
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> testCombinations = new ArrayList();
        testCombinations.addAll(Arrays.asList("X00", "Z"));
        naturalNumberHandler.setCombinations(testCombinations);
        naturalNumberHandler.caseLengthThree(testCombinations);
        assertTrue(naturalNumberHandler.getCombinations().contains("X00Z"));
        assertTrue(naturalNumberHandler.getCombinations().contains("X0Z"));
    } 
    
    @Test
    public void testCaseLengthThree_inputX00andY0andZ(){
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> testCombinations = new ArrayList();
        testCombinations.addAll(Arrays.asList("X00", "Y0", "Z"));
        naturalNumberHandler.setCombinations(testCombinations);
        naturalNumberHandler.caseLengthThree(testCombinations);
        assertTrue(naturalNumberHandler.getCombinations().contains("X00Z"));
        assertTrue(naturalNumberHandler.getCombinations().contains("X0Z"));
    } 
    
    
    @Test
    public void testCaseLengthThree_inputX00andY0(){
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> testCombinations = new ArrayList();
        testCombinations.addAll(Arrays.asList("X00", "Y0"));
        naturalNumberHandler.setCombinations(testCombinations);
        naturalNumberHandler.caseLengthThree(testCombinations);
        assertTrue(naturalNumberHandler.getCombinations().contains("X00Y0"));
        assertTrue(naturalNumberHandler.getCombinations().contains("XY0"));
    } 
    
    @Test
    public void testCaseLengthThree_inputX00andYZ(){
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> testCombinations = new ArrayList();
        testCombinations.addAll(Arrays.asList("X00", "YZ"));
        naturalNumberHandler.setCombinations(testCombinations);
        naturalNumberHandler.caseLengthThree(testCombinations);
        assertTrue(naturalNumberHandler.getCombinations().contains("X00YZ"));
        assertTrue(naturalNumberHandler.getCombinations().contains("XYZ"));
        assertTrue(naturalNumberHandler.getCombinations().contains("X00Y0Z"));
    }
    
    @Test
    public void testCaseLengthThree_inputXY0andZ(){
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> testCombinations = new ArrayList();
        testCombinations.addAll(Arrays.asList("XY0", "Z"));
        naturalNumberHandler.setCombinations(testCombinations);
        naturalNumberHandler.caseLengthThree(testCombinations);
        assertTrue(naturalNumberHandler.getCombinations().contains("X00Y0Z"));
        assertTrue(naturalNumberHandler.getCombinations().contains("XY0Z"));
        assertTrue(naturalNumberHandler.getCombinations().contains("X00YZ"));
    }
    
    @Test
    public void testCaseLengthThree_inputXY0(){
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> testCombinations = new ArrayList();
        testCombinations.add("XY0");
        naturalNumberHandler.setCombinations(testCombinations);
        naturalNumberHandler.caseLengthThree(testCombinations);
        assertTrue(naturalNumberHandler.getCombinations().contains("X00Y0"));
        assertTrue(naturalNumberHandler.getCombinations().contains("XY0"));
    }
    
    @Test
    public void testCaseLengthThree_inputX1Z(){
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> testCombinations = new ArrayList();
        testCombinations.add("X1Z");
        naturalNumberHandler.setCombinations(testCombinations);
        naturalNumberHandler.caseLengthThree(testCombinations);
        assertTrue(naturalNumberHandler.getCombinations().contains("X001Z"));
        assertTrue(naturalNumberHandler.getCombinations().contains("X1Z"));
    }
    
    @Test
    public void testPossibleResults_addsInputToEmptyList(){
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> testCombinations = new ArrayList();
        testCombinations.addAll(Arrays.asList("XYZ", "XY", "Z"));
        NaturalNumberHandler.possibleResults(testCombinations);
        assertEquals(naturalNumberHandler.getCombinations().size(), testCombinations.size());
    }
    
    @Test
    public void testPossibleResults_addsInputToList(){
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> testCombinations = new ArrayList();
        testCombinations.addAll(Arrays.asList("XYZ", "XY", "Z"));
        NaturalNumberHandler.possibleResults(testCombinations);
        assertEquals(naturalNumberHandler.getCombinations(), testCombinations);
    }
}
