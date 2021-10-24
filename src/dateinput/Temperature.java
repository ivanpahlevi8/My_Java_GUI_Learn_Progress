package dateinput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Temperature extends JFrame{
    
    private JSpinner degreesOneLabel = new JSpinner();
    private JSpinner degreesTwoLabel = new JSpinner();
    private JTextField degreesOneTextField = new JTextField();
    private JTextField degreesTwoTextField = new JTextField();
    private JLabel temperatureLabel = new JLabel();
    private JPanel colorPanel = new JPanel();
    private JButton exit = new JButton();
    private JButton reset = new JButton();
    private JScrollBar temperatureScrollBar = new JScrollBar();
    private String[] temperature = {
        "Celcius", "Fahrenheit", "Kelvin", "Reamur"
    };
    private boolean isHot = false;
    
    public static void main(String[] args) {
        Temperature my_temp = new Temperature("Temperature Conversion");
        my_temp.setVisible(true);
        
        my_temp.show();
    }
    
    public Temperature(String title)
    {
        super (title);
        JPanel my_panel = (JPanel) this.getContentPane();
        my_panel.setBackground(new Color(135, 206, 250));
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        
        // attribute frame start here
        
        // calculatorLabel
        temperatureLabel.setText("     Temperatur Conversion");
        temperatureLabel.setOpaque(true);
        temperatureLabel.setBackground(new Color(40, 178, 170));
        temperatureLabel.setFont(new Font("Arial", Font.BOLD, 24));
        temperatureLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.gridwidth = 2;
        gridConstraint.insets = new Insets(10, 10, 30, 10);
        gridConstraint.ipadx = 40;
        gridConstraint.ipady = 10;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(temperatureLabel, gridConstraint);
        
        // degreesOneLabel
        gridConstraint = new GridBagConstraints();
        degreesOneLabel.setModel(new SpinnerListModel(temperature));
        degreesOneLabel.setPreferredSize(new Dimension(150, 40));
        degreesOneLabel.setValue("Fahrenheit");
        ((JSpinner.DefaultEditor) degreesOneLabel.getEditor()).getTextField().setOpaque(true);
        ((JSpinner.DefaultEditor) degreesOneLabel.getEditor()).getTextField().setBackground(new Color(144, 238, 144));
        ((JSpinner.DefaultEditor) degreesOneLabel.getEditor()).getTextField().setFont(new Font("Arial", Font.BOLD, 16));
        ((JSpinner.DefaultEditor) degreesOneLabel.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) degreesOneLabel.getEditor()).getTextField().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(degreesOneLabel, gridConstraint);
        
        // degreesOneTextField
        degreesOneTextField.setText("");
        degreesOneTextField.setColumns(15);
        degreesOneTextField.setPreferredSize(new Dimension(150, 30));
        degreesOneTextField.setEditable(false);
        degreesOneTextField.setAlignmentX(SwingConstants.CENTER);
        degreesOneTextField.setAlignmentY(SwingConstants.CENTER);
        degreesOneTextField.setFont(new Font("Arial", Font.BOLD, 16));
        degreesOneTextField.setOpaque(true);
        degreesOneTextField.setBackground(new Color(144, 238, 144));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(degreesOneTextField, gridConstraint);
        
        // colorPanel
        colorPanel.setPreferredSize(new Dimension(280, 40));
        colorPanel.setBackground(new Color(72, 209, 204));
        colorPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        colorPanel.setLayout(new GridBagLayout());
        gridConstraint = new GridBagConstraints();
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        gridConstraint.gridwidth = 2;
        gridConstraint.insets = new Insets(-5, 10, -5, 10);
        my_panel.add(colorPanel, gridConstraint);
        
        // temperatureScrollBar
        temperatureScrollBar.setPreferredSize(new Dimension(250, 30));
        temperatureScrollBar.setMinimum(-600);
        temperatureScrollBar.setMaximum(1200 + temperatureScrollBar.getVisibleAmount());
        temperatureScrollBar.setBlockIncrement(10);
        temperatureScrollBar.setUnitIncrement(1);
        temperatureScrollBar.setValue(320);
        temperatureScrollBar.setOrientation(JScrollBar.HORIZONTAL);
        gridConstraint = new GridBagConstraints();
        gridConstraint.anchor = GridBagConstraints.CENTER;
        colorPanel.add(temperatureScrollBar, gridConstraint);
        
        // degreesTwoLabel
        gridConstraint = new GridBagConstraints();
        degreesTwoLabel.setModel(new SpinnerListModel(temperature));
        degreesTwoLabel.setPreferredSize(new Dimension(150, 40));
        degreesTwoLabel.setValue("Celcius");
        ((JSpinner.DefaultEditor) degreesTwoLabel.getEditor()).getTextField().setOpaque(true);
        ((JSpinner.DefaultEditor) degreesTwoLabel.getEditor()).getTextField().setBackground(new Color(224, 255, 255));
        ((JSpinner.DefaultEditor) degreesTwoLabel.getEditor()).getTextField().setFont(new Font("Arial", Font.BOLD, 16));
        ((JSpinner.DefaultEditor) degreesTwoLabel.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) degreesTwoLabel.getEditor()).getTextField().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 3;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(degreesTwoLabel, gridConstraint);
        
        // degreesTwoTextField
        degreesTwoTextField.setText("");
        degreesTwoTextField.setColumns(15);
        degreesTwoTextField.setPreferredSize(new Dimension(150, 30));
        degreesTwoTextField.setEditable(false);
        degreesTwoTextField.setAlignmentX(SwingConstants.CENTER);
        degreesTwoTextField.setAlignmentY(SwingConstants.CENTER);
        degreesTwoTextField.setFont(new Font("Arial", Font.BOLD, 16));
        degreesTwoTextField.setOpaque(true);
        degreesTwoTextField.setBackground(new Color(224, 255, 255));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 3;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(degreesTwoTextField, gridConstraint);
        
        // convert
        exit.setText("Exit");
        exit.setOpaque(true);
        exit.setBackground(new Color(251, 160, 122));
        exit.setFont(new Font("Arial", Font.BOLD, 16));
        exit.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 4;
        gridConstraint.ipadx = 30;
        gridConstraint.ipady = 10;
        gridConstraint.insets = new Insets(5, 10, 10, 10);
        my_panel.add(exit, gridConstraint);
        
        //reset
        reset.setText("Reset");
        reset.setOpaque(true);
        reset.setBackground(new Color(251, 160, 122));
        reset.setFont(new Font("Arial", Font.BOLD, 16));
        reset.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 4;
        gridConstraint.ipadx = 30;
        gridConstraint.ipady = 10;
        gridConstraint.insets = new Insets(5, 10, 10, 10);
        my_panel.add(reset, gridConstraint);
        
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        my_panel.setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
        setLocationRelativeTo(null);
        
        
        // Listener start here
        reset.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        resetActionPerformed(e);
                    }
                }
        );
        
        exit.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        exitActionPerformed(e);
                    }
                }
        );
        
        degreesOneLabel.addMouseWheelListener(
                new MouseWheelListener()
                {
                    public void mouseWheelMoved(MouseWheelEvent e)
                    {
                        if (e.getScrollType() != MouseWheelEvent.WHEEL_UNIT_SCROLL)
                        {
                            return;
                        }
                        
                        if (e.getWheelRotation() < 0)
                        {
                            int val = getIndexString(temperature, String.valueOf(degreesOneLabel.getValue()));
                            if (val < temperature.length - 1)
                            {
                                val++;
                                degreesOneLabel.setValue(temperature[val]);
                            }
                        }
                        else
                        {
                            int val = getIndexString(temperature, String.valueOf(degreesOneLabel.getValue()));
                            if (val > 0)
                            {
                                val--;
                                degreesOneLabel.setValue(temperature[val]);
                            }
                        }
                    }
                }
        );
        
        degreesTwoLabel.addMouseWheelListener(
                new MouseWheelListener()
                {
                    public void mouseWheelMoved(MouseWheelEvent e)
                    {
                        if (e.getScrollType() != MouseWheelEvent.WHEEL_UNIT_SCROLL)
                        {
                            return;
                        }
                        
                        if (e.getWheelRotation() < 0)
                        {
                            int val = getIndexString(temperature, String.valueOf(degreesTwoLabel.getValue()));
                            if (val < temperature.length - 1)
                            {
                                val++;
                                degreesTwoLabel.setValue(temperature[val]);
                            }
                        }
                        else
                        {
                            int val = getIndexString(temperature, String.valueOf(degreesTwoLabel.getValue()));
                            if (val > 0)
                            {
                                val--;
                                degreesTwoLabel.setValue(temperature[val]);
                            }
                        }
                    }
                }
        );
        
        temperatureScrollBar.addAdjustmentListener(
                new AdjustmentListener()
                {
                    public void adjustmentValueChanged(AdjustmentEvent e)
                    {
                        temperatureScrollBarAdjusmentValueChanged(e);
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
    
    private void resetActionPerformed(ActionEvent e)
    {
        degreesOneLabel.setValue(temperature[1]);
        degreesTwoLabel.setValue(temperature[0]);
        temperatureScrollBar.setValue(320);
        degreesOneTextField.setText("");
        degreesTwoTextField.setText("");
        temperatureScrollBar.requestFocus();
        colorPanel.setBackground(new Color(72, 209, 204));
    }
    
    private void exitActionPerformed(ActionEvent e)
    {
        Toolkit.getDefaultToolkit().beep();
        int action;
        action = JOptionPane.showConfirmDialog(null, "Are You Sure Want Exit Form ? ", "Warn", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (action == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
        else
        {
            temperatureScrollBar.requestFocus();
        }
    }
    
    private void temperatureScrollBarAdjusmentValueChanged(AdjustmentEvent e)
    {
        double tempF, tempC, tempR, tempK, temp;
        String labelOne = String.valueOf(degreesOneLabel.getValue());
        String labelTwo = String.valueOf(degreesTwoLabel.getValue());

        temp = (double) temperatureScrollBar.getValue() / 10;
        // dibagi sepuluh karena sebelumnya  rentang dibuat dari -600 hingga 1200
       // sehingga dengan di bagi 10 menjadi -60 hingga 120, dengan blok increment sebesar 1 dan unit 0.1
       // dibuat -600 hingga 1200 untuk memudahkan pembagian angkau di belakang koma
        
        // change color 
        if (temp < 10)
        {
            colorPanel.setBackground(new Color(25, 25, 112));
        }
        else if (temp < 20 && temp > -10)
        {
            colorPanel.setBackground(new Color(0, 255, 254));
        }
        else if (temp > 20 && temp < 50)
        {
            colorPanel.setBackground(new Color(251, 160, 122));
        }
        else if (temp > 50 && temp < 80)
        {
            colorPanel.setBackground(new Color(251, 140, 1));
        }
        else if (temp > 80)
        {
            colorPanel.setBackground(new Color(250, 69, 1));
        }
        
        
        if (labelOne.equalsIgnoreCase(temperature[0]))
        {
            tempC = temp;
            degreesOneTextField.setText(new DecimalFormat("0.0").format(tempC));
            if (labelTwo.equalsIgnoreCase(temperature[0]))
            {
                degreesTwoTextField.setText(degreesOneTextField.getText());
            }
            else if (labelTwo.equalsIgnoreCase(temperature[1]))
            {
                tempF = (9.0 / 5.0) * tempC + 32;
                degreesTwoTextField.setText(new DecimalFormat("0.0").format(tempF));
            }
            else if (labelTwo.equalsIgnoreCase(temperature[2]))
            {
                tempK = tempC + 273;
                degreesTwoTextField.setText(new DecimalFormat("0.0").format(tempK));
            }
            else if (labelTwo.equalsIgnoreCase(temperature[3]))
            {
                tempR = (4.0 / 5.0) * tempC;
                degreesTwoTextField.setText(new DecimalFormat("0.0").format(tempR));
            }
        }
        else if(labelOne.equalsIgnoreCase(temperature[1]))
        {
            tempF = temp;
            degreesOneTextField.setText(new DecimalFormat("0.0").format(tempF));
            if (labelTwo.equalsIgnoreCase(temperature[0]))
            {
                tempC = (5.0 / 9.0) * (tempF - 32.0);
                degreesTwoTextField.setText(new DecimalFormat("0.0").format(tempC));
            }
            else if (labelTwo.equalsIgnoreCase(temperature[1]))
            {
                degreesTwoTextField.setText(degreesOneTextField.getText());
            }
            else if (labelTwo.equalsIgnoreCase(temperature[2]))
            {
                tempK = (5.0 / 9.0) * (tempF - 32.0) + 273;
                degreesTwoTextField.setText(new DecimalFormat("0.0").format(tempK));
                
            }
            else if (labelTwo.equalsIgnoreCase(temperature[3]))
            {
                tempR = (4.0 / 9.0) * (tempF - 32.0);
                degreesTwoTextField.setText(new DecimalFormat("0.0").format(tempR));
            }
        }
        else if (labelOne.equalsIgnoreCase(temperature[2]))
        {
            tempK = temp;
            degreesOneTextField.setText(new DecimalFormat("0.0").format(tempK));
            if (labelTwo.equalsIgnoreCase(temperature[0]))
            {
                tempC = tempK - 273;
                degreesTwoTextField.setText(new DecimalFormat("0.0").format(tempC));
            }
            else if (labelTwo.equalsIgnoreCase(temperature[1]))
            {
                tempF = (9.0 / 5.0) * (tempK - 271) + 32;
                degreesTwoTextField.setText(new DecimalFormat("0.0").format(tempF));
            }
            else if (labelTwo.equalsIgnoreCase(temperature[2]))
            {
                degreesTwoTextField.setText(degreesOneTextField.getText());
            }
            else if (labelTwo.equalsIgnoreCase(temperature[3]))
            {
                tempR = (4.0 / 5.0) * (tempK - 273);
                degreesTwoTextField.setText(new DecimalFormat("0.0").format(tempR));
            }
        }
         else if (labelOne.equalsIgnoreCase(temperature[3]))
        {
            tempR = temp;
            degreesOneTextField.setText(new DecimalFormat("0.0").format(tempR));
            if (labelTwo.equalsIgnoreCase(temperature[0]))
            {
                tempC = (5.0 / 4.0) * tempR;
                degreesTwoTextField.setText(new DecimalFormat("0.0").format(tempC));
            }
            else if (labelTwo.equalsIgnoreCase(temperature[1]))
            {
                tempF = (9.0 / 4.0) * tempR + 32;
                degreesTwoTextField.setText(new DecimalFormat("0.0").format(tempF));
            }
            else if (labelTwo.equalsIgnoreCase(temperature[2]))
            {
                tempK = (5.0 / 4.0) * tempR + 273;
                degreesTwoTextField.setText(new DecimalFormat("0.0").format(tempK));
            }
            else if (labelTwo.equalsIgnoreCase(temperature[3]))
            {
                degreesTwoTextField.setText(degreesOneTextField.getText());
            }
        }
    }
    
    private int getIndexString(String[] value, String item)
    {
        int len = value.length;
        int index = 0;
        for (int i = 0; i < len; i++)
        {
            if (value[i].equalsIgnoreCase(item))
            {
                break;
            }
            else
            {
                index++;
            }
        }
        
        return index;
    }
    
}


// Untuk Button, JCheckButton, JRadioButton
 /*
    Menggunakan listener dengan jenis action listener, dengan format
    addActionListener(new ActionListener() -> //eksekusi);
    khusus JCheck dan JRadio, dapat dikelompokkan terlebih dahulu dengan ButtonGroup my_button = new ButtonGroup()
    agar tidak dapat memilih pilihan lebih dari dua.
*/

// untuk JSPinner 
/*
    Menggunakan listener dengan jeis changeListener dengan format
    addChangeListener(
        new ChangeListener()
        {
            public void stateChanged(ChangeEvent)
            {
                // eksekusi
            {
        {
    );
    
*/

// untuk JScrollBar
/*
    Mengggunakan listener dengan jenis adjustmentListener dengan format :
    addAdjustmentListener(
        new AdjustmentListener()
        {
            public void adjustmentValueChanged(AdjustmentEvent e)
            {
                // eksekusi
            }
        }
    );
*/

