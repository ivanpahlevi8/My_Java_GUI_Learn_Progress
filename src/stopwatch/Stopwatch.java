
package stopwatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;




public class Stopwatch extends JFrame {
    
    private long startTime;
    private long stopTime;
    private double elapsedTime;
    private boolean stopButtonCondition = false;
    private Timer my_timer;
    private int incr = 1;
    private boolean resetActivation = false;
    
    private JButton startButton = new JButton();
    private JButton stopButton = new JButton();
    private JButton exitButton = new JButton();
    private JButton resetButton = new JButton();
    private JButton roundButton = new JButton();
    private JLabel startLabel = new JLabel();
    private JLabel stopLabel = new JLabel();
    private JLabel elapsedLabel = new JLabel();
    private JLabel roundLabel = new JLabel();
    private JTextField startTextField = new JTextField();
    private JTextField stopTextField = new JTextField();
    private JTextField elapsedTextField = new JTextField();
    private JTextField roundField = new JTextField();
    private JTextArea my_area = new JTextArea();
    private JScrollPane wrapperTextArea = new JScrollPane(my_area);

    public static void main(String[] args) {
        Stopwatch my_stopwatch = new Stopwatch("Stopwatch Aplication");
        my_stopwatch.setSize(600, 350);
        my_stopwatch.setVisible(true);
        my_stopwatch.show();
    }
    
    public Stopwatch(String title_aplication)
    {
        super (title_aplication);
        /*
            Mewarisi kelas induk dari JFrame
            Ketika object dari stopwatch yang mewarisi kelas induk JFrame di buat
            Maka frame utama otomatis terbuat dengan sendirinya
            Tinggal di tambah material - material frame seperti button dll.
        */
        JPanel main_panel = (JPanel) this.getContentPane();
        /*
            Membuat object main_panel dari class JPanel yang mana main_panel memiliki akses terhadap JPanel
            Dalam Scope ini karen this.getContentPanel. Sehingga main_panel bisa melakukan manipulasi terhadap
            fungsi-fungsi pada kelas Induk JPanel dalam class ini.
            Tidak harus ditampilkan sebenarmya, jika hanya ingin menggunakan fram JPanle tanpa atribut lainnya.
        */
        main_panel.setBackground(Color.MAGENTA);
        
        
        JButton greet_button = new JButton();
        greet_button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                System.out.println("Hello Ivan !!!");
                Toolkit.getDefaultToolkit().beep();
            }
        });
        
        main_panel.setLayout(new GridBagLayout());
        /*
            Untuk mengatur layout peletakan dari elemen - elemen pada frame
            seperti button, panel, label dan lain-lain
        */
        GridBagConstraints gridConstraint = new GridBagConstraints();
        /*
            Membuat object dari GridBagConstraint untuk membagi - bagi layout pada frame
            dengan membuat seprerti colom dan baris. Ada 6 layout pada JFrame
            liat buku halaman 67 untuk lebih jeals
        */
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        
        // start button
        startButton.setText("Start Timing");
        startButton.setBackground(Color.GREEN);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        main_panel.add(startButton, gridConstraint);
        
        //stop button
        stopButton.setText("Stop Timing");
        stopButton.setBackground(Color.ORANGE);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        main_panel.add(stopButton, gridConstraint);
        
        //exit button
        exitButton.setText("Exit");
        exitButton.setBackground(Color.RED);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 2;
        main_panel.add(exitButton, gridConstraint);
        
        //start label
        startLabel.setText("Start Time");
        startLabel.setBackground(Color.GREEN);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 0;
        main_panel.add(startLabel, gridConstraint);
        
        //stop label
        stopLabel.setText("End Time");
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 1;
        main_panel.add(stopLabel, gridConstraint);
        
        //elapsed label
        elapsedLabel.setText("ElapsedTime(sec)");
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 2;
        main_panel.add(elapsedLabel, gridConstraint);
        
        //start text field
        startTextField.setText("");
        startTextField.setColumns(15);
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 0;
        main_panel.add(startTextField, gridConstraint);
        
        //stop text field
        stopTextField.setText("");
        stopTextField.setColumns(15);
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 1;
        main_panel.add(stopTextField, gridConstraint);
        
        //elapsed text field
        elapsedTextField.setText("");
        elapsedTextField.setColumns(15);
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 2;
        main_panel.add(elapsedTextField, gridConstraint);
        
        // round label
        roundLabel.setText("Round");
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 0;
        main_panel.add(roundLabel, gridConstraint);
        
        // text area
        my_area.setText("");
        my_area.setColumns(10);
        my_area.setRows(5);
        gridConstraint.gridx = 3;
        gridConstraint.gridy = 1;
        gridConstraint.gridwidth = 10;
        gridConstraint.gridheight = 5;
        gridConstraint.insets = new Insets(5, 5, 5, 5);
        main_panel.add(wrapperTextArea, gridConstraint);
        
        //reset button
        resetButton.setText("Reset");
        resetButton.setBackground(Color.YELLOW);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 3;
        main_panel.add(resetButton, gridConstraint);
        
        //round button
        roundButton.setText("Round");
        roundButton.setBackground(Color.LIGHT_GRAY);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 3;
        main_panel.add(roundButton, gridConstraint);
        
        //greet button
        greet_button.setText("Hello");
        greet_button.setBackground(Color.CYAN);
        gridConstraint.gridx = 2;
        gridConstraint.gridy = 3;
        main_panel.add(greet_button, gridConstraint);
        
        // menambahkan listener exit button agar sistem berhenti ketika exit button di klik
        exitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        // menambahkan listener windwo agar sistem berhenti ketika window si close
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                exitForm(e);
            }
        }
        );    
        
        // action listener for start button
        startButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        startButtonActionPerformed(e);
                    }
                }
        
        );
        
        // stop button listener
        stopButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        stopButtonActionPerformed(e);
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
        
        roundButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        roundButtonActionPerformed(e);
                    }
                }
        );
        
    }
    
    class Helper extends TimerTask
    {   
        public void run()
        {
            stopTime = System.currentTimeMillis();
            stopTextField.setText(String.valueOf(stopTime));
            elapsedTime = (stopTime - startTime)/1000.0;
            elapsedTextField.setText(String.valueOf(elapsedTime));
        }
    }
    
    private void roundButtonActionPerformed(ActionEvent e)
    {
        my_area.append("(" + String.valueOf(incr) + ".) " + String.valueOf(elapsedTime) + " Second \n");
        incr++;
    }
    
    private void resetButtonActionPerformed(ActionEvent e)
    {
        if (resetActivation)
        {
            startTime = (long) 0.0;
            stopTime = (long) 0.0;
            elapsedTime = (double) 0.0;
            startTextField.setText(" ");
            stopTextField.setText(" ");
            elapsedTextField.setText(" ");
            my_area.setText("");
            incr = 1;
            stopButtonCondition = false;
        }
    }
    
    private void startButtonActionPerformed(ActionEvent e)
    {
        startTime = System.currentTimeMillis();
        startTextField.setText(String.valueOf(startTime));
        stopTime = System.currentTimeMillis();
        stopTextField.setText(" ");
        elapsedTextField.setText(" ");
        my_timer = new Timer();
        TimerTask help = new Helper();
        my_timer.schedule(help, 0, 1000);
        stopButtonCondition = true;
    }
    
    private void stopButtonActionPerformed(ActionEvent e)
    {
        if (stopButtonCondition)
        {
            stopTime = System.currentTimeMillis();
            stopTextField.setText(String.valueOf(stopTime));
            elapsedTime = (stopTime - startTime)/1000.0;
            elapsedTextField.setText(String.valueOf(elapsedTime));
            Toolkit.getDefaultToolkit().beep();
            my_timer.cancel();
            resetActivation = true;
        }
    }
    
    private void exitForm(WindowEvent e)
    {
        System.exit(0);
    }
       
}


