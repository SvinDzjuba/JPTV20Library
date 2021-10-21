package entity;

import java.io.Serializable;

public class Author implements Serializable{
    private String FirstName;
    private String LastName;
    private int Year;

    public Author() {
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    @Override
    public String toString() {
        return "Author{" + "FirstName=" + FirstName + ", LastName=" + LastName + ", Year=" + Year + '}';
    }
   
}
