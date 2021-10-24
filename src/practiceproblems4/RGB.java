package practiceproblems4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RGB extends JFrame {
    
    private JLabel colorTest = new JLabel();
    private JLabel redValue = new JLabel();
    private JLabel greenValue = new JLabel();
    private JLabel blueValue = new JLabel();
    private JScrollBar red = new JScrollBar();
    private JScrollBar green = new JScrollBar();
    private JScrollBar blue = new JScrollBar();
    
    private int r = 0;
    private int g = 0;
    private int b = 0;

    public static void main(String[] args) {
        RGB my_rgb = new RGB("RGB Test");
        my_rgb.setVisible(true);
        
        my_rgb.show();
    }
    
    public RGB(String title)
    {
        super (title);
        JPanel my_panel = (JPanel) this.getContentPane();
        my_panel.setBackground(new Color(135, 206, 250));
        
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        
        // atribute start here
        // colorTest
        colorTest.setOpaque(true);
        colorTest.setPreferredSize(new Dimension(400, 150));
        colorTest.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        colorTest.setBackground(Color.WHITE);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.gridwidth = 3;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(colorTest, gridConstraint);
        
        //redValue
        gridConstraint = new GridBagConstraints();
        redValue.setOpaque(true);
        redValue.setFont(new Font("Arial", Font.BOLD, 18));
        redValue.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        redValue.setBackground(new Color(220, 20, 60));
        redValue.setPreferredSize(new Dimension(150, 30));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(redValue, gridConstraint);
        
        // greenValue
        gridConstraint = new GridBagConstraints();
        greenValue.setOpaque(true);
        greenValue.setFont(new Font("Arial", Font.BOLD, 18));
        greenValue.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        greenValue.setBackground(new Color(124, 252, 2));
        greenValue.setPreferredSize(new Dimension(150, 30));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(greenValue, gridConstraint);
        
        // blueValue
        gridConstraint = new GridBagConstraints();
        blueValue.setOpaque(true);
        blueValue.setFont(new Font("Arial", Font.BOLD, 18));
        blueValue.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        blueValue.setBackground(new Color(65, 105, 225));
        blueValue.setPreferredSize(new Dimension(150, 30));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(blueValue, gridConstraint);
        
        // red
        red.setPreferredSize(new Dimension(150, 30));
        red.setMinimum(0);
        red.setMaximum(265);
        red.setBlockIncrement(5);
        red.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        red.setOpaque(true);
        red.setBackground(new Color(220, 20, 60));
        red.setUnitIncrement(1);
        red.setValue(0);
        red.setOrientation(JScrollBar.HORIZONTAL);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(red, gridConstraint);
        
        // green
        green.setPreferredSize(new Dimension(150, 30));
        green.setMinimum(0);
        green.setMaximum(265);
        green.setBlockIncrement(5);
        green.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        green.setOpaque(true);
        green.setBackground(new Color(124, 252, 2));
        green.setUnitIncrement(1);
        green.setValue(0);
        green.setOrientation(JScrollBar.HORIZONTAL);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 2;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(green, gridConstraint);
        
        // blue
        blue.setPreferredSize(new Dimension(150, 30));
        blue.setMinimum(0);
        blue.setMaximum(265);
        blue.setBlockIncrement(5);
        blue.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        blue.setOpaque(true);
        blue.setBackground(new Color(65, 105, 225));
        blue.setUnitIncrement(1);
        blue.setValue(0);
        blue.setOrientation(JScrollBar.HORIZONTAL);
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 2;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(blue, gridConstraint);
        
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        my_panel.setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
        setLocationRelativeTo(null);
        
        // listener start here
        
        red.addAdjustmentListener(
                new AdjustmentListener()
                {
                    public void adjustmentValueChanged(AdjustmentEvent e)
                    {
                        redAdjustmentValueChanged(e);
                    }
                }
        );
        
        green.addAdjustmentListener(
                new AdjustmentListener()
                {
                    public void adjustmentValueChanged(AdjustmentEvent e)
                    {
                        greenAdjustmentValueChanged(e);
                    }
                }
        );
        
        blue.addAdjustmentListener(
                new AdjustmentListener()
                {
                    public void adjustmentValueChanged(AdjustmentEvent e)
                    {
                        blueAdjustmentValueChanged(e);
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
    
    private void redAdjustmentValueChanged(AdjustmentEvent e)
    {
        r = Integer.valueOf(red.getValue()).intValue();
        redValue.setText(String.valueOf(r));
        colorTest.setBackground(new Color(r, g, b));
    }
    
    private void greenAdjustmentValueChanged(AdjustmentEvent e)
    {
        g = Integer.valueOf(green.getValue()).intValue();
        greenValue.setText(String.valueOf(g));
        colorTest.setBackground(new Color(r, g, b));
    }
    
    private void blueAdjustmentValueChanged(AdjustmentEvent e)
    {
        b = Integer.valueOf(blue.getValue()).intValue();
        blueValue.setText(String.valueOf(b));
        colorTest.setBackground(new Color(r, g, b));
    }
}
