package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextArea;

public class TextInput extends JTextArea {
    
    // Constructor
    public TextInput() {
        
        this.setFont(new Font("FreeMono", Font.BOLD, 14));
        this.setBackground(new Color(240, 240, 240));
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setMargin(new Insets(2, 2, 2, 2));
    }
}