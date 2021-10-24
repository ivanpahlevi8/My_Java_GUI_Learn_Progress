package dateinput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DateInput extends JFrame {
    
    private JSpinner monthSpinner = new JSpinner();
    private JSpinner daySpinner = new JSpinner();
    private JLabel dateLabel = new JLabel();
    private JButton exitButton = new JButton();
    private int value = 0;
    
    private String[] month = {
        "January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "Desember"
    };
    

    public static void main(String[] args) {
        DateInput my_date = new DateInput("Date Input");
        my_date.setVisible(true);
        
        my_date.show();
    }
    
    public DateInput(String title)
    {
        super (title);
        JPanel my_panel = (JPanel) this.getContentPane();
        
        my_panel.setBackground(new Color(64, 224, 208));
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        
        // the atribute start here
        // Month Spinner
        monthSpinner.setModel(new SpinnerListModel(month));
        monthSpinner.setPreferredSize(new Dimension(150, 30));
        ((JSpinner.DefaultEditor) monthSpinner.getEditor()).getTextField().setFont(new Font("Arial", Font.BOLD, 16));
        ((JSpinner.DefaultEditor) monthSpinner.getEditor()).getTextField().setOpaque(true);
        ((JSpinner.DefaultEditor) monthSpinner.getEditor()).getTextField().setBackground(new Color(173, 216, 230));
        ((JSpinner.DefaultEditor) monthSpinner.getEditor()) .getTextField().setForeground(new Color(47, 79, 79));
        ((JSpinner.DefaultEditor) monthSpinner.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) monthSpinner.getEditor()).getTextField().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(monthSpinner, gridConstraint);
        
        //Day Spinne
        daySpinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
        daySpinner.setPreferredSize(new Dimension(100, 30));
        ((JSpinner.DefaultEditor) daySpinner.getEditor()).getTextField().setFont(new Font("Arial", Font.BOLD, 16));
        ((JSpinner.DefaultEditor) daySpinner.getEditor()).getTextField().setBackground(new Color(173, 216, 230));
        ((JSpinner.DefaultEditor) daySpinner.getEditor()) .getTextField().setForeground(new Color(47, 79, 79));
        ((JSpinner.DefaultEditor) daySpinner.getEditor()).getTextField().setEditable(false);  
        ((JSpinner.DefaultEditor) daySpinner.getEditor()).getTextField().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        ((JSpinner.DefaultEditor) daySpinner.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 0;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(daySpinner, gridConstraint);
        
        // dateLabel
        dateLabel.setText("January 1");
        dateLabel.setFont(new Font("Arial", Font.BOLD, 25));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setBackground(new Color(224, 255, 255));
        dateLabel.setOpaque(true);
        dateLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.ipadx = 40;
        gridConstraint.ipady = 10;
        gridConstraint.gridwidth = 2;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(dateLabel, gridConstraint);
        
        // exitButton
        exitButton.setText("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.setOpaque(true);
        exitButton.setBackground(new Color(251, 160, 122));
        exitButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        exitButton.setMargin(new Insets(5, 5, 5, 5));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 2;
        gridConstraint.gridwidth = 1;
        gridConstraint.ipadx = 30;
        gridConstraint.ipady = 8;
        gridConstraint.insets = new Insets(5, 10, 10, 10);
        my_panel.add(exitButton, gridConstraint);
        
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        my_panel.setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
        setLocationRelativeTo(null);
        
        // the listener start here
        addWindowListener(
                new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        exitForm(e);
                    }
                }
        );
        
        monthSpinner.addChangeListener(
                new ChangeListener()
                {
                    public void stateChanged(ChangeEvent e)
                    {
                        dateStateChanged(e);
                        monthSpinnerStateChange(e);
                    }
                }
        );
        
        daySpinner.addChangeListener(
                new ChangeListener()
                {
                    public void stateChanged(ChangeEvent e)
                    {
                        dateStateChanged(e);
                    }
                }
        );
        
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
        
        monthSpinner.addMouseWheelListener(
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
                            value++;
                            monthSpinner.setValue(month[value]);
                        }
                        else
                        {
                            if (value > 0)
                            {
                                value--;
                                monthSpinner.setValue(month[value]);
                            }
                        }
                    }
                }
        );
        
        daySpinner.addMouseWheelListener(
                    new MouseWheelListener()
                    {
                        public void mouseWheelMoved(MouseWheelEvent e)
                        {
                           if (e.getScrollType() != MouseWheelEvent.WHEEL_UNIT_SCROLL) {
                                return;
                                }
                            int value = (Integer) Integer.valueOf(daySpinner.getValue().toString()).intValue();
                            if (e.getWheelRotation() < 0)
                            {
                                int present = Integer.valueOf(daySpinner.getValue().toString()).intValue();
                                present = present + 1;
                                daySpinner.setValue(present);
                            }
                            else
                            {
                                int present = Integer.valueOf(daySpinner.getValue().toString()).intValue();
                                if (present > 1)
                                {
                                    present = present - 1;
                                daySpinner.setValue(present); 
                                }
                            }
                        }
                    }
            );
       }
    
    public void exitForm(WindowEvent e)
    {
        System.exit(0);
    }
    
    private void monthSpinnerStateChange(ChangeEvent e)
    {
        
    }
    
    private void daySpinnerStateChange(ChangeEvent e)
    {
        
    }
    
    private void exitButtonActionPerformed(ActionEvent e)
    {
        String time = dateLabel.getText();
        Toolkit.getDefaultToolkit().beep();
        int action = JOptionPane.showConfirmDialog(null, "Your Set Time : " + time, "WARN", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (action == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
        else
        {
            ((JSpinner.DefaultEditor) monthSpinner.getEditor()).getTextField().requestFocus();
            monthSpinner.setValue("January");
            daySpinner.setValue(1);
            value = 0;
        }
    }
    
    private void dateStateChanged(ChangeEvent e)
    {
        dateLabel.setText(monthSpinner.getValue() + " " + daySpinner.getValue());
    }
    
}
