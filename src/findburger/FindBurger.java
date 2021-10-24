package findburger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Random;

public class FindBurger extends JFrame {
    
    private JLabel label0 = new JLabel();
    private JLabel label1 = new JLabel();
    private JLabel label2 = new JLabel();
    private JLabel banner = new JLabel();
    private JButton newButton = new JButton();
    private JButton exitButton = new JButton();
    private JLabel[] choiceLabel = new JLabel[3];
    ImageIcon burger = new ImageIcon("D:/Second/Coding/File Coding Java/LJProjects/Picture/burger.gif");
    private Random myRandom = new Random();
    private int burgerLocation;

    public static void main(String[] args) {
        FindBurger my_burger = new FindBurger("Find The Burger");
        my_burger.setVisible(true);
        
        my_burger.show();
    }
    
    public FindBurger(String title)
    {
        super (title);
        JPanel my_panel = (JPanel) this.getContentPane();
        my_panel.setBackground(new Color(02, 205, 170));
        
        burgerLocation = myRandom.nextInt(3);
        newButton.setEnabled(false);
        
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        
        // atribute frame strats here
        choiceLabel[0] = label0;
        choiceLabel[1] = label1;
        choiceLabel[2] = label2;
        
        // banner
        banner.setText("Guest Where The Burger Hides");
        banner.setFont(new Font("Arial", Font.BOLD, 40));
        banner.setOpaque(true);
        banner.setBackground(new Color(62, 250, 153));
        banner.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.gridwidth = 3;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(banner, gridConstraint);
        gridConstraint.gridwidth = 1;
        
        // label0
        label0.setPreferredSize(new Dimension(burger.getIconWidth(), burger.getIconHeight()));
        label0.setOpaque(true);
        label0.setBackground(new Color(62, 254, 255));
        label0.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(label0, gridConstraint);
        
        // label1
        label1.setPreferredSize(new Dimension(burger.getIconWidth(), burger.getIconHeight()));
        label1.setOpaque(true);
        label1.setBackground(new Color(62, 254, 255));
        label1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(label1, gridConstraint);
        
        // label2
        label2.setPreferredSize(new Dimension(burger.getIconWidth(), burger.getIconHeight()));
        label2.setOpaque(true);
        label2.setBackground(new Color(62, 254, 255));
        label2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(label2, gridConstraint);
        
        //newButton
        newButton.setText("Play Again");
        newButton.setFont(new Font("Arial", Font.BOLD, 18));
        newButton.setOpaque(true);
        newButton.setBackground(new Color(135, 206, 235));
        newButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 2;
        gridConstraint.ipadx = 30;
        gridConstraint.ipady = 10;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(newButton, gridConstraint);
        
        //exitButton
        exitButton.setText("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));
        exitButton.setOpaque(true);
        exitButton.setBackground(new Color(250, 69, 1));
        exitButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 3;
        gridConstraint.ipadx = 30;
        gridConstraint.ipady = 10;
        gridConstraint.insets = new Insets(5, 10, 10, 10);
        my_panel.add(exitButton, gridConstraint);
        
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        my_panel.setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
        setLocationRelativeTo(null);
        
        // listener start here
        label0.addMouseListener(
                new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent e)
                    {
                        labelMouseClicked(e);
                    }
                }
        );
        
        label1.addMouseListener(
                new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent e)
                    {
                        labelMouseClicked(e);
                    }
                }
        );
        
        label2.addMouseListener(
                new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent e)
                    {
                        labelMouseClicked(e);
                    }
                }
        );
        
        newButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        newButtonActionPerformed(e);
                    }
                }
        );
        
        exitButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        exitButtonActionPerformed(e);
                    }
                }
        );
        
        
        addWindowListener(
                new WindowAdapter()
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
    
    private void labelMouseClicked(MouseEvent e)
    {
        Component clickedComponent = e.getComponent();
        int choice;
        for (choice = 0; choice < 3; choice++)
        {
            if (choiceLabel[choice] == clickedComponent)
            {
                break;
            }
        }
        
        choiceLabel[choice].setBackground(Color.WHITE);
        if (choice == burgerLocation)
        {
            choiceLabel[choice].setIcon(burger);
            newButton.setEnabled(true);
        }
        else
        {
            JOptionPane.showConfirmDialog(null, "Wrong Choice", "WARN", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
            choiceLabel[burgerLocation].setIcon(burger);
            newButton.setEnabled(true);
        }
    }
    
    private void newButtonActionPerformed(ActionEvent e)
    {
        for (int i = 0; i < 3; i++)
        {
            choiceLabel[i].setBackground(new Color(62, 254, 255));
            choiceLabel[i].setIcon(null);
        }
        burgerLocation = myRandom.nextInt(3);
        newButton.setEnabled(false);
    }
    
    private void exitButtonActionPerformed(ActionEvent e)
    {
        int action;
        action = JOptionPane.showConfirmDialog(null, "Are You Sure Want To Exit ? ", "WARN", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (action == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
        else
        {
            newButton.requestFocus();
        }
    }
    
}
