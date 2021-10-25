package practiceproblems4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class FileTimes extends JFrame {
    
    private JFileChooser chooser = new JFileChooser();
    private JLabel banner = new JLabel();
    private JTextArea textFile = new JTextArea();
    private JScrollPane wrap = new JScrollPane();
    private File[] listFile;
    private int incr = 0;
    private GregorianCalendar date = new GregorianCalendar();
    
    public static void main(String[] args) {
       FileTimes my_file = new FileTimes("File Times");
       my_file.setVisible(true);
       
       my_file.show();
    }
    
    public FileTimes(String title)
    {
        super (title);
        JPanel my_panel = (JPanel) this.getContentPane();
        my_panel.setBackground(new Color(0, 255, 254));
        
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        
        // atribute start here
        //banner
        banner.setText("File Times Problem");
        banner.setFont(new Font("Arial", Font.BOLD, 50));
        banner.setOpaque(true);
        banner.setBackground(new Color(115, 255, 216));
        banner.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 30, 10, 30)));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.gridwidth = 2;
        gridConstraint.anchor = GridBagConstraints.CENTER;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(banner, gridConstraint);
        
        // chooser
        gridConstraint = new GridBagConstraints();
        chooser.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 30, 10, 30)));
        chooser.setOpaque(true);
        chooser.setBackground(new Color(224, 255, 255));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(chooser, gridConstraint);
        
        //textFile
        textFile.setPreferredSize(new Dimension(3000, 350));
        textFile.setOpaque(true);
        textFile.setBackground(new Color(240, 248, 254));
        textFile.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()), BorderFactory.createEmptyBorder(10, 30, 10, 30)));
        textFile.setFont(new Font("Arial", Font.BOLD, 18));
        textFile.setText("No \t File Name \t \tDate Modified\n___________________________________________________________\n\n");
        textFile.setEditable(false);
        
        // scrollPane
        wrap.setPreferredSize(new Dimension(650, 350));
        wrap.setViewportView(textFile);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 1;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(wrap, gridConstraint);
        
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        my_panel.setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
        setLocationRelativeTo(null);
        
        // listener start here
        chooser.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        chooserActionPerformed(e);
                        System.out.println(8);
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
    
    private void chooserActionPerformed(ActionEvent e)
    {
        System.out.println("Call111");
        if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION))
        {
            System.out.println("Call");
 
            listFile = chooser.getSelectedFile().listFiles();
            for (File my : listFile)
            {
                textFile.setFont(new Font("Arial", Font.PLAIN, 14));
                Long time = my.lastModified();
                Date my_date = new Date(time);
                SimpleDateFormat dt = new SimpleDateFormat("yyyy - mm - dd");
                String name = my.toString();
                int a = name.lastIndexOf("\\");
                name = name.substring(a + 1);
                System.out.println(a);
                String date = dt.format(my_date);
                textFile.append((incr + 1) + ". \t " + name + " \t \t" + date + " \n");
                incr++;
            }
        }
    }
    
    private void exitForm(WindowEvent e)
    {
        System.exit(0);
    }
    
}
