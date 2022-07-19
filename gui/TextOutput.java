package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextArea;

public class TextOutput extends JTextArea {
    
    // Constructor
    public TextOutput() {
        
        this.setFont(new Font("FreeMono", Font.BOLD, 14));
        this.setBackground(new Color(240, 240, 240));
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setEditable(false);
        this.setMargin(new Insets(2, 2, 2, 2));
    }
}