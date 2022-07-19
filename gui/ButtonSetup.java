package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ButtonSetup extends JButton {
    
    // Constructor
    public ButtonSetup() {
        
        this.setText("Setup");
        this.setBounds(264, 184, 96, 24);
        this.setBackground(new Color(232, 232, 232));
        this.setBorder(BorderFactory.createBevelBorder(0));
        this.setFocusable(false);
    }
}