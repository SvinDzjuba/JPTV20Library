/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import guiComponents.EditComponent;
import guiComponents.InfoComponent;
import guiComponents.CaptionComponent;
import guiComponents.ListAuthorsComponent;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pupil
 */
public class GuiApp extends JFrame{
private CaptionComponent captionComponent;
private InfoComponent infoComponent;
private EditComponent editComponent;
private ListAuthorsComponent listAuthorsComponent;
private EditComponent publishedYearComponent;
private EditComponent quantityComponent;
private ButtonComponent buttonComponent;
    public GuiApp(){
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void initComponents(){
        this.setPreferredSize(new Dimension(600,400));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(0,25)));
        captionComponent = new CaptionComponent("Добавление книги в библиотеку", this.getWidth(), 30);
        this.add(captionComponent);
        infoComponent = new InfoComponent("Информация о добавлении книги в библиотеку", this.getWidth(), 27);
        this.add(infoComponent);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        editComponent = new EditComponent("Название книги", this.getWidth(), 30, 250);
        this.add(editComponent);
        listAuthorsComponent = new ListAuthorsComponent("Авторы", this.getWidth(), 120, 250);
        this.add(listAuthorsComponent);
        publishedYearComponent = new EditComponent("Год издания книги", this.getWidth(), 30, 100);
        this.add(publishedYearComponent);
        quantityComponent = new EditComponent ("Количество экземпляров", this.getWidth(), 30, 100);
        this.add(quantityComponent);
        buttonComponent = new ButtonComponent("Добавить книгу", this.getWidth(),30,150,150);
        this.add(buttonComponent);
    }
    
    public static void main(String[] args) {
       javax.swing.SwingUtilities.invokeLater(new Runnable(){
           public void run(){
               new GuiApp().setVisible(true);
           }
       });
    }
}
