package jptv20library;

import java.util.Calendar;
import java.util.GregorianCalendar;
import myclasses.Book;
import myclasses.Reader;
import myclasses.Author;
import myclasses.History;


public class App {
    public void run() {
        Reader reader1 = new Reader();
        reader1.setFirstName("Makson");
        reader1.setLastName("Dzjuba");
        reader1.setPhone("53005207");
        Reader reader2 = new Reader();
        reader2.setFirstName("Olga");
        reader2.setLastName("Jukova");
        reader2.setPhone("55462176");
        
        Book book1 = new Book();
        book1.setBookName("Voina i Mir");
        book1.setPublishedYear(2021);
        Author author1 = new Author();
        author1.setFirstName("Lev");
        author1.setLastName("Tolstoi");
        author1.setYear(1828);
        Author [] authors1 = new Author[1];
        authors1[0]=author1;
        book1.setAuthor(authors1);
        
        Book book2 = new Book();
        book2.setBookName("Otci i Deti");
        book2.setPublishedYear(1862);
        Author author2 = new Author();
        author2.setFirstName("Roman");
        author2.setLastName("Turgenev");
        author2.setYear(1818);
        Author [] authors2 = new Author[1];
        authors2[0]=author2;
        book2.setAuthor(authors2);
        
        Calendar c = new GregorianCalendar();
        
        History history1 = new History();
        history1.setReader(reader2);
        history1.setBook(book2);
        history1.setGivendate(c.getTime());
        //history1.setReturndate(c.getTime());
        
        System.out.println("History1: "+history1.toString());
                
        c = new GregorianCalendar();
        history1.setReturndate(c.getTime());
        System.out.println("History1: "+history1.toString());
        System.out.println("-------------------------------------------");
        
        History history2 = new History();
        history2.setReader(reader2);
        history2.setBook(book2);
        history2.setGivendate(c.getTime());
        //history2.setReturndate(c.getTime());
        
        System.out.println("History2: "+history2.toString());
        
        
        c = new GregorianCalendar();
        history2.setReturndate(c.getTime());
        System.out.println("History2: "+history2.toString());
    }
}
