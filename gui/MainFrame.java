package gui;

import gui.menubar.Menu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import main.DataHolder;

public class MainFrame extends JFrame {
    
    DataHolder data;
    
    public Menu menu;
    
    private ActionHandler actionHandler;
    
    public TextInput textInput;
    public TextOutput textOutput;
    
    TextInputHandler textInputHandler;
    
    // Constructor
    public MainFrame(DataHolder data) {
        
        this.setTitle("Secretus Cryptica");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(720, 480);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null); // all components will be manually bounded for now
        this.getContentPane().setBackground(new Color(223, 223, 223));
        
        this.data = data;
        
        this.menu = new Menu();
        this.add(menu);
        
        this.actionHandler = new  ActionHandler();
        this.menu.menuFile.menuFileExit.addActionListener(actionHandler);
        
        this.textInput = new TextInput();
        JScrollPane inputScrollPane = new JScrollPane(this.textInput);
        inputScrollPane.setBounds(4, 28, 256, 208);
        inputScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        inputScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        inputScrollPane.setBorder(BorderFactory.createBevelBorder(1));
        this.add(inputScrollPane);
        
        this.textOutput = new TextOutput();
        JScrollPane outputScrollPane = new JScrollPane(this.textOutput);
        outputScrollPane.setBounds(4, 236, 256, 208);
        outputScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        outputScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        outputScrollPane.setBorder(BorderFactory.createBevelBorder(1));
        this.add(outputScrollPane);
        
        textInputHandler = new TextInputHandler();
        this.textInput.addKeyListener(textInputHandler);
        
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
    
    class TextInputHandler implements KeyListener {
        
        @Override
        public void keyPressed(KeyEvent ke) {
            data.setInput(textInput.getText());
            data.process();
            textOutput.setText(data.getOutput());
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            data.setInput(textInput.getText());
            data.process();
            textOutput.setText(data.getOutput());
        }
        
        @Override public void keyTyped(KeyEvent ke) {}
    }
}