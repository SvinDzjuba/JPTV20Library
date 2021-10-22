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

    public void saveBooks(List<Book> books) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("books");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.flush();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "Нет файла books", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }

    public List<Book> loadBooks() {
        List<Book> listBooks = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("books");
            ois = new ObjectInputStream(fis);
            listBooks = (List<Book>) ois.readObject();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "Нет файла books", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return listBooks;
    }

    @Override
    public void saveReaders(List<Reader> readers) {
        
    }

    @Override
    public List<Reader> loadReaders() {
        List<Reader> loadReaders = new ArrayList<>();
        
        return loadReaders;
    }

    @Override
    public void saveHistories(List<History> histories) {
        
    }

    @Override
    public List<History> loadHistories() {
        List<History> loadHistories = new ArrayList<>();
        
        return loadHistories;
    }
}
