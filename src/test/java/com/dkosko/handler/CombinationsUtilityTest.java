
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
    
}
