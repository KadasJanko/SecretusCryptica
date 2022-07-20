package main;

import function.FunctionReverseText;
import gui.MainFrame;

/**
    Developed by Jan Kadas © 2022
    All rights reserved.
    Name of project: Secretus Cryptica
*/
public class Main {
    
    public static void main(String[] args) {
        
        DataHolder data = new DataHolder();
        MainFrame mainFrame = new MainFrame(data);
        
        // testing code snippet
        String message = "This code should be backwards.";
        System.out.println("Message: " + message);
        
        FunctionReverseText reverser = new FunctionReverseText(message);
        reverser.process();
        
        System.out.println("Result: " + reverser.getOutput());
        // end of test
    }
}