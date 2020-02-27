
package com.dkosko.handler;

import com.dkosko.io.InputOutput;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class NaturalNumberHandlerTest {
    
    
    public NaturalNumberHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testCreateNumbers() {
        
    }

    
    @Test
    public void testConcatElementToList() {
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> example = new ArrayList();
        example.add("1");
        List<String> result = naturalNumberHandler.createNumbers(example);
        assertFalse(result.isEmpty());
    }

    
    @Test
    public void testCombineX0andZ() {
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        List<String> example = new ArrayList();
        example.add("10");
        example.add("1");
        List<String> result = naturalNumberHandler.createNumbers(example);
        assertTrue(result.size() == 1);
    }

    
    @Test
    public void testCombineX00andY0andZ() {
        
    }

    
    @Test
    public void testCaseLengthTwo() {
        
    }

    
    @Test
    public void testCaseLengthThree() {
        
    }

    
    @Test
    public void testCombineXYZ() {
        
    }

    
    @Test
    public void testCombineXY0andZ() {
        
    }

    
    @Test
    public void testCombineX1Y() {
        
    }

    
    @Test
    public void testCombineXY() {
        
    }

    
    @Test
    public void testPossibleResults() {
        
    }
    
}
