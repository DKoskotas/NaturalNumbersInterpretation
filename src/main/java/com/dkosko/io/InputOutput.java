
package com.dkosko.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputOutput {
    
    // This method is called to request a number from the user
    public List<String> requestInput() {
        boolean invalid = true;
        List<String> parts = new ArrayList();
        while (invalid) {
            System.out.println("Enter a phone number:");
            String input = new Scanner(System.in).nextLine();
            if ("".equals(input)) {
                System.out.println("Invalid number, try again:");
            } else {
                parts = Arrays.stream(input.split(" ")).collect(Collectors.toList());
                for (String part : parts) {
                    if (part.length() <= 3) {
                        invalid = false;
                        continue;
                    } else {
                        invalid = true;
                        System.out.println("Invalid number, try again:");
                        break;
                    }
                }
            }
        }
        return parts;
    }
    
    //prints the numbers that have been produced along with their validity
    public void printNumbers(List<String> numbers) {
        System.out.println("\nRESULTS:\n");
        for (String number : numbers) {
            if (checkNumbers(number)) {
                System.out.println(number + " [phone number: VALID]");
            } else {
                System.out.println(number + " [phone number: INVALID]");
            }
        }
    }

    // Checking whether the input is a valid Greek local or international phone numbers
    protected boolean checkNumbers(String number) {
        return ((number.startsWith("2") || number.startsWith("69")) && number.length() == 10) ||
                ((number.startsWith("00302") || number.startsWith("003069")) && number.length() == 14);
    }
}
