
package com.dkosko;

import com.dkosko.handler.NaturalNumberHandler;
import com.dkosko.io.InputOutput;
import java.util.List;


public class MainClass {
    
    public static void main(String[] args) {
        
        InputOutput io = new InputOutput();
        List<String> input = io.requestInput();
        NaturalNumberHandler naturalNumberHandler = new NaturalNumberHandler();
        io.printNumbers(naturalNumberHandler.createNumbers(input)); 
           
    }
}
