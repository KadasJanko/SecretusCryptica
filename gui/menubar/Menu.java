package gui.menubar;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JMenuBar;

public class Menu extends JMenuBar {
    
    public MenuFile menuFile;
    
    // Constructor
    public Menu() {
        
        this.setBounds(0, 0, 718, 24);
        this.setBackground(new Color(232, 232, 232));
        this.setBorder(BorderFactory.createBevelBorder(0));
        this.menuFile = new MenuFile();
        this.add(menuFile);
    }
}