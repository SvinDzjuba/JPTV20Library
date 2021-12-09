package guiComponents;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pupil
 */
public class InfoComponent extends JPanel{
    private JLabel info;    
    public InfoComponent(String text ,int widthWindow, int heightPanel){
        initComponents(text, widthWindow, heightPanel);
    }
        
    private void initComponents(String text, int widthWindow, int heightPanel){
        this.setPreferredSize(new Dimension(widthWindow,heightPanel));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        info = new JLabel(text);
        info.setPreferredSize(new Dimension(widthWindow,heightPanel));
        info.setMinimumSize(info.getPreferredSize());
        info.setMaximumSize(info.getPreferredSize());
        info.setHorizontalAlignment(JLabel.CENTER);
        info.setFont(new Font("Trebutche MS",0,16));
        this.add(info);
    }
}