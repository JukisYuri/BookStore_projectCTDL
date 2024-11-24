package BookStore;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    
    public MainFrame() throws HeadlessException{
        super();
        setTitle("BookStore.Book Store");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,200);
        setLocation(300,200);
        setResizable(false);
        
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MainFrame();
    }
}