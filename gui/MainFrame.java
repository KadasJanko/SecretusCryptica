package gui;

import gui.menubar.Menu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    
    public Menu menu;
    
    private ActionHandler actionHandler;
    
    // Constructor
    public MainFrame() {
        
        this.setTitle("Secretus Cryptica");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(720, 480);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null); // all components will be manually bounded for now
        this.getContentPane().setBackground(new Color(223, 223, 223));
        
        this.menu = new Menu();
        this.add(menu);
        
        this.actionHandler = new  ActionHandler();
        this.menu.menuFile.menuFileExit.addActionListener(actionHandler);
        
        this.setVisible(true);
    }
    
    class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == menu.menuFile.menuFileExit) {
                dispose();
            }
        }
    }
}