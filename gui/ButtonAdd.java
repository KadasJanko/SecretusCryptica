package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ButtonAdd extends JButton {
    
    // Constructor
    public ButtonAdd() {
        
        this.setText("+ Add");
        this.setBounds(264, 28, 96, 24);
        this.setBackground(new Color(232, 232, 232));
        this.setBorder(BorderFactory.createBevelBorder(0));
        this.setFocusable(false);
    }
}