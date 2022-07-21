package gui.dialog;

import function.FunctionReverseText;
import gui.MainFrame;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import main.DataHolder;

public class DialogAddFunction extends JFrame {
    
    public DataHolder data;
    public MainFrame mainFrame;
    
    private String[] functionNamedList = {
        "reverse text"
    };
    public JComboBox<String> functionSelector;
    
    public JButton buttonOK;
    public JButton buttonCancel;
    
    private MouseHandler mouseHandler;
    
    // Constructor
    public DialogAddFunction(DataHolder data, MainFrame mainFrame) {
        
        this.setTitle("Add function");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(218, 104);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(223, 223, 223));
        
        this.data = data;
        this.mainFrame = mainFrame;
        
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
        
        this.mouseHandler = new MouseHandler();
        buttonOK.addMouseListener(mouseHandler);
    }
    
    class MouseHandler implements MouseListener {
        
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == buttonOK) {
                int option = functionSelector.getSelectedIndex();
                
                switch(option) {
                    case 0: // Reverse text selected
                        // add new function into given DataHolder
                        data.addFunction(new FunctionReverseText());
                        // invoke processing data through function list
                        data.process();
                        // update text on output
                        mainFrame.textOutput.setText(data.getOutput());
                        // close this function selection dialog
                        dispose();
                        break;
                }
            }
        }
        
        @Override public void mousePressed(MouseEvent me) {}
        @Override public void mouseReleased(MouseEvent me) {}
        @Override public void mouseEntered(MouseEvent me) {}
        @Override public void mouseExited(MouseEvent me) {}
    }
}