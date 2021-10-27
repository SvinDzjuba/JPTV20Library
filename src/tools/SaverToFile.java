package tools;

import entity.Book;
import entity.History;
import entity.Reader;
import nterfaces.Keeping;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SaverToFile implements Keeping{

    @Override
    public void saveBooks(List<Book> books) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("books");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.flush();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "��� ����� books", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ ����� ������", ex);
        }
    }

    @Override
    public List<Book> loadBooks() {
        List<Book> listBooks = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("books");
            ois = new ObjectInputStream(fis);
            listBooks = (List<Book>) ois.readObject();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "��� ����� books", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ �����", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "��� ������ ������", ex);
        }
        return listBooks;
    }

    @Override
    public void saveReaders(List<Reader> reader) {
        FileOutputStream fos=null;
        ObjectOutputStream oos = null;
        try{
            fos=new FileOutputStream("reader");
            oos=new ObjectOutputStream(fos);
            oos.writeObject(reader);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "��� ����� readers", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ �����", ex);
        }
    }
    @Override
    public List<Reader> loadReaders() {
        List<Reader> reader= new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("reader");
            ois= new ObjectInputStream(fis);
            reader = (List<Reader>) ois.readObject();
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "���� readers ��� �� ������", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ ������ readers", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "������ ����� ����������", ex);
        }
        return reader;
    }

    @Override
    public void saveHistories(List<History> histories) {
        FileOutputStream fos=null;
        ObjectOutputStream oos = null;
        try{
            fos=new FileOutputStream("histories");
            oos=new ObjectOutputStream(fos);
            oos.writeObject(histories);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "��� ����� histories", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ �����", ex);
        }
    }

    @Override
    public List<History> loadHistories() {
        List<History> histories= new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("histories");
            ois= new ObjectInputStream(fis);
            histories= (List<History>) ois.readObject();
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "���� histories ��� �� ������", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "������ ������ histories", ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "Histories ����� ����������", ex);
        }
        return histories;
    }
}
