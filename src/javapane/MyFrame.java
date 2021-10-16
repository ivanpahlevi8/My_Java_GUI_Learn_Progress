package javapane;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFrame extends JFrame {

    public static void main(String[] args) {
        
        new MyFrame("Title").show();
    }
    
    public MyFrame (String title)
    {
        setTitle(title);
        setResizable(false);
        setSize(300, 300);
        addWindowListener(new WindowAdapter()
        {
                public void windowClosing(WindowEvent e)
                {
                    exitForm(e);
                }
                
        }
        );
    }
    private void exitForm(WindowEvent e)
    {
        System.exit(0);
    }
}
