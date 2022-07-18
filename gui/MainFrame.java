package gui;

import java.awt.Color;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    
    // Constructor
    public MainFrame() {
        
        this.setTitle("Secretus Cryptica");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(720, 480);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null); // all components will be manually bounded for now
        this.getContentPane().setBackground(new Color(223, 223, 223));
        
        this.setVisible(true);
    }
}