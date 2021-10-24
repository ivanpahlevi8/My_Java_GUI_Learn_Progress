package practiceproblems4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuestNumber extends JFrame {
    
    private JLabel titleLabel = new JLabel();
    private JLabel minimumLabel = new JLabel();
    private JLabel maksimumLabel = new JLabel();
    private JLabel numGuessLabel = new JLabel();
    private JLabel numTryLabel = new JLabel();
    private JLabel minimum = new JLabel();
    private JLabel guess = new JLabel();
    private JLabel maksimum = new JLabel();
    private JScrollBar number = new JScrollBar();
    private JButton resetButton = new JButton();
    private JButton exitButton = new JButton();
    private JButton confirmButton = new JButton();
    private Random my_random = new Random();
    int minimumVal;
    int maksimumVal;
    private int numGuess;
    private int numTry = 3;
    private int rep = 0;
    private int[] incr = {30, 20, 10};
    private int condt = 1;

    public static void main(String[] args) {
        GuestNumber my_number = new GuestNumber("Guest Number");
        my_number.setVisible(true);
        
        my_number.show();
    }
    
    public GuestNumber(String title)
    {
        super (title);
        JPanel my_panel = (JPanel) this.getContentPane();
        my_panel.setBackground(new Color(62, 250, 153));
        
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        
        numGuess = my_random.nextInt(100);
        
        // code start here
        titleLabel.setText("Guest Number Between 0 To 100");
        titleLabel.setOpaque(true);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 38));
        titleLabel.setBackground(new Color(40, 178, 170));
        titleLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        titleLabel.setAlignmentX(SwingConstants.CENTER);
        titleLabel.setAlignmentY(SwingConstants.CENTER);
        titleLabel.setPreferredSize(new Dimension(600, 50));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.insets = new Insets(10, 10, 50, 10);
        gridConstraint.gridwidth = 3;
        my_panel.add(titleLabel, gridConstraint);
        
        //minimum
        gridConstraint = new GridBagConstraints();
        minimum.setText("Minimum Number");
        minimum.setOpaque(true);
        minimum.setFont(new Font("Arial", Font.BOLD, 20));
        minimum.setBackground(new Color(144, 238, 144));
        minimum.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        minimum.setPreferredSize(new Dimension(175, 50));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        gridConstraint.insets = new Insets(10, 10, 0, 10);
        my_panel.add(minimum, gridConstraint);
        
        // guess
        gridConstraint = new GridBagConstraints();
        guess.setText("Number Guess");
        guess.setOpaque(true);
        guess.setFont(new Font("Arial", Font.BOLD, 20));
        guess.setBackground(new Color(144, 238, 144));
        guess.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        guess.setPreferredSize(new Dimension(150, 50));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 1;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        gridConstraint.insets = new Insets(10, 10, 0, 10);
        my_panel.add(guess, gridConstraint);
        
        // maksimum
        gridConstraint = new GridBagConstraints();
        maksimum.setText("Maksimum Number");
        maksimum.setOpaque(true);
        maksimum.setFont(new Font("Arial", Font.BOLD, 20));
        maksimum.setBackground(new Color(144, 238, 144));
        maksimum.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        maksimum.setPreferredSize(new Dimension(190, 50));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 1;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        gridConstraint.insets = new Insets(10, 10, 0, 10);
        my_panel.add(maksimum, gridConstraint);
        
        //minimumLabel
        gridConstraint = new GridBagConstraints();
        minimumLabel.setText("");
        minimumLabel.setOpaque(true);
        minimumLabel.setFont(new Font("Arial", Font.BOLD, 20));
        minimumLabel.setBackground(new Color(135, 206, 250));
        minimumLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createLineBorder(Color.BLACK, 3, true)));
        minimumLabel.setPreferredSize(new Dimension(200, 50));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(minimumLabel, gridConstraint);
        
        //numGuessLabel
        gridConstraint = new GridBagConstraints();
        numGuessLabel.setText("");
        numGuessLabel.setOpaque(true);
        numGuessLabel.setFont(new Font("Arial", Font.BOLD, 20));
        numGuessLabel.setBackground(new Color(135, 206, 250));
        numGuessLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createLineBorder(Color.BLACK, 3, true)));
        numGuessLabel.setPreferredSize(new Dimension(200, 50));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 2;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(numGuessLabel, gridConstraint);
        
        //maksimumLabel
        gridConstraint = new GridBagConstraints();
        maksimumLabel.setText("");
        maksimumLabel.setOpaque(true);
        maksimumLabel.setFont(new Font("Arial", Font.BOLD, 20));
        maksimumLabel.setBackground(new Color(135, 206, 250));
        maksimumLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createLineBorder(Color.BLACK, 3, true)));
        maksimumLabel.setPreferredSize(new Dimension(200, 50));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 2;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(maksimumLabel, gridConstraint);
        
        //numTryLabel
        gridConstraint = new GridBagConstraints();
        numTryLabel.setText(String.valueOf("Chance : " + numTry));
        numTryLabel.setOpaque(true);
        numTryLabel.setFont(new Font("Arial", Font.BOLD, 20));
        numTryLabel.setBackground(new Color(135, 206, 250));
        numTryLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        /*
            Parameter paling belakang dari createCompoundBorder terlebih dahulu di gambar baru parameter terdepan
        */
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 3;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(numTryLabel, gridConstraint);
        
        // confirmButton
        gridConstraint = new GridBagConstraints();
        confirmButton.setText("Confirm");
        confirmButton.setOpaque(true);
        confirmButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        confirmButton.setFont(new Font("Arial", Font.BOLD, 20));
        confirmButton.setBackground(new Color(175, 238, 239));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 4;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(confirmButton, gridConstraint);
        
        // number
        gridConstraint = new GridBagConstraints();
        number.setPreferredSize(new Dimension(300, 50));
        number.setMinimum(0);
        number.setMaximum(110);
        number.setBlockIncrement(5);
        number.setUnitIncrement(1);
        number.setOpaque(true);
        number.setBackground(new Color(224, 255, 255));
        number.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        number.setValue(10);
        number.setOrientation(JScrollBar.HORIZONTAL);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 5;
        gridConstraint.gridwidth = 1;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(number, gridConstraint);
        
        //resetButton
        gridConstraint = new GridBagConstraints();
        resetButton.setText("Reset");
        resetButton.setOpaque(true);
        resetButton.setFont(new Font("Arial", Font.BOLD, 20));
        resetButton.setBackground(new Color(43, 191, 254));
        resetButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 6;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(resetButton, gridConstraint);
        
        //exitButton
        gridConstraint = new GridBagConstraints();
        exitButton.setText("Exit");
        exitButton.setOpaque(true);
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setBackground(new Color(240, 128, 128));
        exitButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 6;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(exitButton, gridConstraint);
        
        minimumLabel.setText(String.valueOf(0));
        maksimumLabel.setText(String.valueOf(100));
        minimumVal = number.getMinimum();
        maksimumVal = number.getMaximum();
        
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        my_panel.setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
        setLocationRelativeTo(null);
        
        // listener start here
        
        number.addAdjustmentListener(
                new AdjustmentListener()
                {
                    public void adjustmentValueChanged(AdjustmentEvent e)
                    {
                        numberAdjustmentValueChanged(e);
                    }
                }
        );
        
        resetButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        resetButtonActionPerformed(e);
                    }
                }
        );
        
        confirmButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        confirmButtonActionPerformed(e);
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
    
    public void exitForm(WindowEvent e)
    {
        System.exit(0);
    }
    
    private void numberAdjustmentValueChanged(AdjustmentEvent e)
    {
        int guessNumber = Integer.valueOf(number.getValue()).intValue();
        minimumLabel.setText(String.valueOf(minimumVal));
        maksimumLabel.setText(String.valueOf(maksimumVal));
        numGuessLabel.setText(String.valueOf(guessNumber));
    }
    
    private void confirmButtonActionPerformed(ActionEvent e)
    {
        int numUser = Integer.valueOf(number.getValue()).intValue();
        System.out.println("Random : " + numGuess);
        
        if (numTry == 0)
        {
            JOptionPane.showConfirmDialog(null, "Sorry Your Guess Are not Correct\nYou are not gonna get your drink", "INFO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Reset1");
            ActionEvent g = null;
            resetButtonActionPerformed(g);
            System.out.println("Reset2");
        }
        
        if (numUser == numGuess)
        {
            JOptionPane.showConfirmDialog(null, "Congratulation Your Guess Are Correct\nThe Monza SP2 Are Your's Now", "INFO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            number.setMinimum(0);
            number.setMaximum(110);
            number.setValue(10);
            minimumLabel.setText(String.valueOf(number.getMinimum()));
            maksimumLabel.setText(String.valueOf(number.getMaximum()));
            numTry = 3;
            numTryLabel.setText(String.valueOf(numTry));
            numGuessLabel.setText("");
            numGuess = my_random.nextInt(100);
            minimumVal = 0;
            maksimumVal = 100;
            rep = 0;
            condt = 1;
        }
        else
        {
            if (condt == 1)
            {
                if (numGuess > 30 && numGuess < 70)
                {
                    minimumVal = numGuess - incr[rep];
                    maksimumVal = numGuess + incr[rep];
                    System.out.println("Condt 1");
                }
                else if (numGuess > 20 && numGuess < 80)
                {
                    rep = 1;
                    minimumVal = numGuess - incr[rep];
                    maksimumVal = numGuess + incr[rep];
                    System.out.println("Condt 2");
                }
                else if (numGuess > 10 && numGuess < 90)
                {
                    rep = 2;
                    minimumVal = numGuess - incr[rep];
                    maksimumVal = numGuess + incr[rep];
                    System.out.println("Condt 3");
                }
                else
                {
                    minimumVal += 5;
                    maksimumVal -= 5;
                    System.out.println("Condt 4");
                }
                if (maksimumVal < minimumVal || maksimumVal == minimumVal)
                {
                    System.out.println("Reset Syntax");
                    number.setMinimum(0);
                    number.setMaximum(110);
                    number.setValue(10);
                    minimumLabel.setText(String.valueOf(number.getMinimum()));
                    maksimumLabel.setText(String.valueOf(number.getMaximum()));
                    numTry = 3;
                    numTryLabel.setText(String.valueOf(numTry));
                    numGuessLabel.setText("");
                    numGuess = my_random.nextInt(100);
                    minimumVal = 0;
                    maksimumVal = 100;
                    rep = 0;
                    condt = 1;
                }
                condt = 0;
            }
            else
            {
                if (numGuess > 30 && numGuess < 70)
                {
                    minimumVal = minimumVal + 5;
                    maksimumVal = maksimumVal - 5;
                    System.out.println("Condt 1'");
                }
                else if (numGuess > 20 && numGuess < 80)
                {
                    rep = 1;
                    minimumVal = minimumVal + 5;
                    maksimumVal = maksimumVal - 5;
                    System.out.println("Condt 2'");
                }
                else if (numGuess > 10 && numGuess < 90)
                {
                    rep = 2;
                    minimumVal = minimumVal + 5;
                    maksimumVal = maksimumVal - 5;
                    System.out.println("Condt 3'");
                }
                else
                {
                    minimumVal += 5;
                    maksimumVal -= 5;
                    System.out.println("Condt 4'");
                }
                
                if (maksimumVal < minimumVal || maksimumVal == minimumVal)
                {
                    System.out.println("Reset Syntax'");
                    number.setMinimum(0);
                    number.setMaximum(110);
                    number.setValue(10);
                    minimumLabel.setText(String.valueOf(number.getMinimum()));
                    maksimumLabel.setText(String.valueOf(number.getMaximum()));
                    numTry = 3;
                    numTryLabel.setText(String.valueOf(numTry));
                    numGuessLabel.setText("");
                    numGuess = my_random.nextInt(100);
                    minimumVal = 0;
                    maksimumVal = 100;
                    rep = 0;
                    condt = 1;
                }
            }

            number.setMinimum(minimumVal);
            number.setMaximum(maksimumVal);
            minimumLabel.setText(String.valueOf(minimumVal));
            maksimumLabel.setText(String.valueOf(maksimumVal));
            numTry--;
            numTryLabel.setText(String.valueOf(numTry));
        }
    }
    
    public void resetButtonActionPerformed(ActionEvent e)
    {
        number.setMinimum(0);
        number.setMaximum(110);
        number.setValue(10);
        minimumLabel.setText(String.valueOf(number.getMinimum()));
        maksimumLabel.setText(String.valueOf(number.getMaximum()));
        numTry = 3;
        numTryLabel.setText(String.valueOf(numTry));
        numGuessLabel.setText("");
        numGuess = my_random.nextInt(100);
        condt = 1;
        rep = 0;
    }
    
    public void exitButtonActionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
}
