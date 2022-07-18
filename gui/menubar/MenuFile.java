package gui.menubar;

import javax.swing.JMenu;

public class MenuFile extends JMenu {
    
    public MenuFileExit menuFileExit;
    
    // Constructor
    public MenuFile() {
        
        this.setText("File");
        this.setBorder(null);
        
        this.menuFileExit = new MenuFileExit();
        this.add(menuFileExit);
    }
}