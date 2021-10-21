package tools;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import nterfaces.Keeping;


    public class SaverToFile implements Keeping{

        @Override
        public void saveBooks(Book[] books) {
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            try {
                fos = new FileOutputStream("books");
            } catch (FileNotFoundException ex){
                Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO,"Нет файла books",ex);
            } catch (IOException ex){
                Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE,"Ошибка ввода данных",ex);
              
            }
        }

        @Override
        public Book[] loadBooks() {
            Book[] books = new Book[10];
            
            FileInputStream fis = null;
            ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream("books");
            ois = new ObjectInputStream(fis);
            books = (Book[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "Файл books еще на создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.SEVERE, "Oшибка считывания файла books", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFile.class.getName()).log(Level.INFO, "Класса Book не существует", ex);
        }
        
        return books;
    }

        @Override
        public void saveReaders(Reader[] readers) {
            
        }

        @Override
        public Reader[] loadReaders() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void saveHistories(History[] histories) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public History[] loadHistories() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
