package calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    
    private JTextArea screenField = new JTextArea();
    private JButton num_1 = new JButton();
    private JButton num_2 = new JButton();
    private JButton num_3 = new JButton();
    private JButton num_4 = new JButton();
    private JButton num_5 = new JButton();
    private JButton num_6 = new JButton();
    private JButton num_7 = new JButton();
    private JButton num_8 = new JButton();
    private JButton num_9 = new JButton();
    private JButton num_0 = new JButton();
    private JButton exitButton = new JButton();
    private JButton resultButton = new JButton();
    private JButton addButton = new JButton();
    private JButton substractButton = new JButton();
    private JButton divButton = new JButton();
    private JButton timesButton = new JButton();
    private JButton resetButton = new JButton();
    private JButton dotButton = new JButton();
    private JButton squaredButton = new JButton();
    private JButton rootButton = new JButton();
    
    private boolean add = false;
    private boolean substract = false;
    private boolean div = false;
    private boolean times = false;
    private boolean squared = false;
    private boolean root = false;
    
    private double squaredResultNum1;
    private double rootResult;
    
    public static void main(String[] args) {
        Calculator my_calculator = new Calculator("Calculator");
        my_calculator.setSize(350, 350);
        my_calculator.setVisible(true);
        my_calculator.show();
    }
    
    public Calculator(String title)
    {
        super (title);
        JPanel my_panel = (JPanel) this.getContentPane();
        my_panel.setBackground(Color.DARK_GRAY);
        
        setLocationRelativeTo(null);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        gridConstraint.insets = new Insets(2, 2, 2, 22);
        
        //screen field
        screenField.setText("");
        screenField.setColumns(20);
        screenField.setEditable(false);
        gridConstraint.gridwidth = 4;
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.fill = GridBagConstraints.HORIZONTAL;
        my_panel.add(screenField, gridConstraint);
        
        
        // num_1
        num_1.setText("1");
        gridConstraint.gridwidth = 1;
        gridConstraint.insets = new Insets(22, 2, 2, 22);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        my_panel.add(num_1, gridConstraint);
        
        // num_2
        num_2.setText("2");
        gridConstraint.insets = new Insets(22, 2, 2, 22);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 2;
        my_panel.add(num_2, gridConstraint);
        
        // num_3
        num_3.setText("3");
        gridConstraint.insets = new Insets(22, 2, 2, 22);
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 2;
        my_panel.add(num_3, gridConstraint);
        
        // add button
        addButton.setText("+");
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 2;
        my_panel.add(addButton, gridConstraint);
        
        gridConstraint.insets = new Insets(5, 2, 2, 22);
        // substractButtom
        substractButton.setText("-");
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 3;
        my_panel.add(substractButton, gridConstraint);
        
        //timesButton
        timesButton.setText("X");
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 4;
        my_panel.add(timesButton, gridConstraint);
        
        //divButton
        divButton.setText("/");
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 5;
        my_panel.add(divButton, gridConstraint);
        
        //dotButton
        dotButton.setText(".");
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 6;
        my_panel.add(dotButton, gridConstraint);
        
        // num_4
        num_4.setText("4");
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 3;
        my_panel.add(num_4, gridConstraint);
        
        // num_5
        num_5.setText("5");
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 3;
        my_panel.add(num_5, gridConstraint);
        
        // num_6
        num_6.setText("6");
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 3;
        my_panel.add(num_6, gridConstraint);
        
        // num_7
        num_7.setText("7");
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 4;
        my_panel.add(num_7, gridConstraint);
        
        // num_8
        num_8.setText("8");
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 4;
        my_panel.add(num_8, gridConstraint);
        
        // num_9
        num_9.setText("9");
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 4;
        my_panel.add(num_9, gridConstraint);
        
        // num_0
        num_0.setText("0");
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 5;
        my_panel.add(num_0, gridConstraint);
        
        // result
        resultButton.setText("=");
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 6;
        my_panel.add(resultButton, gridConstraint);
        
        // resetButtom
        resetButton.setText("C");
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 6;
        my_panel.add(resetButton, gridConstraint);
        
        // squaredButton
        squaredButton.setText("^n");
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 5;
        my_panel.add(squaredButton, gridConstraint);
        
        // rootButton
        rootButton.setText("^0.5");
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 5;
        my_panel.add(rootButton, gridConstraint);
        
        // exit
        gridConstraint.insets = new Insets(22, 2, 2, 22);
        exitButton.setText("Exit");
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 7;
        my_panel.add(exitButton, gridConstraint);
        
        pack();
        setLocationRelativeTo(null);
        
        addWindowListener(
                new WindowAdapter()
                {
                    public void windowClosing (WindowEvent e)
                    {
                        System.exit(0);
                    }
                }
        );
        
        num_1.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        num1ButtonActionPerformed(e);
                    }
                }
        );
        
        num_2.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        num2ButtonActionPerformed(e);
                    }
                }
        );
        
        num_3.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        num3ButtonActionPerformed(e);
                    }
                }
        );
        
        num_4.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        num4ButtonActionPerformed(e);
                    }
                }
        );
        
        num_5.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        num5ButtonActionPerformed(e);
                    }
                }
        );
        
        num_6.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        num6ButtonActionPerformed(e);
                    }
                }
        );
        
        num_7.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        num7ButtonActionPerformed(e);
                    }
                }
        );
        
        num_8.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        num8ButtonActionPerformed(e);
                    }
                }
        );
        
        num_9.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        num9ButtonActionPerformed(e);
                    }
                }
        );
        
        num_0.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        num0ButtonActionPerformed(e);
                    }
                }
        );
        
        addButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        addButtonActionPerformed(e);
                    }
                }
        );
        
        substractButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        substractButtonActionPerformed(e);
                    }
                }
        );
        
        divButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        divButtonActionPerformed(e);
                    }
                }
        );
        
        
        timesButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        timesButtonActionPerformed(e);
                    }
                }
        );
        
        exitButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        System.exit(0);
                    }
                }
        );
        
        resultButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        resultButtonActionPerformed(e);
                    }
                }
        );
        
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
        
        dotButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        dotButtonActionPerformed(e);
                    }
                }
        );
        
        squaredButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        squaredButtonActionPerformed(e);
                    }
                }
        );
        
        rootButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        rootButtonActionPerformed(e);
                    }
                }
        );
        
    }
    
    private void num1ButtonActionPerformed(ActionEvent e)
    {
        screenField.append("1");
    }
    
    private void num2ButtonActionPerformed(ActionEvent e)
    {
        screenField.append("2");
    }
    
    private void num3ButtonActionPerformed(ActionEvent e)
    {
        screenField.append("3");
    }
    
    private void num4ButtonActionPerformed(ActionEvent e)
    {
        screenField.append("4");
    }
    
    private void num5ButtonActionPerformed(ActionEvent e)
    {
        screenField.append("5");
    }
    
    private void num6ButtonActionPerformed(ActionEvent e)
    {
        screenField.append("6");
    }
    
    private void num7ButtonActionPerformed(ActionEvent e)
    {
        screenField.append("7");
    }
    
    private void num8ButtonActionPerformed(ActionEvent e)
    {
        screenField.append("8");
    }
    
    private void num9ButtonActionPerformed(ActionEvent e)
    {
        screenField.append("9");
    }
    
    private void num0ButtonActionPerformed(ActionEvent e)
    {
        screenField.append("0");
    }
    
    private void dotButtonActionPerformed(ActionEvent e)
    {
        screenField.append(".");
    }
    
    private void addButtonActionPerformed(ActionEvent e)
    {
        screenField.append("+");
        add = true;
    }
    
    private void substractButtonActionPerformed(ActionEvent e)
    {
        screenField.append("-");
        substract = true;
    }
    
    private void divButtonActionPerformed(ActionEvent e)
    {
        screenField.append("/");
        div = true;
    }
    
    private void timesButtonActionPerformed(ActionEvent e)
    {
        screenField.append("X");
        times = true;
    }
    
    private void resetButtonActionPerformed(ActionEvent e)
    {
        screenField.setText("");
        add = false;
        substract = false;
        div = false;
        times = false;
    }
    
    public void squaredButtonActionPerformed(ActionEvent e)
    {
        screenField.append("^");
        squared = true;
    }
    
    public void rootButtonActionPerformed (ActionEvent e)
    {
        screenField.append("^0.5");
        root = true;
    }
    
    private void resultButtonActionPerformed(ActionEvent e)
    {
        String hasil = screenField.getText().trim();
        String angka1 = "";
        String angka2 = "";
        int len = hasil.length();
        char trans;
        int k = 0;
        for (int i = 0; i < len; i++)
        {
            trans = hasil.charAt(i);
            if (Character.isDigit(trans) || trans == '.')
            {
                angka1 = angka1 + trans;
                k++;
            }
            else
            {
                break;
            }
        }

        for (int i = k + 1 ; i < len; i++)
        {
            trans = hasil.charAt(i);
            if (Character.isDigit(trans) || trans == '.')
            {
                angka2 = angka2 + trans;
            }
            else
            {
                break;
            }
        }
        
        if (add)
        {
            double hasilAngka1 = Double.valueOf(angka1).doubleValue();
            double hasilAngka2 = Double.valueOf(angka2).doubleValue();
            String hasilAkhir = String.valueOf((hasilAngka1 + hasilAngka2));
            screenField.setText(hasilAkhir);
        }
        else if(substract)
        {
            double hasilAngka1 = Double.valueOf(angka1).doubleValue();
            double hasilAngka2 = Double.valueOf(angka2).doubleValue();
            String hasilAkhir = String.valueOf((hasilAngka1 - hasilAngka2));
            screenField.setText(hasilAkhir);
        }
        else if (div)
        {
            double hasilAngka1 = Double.valueOf(angka1).doubleValue();
            double hasilAngka2 = Double.valueOf(angka2).doubleValue();
            if (hasilAngka2 == 0.0)
            {
                screenField.setText("Math Error");
                Toolkit.getDefaultToolkit().beep();
            }
            else
            {
                String hasilAkhir = String.valueOf((hasilAngka1 / hasilAngka2));
                screenField.setText(hasilAkhir);
            }
        }
        else if (times)
        {
            double hasilAngka1 = Double.valueOf(angka1).doubleValue();
            double hasilAngka2 = Double.valueOf(angka2).doubleValue();
            String hasilAkhir = String.valueOf((hasilAngka1 * hasilAngka2));
            screenField.setText(hasilAkhir);
        }
        else if (squared)
        {
            double hasilAngka1 = Double.valueOf(angka1).doubleValue();
            double hasilAngka2 = Double.valueOf(angka2).doubleValue();
            String hasilAkhir = String.valueOf(Math.pow(hasilAngka1, hasilAngka2));
            screenField.setText(hasilAkhir);
        }
        else if (true)
        {
            double hasilAngka1 = Double.valueOf(angka1).doubleValue();
            double hasilAngka2 = Double.valueOf(angka2).doubleValue();
            String hasilAkhir = String.valueOf(Math.pow(hasilAngka1, hasilAngka2));
            screenField.setText(hasilAkhir);
        }
    }
}
