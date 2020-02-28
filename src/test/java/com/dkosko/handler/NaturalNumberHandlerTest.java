
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
        List<String> testCombinations = new ArrayList<>();
        testCombinations.addAll(Arrays.asList("a", "b", "c"));
        naturalNumberHandler.setCombinations(testCombinations);
        String testElement = "x";
        NaturalNumberHandler.concatElementToList(testElement);
        assertTrue(naturalNumberHandler.getCombinations().contains("a" + testElement));
        assertTrue(naturalNumberHandler.getCombinations().contains("b" + testElement));
        assertTrue(naturalNumberHandler.getCombinations().contains("b" + testElement));
        assertEquals(testCombinations.size(), naturalNumberHandler.getCombinations().size());
    }
    
}
