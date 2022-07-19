package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ButtonUp extends JButton {
    
    // Constructor
    public ButtonUp() {
        
        this.setText("Up");
        this.setBounds(264, 80, 96, 24);
        this.setBackground(new Color(232, 232, 232));
        this.setBorder(BorderFactory.createBevelBorder(0));
        this.setFocusable(false);
    }
}