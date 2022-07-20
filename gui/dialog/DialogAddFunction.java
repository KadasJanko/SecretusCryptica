package gui.dialog;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class DialogAddFunction extends JFrame {
    
    private String[] functionNamedList = {
        "reverse text"
    };
    public JComboBox<String> functionSelector;
    
    public JButton buttonOK;
    public JButton buttonCancel;
    
    // Constructor
    public DialogAddFunction() {
        
        this.setTitle("Add function");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(218, 104);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(223, 223, 223));
        
        functionSelector = new JComboBox<>(functionNamedList);
        functionSelector.setBounds(8, 8, 200, 24);
        functionSelector.setBorder(BorderFactory.createBevelBorder(1));
        this.add(functionSelector);
        
        buttonOK = new JButton();
        buttonOK.setText("OK");
        buttonOK.setBounds(8, 40, 96, 24);
        buttonOK.setFocusable(false);
        buttonOK.setBackground(new Color(223, 223, 223));
        buttonOK.setBorder(BorderFactory.createBevelBorder(0));
        this.add(buttonOK);
        
        buttonCancel = new JButton();
        buttonCancel.setText("Cancel");
        buttonCancel.setBounds(112, 40, 96, 24);
        buttonCancel.setFocusable(false);
        buttonCancel.setBackground(new Color(223, 223, 223));
        buttonCancel.setBorder(BorderFactory.createBevelBorder(0));
        this.add(buttonCancel);
    }
}