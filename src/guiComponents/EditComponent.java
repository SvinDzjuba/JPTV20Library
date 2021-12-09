package guiComponents;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pupil
 */
public class EditComponent extends JPanel{
    private JLabel title;    
    private JTextField editor;
    public EditComponent(String text, int widthWindow, int heightPanel, int widthEditor){
        initComponents(text, widthWindow, heightPanel, widthEditor);
    }
    
    private void initComponents(String text, int widthWindow, int heightPanel, int widthEditor){
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
        editor = new JTextField();
        editor.setPreferredSize(new Dimension(widthEditor,27));
        editor.setMinimumSize(getPreferredSize());
        editor.setMaximumSize(getPreferredSize());
        this.add(editor);
    }
}