package pizza;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Pizza extends JFrame {
    
    // put all this thing in main panel
    private JPanel sizePanel = new JPanel();
    private JPanel crustPanel = new JPanel();
    private JPanel toppingsPanel = new JPanel();
    private JRadioButton eatInRadioButton = new JRadioButton();
    private JRadioButton takeOutRadioButton = new JRadioButton();
    private JButton buildButton = new JButton();
    private JButton exitButton = new JButton();
    private JButton resetButton = new JButton();
    
    // put this thing in sizePanel
    private JRadioButton smallRadioButton = new JRadioButton();
    private JRadioButton mediumRadioButton = new JRadioButton();
    private JRadioButton largeRadioButton = new JRadioButton();
    
    // put this things in crustPanel
    private JRadioButton thinRadioButton = new JRadioButton();
    private JRadioButton thickRadioButton = new JRadioButton();
    
    // put this things in toppingsPanel
    private JCheckBox cheeseCheckBox = new JCheckBox();
    private JCheckBox mushroomsCheckBox = new JCheckBox();
    private JCheckBox olivesCheckBox = new JCheckBox();
    private JCheckBox onionsCheckBox = new JCheckBox();
    private JCheckBox peppersCheckBox = new JCheckBox();
    private JCheckBox tomatoesCheckBox = new JCheckBox();
    
    // button group
    private ButtonGroup sizeButtonGroup = new ButtonGroup();
    private ButtonGroup crustButtonGroup = new ButtonGroup();
    private ButtonGroup whereButtonGroup = new ButtonGroup();
    
    // variable for running application
    private String pizzaSize;
    private String pizzaCrust;
    private String pizzaWhere;
    private JCheckBox[] topping = new JCheckBox[6];
    
    public static void main(String[] args) {
        Pizza my_pizza = new Pizza("Ivan Pizza");
        my_pizza.setSize(530, 350);
        my_pizza.setVisible(true);
        
        my_pizza.show();
    }
    
    public Pizza(String title)
    {
        super(title);
        JPanel my_panel = (JPanel) this.getContentPane();
        my_panel.setBackground(new Color(173, 216, 230));
        
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        
        // SizePanel
        // NODE
        sizePanel.setLayout(new GridBagLayout());
        sizePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), "Sizes"));
        sizePanel.setFont(new Font("Arial", Font.BOLD, 16));
        sizePanel.setOpaque(true);
        sizePanel.setBackground(new Color(255, 250, 205));
        gridConstraint.insets = new Insets(5, 5, 5, 5);
        // smallRadioButton
        smallRadioButton.setText("Small");
        smallRadioButton.setSelected(true);
        smallRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        smallRadioButton.setOpaque(true);
        smallRadioButton.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.anchor = GridBagConstraints.WEST;
        sizeButtonGroup.add(smallRadioButton);
        sizePanel.add(smallRadioButton, gridConstraint);
        //mediumRadioButton
        mediumRadioButton.setText("Medium");
        mediumRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        mediumRadioButton.setOpaque(true);
        mediumRadioButton.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.anchor = GridBagConstraints.WEST;
        sizeButtonGroup.add(mediumRadioButton);
        sizePanel.add(mediumRadioButton, gridConstraint);
        //largeRadioButton
        largeRadioButton.setText("Large");
        largeRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        largeRadioButton.setOpaque(true);
        largeRadioButton.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        gridConstraint.anchor = GridBagConstraints.WEST;
        sizeButtonGroup.add(largeRadioButton);
        sizePanel.add(largeRadioButton, gridConstraint);
        // adding things to main panel
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        my_panel.add(sizePanel, gridConstraint);
        
        
        // Crust Panel
        // NODE
        crustPanel.setLayout(new GridBagLayout());
        crustPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), "Crust Type"));
        crustPanel.setFont(new Font("Arial", Font.BOLD, 16));
        crustPanel.setOpaque(true);
        crustPanel.setBackground(new Color(255, 250, 205));
        gridConstraint.insets = new Insets(5, 5, 5, 5);
        //thinRadioButton
        thinRadioButton.setText("Thin Crust");
        thinRadioButton.setSelected(true);
        thinRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        thinRadioButton.setOpaque(true);
        thinRadioButton.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.anchor = GridBagConstraints.WEST;
        crustButtonGroup.add(thinRadioButton);
        crustPanel.add(thinRadioButton, gridConstraint);
        //thickRadioButton
        thickRadioButton.setText("Thick Crust");
        thickRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        thickRadioButton.setOpaque(true);
        thickRadioButton.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        crustButtonGroup.add(thickRadioButton);
        crustPanel.add(thickRadioButton, gridConstraint);
        //adding things to main panel
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        my_panel.add(crustPanel, gridConstraint);
        
        
        //ToppingsPanel
        // NODE
        toppingsPanel.setLayout(new GridBagLayout());
        toppingsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), "Toppings"));
        toppingsPanel.setFont(new Font("Arial", Font.BOLD, 16));
        toppingsPanel.setOpaque(true);
        toppingsPanel.setBackground(new Color(255, 250, 205));
        gridConstraint.insets = new Insets(5, 5, 5, 5);
        // cheeseCheckBox
        cheeseCheckBox.setText("Extra Cheese");
        cheeseCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        cheeseCheckBox.setOpaque(true);
        cheeseCheckBox.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.anchor = GridBagConstraints.WEST;
        toppingsPanel.add(cheeseCheckBox, gridConstraint);
        //mushroomsCheckBox
        mushroomsCheckBox.setText("Mushrooms");
        mushroomsCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        mushroomsCheckBox.setOpaque(true);
        mushroomsCheckBox.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.anchor = GridBagConstraints.WEST;
        toppingsPanel.add(mushroomsCheckBox, gridConstraint);
        //olivesCheckBox
        olivesCheckBox.setText("Black Olives");
        olivesCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        olivesCheckBox.setOpaque(true);
        olivesCheckBox.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        gridConstraint.anchor = GridBagConstraints.WEST;
        toppingsPanel.add(olivesCheckBox, gridConstraint);
        //onionsCheckBox
        onionsCheckBox.setText("Onions");
        onionsCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        onionsCheckBox.setOpaque(true);
        onionsCheckBox.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 0;
        gridConstraint.anchor = GridBagConstraints.WEST;
        toppingsPanel.add(onionsCheckBox, gridConstraint);
        //peppersCheckBox
        peppersCheckBox.setText("Green Peppers");
        peppersCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        peppersCheckBox.setOpaque(true);
        peppersCheckBox.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 1;
        gridConstraint.anchor = GridBagConstraints.WEST;
        toppingsPanel.add(peppersCheckBox, gridConstraint);
        // tomatoesCheckBox
        tomatoesCheckBox.setText("Tomatoes");
        tomatoesCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        tomatoesCheckBox.setOpaque(true);
        tomatoesCheckBox.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 2;
        gridConstraint.anchor = GridBagConstraints.WEST;
        toppingsPanel.add(tomatoesCheckBox, gridConstraint);
        // adding things to main panel
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 0;
        gridConstraint.gridwidth = 2;
        gridConstraint.insets = new Insets(5, 25, 5, 5);
        my_panel.add(toppingsPanel, gridConstraint);
        gridConstraint.gridwidth = 1;
        
        
        gridConstraint.insets = new Insets(5, 5, 5, 5);
        // eatInRadioButton
        eatInRadioButton.setText("Eat In");
        eatInRadioButton.setSelected(true);
        eatInRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        eatInRadioButton.setOpaque(true);
        eatInRadioButton.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 1;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        whereButtonGroup.add(eatInRadioButton);
        my_panel.add(eatInRadioButton, gridConstraint);
        
        
        // takeOutRadioButton
        takeOutRadioButton.setText("Take Out");
        takeOutRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        takeOutRadioButton.setOpaque(true);
        takeOutRadioButton.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 1;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        whereButtonGroup.add(takeOutRadioButton);
        my_panel.add(takeOutRadioButton, gridConstraint);
        
        
        //buildButton
        buildButton.setText("Build Pizza");
        buildButton.setFont(new Font("Arial", Font.BOLD, 16));
        buildButton.setOpaque(true);
        buildButton.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 2;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(buildButton, gridConstraint);
        
        
        // exitButton
        exitButton.setText("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.setOpaque(true);
        exitButton.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 2;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(exitButton, gridConstraint);
        
        //resetButton
        resetButton.setText("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 16));
        resetButton.setOpaque(true);
        resetButton.setBackground(new Color(230, 230, 250));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(resetButton, gridConstraint);
        
        
        pack();
        setLocationRelativeTo(null);
        
        
        // ADDING ACTION LISTENER FOR EACH ITEM IN FRAME
        // NODE
        
        // sizeRadioButton Group
        smallRadioButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        sizeRadioButtonActionPerformed(e);
                    }
                }
        );
        
        mediumRadioButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        sizeRadioButtonActionPerformed(e);
                    }
                }
        );
        
        largeRadioButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        sizeRadioButtonActionPerformed(e);
                    }
                }
        );
        
        
        // Crust Panel Items Action Listener
        thinRadioButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        crustRadioButtonActionPerformed(e);
                    }
                }
        );
        
        thickRadioButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        crustRadioButtonActionPerformed(e);
                    }
                }
        );
        
        
        // Toppings Panel Action Listener
        
        
        
        // Main Frame Action Listener
        eatInRadioButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        whereRadioButtonActionPerformed(e);
                    }
                }
        );
        
        takeOutRadioButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        whereRadioButtonActionPerformed(e);
                    }
                }
        );
        
        buildButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        buildButtonActionPerformed(e);
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
        
        
        addWindowListener(
                new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        exitForm(e);
                    }
                }
        );
        
        
        // initializing variable as default choice
        pizzaSize = smallRadioButton.getText();
        pizzaCrust = thinRadioButton.getText(); 
        pizzaWhere = eatInRadioButton.getText();
        topping[0] = cheeseCheckBox;
        topping[1] = mushroomsCheckBox;
        topping[2] = olivesCheckBox;
        topping[3] = onionsCheckBox;
        topping[4] = peppersCheckBox;
        topping[5] = tomatoesCheckBox;
    }
    
    public void exitForm(WindowEvent e)
    {
        System.exit(0);
    }
    
    private void sizeRadioButtonActionPerformed(ActionEvent e)
    {
        pizzaSize = e.getActionCommand();
    }
    
    private void crustRadioButtonActionPerformed(ActionEvent e)
    {
        pizzaCrust = e.getActionCommand();
    }
    
    private void whereRadioButtonActionPerformed(ActionEvent e)
    {
        pizzaWhere = e.getActionCommand();
    }
    
    private void resetButtonActionPerformed(ActionEvent e)
    {
        // size panel
        smallRadioButton.setSelected(true);
        mediumRadioButton.setSelected(false);
        largeRadioButton.setSelected(false);
        
        // crust panel
        thinRadioButton.setSelected(true);
        thickRadioButton.setSelected(false);
        
        // topping panel
        cheeseCheckBox.setSelected(false);
        mushroomsCheckBox.setSelected(false);
        olivesCheckBox.setSelected(false);
        onionsCheckBox.setSelected(false);
        peppersCheckBox.setSelected(false);
        tomatoesCheckBox.setSelected(false);
        
        // where button
        eatInRadioButton.setSelected(true);
        takeOutRadioButton.setSelected(false);
    }
    
    private void buildButtonActionPerformed(ActionEvent e)
    {
        String message;
        int value = 0;
        String toppings = "";
        message = "In or Out : " + pizzaWhere + "\n";
        message = message + "Big or Small : "+ pizzaSize + " Pizza" + "\n";
        message = message + "Crust Type : " + pizzaCrust + "\n" + "Toppings : \n";
        for (int i = 0; i < 6; i++)
        {
            if (topping[i].isSelected())
            {
                toppings = toppings + "@ " + topping[i].getText() + "\n";
                value++;
            }
        }
        
        if (value == 0)
        {
            message = message + "@ Cheese Only\n";
        }
        else
        {
            message = message + toppings;
        }
        
        JOptionPane.showConfirmDialog(null, message, "Your Pizza", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void exitButtonActionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
    
}
