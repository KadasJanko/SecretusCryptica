package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ButtonMoveDown extends JButton {
    
    // Constructor
    public ButtonMoveDown() {
        
        this.setText("Move Down");
        this.setBounds(264, 158, 96, 24);
        this.setBackground(new Color(232, 232, 232));
        this.setBorder(BorderFactory.createBevelBorder(0));
        this.setFocusable(false);
    }
}