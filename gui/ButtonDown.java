package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ButtonDown extends JButton {
    
    // Constructor
    public ButtonDown() {
        
        this.setText("Down");
        this.setBounds(264, 106, 96, 24);
        this.setBackground(new Color(232, 232, 232));
        this.setBorder(BorderFactory.createBevelBorder(0));
        this.setFocusable(false);
    }
}