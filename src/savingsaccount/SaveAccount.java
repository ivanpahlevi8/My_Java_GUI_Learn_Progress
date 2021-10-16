package savingsaccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;


public class SaveAccount extends JFrame {
    
    private JLabel depositLabel = new JLabel();
    private JLabel interestLabel = new JLabel();
    private JLabel monthsLabel = new JLabel();
    private JLabel finalLabel = new JLabel();
    private JTextField depositTextField = new JTextField();
    private JTextField interestTextField = new JTextField();
    private JTextField monthsTextField = new JTextField();
    private JTextField finalTextField = new JTextField();
    private JButton calculateButton = new JButton();
    private JButton exitButton = new JButton();
    private JButton resetButton = new JButton();
    
    public static void main(String[] args)
    {
        SaveAccount my_account = new SaveAccount("Savings Account");
        my_account.setSize(520, 300);
        my_account.setVisible(true);
        my_account.show();
    }
    
    public SaveAccount (String title)
    {
        super(title);
        JPanel my_panel = (JPanel) this.getContentPane();
        my_panel.setBackground(new Color(176, 224, 230));
        setResizable(false);
        
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        
        // deposit Label
        depositLabel.setText("Monthly Deposit");
        depositLabel.setOpaque(true);
        depositLabel.setBackground(new Color(152, 251, 153));
        depositLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        depositLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.insets = new Insets(5, 5, 5, 5);
        my_panel.add(depositLabel, gridConstraint);
         
        // interest Label
        interestLabel.setText("Yearly Interest");
        interestLabel.setOpaque(true);
        interestLabel.setBackground(new Color(152, 251, 153));
        interestLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        interestLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        my_panel.add(interestLabel, gridConstraint);
        
        // months label
        monthsLabel.setText("Number Of Months");
        monthsLabel.setOpaque(true);
        monthsLabel.setBackground(new Color(152, 251, 153));
        monthsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        monthsLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        my_panel.add(monthsLabel, gridConstraint);
        
        // final label
        finalLabel.setText("Final Balance");
        finalLabel.setOpaque(true);
        finalLabel.setBackground(new Color(152, 251, 153));
        finalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        finalLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 3;
        my_panel.add(finalLabel, gridConstraint);
        
        //deposit text field
        depositTextField.setText("");
        depositTextField.setColumns(20);
        depositTextField.setFont(new Font("Arial", Font.BOLD, 14));
        depositTextField.setBackground(new Color(255, 255, 239));
        gridConstraint.gridwidth = 15;
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 0;
        my_panel.add(depositTextField, gridConstraint);
        
        //interest text field
        interestTextField.setText("");
        interestTextField.setColumns(20);
        interestTextField.setFont(new Font("Arial", Font.BOLD, 14));
        interestTextField.setBackground(new Color(255, 255, 239));
        gridConstraint.gridwidth = 15;
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 1;
        my_panel.add(interestTextField, gridConstraint);
        
        // months text field
        monthsTextField.setText("");
        monthsTextField.setColumns(20);
        monthsTextField.setFont(new Font("Arial", Font.BOLD, 14));
        monthsTextField.setBackground(new Color(255, 255, 239));
        gridConstraint.gridwidth = 15;
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 2;
        my_panel.add(monthsTextField, gridConstraint);
        
        // final text field
        finalTextField.setText("");;
        finalTextField.setColumns(20);
        finalTextField.setFont(new Font("Arial", Font.BOLD, 14));
        finalTextField.setBackground(new Color(255, 255, 239));
        finalTextField.setEditable(true); // digunakan agar ketika menekan tab untuk ke rtext field selanjutnya, final text field dilewati
        gridConstraint.gridwidth = 15;
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 3;
        my_panel.add(finalTextField, gridConstraint);
        
        // calculate button
        calculateButton.setText("Calculate");
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 4;
        my_panel.add(calculateButton, gridConstraint);
        
        // exit button
        exitButton.setText("Exit");
        exitButton.setFocusable(false);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 6;
        my_panel.add(exitButton, gridConstraint);
        
        //reset button
        resetButton.setText("Reset");
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 5;
        my_panel.add(resetButton, gridConstraint);
        
        pack();
        /*
            Pack berfungsi untuk mentapkan ukuran dari frame sehingga semua isi dari frame berada pada tempatnya
            jika tidak memakai pack, maka ketika di set frame muncul d tengan menggunakan fungsi di bawah, frame tidak berada di tengan pas pada layar
            pack diletakkan setelah semua atribut dari frame di tambahkan
        */
        setLocationRelativeTo(null);
        
        // exit button action
        exitButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        exitButtonPerformedAction(e);
                    }
                }
        );
        
        // calculate button action
        calculateButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        calculateButtonActionPerformed(e);
                    }
                }
        );
        
        // reset button action
        resetButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        resetButtonActionPerformed(e);
                    }
                }
        );
        
        // depositTextField listener
        depositTextField.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        depositTextFieldActionPerformed(e);
                    }
                }
        );
        
        /*
            pada text field, ketika enter ditekan, maka itu merupakan listener dari text fiel
            ada 3 action yang bisa deiberikan pada textfield ketika enter ditekan, yaitu, 
            1. requestFocus() untuk memberikan focus ke text field
            2. transferFocus() untuk memberikan focus ke text field selanjutnya
            3. transferFocusBackward() untuk memberkan focus ke text field sebelumnya
        */
        
        // interestTextField
        interestTextField.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        interestTextFieldActionPerformed(e);
                    }
                }
        );
        
        // monthsTextField
        monthsTextField.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        monthsTextFieldActionPerformed(e);
                    }
                }
        );
        
        //finalTextField
        finalTextField.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        finalTextFieldActionPerformed(e);
                    }
                }
        );
        
        // window action listener
        addWindowListener(
                new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        System.exit(0);
                    }
                }
        );
        
        
    }
    
    private void exitButtonPerformedAction(ActionEvent e)
    {
        Toolkit.getDefaultToolkit().beep();
        int action;
        action = JOptionPane.showConfirmDialog(null, "Are You Sure Want Exit ? ", "WARNING", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (action == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
    
    private void calculateButtonActionPerformed(ActionEvent e)
    {
        double deposit;
        double interest;
        double months;
        double finalBalance;
        double monthlyInterest;
        double finalCompute;
        double intChange;
        int intDirection;
        

        if (!validateDecimalNumber(depositTextField))
        {
            depositTextField.setText("");
            depositTextField.requestFocus();
            Toolkit.getDefaultToolkit().beep();
        }
        else if (!validateDecimalNumber(interestTextField))
        {
            interestTextField.setText("");
            interestTextField.requestFocus();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(!validateDecimalNumber(monthsTextField))
        {
            monthsTextField.setText("");
            monthsTextField.requestFocus();
            Toolkit.getDefaultToolkit().beep();
        }
        else if (
                depositTextField.getText().equals("") && interestTextField.getText().equals("") && 
                monthsTextField.getText().equals("")
                )
        {
            Toolkit.getDefaultToolkit().beep();
            int action;
            action = JOptionPane.showConfirmDialog(null, "Input The Box First", "Warn", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
            if (action == JOptionPane.YES_OPTION)
            {
                depositTextField.requestFocus();
            }
        }
        else
        {
            // jika deposit text field kosong dan ingin dicari nilainya
            if (depositTextField.getText().trim().equals(""))
            {
                interest = Double.valueOf(interestTextField.getText()).doubleValue();
                monthlyInterest = interest / 1200;
                months = Double.valueOf(monthsTextField.getText()).doubleValue();
                finalBalance = Double.valueOf(finalTextField.getText()).doubleValue();
                
                if (interest == 0)
                {
                    deposit = finalBalance / months;
                }
                else
                {
                    deposit = finalBalance * ((Math.pow((1 + monthlyInterest), months)) - 1);
                }
                depositTextField.setText(new DecimalFormat("0.00").format(deposit));
            }
            
            // jika interest field kosong dan ingin dicari nilainya
            else if (interestTextField.getText().trim().equals(""))
            {
                deposit = Double.valueOf(depositTextField.getText()).doubleValue();
                months = Double.valueOf(monthsTextField.getText()).doubleValue();
                finalBalance = Double.valueOf(finalTextField.getText()).doubleValue();
                interest = 0;
                intChange = 1;
                intDirection = 1;
                do {
                    interest = interest + (intDirection * intChange);
                    monthlyInterest = interest / 1200;
                    finalCompute = deposit * (Math.pow((1 + monthlyInterest), months) - 1);
                    
                    if (intDirection == 1)
                    {
                        if (finalCompute > finalBalance)
                        {
                            intDirection = -1;
                            intChange = intChange / 10;
                        }
                    }
                    else
                    {
                        if (finalCompute < finalBalance)
                        {
                            intDirection = 1;
                            intChange = intChange / 10;
                        }
                    }
                }
                while (Math.abs(finalCompute - finalBalance) >= 0.005);
                
                interestTextField.setText(new DecimalFormat("0.00").format(interest));
            }
            
            // months text field kosong dan ingin dicari nilainya
            else if (monthsTextField.getText().trim().equals(""))
            {
                deposit = Double.valueOf(depositTextField.getText()).doubleValue();
                interest = Double.valueOf(interestTextField.getText()).doubleValue();
                monthlyInterest = interest / 1200;
                finalBalance = Double.valueOf(finalTextField.getText()).doubleValue();
                
                if (interest == 0)
                {
                    months = finalBalance / deposit;
                }
                else
                {
                    months = Math.log(finalBalance * monthlyInterest + 1) * Math.log(1 + monthlyInterest);
                    /*
                        Need more riset about how using log proper in this scope of function
                    */
                }
                
                monthsTextField.setText(new DecimalFormat("0.00").format(months));
            }
            
            // jika final text field kosong atau normal
            else if (finalTextField.getText().trim().equals(""))
            {
                deposit = Double.valueOf(depositTextField.getText()).doubleValue();
                interest = Double.valueOf(interestTextField.getText()).doubleValue();
                monthlyInterest = interest / 1200;
                months = Double.valueOf(monthsTextField.getText()).doubleValue();
                
                if (interest == 0)
                {
                    finalBalance = deposit * months;
                }
                else
                {
                    finalBalance = deposit * (Math.pow((1 + monthlyInterest), months) - 1) / monthlyInterest;
                }
                 
                
                finalTextField.setText(new DecimalFormat("0.00").format(finalBalance));
            }
        }
    }
    
    private void depositTextFieldActionPerformed(ActionEvent e)
    {
        depositTextField.transferFocus();
    }
    
    private void finalTextFieldActionPerformed(ActionEvent e)
    {
        finalTextField.transferFocus();
    }
    
    private void interestTextFieldActionPerformed(ActionEvent e)
    {
        interestTextField.transferFocus();
    }
    
    private void monthsTextFieldActionPerformed(ActionEvent e)
    {
        monthsTextField.transferFocus();
    }
    
    private void resetButtonActionPerformed(ActionEvent e)
    {
        Toolkit.getDefaultToolkit().beep();
        int action;
        action = JOptionPane.showConfirmDialog(null, "Are You Sure Want To Reset ? ", "WARN", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (action == JOptionPane.YES_OPTION)
        {
            depositTextField.setText("");
            interestTextField.setText("");
            monthsTextField.setText("");
            finalTextField.setText("");
        }
        
    }
    
    private boolean validateDecimalNumber (JTextField j)
    {
        String s = j.getText().trim();
        boolean hasDecimal = false;
        boolean valid = true;
        
        if (s.length() == 0)
        {
            valid = true;
        }
        else
        {
            for (int i =0; i < s.length(); i++)
            {
                char trans = s.charAt(i);
                if (trans >= '0' && trans <= '9')
                {
                    valid = true;
                }
                else if(trans == '.' && !hasDecimal)
                {
                    hasDecimal = true;
                }
                else
                {
                    valid = false;
                    break;
                }
            }
        }
        
        return valid;
    } 
}
