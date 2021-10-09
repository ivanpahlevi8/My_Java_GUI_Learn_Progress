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
        my_account.setSize(480, 300);
        my_account.setVisible(true);
        my_account.show();
    }
    
    public SaveAccount (String title)
    {
        super(title);
        JPanel my_panel = (JPanel) this.getContentPane();
        my_panel.setBackground(Color.CYAN);
        
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        
        // deposit Label
        depositLabel.setText("Monthly Deposit");
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.insets = new Insets(5, 5, 5, 5);
        my_panel.add(depositLabel, gridConstraint);
        
        // interest Label
        interestLabel.setText("Yearly Interest");
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        my_panel.add(interestLabel, gridConstraint);
        
        // months label
        monthsLabel.setText("Number Of Months");
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        my_panel.add(monthsLabel, gridConstraint);
        
        // final label
        finalLabel.setText("Final Balance");
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 3;
        my_panel.add(finalLabel, gridConstraint);
        
        //deposit text field
        depositTextField.setText("");
        depositTextField.setColumns(20);
        gridConstraint.gridwidth = 15;
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 0;
        my_panel.add(depositTextField, gridConstraint);
        
        //interest text field
        interestTextField.setText("");
        interestTextField.setColumns(20);
        gridConstraint.gridwidth = 15;
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 1;
        my_panel.add(interestTextField, gridConstraint);
        
        // months text field
        monthsTextField.setText("");
        monthsTextField.setColumns(20);
        gridConstraint.gridwidth = 15;
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 2;
        my_panel.add(monthsTextField, gridConstraint);
        
        // final text field
        finalTextField.setText("");;
        finalTextField.setColumns(20);
        finalTextField.setEditable(false);
        finalTextField.setFocusable(false); // digunakan agar ketika menekan tab untuk ke rtext field selanjutnya, final text field dilewati
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
        System.exit(0);
    }
    
    private void calculateButtonActionPerformed(ActionEvent e)
    {
        double deposit;
        double interest;
        double months;
        double finalBalance;
        double monthlyInterest;
        
        deposit = Double.valueOf(depositTextField.getText()).doubleValue();
        interest = Double.valueOf(interestTextField.getText()).doubleValue();
        if (interest == 0)
        {
            finalTextField.setText("Error, Interest Value Less Than One");
        }
        else
        {
            monthlyInterest = interest / 1200;
            months = Double.valueOf(monthsTextField.getText()).doubleValue();
            finalBalance = deposit * (Math.pow((1 + monthlyInterest), months) - 1) / monthlyInterest;
            finalTextField.setText(new DecimalFormat("0.00").format(finalBalance));
        }
    }
    
    private void resetButtonActionPerformed(ActionEvent e)
    {
        depositTextField.setText("");
        interestTextField.setText("");
        monthsTextField.setText("");
        finalTextField.setText("");
        Toolkit.getDefaultToolkit().beep();
    }
}
