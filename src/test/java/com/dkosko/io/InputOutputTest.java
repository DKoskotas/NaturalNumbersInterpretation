
package com.dkosko.io;

import com.dkosko.handler.NaturalNumberHandler;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;


public class InputOutputTest {
    
   private InputOutput io = new InputOutput();
    
    public InputOutputTest() {
    }
    
    //Test method for requestInput()
    @Test
    public void requestInput_returnsList() {
        String data = "12 345";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        List<String> testResult = io.requestInput();
        assertEquals(2, testResult.size());
        assertTrue(testResult.contains("12"));
        assertTrue(testResult.contains("345"));
    }

    //Test method for checkNumbers() in multiple cases
    @Test
    public void testCheckNumbers() {
        assertTrue(io.checkNumbers("2112345678"));
        assertTrue(io.checkNumbers("00302112345678"));
        assertTrue(io.checkNumbers("6912312345"));
        assertTrue(io.checkNumbers("00306912312345"));
        assertFalse(io.checkNumbers("21123456789"));
        assertFalse(io.checkNumbers("211234567890"));
        assertFalse(io.checkNumbers("01123456789"));
        assertFalse(io.checkNumbers("002021123456789"));
        assertFalse(io.checkNumbers("0030211234567"));
        assertFalse(io.checkNumbers("0030211234567890"));
        assertFalse(io.checkNumbers("0030691234567890"));
        assertFalse(io.checkNumbers("0030691234567"));
    }
    
    
    @After
    public void cleanUp() {
        System.setIn(System.in);
    }
    
}
