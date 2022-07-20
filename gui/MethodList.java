package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextArea;

public class MethodList extends JTextArea {
    
    // Constructor
    public MethodList() {
        
        this.setFont(new Font("FreeMono", Font.BOLD, 14));
        this.setBackground(new Color(0, 63, 31));
        this.setForeground(new Color(0, 255, 127));
        this.setMargin(new Insets(2, 2, 2, 2));
        this.setEditable(false);
    }
}