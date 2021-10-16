package javapane;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Password extends JFrame{
    
    private JLabel passwordLabel = new JLabel();
    private JLabel newPassLabel = new JLabel();
    private JLabel oldPassLabel = new JLabel();
    private JPasswordField inputPasswordField = new JPasswordField();
    private JPasswordField testOldPasswordField = new JPasswordField();
    private JPasswordField newPasswordField = new JPasswordField();
    private JButton validButton = new JButton();
    private JButton exitButton = new JButton();
    private JButton setNewPassButton = new JButton();
    private JButton deleteButton = new JButton();
    private JButton checkButton = new JButton();
    private JButton backButton = new JButton();
    private JButton setPassButton = new JButton();
    
    private String password = "123";
    
    private boolean layer1 = true;
    private boolean layer2 = false;
    private boolean layer3 = false;
    
    private Integer inputTry = new Integer(0);
    

    public static void main(String[] args) {
        Password my_password = new Password("Rent\'O");
        my_password.setVisible(true);
        my_password.setSize(400, 250);
        
        my_password.show();
    }
    
    public Password(String Title)
    {
        super(Title);
        JPanel my_panel = (JPanel) this.getContentPane();
        //setResizable(false);
        my_panel.setBackground(new Color(250, 250, 210));
        
        setResizable(false);
        
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        
        
        // passwordLabel
        passwordLabel.setText("Please Enter Your Password");
        passwordLabel.setOpaque(true);
        passwordLabel.setBackground(Color.WHITE);
        passwordLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setVisible(true);
        gridConstraint.insets = new Insets(5, 20, 5, 20);
        /*
            Berturt turut insets mengatur spasi atau pixel dari control dengan space :
            atas(5), kiri(20), bawah(5), kanan(20)
        */
        gridConstraint.ipadx = 30;
        gridConstraint.ipady = 20;
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.gridwidth = 2;
        my_panel.add(passwordLabel, gridConstraint);
        gridConstraint.gridwidth = 1;
        
        // old pass Label
        oldPassLabel.setText("Enter Your Old Password");
        oldPassLabel.setOpaque(true);
        oldPassLabel.setBackground(Color.WHITE);
        oldPassLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        oldPassLabel.setFont(new Font("Arial", Font.BOLD, 18));
        oldPassLabel.setHorizontalAlignment(SwingConstants.CENTER);
        oldPassLabel.setVisible(false);
        gridConstraint.insets = new Insets(5, 20, 5, 20);
        gridConstraint.ipadx = 30;
        gridConstraint.ipady = 20;
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.gridwidth = 2;
        my_panel.add(oldPassLabel, gridConstraint);
        gridConstraint.gridwidth = 1;
        
        // newPassLabel
        newPassLabel.setText("Enter Your New Password");
        newPassLabel.setOpaque(true);
        newPassLabel.setBackground(Color.WHITE);
        newPassLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        newPassLabel.setFont(new Font("Arial", Font.BOLD, 18));
        newPassLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newPassLabel.setVisible(false);
        gridConstraint.insets = new Insets(5, 20, 5, 20);
        gridConstraint.ipadx = 30;
        gridConstraint.ipady = 20;
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.gridwidth = 2;
        my_panel.add(newPassLabel, gridConstraint);
        gridConstraint.gridwidth = 1;
        
        // inputPasswordField
        inputPasswordField.setText("");
        inputPasswordField.setColumns(20);
        inputPasswordField.setFont(new Font("Arial", Font.BOLD, 14));
        inputPasswordField.setVisible(true);
        gridConstraint.gridwidth = 2;
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.ipadx = 0;
        gridConstraint.ipady = 0;
        gridConstraint.insets = new Insets(1, 1, 1, 1);
        my_panel.add(inputPasswordField, gridConstraint);
        gridConstraint.gridwidth = 1;
        gridConstraint.ipadx = 0;
        gridConstraint.ipady = 0;
        
        // testOldPasswordField
        testOldPasswordField.setText("");
        testOldPasswordField.setColumns(20);
        testOldPasswordField.setFont(new Font("Arial", Font.BOLD, 14));
        testOldPasswordField.setVisible(false);
        gridConstraint.gridwidth = 2;
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.ipadx = 0;
        gridConstraint.ipady = 0;
        gridConstraint.insets = new Insets(1, 1, 1, 1);
        my_panel.add(testOldPasswordField, gridConstraint);
        gridConstraint.gridwidth = 1;
        gridConstraint.ipadx = 0;
        gridConstraint.ipady = 0;
        
        // newPasswordField
        newPasswordField.setText("");
        newPasswordField.setColumns(20);
        newPasswordField.setFont(new Font("Arial", Font.BOLD, 14));
        newPasswordField.setVisible(false);
        gridConstraint.gridwidth = 2;
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.ipadx = 0;
        gridConstraint.ipady = 0;
        gridConstraint.insets = new Insets(1, 1, 1, 1);
        my_panel.add(newPasswordField, gridConstraint);
        gridConstraint.gridwidth = 1;
        gridConstraint.ipadx = 0;
        gridConstraint.ipady = 0;
        
        
        // valid button
        validButton.setText("Validate");
        validButton.setVisible(true);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        gridConstraint.gridwidth = 1;
        gridConstraint.insets = new Insets(5, 30, 5, 20);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(validButton, gridConstraint);
        
        // checkButton
        checkButton.setText("Enter");
        checkButton.setVisible(false);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        gridConstraint.gridwidth = 1;
        gridConstraint.insets = new Insets(5, 30, 5, 20);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(checkButton, gridConstraint);
        
        //setPassButton
        setPassButton.setText("Set Pass");
        setPassButton.setVisible(false);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        gridConstraint.gridwidth = 1;
        gridConstraint.insets = new Insets(5, 30, 5, 20);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(setPassButton, gridConstraint);
        
        // exit button
        exitButton.setText("Exit");
        exitButton.setVisible(true);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 2;
        gridConstraint.gridwidth = 1;
        gridConstraint.insets = new Insets(5, 100, 5, 20);
        my_panel.add(exitButton, gridConstraint);
        
        // deleteButton
        deleteButton.setText("Delete");
        deleteButton.setVisible(false);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 2;
        gridConstraint.gridwidth = 1;
        gridConstraint.insets = new Insets(5, 100, 5, 20);
        my_panel.add(deleteButton, gridConstraint);
        
        // backButton
        backButton.setText("Back");
        backButton.setVisible(true);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 3;
        gridConstraint.gridwidth = 1;
        gridConstraint.insets = new Insets(5, 30, 5, 20);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(backButton, gridConstraint);
        
        //setNewPassButton
        setNewPassButton.setText("Set Pass");
        setNewPassButton.setVisible(true);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 3;
        gridConstraint.gridwidth = 1;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        gridConstraint.insets = new Insets(5, 100, 5, 20);
        my_panel.add(setNewPassButton, gridConstraint);
        
        pack();
        setLocationRelativeTo(null);
        
        addWindowListener(
                new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        exitForm(e);
                    }
                }
        );
        
        // exitButtonListener
        exitButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        exitButtonActionPerformed(e);
                    }
                }
        );
        
        // validateButtonListener
        validButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        validButtonActionPerformed(e);
                    }
                }
        );
        
        // setNewPassButtonListener
        setNewPassButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        setNewPassButtonActionPerformed(e);
                    }
                }
        );
        
        // backButtonListener
        backButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        backButtonActionPerformed(e);
                    }
                }
        );
        
        //deleteButtonListener
        deleteButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        deleteButtonActionPerformed(e);
                    }
                }
        );
        
        // enterButtonListener
        checkButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        enterButtonActionPerformed(e);
                    }
                }
        );
        
        // setPassButtonListener
        setPassButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        setPassButtonActionPerformed(e);
                    }
                }
        );
    }
    
    public void exitForm(WindowEvent e)
    {
        System.exit(0);
    }
    
    public void exitButtonActionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
    
    public void validButtonActionPerformed(ActionEvent e)
    {
        char[] trans = inputPasswordField.getPassword();
        String val = "";
        for (int i = 0; i < trans.length; i++)
        {
            val = val + trans[i];
        }
        
        if (val.equalsIgnoreCase(password))
        {
            int action;
            System.out.println("In");
            Toolkit.getDefaultToolkit().beep();
            action = JOptionPane.showConfirmDialog(null, "Your Password Is Correct", "WARN", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        else
        {
            int action;
            Toolkit.getDefaultToolkit().beep();
            action = JOptionPane.showConfirmDialog(null, "Wrong Password. Try Again", "WARN", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            inputTry++;
            if (inputTry == 3)
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showConfirmDialog(null, "You Have Reached Limit \n Contact Admin To Get \n Your Account Back", "WARN", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE );
                System.exit(0);;
            }
            inputPasswordField.setText("");
            inputPasswordField.requestFocus();            
        }
    }
    
    public void setNewPassButtonActionPerformed(ActionEvent e)
    {
        layer2 = true;
        layer1 = false;
        layer3 = false;
        layer(layer1, layer2, layer3);
    }
    
    public void deleteButtonActionPerformed(ActionEvent e)
    {
        testOldPasswordField.setText("");
        testOldPasswordField.requestFocus();
        newPasswordField.setText("");;
        newPasswordField.requestFocus();
    }
    
    public void setPassButtonActionPerformed(ActionEvent e)
    {
        char [] data = newPasswordField.getPassword();
        String trans = "";
        for (int i = 0; i < data.length; i++)
        {
            trans = trans + data[i];
        }
        
        password = trans;
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showConfirmDialog(null, "New Password Valid", "WARN", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        newPasswordField.setText("");
        layer1 = true;
        layer2 = false;
        layer3 = false;
        layer (layer1, layer2, layer3);
    }
    
    public void enterButtonActionPerformed(ActionEvent e)
    {
        char[] trans = testOldPasswordField.getPassword();
        String val = "";
        for (int i = 0; i < trans.length; i++)
        {
            val = val + trans[i];
        }
        
        if (val.equalsIgnoreCase(password))
        {
            int action;
            System.out.println("In");
            Toolkit.getDefaultToolkit().beep();
            action = JOptionPane.showConfirmDialog(null, "Your Password Is Correct", "WARN", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
            layer3 = true;
            layer2 = false;
            layer1 = false;
            layer (layer1, layer2, layer3);
            testOldPasswordField.setText("");
        }
        else
        {
            int action;
            Toolkit.getDefaultToolkit().beep();
            action = JOptionPane.showConfirmDialog(null, "Wrong Password. Try Again", "WARN", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            inputTry++;
            if (inputTry == 3)
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showConfirmDialog(null, "You Have Reached Limit \n Contact Admin To Get \n Your Account Back", "WARN", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                System.exit(0);;
            }
            inputPasswordField.setText("");
            inputPasswordField.requestFocus();            
        }
    }
    
    public void backButtonActionPerformed(ActionEvent e)
    {
        if (layer1 && !layer2 && !layer3)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showConfirmDialog(null, "Already In First Page", "WARN", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        }
        else if (layer2 && !layer1 && !layer3)
        {
            layer1 = true;
            layer2 = false;
            layer3 = false;
            layer (layer1, layer2, layer3);
        }
        else if (layer3 && !layer1 && !layer2)
        {
            layer1 = false;
            layer2 = true;
            layer3 = false;
            layer (layer1, layer2, layer3);
        }
    }
    
    public void layer (boolean first, boolean second, boolean third)
    {
        if (first)
        {
            // layer 1
            passwordLabel.setVisible(true);
            inputPasswordField.setVisible(true);
            validButton.setVisible(true);
            exitButton.setVisible(true);
            setNewPassButton.setVisible(true);
            
            // layer 2
            oldPassLabel.setVisible(false);
            checkButton.setVisible(false);
            deleteButton.setVisible(false);
            testOldPasswordField.setVisible(false);
            
            //layer3
            newPasswordField.setVisible(false);
            newPassLabel.setVisible(false);
            setPassButton.setVisible(false);
        }
        else if (second)
        {
            passwordLabel.setVisible(false);
            inputPasswordField.setVisible(false);
            validButton.setVisible(false);
            exitButton.setVisible(false);
            setNewPassButton.setVisible(false);
            
            //layer2
            oldPassLabel.setVisible(true);
            checkButton.setVisible(true);
            deleteButton.setVisible(true);
            testOldPasswordField.setVisible(true);
            
            //layer3
            newPasswordField.setVisible(true);
            newPassLabel.setVisible(false);
            setPassButton.setVisible(false);
        }
        else if (third)
        {
            // layer1
            passwordLabel.setVisible(false);
            inputPasswordField.setVisible(false);
            validButton.setVisible(false);
            exitButton.setVisible(false);
            setNewPassButton.setVisible(false);
            
            //layer2
            oldPassLabel.setVisible(false);
            checkButton.setVisible(false);
            deleteButton.setVisible(true);
            testOldPasswordField.setVisible(false);
            
            //layer3
            newPasswordField.setVisible(true);
            newPassLabel.setVisible(true);
            setPassButton.setVisible(true);
        }
    }
    
}
