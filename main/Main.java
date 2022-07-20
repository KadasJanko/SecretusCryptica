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
        FunctionReverseText reverser = new FunctionReverseText();
        data.addFunction(reverser);
        // end of test
    }
}