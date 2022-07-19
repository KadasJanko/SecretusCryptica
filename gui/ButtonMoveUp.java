package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ButtonMoveUp extends JButton {
    
    // Constructor
    public ButtonMoveUp() {
        
        this.setText("Move Up");
        this.setBounds(264, 132, 96, 24);
        this.setBackground(new Color(232, 232, 232));
        this.setBorder(BorderFactory.createBevelBorder(0));
        this.setFocusable(false);
    }
}