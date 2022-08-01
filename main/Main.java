package main;

import function.FunctionAlphabetShifter;
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
        String message = "This text will be shifted. ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        FunctionAlphabetShifter shifter = new FunctionAlphabetShifter();
        shifter.setInput(message);
        shifter.setCount(3);
        shifter.setBackwards(false);
        shifter.process();
        
        String result = shifter.getOutput();
        
        System.out.println(message);
        System.out.println(result);
        
        shifter.setInput(result);
        shifter.setBackwards(true);
        shifter.process();
        
        result = shifter.getOutput();
        
        System.out.println(result);
        // end of test
    }
}