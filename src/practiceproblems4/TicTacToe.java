package practiceproblems4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame {
    
    private JLabel titleGame = new JLabel();
    private JLabel label_00 = new JLabel();
    private JLabel label_01 = new JLabel();
    private JLabel label_02 = new JLabel();
    private JLabel label_10 = new JLabel();
    private JLabel label_11 = new JLabel();
    private JLabel label_12 = new JLabel();
    private JLabel label_20 = new JLabel();
    private JLabel label_21 = new JLabel();
    private JLabel label_22 = new JLabel();
    private JLabel grid_1 = new JLabel();
    private JLabel grid_2 = new JLabel();
    private JLabel grid_3 = new JLabel();
    private JLabel grid_4 = new JLabel();
    private JButton resetButton = new JButton();
    private JButton exitButton = new JButton();
    private ImageIcon xIcon = new ImageIcon("D:/Second/Coding/File Coding Java/LJProjects/Picture/X.gif");
    private ImageIcon oIcon = new ImageIcon("D:/Second/Coding/File Coding Java/LJProjects/Picture/O.gif");
    private int player = 1;
    private JLabel[][] groupLabel = {
        {label_00, label_01, label_02},
        {label_10, label_11, label_12},
        {label_20, label_21, label_22}
    };
    private int[][] condition = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    };
    
    public static void main(String[] args) {
        TicTacToe my_games = new TicTacToe("TicTacToe Games");
        my_games.setVisible(true);
        
        my_games.show();
    }
    
    public TicTacToe(String title)
    {
        super (title);
        JPanel my_panel = (JPanel) this.getContentPane();
        my_panel.setBackground(new Color(152, 251, 153));
        
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        
        // atribute start here
        //titleGame
        titleGame.setPreferredSize(new Dimension(100, 50));
        titleGame.setText("TicTacToe");
        titleGame.setFont(new Font("Arial", Font.BOLD, 18));
        titleGame.setOpaque(true);
        titleGame.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 0, 10, 0)));
        titleGame.setBackground(new Color(175, 238, 239));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 0;
        gridConstraint.insets = new Insets(10, 10, 40, 10);
        my_panel.add(titleGame, gridConstraint);
        
        // label_00
        label_00.setPreferredSize(new Dimension(150, 150));
        label_00.setOpaque(true);
        label_00.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 0, 10, 0)));
        label_00.setBackground(new Color(175, 238, 239));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 30, 0, 0);
        my_panel.add(label_00, gridConstraint);
        
        // label_01
        label_01.setPreferredSize(new Dimension(150, 150));
        label_01.setOpaque(true);
        label_01.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 0, 10, 0)));
        label_01.setBackground(new Color(175, 238, 239));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 0, 0, 0);
        my_panel.add(label_01, gridConstraint);
        
        // label_02
        label_02.setPreferredSize(new Dimension(150, 150));
        label_02.setOpaque(true);
        label_02.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 0, 10, 0)));
        label_02.setBackground(new Color(175, 238, 239));
        gridConstraint.gridx = 4;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 0, 0, 30);
        my_panel.add(label_02, gridConstraint);
        
        // label_10
        label_10.setPreferredSize(new Dimension(150, 150));
        label_10.setOpaque(true);
        label_10.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 0, 10, 0)));
        label_10.setBackground(new Color(175, 238, 239));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 3;
        gridConstraint.insets = new Insets(0, 30, 0, 0);
        my_panel.add(label_10, gridConstraint);
        
        // label_11
        label_11.setPreferredSize(new Dimension(150, 150));
        label_11.setOpaque(true);
        label_11.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 0, 10, 0)));
        label_11.setBackground(new Color(175, 238, 239));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 3;
        gridConstraint.insets = new Insets(0, 0, 0, 0);
        my_panel.add(label_11, gridConstraint);
        
        // label_12
        label_12.setPreferredSize(new Dimension(150, 150));
        label_12.setOpaque(true);
        label_12.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 0, 10, 0)));
        label_12.setBackground(new Color(175, 238, 239));
        gridConstraint.gridx = 4;
        gridConstraint.gridy = 3;
        gridConstraint.insets = new Insets(0, 0, 0, 30);
        my_panel.add(label_12, gridConstraint);
        
        // label_20
        
        label_20.setPreferredSize(new Dimension(150, 150));
        label_20.setOpaque(true);
        label_20.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 0, 10, 0)));
        label_20.setBackground(new Color(175, 238, 239));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 5;
        gridConstraint.insets = new Insets(0, 30, 10, 0);
        my_panel.add(label_20, gridConstraint);
        
        // label_21
        label_21.setPreferredSize(new Dimension(150, 150));
        label_21.setOpaque(true);
        label_21.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 0, 10, 0)));
        label_21.setBackground(new Color(175, 238, 239));
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 5;
        gridConstraint.insets = new Insets(0, 0, 10, 0);
        my_panel.add(label_21, gridConstraint);
        
        // label_22
        label_22.setPreferredSize(new Dimension(150, 150));
        label_22.setOpaque(true);
        label_22.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 0, 10, 0)));
        label_22.setBackground(new Color(175, 238, 239));
        gridConstraint.gridx = 4;
        gridConstraint.gridy = 5;
        gridConstraint.insets = new Insets(0, 0, 10, 30);
        my_panel.add(label_22, gridConstraint);
        
        // grid1
        gridConstraint = new GridBagConstraints();
        grid_1.setPreferredSize(new Dimension(10, 470));
        grid_1.setOpaque(true);
        grid_1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        grid_1.setBackground(Color.BLACK);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 1;
        gridConstraint.gridheight = 5;
        gridConstraint.anchor = GridBagConstraints.WEST;
        my_panel.add(grid_1, gridConstraint);
        
        // grid_2
        gridConstraint = new GridBagConstraints();
        grid_2.setPreferredSize(new Dimension(10, 470));
        grid_2.setOpaque(true);
        grid_2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        grid_2.setBackground(Color.BLACK);
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 1;
        gridConstraint.gridheight = 5;
        gridConstraint.anchor = GridBagConstraints.WEST;
        my_panel.add(grid_2, gridConstraint);
        
        // grid_3
        gridConstraint = new GridBagConstraints();
        grid_3.setPreferredSize(new Dimension(470, 10));
        grid_3.setOpaque(true);
        grid_3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        grid_3.setBackground(Color.BLACK);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        gridConstraint.gridwidth = 5;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(grid_3, gridConstraint);
        
        // grid_4
        gridConstraint = new GridBagConstraints();
        grid_4.setPreferredSize(new Dimension(470, 10));
        grid_4.setOpaque(true);
        grid_4.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        grid_4.setBackground(Color.BLACK);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 4;
        gridConstraint.gridwidth = 5;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(grid_4, gridConstraint);
        
        // resetButton
        resetButton.setText("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 18));
        resetButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        resetButton.setOpaque(true);
        resetButton.setBackground(new Color(62, 254, 255));
        gridConstraint = new GridBagConstraints();
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 6;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(resetButton, gridConstraint);
        
        // exitButton
        exitButton.setText("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));
        exitButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        exitButton.setOpaque(true);
        exitButton.setBackground(new Color(62, 254, 255));
        gridConstraint = new GridBagConstraints();
        gridConstraint.gridx = 4;
        gridConstraint.gridy = 6;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        gridConstraint.anchor = GridBagConstraints.CENTER;
        my_panel.add(exitButton, gridConstraint);
        
         pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        my_panel.setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
        setLocationRelativeTo(null);
        
        //listener start here
        
        for (int i = 0; i < 3; i++)
        {
            for (int a = 0; a < 3; a++)
            {
                groupLabel[i][a].addMouseListener(
                        new MouseAdapter()
                        {
                            public void mouseClicked(MouseEvent e)
                            {
                                labelMouseClicked(e);
                            }
                        }
                );
            }
        }
        
        resetButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        resetButtonActionPerformed(e);
                    }
                }
        );
        
        exitButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        exitButtonActionPeformed(e);
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
    
    private void exitButtonActionPeformed(ActionEvent e)
    {
        Toolkit.getDefaultToolkit().beep();
        int action = JOptionPane.showConfirmDialog(null, "Are You Sure Want To Exit ?", "WARN", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (action == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
        
    }
    
    private void resetButtonActionPerformed(ActionEvent e)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int a = 0; a < 3; a++)
            {
                condition[i][a] = 0;
            }
        }
        
        player = 1;
        
        for (int i = 0; i < 3; i++)
        {
            for (int a = 0; a < 3; a++)
            {
                groupLabel[i][a].setIcon(null);
            }
        }
    }
    
    private void labelMouseClicked(MouseEvent e)
    {
        Component clickedComponent = e.getComponent();
        int choiceRow, choiceColumn;
        choiceColumn = -1;
        choiceRow = -1;
        boolean firstGame = true;
        
        // check is the game first start by checking the condition array
        
        for (int i = 0; i < 3; i++)
        {
            for (int a = 0; a < 3; a++)
            {
                if (condition[i][a] != 0)
                {
                    firstGame = false;
                    break;
                }
            }
        }
        

        for (int i = 0; i < 3; i++)
            {
                choiceRow++;
                choiceColumn = -1;
                for (int a = 0; a < 3; a++)
                {
                    choiceColumn++;
                    if (groupLabel[choiceRow][choiceColumn] == clickedComponent)
                    {
                        break;
                    }
                }
                if (groupLabel[choiceRow][choiceColumn] == clickedComponent)
                    {
                        break;
                    }
                /*
                    break hanya bisa digunakan untuk keluar dari satu loop pada bagian ini
                    sehingga digunakan dua if yang sama di dua scope for yg berbeda untuk menghentikan dua for :)
                */
            }
        if (firstGame)
        {
            condition[choiceRow][choiceColumn] = 1;
            groupLabel[choiceRow][choiceColumn].setIcon(xIcon);
            player = -1;
        }
        else
        {  
            if (player == 1)
            {
                condition[choiceRow][choiceColumn] = 1;
                groupLabel[choiceRow][choiceColumn].setIcon(xIcon);
                player = -1;
            }
            else if (player == -1)
            {
                condition[choiceRow][choiceColumn] = -1;
                groupLabel[choiceRow][choiceColumn].setIcon(oIcon);
                player = 1;
            }
        }
        
        
        // check if game over
        boolean player1Win = false;
        int amountPlayer1 = 0;
        int amountPlayer2 = 0;
        boolean player2Win = false;
        
        // check for horizontal
        for (int i = 0; i < 3; i++)
        {
            amountPlayer1 = 0;
            amountPlayer2 = 0;
            for (int a = 0; a < 3; a++)
            {
                if (condition[i][a] == 1)
                {
                    amountPlayer1++;
                }
                else if (condition[i][a] == -1)
                {
                    amountPlayer2--;
                }
                
                if (amountPlayer1 == 3 || amountPlayer2 == -3)
                {
                    break;
                }
            }
            
            if (amountPlayer1 == 3)
            {
                player1Win = true;
            }
            else if(amountPlayer2 == -3)
            {
                player2Win = true;
            }
        }
        
        // check for vertical
        for (int a = 0; a < 3; a++)
        {
            amountPlayer1 = 0;
            amountPlayer2 = 0;
            
            for (int i = 0; i < 3; i++)
            {
                if (condition[i][a] == 1)
                {
                    amountPlayer1++;
                }
                else if (condition[i][a] == -1)
                {
                    amountPlayer2--;
                }
                
                if (amountPlayer1 == 3 || amountPlayer2 == -3)
                {
                    break;
                }
            }
            
            if (amountPlayer1 == 3)
            {
                player1Win = true;
            }
            else if(amountPlayer2 == -3)
            {
                player2Win = true;
            }
        }
        
        // check for right diagonal
        amountPlayer1 = 0;
        amountPlayer2 = 0;
        for (int i = 0; i < 3; i++)
        {
            if (condition[i][i] == 1)
            {
                amountPlayer1++;
            }
            else if (condition[i][i] == -1)
            {
                amountPlayer2--;
            }
            // check
            if (amountPlayer1 == 3)
            {
                player1Win = true;
            }
            else if(amountPlayer2 == -3)
            {
                player2Win = true;
            }
        }
        
        // check for left diagonal
        amountPlayer1 = 0;
        amountPlayer2 = 0;
        int z = 0;
        for (int i = 2; i >= 0; i--)
        {
            if (condition[z][i] == 1)
            {
                amountPlayer1++;
            }
            else if (condition[z][i] == -1)
            {
                amountPlayer2--;
            }
            //check
            if (amountPlayer1 == 3)
            {
                player1Win = true;
            }
            else if(amountPlayer2 == -3)
            {
                player2Win = true;
            }
            z++;
        }
        
        /*
        System.out.println(player1Win);
        System.out.println(amountPlayer2);
        System.out.println(amountPlayer1);
        System.out.println(player2Win);
        */
        
        if (player1Win)
        {
            JOptionPane.showConfirmDialog(null, "Player 1 WIN\n\tCongratulation\nThe Monza SP2 Are Your's", "INFO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            for (int i = 0; i < 3; i++)
            {
                for (int a = 0; a < 3; a++)
                {
                    condition[i][a] = 0;
                }
            }
        
            player = 1;
        
            for (int i = 0; i < 3; i++)
            {
                for (int a = 0; a < 3; a++)
                {
                    groupLabel[i][a].setIcon(null);
                }
            }
        }
        else if (player2Win)
        {
            JOptionPane.showConfirmDialog(null, "Player 2 WIN\n\tCongratulation\nThe Monza SP2 Are Your's", "INFO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            for (int i = 0; i < 3; i++)
            {
                for (int a = 0; a < 3; a++)
                {
                    condition[i][a] = 0;
                }
            }
        
            player = 1;
        
            for (int i = 0; i < 3; i++)
            {
                for (int a = 0; a < 3; a++)
                {
                    groupLabel[i][a].setIcon(null);
                }
            }
        }
    }
    
}
