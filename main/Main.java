package main;

import function.FunctionJoiner;
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
        String message = "This text should be splitted and joined.";
        
        FunctionSplitter splitter = new FunctionSplitter(message, ' ');
        splitter.process();
        
        String[] result = splitter.getOutputArray();
        
        System.out.println("Message: " + message);
        System.out.println("Result:\n[");
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println("]");
        
        FunctionJoiner joiner = new FunctionJoiner(result);
        joiner.process();
        
        String finalResult = joiner.getOutput();
        
        System.out.println("Final result: " + finalResult);
        // end of test
    }
}