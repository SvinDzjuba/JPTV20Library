package myclasses;

import java.util.Arrays;

public class Book {
    private String BookName;
    private int PublishedYear;
    private Author [] Author;

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

    public Author[] getAuthor() {
        return Author;
    }

    public void setAuthor(Author[] Author) {
        this.Author = Author;
    }

    @Override
    public String toString() {
        return "Book{" + "BookName=" + BookName + ", PublishedYear=" + PublishedYear + ", Author="+ Arrays.toString(Author)+'}';
        
    }

    
}
