package entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import entity.Author;

public class Book implements Serializable{
    private String BookName;
    private int PublishedYear;
    private List<Author> author;
    
    public Book() {
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public int getPublishedYear() {
        return PublishedYear;
    }

    public void setPublishedYear(int PublishedYear) {
        this.PublishedYear = PublishedYear;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + "caption=" + BookName+ ",\n author=" + Arrays.toString(author.toArray())+ ",\n publishedYear=" + PublishedYear+ "\n}";
    }
}
