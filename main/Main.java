package main;

import function.FunctionSplitter;
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
        String message = "This text should be splitted into array of strings.";
        
        FunctionSplitter splitter = new FunctionSplitter(message, ' ');
        splitter.process();
        
        String[] result = splitter.getOutputArray();
        
        System.out.println("Message: " + message);
        System.out.println("Result:\n[");
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println("]");
        // end of test
    }
}