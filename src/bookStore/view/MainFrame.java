package bookStore.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    JMenuBar menuBar;
    JMenu menuFile,menuManager;
    JMenuItem mniExit,mniUpdate, mniBookManager, mniMainMenu;
    JPanel mainPanel;
    ActionListener actionMenu;
    public MainFrame(){
        setTitle("Book Store Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        
        setJMenuBar(createMenuBar());
        
        mainPanel = new BookStoreManagerPanel();
        add(mainPanel);
        
        
        setVisible(true);
    }
    
    public JMenuBar createMenuBar() {
        actionMenu = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = e.getActionCommand();
                ((BookStoreManagerPanel)mainPanel).showLayout(user);
            }
        };
        
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        mniExit = new JMenuItem("Exit");
        mniExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuFile.add(mniExit);
        mniUpdate = new JMenuItem("Update Book");
        menuFile.add(mniUpdate);
        
        menuManager = new JMenu("Manager Options");
        mniMainMenu = new JMenuItem("Main Menu");
        mniMainMenu.setActionCommand("mainPanel");
        mniMainMenu.addActionListener(actionMenu);
        menuManager.add(mniMainMenu);
        
        mniBookManager = new JMenuItem("Book Manager");
        mniBookManager.setActionCommand("bookPanel");
        mniBookManager.addActionListener(actionMenu);
        menuManager.add(mniBookManager);
        
        menuBar.add(menuFile, JMenuBar.getDefaultLocale());
        menuBar.add(menuManager,JMenuBar.getDefaultLocale());
        
        return menuBar;
    }
    
    public static void main(String[] args) {
        new MainFrame();
    }
}