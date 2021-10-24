package imagerviewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class ImageViewer extends JFrame {
    
    private JFileChooser imageChooser = new JFileChooser();
    private JLabel imageLabel = new JLabel();
    private String[] ext = {"gif", "jpg"};
    
    public static void main(String[] args) {
        ImageViewer my_viewer = new ImageViewer("ImageViewer");
        my_viewer.setVisible(true);
        
        my_viewer.show();
    }
    
    public ImageViewer(String title)
    {
        super(title);
        JPanel my_panel = (JPanel) this.getContentPane();
        my_panel.setBackground(new Color(135, 206, 235));
        
        my_panel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraint = new GridBagConstraints();
        
        // the atribute start here
        // imageLabel
        imageLabel.setOpaque(true);
        imageLabel.setPreferredSize(new Dimension(270, 300));
        imageLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        imageLabel.setBackground(new Color(224, 255, 255));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);
        gridConstraint.gridx = 1;
        gridConstraint.gridy = 0;
        gridConstraint.insets = new Insets(10, 10, 10, 10);
        my_panel.add(imageLabel, gridConstraint);
        
        // imageChooser
        imageChooser.addChoosableFileFilter(new FileNameExtensionFilter("Graphics File", "gif", "jpg", "png"));
        imageChooser.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        imageChooser.setOpaque(true);
        imageChooser.setBackground(new Color(144, 238, 144));
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        my_panel.add(imageChooser, gridConstraint);
        
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        my_panel.setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
        setLocationRelativeTo(null);
        
        // the listener start here
        imageChooser.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        imageChooserActionPerformed(e);
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
    
    private void imageChooserActionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION))
        {
            ImageIcon my_icon = new ImageIcon(imageChooser.getSelectedFile().toString());
            System.out.println(imageChooser.getSelectedFile().toString());
            imageLabel.setIcon(my_icon);
            /*
                imageChooser.getSelectedFile().toString()
                Mereturn string dengan isi string berupa lokasi file secara spesifik
            */
        }
    }
    
    private void exitForm(WindowEvent e)
    {
        System.exit(0);
    }
    
}
