package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ButtonRemove extends JButton {
    
    // Constructor
    public ButtonRemove() {
        
        this.setText("- Remove");
        this.setBounds(264, 54, 96, 24);
        this.setBackground(new Color(232, 232, 232));
        this.setBorder(BorderFactory.createBevelBorder(0));
        this.setFocusable(false);
    }
}