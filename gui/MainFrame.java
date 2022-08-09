package gui;

import gui.dialog.DialogAddFunction;
import gui.menubar.Menu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    
    public ButtonAdd buttonAdd;
    public ButtonRemove buttonRemove;
    public ButtonSelectUp buttonSelectUp;
    public ButtonSelectDown buttonSelectDown;
    public ButtonMoveUp buttonMoveUp;
    public ButtonMoveDown buttonMoveDown;
    public ButtonSetup buttonSetup;
    public MethodList methodList;
    
    private DialogAddFunction dialogAddFunction;
    private MouseHandler mouseHandler;
    
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
        
        this.buildFrame();
        
        this.setVisible(true);
    }
    
    /**
     * Composites menu bar with its elements, all frame components, creates
     * instances of listeners.
     */
    private void buildFrame() {
        
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
        
        this.mouseHandler = new MouseHandler();
        
        this.buttonAdd = new ButtonAdd();
        this.buttonAdd.addMouseListener(mouseHandler);
        this.add(buttonAdd);
        
        this.dialogAddFunction = new DialogAddFunction(this.data, this);
        
        this.buttonRemove = new ButtonRemove();
        this.buttonRemove.addMouseListener(mouseHandler);
        this.add(buttonRemove);
        
        this.buttonSelectUp = new ButtonSelectUp();
        this.buttonSelectUp.addMouseListener(mouseHandler);
        this.add(buttonSelectUp);
        
        this.buttonSelectDown = new ButtonSelectDown();
        this.buttonSelectDown.addMouseListener(mouseHandler);
        this.add(buttonSelectDown);
        
        this.buttonMoveUp = new ButtonMoveUp();
        this.buttonMoveUp.addMouseListener(mouseHandler);
        this.add(buttonMoveUp);
        
        this.buttonMoveDown = new ButtonMoveDown();
        this.buttonMoveDown.addMouseListener(mouseHandler);
        this.add(buttonMoveDown);
        
        this.buttonSetup = new ButtonSetup();
        this.add(buttonSetup);
        
        this.methodList = new MethodList();
        JScrollPane methodListScrollPane = new JScrollPane(methodList);
        methodListScrollPane.setBounds(364, 28, 350, 208);
        methodListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        methodListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        methodListScrollPane.setBorder(BorderFactory.createBevelBorder(1));
        this.add(methodListScrollPane);
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
    
    class MouseHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == buttonAdd) {
                dialogAddFunction.setVisible(true);
            }
            if (e.getSource() == buttonRemove) {
                data.removeFunction();
                data.process();
                methodList.setText(data.getFunctionList());
                textOutput.setText(data.getOutput());
            }
            if (e.getSource() == buttonSelectUp) {
                data.selectUp();
                methodList.setText(data.getFunctionList());
            }
            if (e.getSource() == buttonSelectDown) {
                data.selectDown();
                methodList.setText(data.getFunctionList());
            }
            if (e.getSource() == buttonMoveUp) {
                data.moveUp();
                data.process();
                methodList.setText(data.getFunctionList());
                textOutput.setText(data.getOutput());
            }
            if (e.getSource() == buttonMoveDown) {
                data.moveDown();
                data.process();
                methodList.setText(data.getFunctionList());
                textOutput.setText(data.getOutput());
            }
        }

        @Override public void mousePressed(MouseEvent me) {}
        @Override public void mouseReleased(MouseEvent me) {}
        @Override public void mouseEntered(MouseEvent me) {}
        @Override public void mouseExited(MouseEvent me) {}
    }
}