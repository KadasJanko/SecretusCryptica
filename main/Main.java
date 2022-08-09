package main;

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
        System.out.println(data.getCharacterKey(true, false, true, false, false));
        System.out.println(data.getCharacterKey(true, true, true, true, true));
        // end of test
    }
}