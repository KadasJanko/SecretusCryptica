package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ButtonSelectUp extends JButton {
    
    // Constructor
    public ButtonSelectUp() {
        
        this.setText("Up");
        this.setBounds(264, 80, 96, 24);
        this.setBackground(new Color(232, 232, 232));
        this.setBorder(BorderFactory.createBevelBorder(0));
        this.setFocusable(false);
    }
}