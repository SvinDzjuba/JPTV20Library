package gui;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pupil
 */
public class ButtonComponent extends JPanel{
    private JLabel title;
    private JButton button;
    public ButtonComponent(){
        initComponents(String text, int widthWindow, int heightPanel, int left, int widthEditor);
    }
    
    private void initComponents(String text, int widthWindow, int heightPanel, int left, int widthEditor){
        this.setPreferredSize(new Dimension(widthWindow,heightPanel));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        title = new JLabel(text);
        title.setPreferredSize(new Dimension(widthWindow/3,27));
        title.setMinimumSize(title.getPreferredSize());
        title.setMaximumSize(title.getPreferredSize());
        title.setHorizontalAlignment(JLabel.RIGHT);
        title.setFont(new Font("Trebutche MS",1,12));
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        button = new JButton();
        button.setPreferredSize(new Dimension(widthEditor,27));
        button.setMinimumSize(getPreferredSize());
        button.setMaximumSize(getPreferredSize());
        this.add(button);
    }
}
