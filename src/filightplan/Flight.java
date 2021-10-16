package filightplan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Flight extends JFrame {
    
    // For Layer One Atribute
    private JLabel citiesDirectLabel = new JLabel();
    private JLabel citiesFromLabel = new JLabel();
    private JLabel seatLabel = new JLabel();
    private JLabel mealLabel = new JLabel();
    private JLabel numSeatLabel = new JLabel();
    private JLabel flightNumberLabel = new JLabel();
    private JList citiesDirectList = new JList();
    private JList citiesFromList = new JList();
    private JComboBox seatComboBox = new JComboBox();
    private JComboBox mealComboBox = new JComboBox();
    private JScrollPane citiesDirectScrollPane = new JScrollPane();
    private JScrollPane citiesFromScrollPane = new JScrollPane();
    private JButton assignButton = new JButton();
    private JButton exitButton = new JButton();
    private JRadioButton seatNum;
    
    private List<JRadioButton> seatButton = new ArrayList<JRadioButton>();
    private String numSeat;
    
    private List<JRadioButton> flightNumber = new ArrayList<>();
    private String flight;
    
    private JScrollPane frameScrollPane = new JScrollPane();
    private JPanel seatPanel = new JPanel();
    
    private JScrollPane flightNumberScrollPane = new JScrollPane();
    private JPanel flightNumberPanel = new JPanel();
    
    private ButtonGroup seatButtonGroup = new ButtonGroup();
    private ButtonGroup flightNumberButtonGroup = new ButtonGroup();
    
    private JRadioButton economicRadioButton = new JRadioButton();
    private JRadioButton businessRadioButton = new JRadioButton();
    
    private String seatClass;
    
    // Layer Two Atribute
    
    private JLabel ivanAirlines = new JLabel();
    private JLabel classSeat = new JLabel();
    private JLabel classSeatValue = new JLabel();
    private JLabel destinationCity = new JLabel();
    private JLabel destinationCityValue = new JLabel();
    private JLabel departureCity = new JLabel();
    private JLabel departureCityValue = new JLabel();
    private JLabel seatNumber = new JLabel();
    private JLabel seatNumberValue = new JLabel();
    private JLabel meal = new JLabel();
    private JLabel mealValue = new JLabel();
    

    public static void main(String[] args) {
        Flight my_flight = new Flight("Ivan Airlines"); 
        my_flight.setSize(850, 450);
        my_flight.setVisible(true);
        
        my_flight.show();
    }
    
    public Flight(String title)
    {
        super (title);
        JPanel my_panel = (JPanel) this.getContentPane();
        my_panel.setBackground(new Color(173, 216, 230));
        
        //setResizable(false);
        
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        
        // List City
        // NODE LIST CITY
        
        // Labels Direct Cities
        citiesDirectLabel.setText("Destination City");
        citiesDirectLabel.setFont(new Font("Arial", Font.BOLD, 16));
        citiesDirectLabel.setOpaque(true);
        citiesDirectLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        citiesDirectLabel.setBackground(new Color(250, 250, 210));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.insets = new Insets(10, 0, 0, 0);
        my_panel.add(citiesDirectLabel, gridConstraint);
        
        // Labels From Cities
        citiesFromLabel.setText("Departure City");
        citiesFromLabel.setFont(new Font("Arial", Font.BOLD, 16));
        citiesFromLabel.setOpaque(true);
        citiesFromLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        citiesFromLabel.setBackground(new Color(250, 250, 210));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 0;
        gridConstraint.insets = new Insets(10, 20, 0, 0);
        my_panel.add(citiesFromLabel, gridConstraint);
        
        // direct scoll pane
        citiesDirectScrollPane.setPreferredSize(new Dimension(150, 100));
        citiesDirectScrollPane.setViewportView(citiesDirectList);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 10, 10, 20);
        my_panel.add(citiesDirectScrollPane, gridConstraint);
        
        // from scroll pane
        citiesFromScrollPane.setPreferredSize(new Dimension(150, 100));
        citiesFromScrollPane.setViewportView(citiesFromList);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 20, 10, 10);
        my_panel.add(citiesFromScrollPane, gridConstraint);
        
        // citiesDirectList
        DefaultListModel citiesListModel = new DefaultListModel();
        citiesListModel.addElement("Padang");
        citiesListModel.addElement("Jakarta");
        citiesListModel.addElement("Surabaya");
        citiesListModel.addElement("Makassar");
        citiesListModel.addElement("Bandung");
        citiesListModel.addElement("Semarang");
        citiesListModel.addElement("Bali");
        citiesListModel.addElement("Palembang");
        citiesListModel.addElement("Samarinda");
        citiesListModel.addElement("Lampung");
        citiesListModel.addElement("Bengkulu");
        citiesListModel.addElement("Pekan Baru");
        citiesListModel.addElement("Aceh");
        citiesListModel.addElement("Medan");
        citiesListModel.addElement("Batam");
        citiesDirectList.setModel(citiesListModel);
        citiesDirectList.setSelectedIndex(0);
        citiesDirectList.setOpaque(true);
        citiesDirectList.setBackground(new Color(224, 255, 255));
        citiesDirectList.setFont(new Font("Arial", Font.BOLD, 14));
        citiesDirectList.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        
        //citiesFromList
        DefaultListModel citiesFromListModel = new DefaultListModel();
        citiesFromListModel.addElement("Padang");
        citiesFromListModel.addElement("Jakarta");
        citiesFromListModel.addElement("Surabaya");
        citiesFromListModel.addElement("Makassar");
        citiesFromListModel.addElement("Bandung");
        citiesFromListModel.addElement("Semarang");
        citiesFromListModel.addElement("Bali");
        citiesFromListModel.addElement("Palembang");
        citiesFromListModel.addElement("Samarinda");
        citiesFromListModel.addElement("Lampung");
        citiesFromListModel.addElement("Bengkulu");
        citiesFromListModel.addElement("Pekan Baru");
        citiesFromListModel.addElement("Aceh");
        citiesFromListModel.addElement("Medan");
        citiesFromListModel.addElement("Batam");
        citiesFromList.setModel(citiesFromListModel);
        citiesFromList.setSelectedIndex(1);
        citiesFromList.setOpaque(true);
        citiesFromList.setBackground(new Color(224, 255, 255));
        citiesFromList.setFont(new Font("Arial", Font.BOLD, 14));
        citiesFromList.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));

        // NODE LIST CITY
        
        //Seat Location
        // NODE SEAT
        
        // seatLabel
        seatLabel.setText("Seat Location");
        seatLabel.setFont(new Font("Arial", Font.BOLD, 16));
        seatLabel.setOpaque(true);
        seatLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        seatLabel.setBackground(new Color(250, 250, 210));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 0;
        gridConstraint.insets = new Insets(10, 20, 0, 0);
        my_panel.add(seatLabel, gridConstraint);
        
        //seatComboBox
        seatComboBox.setOpaque(true);
        seatComboBox.setBackground(new Color(224, 255, 255));
        seatComboBox.setFont(new Font("Arial", Font.BOLD, 14));
        seatComboBox.addItem("Aisle");
        seatComboBox.addItem("Middle");
        seatComboBox.addItem("Window");
        seatComboBox.setSelectedIndex(1);
        seatComboBox.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 20, 10, 10);
        gridConstraint.anchor = GridBagConstraints.NORTH;
        my_panel.add(seatComboBox, gridConstraint);
        
        // seatNumLabel
        numSeatLabel.setText("Seat Number");
        numSeatLabel.setFont(new Font("Arial", Font.BOLD, 16));
        numSeatLabel.setOpaque(true);
        numSeatLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        numSeatLabel.setBackground(new Color(250, 250, 210));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        gridConstraint.insets = new Insets(10, 10, 0, 10);
        my_panel.add(numSeatLabel, gridConstraint);
        
        //seatPanel
        seatPanel.setSize(400, 400);
        seatPanel.setLayout(new GridBagLayout());
        seatPanel.setOpaque(true);
        seatPanel.setBackground(new Color(224, 255, 255));
        seatPanel.setFont(new Font("Arial", Font.BOLD, 14));
        seatPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        GridBagConstraints cons = new GridBagConstraints();
        String num;
        for (int i =0; i < 10; i++)
        {
            num = "A " + String.valueOf(i + 1);
            seatNum = new JRadioButton(num);
            cons.gridx = 0;
            cons.gridy = i;
            seatPanel.add(seatNum, cons);
            seatButtonGroup.add(seatNum);
            seatButton.add(seatNum);
            seatNum.addActionListener(
                    new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            seatRadioButtonActionPerformed(e);
                        }
                    }
            );
        }
        for (int i =0; i < 10; i++)
        {
            num = "B " + String.valueOf(i + 1);
            seatNum = new JRadioButton(num);
            cons.gridx = 1;
            cons.gridy = i;
            seatPanel.add(seatNum, cons);
            seatButtonGroup.add(seatNum);
            seatButton.add(seatNum);
            seatNum.addActionListener(
                    new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            seatRadioButtonActionPerformed(e);
                        }
                    }
            );
        }
        for (int i =0; i < 10; i++)
        {
            num = "C " + String.valueOf(i + 1);
            seatNum = new JRadioButton(num);
            cons.gridx = 2;
            cons.gridy = i;
            seatPanel.add(seatNum, cons);
            seatButtonGroup.add(seatNum);
            seatButton.add(seatNum);
            seatNum.addActionListener(
                    new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            seatRadioButtonActionPerformed(e);
                        }
                    }
            );
        }
        for (int i =0; i < 10; i++)
        {
            num = "D " + String.valueOf(i + 1);
            seatNum = new JRadioButton(num);
            cons.gridx = 4;
            cons.gridy = i;
            cons.insets = new Insets(0, 50, 0, 0);
            seatPanel.add(seatNum, cons);
            seatButtonGroup.add(seatNum);
            seatButton.add(seatNum);
            seatNum.addActionListener(
                    new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            seatRadioButtonActionPerformed(e);
                        }
                    }
            );
        }
        cons.insets = new Insets(0, 0, 0, 0);
        for (int i =0; i < 10; i++)
        {
            num = "E " + String.valueOf(i + 1);
            seatNum = new JRadioButton(num);
            cons.gridx = 5;
            cons.gridy = i;
            seatPanel.add(seatNum, cons);
            seatButtonGroup.add(seatNum);
            seatButton.add(seatNum);
            seatNum.addActionListener(
                    new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            seatRadioButtonActionPerformed(e);
                        }
                    }
            );
        }
        for (int i =0; i < 10; i++)
        {
            num = "F " + String.valueOf(i + 1);
            seatNum = new JRadioButton(num);
            cons.gridx = 6;
            cons.gridy = i;
            seatPanel.add(seatNum, cons);
            seatButtonGroup.add(seatNum);
            seatButton.add(seatNum);
            seatNum.addActionListener(
                    new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            seatRadioButtonActionPerformed(e);
                        }
                    }
            );
        }
        frameScrollPane.setPreferredSize(new Dimension(180, 130));
        frameScrollPane.setViewportView(seatPanel);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 3;
        gridConstraint.insets = new Insets(10, 10, 10, 20);
        seatButton.get(0).setSelected(true);
        my_panel.add(frameScrollPane, gridConstraint);
        
        
        // NODE SEAT
        
        // Meal Preferance
        // NODE MEAL
        
        // mealLabel
        mealLabel.setText("Meal Preferance");
        mealLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mealLabel.setOpaque(true);
        mealLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        mealLabel.setBackground(new Color(250, 250, 210));
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 0;
        gridConstraint.insets = new Insets(10, 20, 0, 0);
        my_panel.add(mealLabel, gridConstraint);
        
        // mealComboBox
        mealComboBox.setOpaque(true);
        mealComboBox.setBackground(new Color(224, 255, 255));
        mealComboBox.setFont(new Font("Arial", Font.BOLD, 14));
        mealComboBox.addItem("Chicken");
        mealComboBox.addItem("Mystery Meat");
        mealComboBox.addItem("Kosher");
        mealComboBox.addItem("Vegetarian");
        mealComboBox.addItem("Fruit Plate");
        mealComboBox.addItem("No Preference");
        mealComboBox.setSelectedIndex(5);
        mealComboBox.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 20, 10, 10);
        gridConstraint.anchor = GridBagConstraints.NORTH;
        my_panel.add(mealComboBox, gridConstraint);
        
        // NODE MEAL
        
        // Flight Number
        // NODE FLIGHT NUMBER
        
        // flightNumberLabel
        flightNumberLabel.setText("Flight Number");
        flightNumberLabel.setFont(new Font("Arial", Font.BOLD, 16));
        flightNumberLabel.setOpaque(true);
        flightNumberLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        flightNumberLabel.setBackground(new Color(250, 250, 210));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 2;
        gridConstraint.insets = new Insets(10, 30, 0, 10);
        my_panel.add(flightNumberLabel, gridConstraint);
        
        //flightNumberPanel
        flightNumberPanel.setSize(400, 400);
        flightNumberPanel.setLayout(new GridBagLayout());
        flightNumberPanel.setOpaque(true);
        flightNumberPanel.setBackground(new Color(224, 255, 255));
        flightNumberPanel.setFont(new Font("Arial", Font.BOLD, 14));
        flightNumberPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        cons = new GridBagConstraints();
        for (int a = 0; a < 20; a++)
        {
            String flight = "IA 7";
            JRadioButton rad = new JRadioButton();
            if (a < 10)
            {
                flight = flight + String.valueOf(0) + String.valueOf(a);
            }
            else
            {
                flight = flight + String.valueOf(a);
            }
            rad.setText(flight);
            cons.gridx = 1;
            cons.gridy = a;
            cons.insets = new Insets(10, 10, 10, 10);
            flightNumberPanel.add(rad, cons);
            flightNumberButtonGroup.add(rad);
            rad.addActionListener(
                    new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        flightNumberRadioButtonActionPerformed(e);
                    }
                }
            );
            flightNumber.add(rad);
        }
        flightNumberScrollPane.setPreferredSize(new Dimension(180, 130));
        flightNumberScrollPane.setViewportView(flightNumberPanel);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 3;
        gridConstraint.insets = new Insets(10, 30, 10, 20);
        flightNumber.get(0).setSelected(true);
        my_panel.add(flightNumberScrollPane, gridConstraint);
        
        // NUOE FLIGHT NUMBER
        
        // assignButton
        assignButton.setText("Assign");
        assignButton.setFont(new Font("Arial", Font.BOLD, 14));
        assignButton.setOpaque(true);
        assignButton.setBackground(new Color(254, 240, 245));
        assignButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 3;
        gridConstraint.insets = new Insets(0, 0, 10, 0);
        gridConstraint.ipadx = 30;
        gridConstraint.ipady = 10;
        gridConstraint.anchor = GridBagConstraints.SOUTH;
        my_panel.add(assignButton, gridConstraint);
        
        // exitButton
        exitButton.setText("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.setOpaque(true);
        exitButton.setBackground(new Color(254, 240, 245));
        exitButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 3;
        gridConstraint.insets = new Insets(0, 0, 10, 0);
        gridConstraint.ipadx = 35;
        gridConstraint.ipady = 10;
        gridConstraint.anchor = GridBagConstraints.SOUTH;
        my_panel.add(exitButton, gridConstraint);
        
        // economicRadioButton
        economicRadioButton.setText("Economic Class");
        economicRadioButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        seatClassRadioButton(e);
                    }
                }
        );
        flightNumberButtonGroup.add(economicRadioButton);
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 2;
        gridConstraint.insets = new Insets(10, 30, 0, 10);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(economicRadioButton, gridConstraint);
        
        // businessRadioButton
        businessRadioButton.setText("Business Class");
        businessRadioButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        seatClassRadioButton(e);
                    }
                }
        );
        flightNumberButtonGroup.add(businessRadioButton);
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 2;
        gridConstraint.insets = new Insets(10, 30, 0, 10);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(businessRadioButton, gridConstraint);
        
        pack();
        setLocationRelativeTo(null);
        
        
        // Layer 2
        // ivanAirlinesLabel
        ivanAirlines.setText("IVAN AIRLINES");
        ivanAirlines.setFont(new Font("Arial", Font.BOLD, 30));
        ivanAirlines.setOpaque(true);
        ivanAirlines.setBackground(new Color(115, 255, 216));
        ivanAirlines.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint = new GridBagConstraints();
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.gridwidth = 2;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(ivanAirlines, gridConstraint);
        
        // classSeat
        classSeat.setText("Class Type");
        classSeat.setFont(new Font("Arial", Font.BOLD, 20));
        classSeat.setOpaque(true);
        classSeat.setBackground(new Color(240, 248, 254));
        classSeat.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint = new GridBagConstraints();
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.gridwidth = 1;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(classSeat, gridConstraint);
        
        // classSeatValue
        classSeatValue.setText(seatClass);
        classSeatValue.setFont(new Font("Arial", Font.BOLD, 20));
        classSeatValue.setOpaque(true);
        classSeatValue.setBackground(new Color(0, 255, 254));
        classSeatValue.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        gridConstraint = new GridBagConstraints();
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 1;
        gridConstraint.gridwidth = 1;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(classSeatValue, gridConstraint);
        
        //
        
        
        // button listener
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
        
        assignButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        assignButtonActionPerformed(e);
                    }
                }
        );
        
        seatButton.get(0).addActionListener(
                new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            seatRadioButtonActionPerformed(e);
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
    
    public void exitForm(WindowEvent e)
    {
        System.exit(0);
    }
    
    public void assignButtonActionPerformed(ActionEvent e)
    {
        String direction = String.valueOf(citiesDirectList.getSelectedValue());
        String from = String.valueOf(citiesFromList.getSelectedValue());
        
        if (direction.equalsIgnoreCase(from))
        {
            Toolkit.getDefaultToolkit().beep();;
            JOptionPane.showConfirmDialog(null, "Destination and Departure City Has Same Value", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            citiesDirectList.setSelectedIndex(0);
            citiesFromList.setSelectedIndex(1);
            seatButton.get(0).setSelected(true);
        }
        else
        {
            offLayerOneAtribut();
        }
    }
    
    public void seatRadioButtonActionPerformed(ActionEvent e)
    {
        numSeat = e.getActionCommand();
        System.out.println(numSeat);
    }
    
    public void seatClassRadioButton(ActionEvent e)
    {
        seatClass = e.getActionCommand();
        classSeatValue.setText(seatClass);
        System.out.println(seatClass);
    }
    
    public void flightNumberRadioButtonActionPerformed(ActionEvent e)
    {
        flight = e.getActionCommand();
        System.out.println(flight);
    }
    
    public void exitButtonActionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
    
    public void offLayerOneAtribut()
    {
        citiesDirectLabel.setVisible(false);
        citiesFromLabel.setVisible(false);
        seatLabel.setVisible(false);
        mealLabel.setVisible(false);
        numSeatLabel.setVisible(false);
        flightNumberLabel.setVisible(false);
        citiesDirectScrollPane.setVisible(false);
        citiesFromScrollPane.setVisible(false);
        assignButton.setVisible(false);
        exitButton.setVisible(false);
        frameScrollPane.setVisible(false);
        flightNumberScrollPane.setVisible(false);
        economicRadioButton.setVisible(false);
        businessRadioButton.setVisible(false);
        seatComboBox.setVisible(false);
        mealComboBox.setVisible(false);
    }
    
    public void onLayerOneAtribute()
    {
        citiesDirectLabel.setVisible(true);
        citiesFromLabel.setVisible(true);
        seatLabel.setVisible(true);
        mealLabel.setVisible(true);
        numSeatLabel.setVisible(true);
        flightNumberLabel.setVisible(true);
        citiesDirectScrollPane.setVisible(true);
        citiesFromScrollPane.setVisible(true);
        assignButton.setVisible(true);
        exitButton.setVisible(true);
        frameScrollPane.setVisible(true);
        flightNumberScrollPane.setVisible(true);
        economicRadioButton.setVisible(true);
        businessRadioButton.setVisible(true);
        seatComboBox.setVisible(true);
        mealComboBox.setVisible(true);
    }
    
    public void onLayerTwoAttribute()
    {
        
    }
}
