package jptv20library;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import nterfaces.Keeping;
import tools.SaverToFile;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private List<Book> books = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();
    private List<History> histories = new ArrayList<>();
    private Keeping keeping = new SaverToFile();
    
    public App(){
        books = keeping.loadBooks();
        readers = keeping.loadReaders();
        histories = keeping.loadHistories();
    }
    
    public void run(){
       String repeat = "r";
        do{
            System.out.println("0: ��������� ���������");
            System.out.println("1: �������� �����");
            System.out.println("2: ������ ����");
            System.out.println("3: �������� ��������");
            System.out.println("4: ������ ���������");
            System.out.println("5: ������ ����� ��������");
            System.out.println("6: ������� �����");
            System.out.println("7: ������ �������� ����");
            System.out.println("�������� ����� ������:");
            int task = scanner.nextInt(); scanner.nextLine();
            switch (task) {
                case 0:
                    repeat="q";
                    System.out.println("����!");
                    break;
                case 1:
                    System.out.println("--- ���������� ����� ---");
                    books.add(addBook());
                    keeping.saveBooks(books);
                    break;
                case 2:
                    System.out.println("--- ������ ���� ---");
                    for (int i = 0; i < books.size(); i++) {
                        if(books.get(i) != null && books.get(i).getCount() > 0){
                            System.out.println(books.get(i).toString());
                        }
                    }
                    System.out.println("-------------------");
                    break;
                case 3:
                    System.out.println("--- ���������� �������� ---");
                    readers.add(addReader());
                    keeping.saveReaders(readers);
                    break;
                case 4:
                    System.out.println("--- ������ ��������� ---");
                    for (int i = 0; i < readers.size(); i++) {
                        if(readers.get(i) != null){
                            System.out.println(readers.get(i).toString());
                        }
                    }
                    System.out.println("-------------------");
                    break;
                case 5:
                    System.out.println("--- ������ ����� ---");
                    History history = addHistory();
                    if(history == null){
                        break;
                    }
                    history.getBook().setCount(history.getBook().getCount() - 1);
                    keeping.saveBooks(books);
                    histories.add(history);
                    keeping.saveHistories(histories);
                    System.out.println("����� "+history.getBook().getBookName()
                                        +" ������ �������� "+history.getReader().getFirstName()
                                        +" " +history.getReader().getLastName()
                    );
                    System.out.println("-------------------");
                    break;
                case 6:
                    System.out.println("--- ������� ����� ---");
                    System.out.println("������ �������� ����:");
                    int n = 0;
                    for (int i = 0; i < histories.size(); i++) {
                        if(histories.get(i) != null
                             && histories.get(i).getReturnedDate() == null
                                && histories.get(i).getBook().getCount() 
                                <  histories.get(i).getBook().getQuantity()
                        ){
                            System.out.printf("%d. ����� \"%s\" ������ %s %s%n"
                                    ,i+1
                                    ,histories.get(i).getBook().getBookName()
                                    ,histories.get(i).getReader().getFirstName()
                                    ,histories.get(i).getReader().getLastName()
                            );
                             n++;
                        }
                    }
                    if(n < 1){
                        System.out.println("��� �������� ����!");
                        System.out.println("-------------------");
                        break;
                    }
                    System.out.print("�������� ����� ����������� �����: ");
                    int numberHistory = scanner.nextInt(); scanner.nextLine();
                    Calendar c = new GregorianCalendar();
                    histories.get(numberHistory - 1).setReturnedDate(c.getTime());
                    histories.get(numberHistory - 1).getBook().setCount(
                            histories.get(numberHistory - 1).getBook().getCount()+1
                    );
                    keeping.saveBooks(books);
                    keeping.saveHistories(histories);
                    System.out.println("����� "
                            +histories.get(numberHistory - 1).getBook().getBookName()
                            +" ���������� � ����������"
                    );
                    System.out.println("-------------------");
                    break;
                case 7:
                    System.out.println("������ �������� ����:");
                    n = 0;
                    for (int i = 0; i < histories.size(); i++) {
                        if(histories.get(i) != null && histories.get(i).getReturnedDate() == null){
                            System.out.println(i+1+"."
                                    +histories.get(i).getReader().getFirstName()
                                    +" "+histories.get(i).getReader().getLastName()
                                    +" ������ ����� ��� ��������� "
                                    +"'"
                                    +histories.get(i).getBook().getBookName()
                                    +"'");
                            n++;
                        }
                    }
                    if(n < 1){
                        System.out.println("��� �������� ����!");
                        System.out.println("-------------------");
                        break;
                    }
                    break;
                default:
                    System.out.println("�������� ����� �� ������!");;
            }
        }while("r".equals(repeat));
    }
    private Book addBook(){
        Book book = new Book();
        System.out.print("������� �������� �����: ");
        book.setBookName(scanner.nextLine());
        System.out.print("������� ��� ������� �����: ");
        book.setPublishedYear(scanner.nextInt());scanner.nextLine();
        System.out.print("������� ���������� ����������� �����: ");
        book.setQuantity(scanner.nextInt());scanner.nextLine();
        book.setCount(book.getQuantity());
        System.out.print("������� ������� � �����: ");
        int countAuthors = scanner.nextInt();scanner.nextLine();
        Author[] authors = new Author[countAuthors];
        for (int i = 0; i < authors.length; i++) {
            Author author = new Author();
            System.out.println("������� ��� ������ "+(i+1)+": ");
            author.setFirstname(scanner.nextLine());
            System.out.println("������� ������� ������: ");
            author.setLastname(scanner.nextLine());
            authors[i] = author;
        }
        book.setAuthor(authors);
        return book;
    }
    private Reader addReader(){
        Reader reader = new Reader();
        System.out.println("������� ��� ��������");
        reader.setFirstName(scanner.nextLine());
        System.out.println("������� ������� ��������");
        reader.setLastName(scanner.nextLine());
        System.out.println("������� ������� ��������");
        reader.setPhone(scanner.nextLine());
        return reader;
    }

    private History addHistory() {
        History history = new History();
        System.out.println("������ ����:");
        int n = 0;
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i) != null && books.get(i).getCount()>0){
                StringBuilder sbAuthorNames = new StringBuilder();
                for (int j = 0; j < books.get(i).getAuthor().length; j++) {
                    sbAuthorNames.append(books.get(i).getAuthor()[j].getFirstname())
                                    .append(" ")
                                    .append(books.get(i).getAuthor()[j].getLastname())
                                    .append(". ");
                }
                
                System.out.println(i+1
                        +". "+books.get(i).getBookName()
                        +". "+books.get(i).getPublishedYear()
                        +". "+sbAuthorNames.toString()
                        +". � �������: " + books.get(i).getCount()
                );
                n++;
            }
        }
        if(n < 1){
            System.out.println("��� ���� ��� ������");
            return null;
        }
        System.out.print("�������� ����� �����: ");
        int numberBook = scanner.nextInt(); scanner.nextLine();
        System.out.println("������ ���������:");
        for (int i = 0; i < readers.size(); i++) {
            if(readers.get(i) != null){
                System.out.println(i+1+". "+readers.get(i).toString());
            }
        }
        System.out.print("�������� ����� ��������: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        history.setBook(books.get(numberBook-1));
        history.setReader(readers.get(numberReader-1));
        Calendar c = new GregorianCalendar();
        history.setGivenDate(c.getTime());
        
        return history;
    }
}








/*
public class App {
    Scanner scanner = new Scanner(System.in);
    private List<Book> books = new ArrayList<>();
    private List<Reader> reader = new ArrayList<>();
    private List<History> histories = new ArrayList<>();
    private Keeping keeper = new SaverToFile();

    public App() {
        books = keeper.loadBooks();
        reader = keeper.loadReaders();
        histories = keeper.loadHistories();
    }
    
    Calendar c = new GregorianCalendar();
    public void run() {
        String repeat = "r";
        do{
            System.out.println("������ - 0: ����� �� ���������");
            System.out.println("������ - 1: �������� �����");
            System.out.println("������ - 2: ������ ����");
            System.out.println("������ - 3: ���� ���������� � ��������");
            System.out.println("������ - 4: ���������� � ��������");
            System.out.println("������ - 5: ������ �����");
            System.out.println("������ - 6: ������ �������� ����");
            System.out.println("������ - 7: ������� ��������� �����");
            System.out.printf("�������� ����� ������: ");
            int task = scanner.nextInt();scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = "d";
                    System.out.println("����!");
                    break;
                case 1:
                    System.out.println("---- ���������� ����� ----");
                    books.add(addBook());
                    keeper.saveBooks(books);
                    break;
                case 2:
                    System.out.println("---- ������ ���� -----");
                    for (int i = 0; i < books.size(); i++) {
                        if(books.get(i) != null){
                            System.out.println(books.get(i).toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("---- ���� ���������� � �������� ----");
                    reader.add(addReader());
                    keeper.saveReaders(reader);                       
                break;
                case 4:
                    System.out.println("---- �������� -----");
                    for (int i = 0; i < reader.size(); i++) {
                        if(reader.get(i) != null){
                            System.out.println(reader.get(i).toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("------ ������ ����� -----");
                        histories.add(addHistory());
                        keeper.saveHistories(histories);
                break;              
                case 6:
                    int n = 0;
                    System.out.println("----- ������ �������� ���� ----");
                    for (int i = 0; i < histories.size(); i++) {
                        if(histories.get(i) != null && histories.get(i).getReturnedDate()== null){
                            System.out.println(histories.get(i).toString());
                            System.out.println("����� "+histories.get(i).getBook().getBookName()
                                +" ������ "+histories.get(i).getReader().getFirstName()
                                +" "+ histories.get(i).getReader().getLastName());
                            n++;
                        }
                    }    
                    if(n<1){
                        System.out.println("----- �������� ����� ��������� -----");
                    }
                    System.out.println("");
                    break;

                case 7:
                    System.out.println("----- ������� �������� ����� -----");
                    System.out.println("������ �������� ����� � ���������"); 
                    printGivenBooks();
                    System.out.println("������� ����� �� ������ ");
                    int numberHistory =scanner.nextInt();scanner.nextLine();
                    Calendar c= new GregorianCalendar();
                    if(histories.get(numberHistory - 1).getBook().getCount()
                            < histories.get(numberHistory - 1).getBook().getQuantity()){
                        histories.get(numberHistory - 1).setReturnedDate(c.getTime());
                        histories.get(numberHistory - 1).getBook().setCount(histories.get(numberHistory - 1).getBook().getCount()+1);
                    }else{
                        System.out.println("������ ����� ����������");
                    }
                    
                    keeper.saveHistories(histories);
                    keeper.saveBooks(books);
                    System.out.printf("����� \"%s\" ����������%n", histories.get(numberHistory-1).getBook().getBookName());
                    break;
                default:
                    System.out.println("----- ������� ����� �� ������ ----- ");
            }
            
        }while("r".equals(repeat));
    }
    private void printGivenBooks(){     
        for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i) != null && histories.get(i).getReturnedDate()== null){
                System.out.printf("%d. �����: %s ������ %s %s%n",
                        i+1,
                        histories.get(i).getBook().getBookName(),
                        histories.get(i).getReader().getFirstName(),
                        histories.get(i).getReader().getLastName()
                );

            }
        }
    }

        private Book addBook(){
            Book book = new Book();
            System.out.printf("������� �������� �����: ");
            book.setBookName(scanner.nextLine());
            System.out.println("");
            System.out.printf("������� ���� ������� �����: ");
            book.setPublishedYear(scanner.nextInt());
            System.out.println("");
            System.out.printf("������� ���������� �������: ");
            int countAuthors = scanner.nextInt(); scanner.nextLine(); 
            System.out.println("=================================");
            Author[] authors = new Author[countAuthors];
            for(int i = 0; i < countAuthors; i++){
                Author author = new Author();
                System.out.printf("������� ��� ������: ");
                author.setFirstname(scanner.nextLine());
                System.out.println("");
                System.out.printf("������� ������� ������: ");
                author.setLastname(scanner.nextLine());
                System.out.println("");
                System.out.printf("������� ��� �������� ������: ");
                author.setBirthYear(scanner.nextInt());scanner.nextLine();
                System.out.println("");
                System.out.println("===============================");
                authors[i] = author;
            }
            book.setAuthor(authors);
            return book;
        
        }
        private Reader addReader(){
            Reader reader = new Reader();
            System.out.printf("������� ��� ��������: ");
            reader.setFirstName(scanner.nextLine());
            System.out.println("");
            System.out.printf("������� ������� ��������: ");
            reader.setLastName(scanner.nextLine());
            System.out.println("");
            System.out.printf("������� ����� �������� ��������: ");
            reader.setPhone(scanner.nextLine());
            System.out.println("=================================");
            
            return reader;
        }
        
        
        private History addHistory(){
            History history = new History();
            System.out.println("������ ����: ");
            int g = 0;
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i) != null && books.get(i).getCount()>0){
                    StringBuilder sbAuthorNames = new StringBuilder();
                    for (int j = 0; j < books.get(i).getAuthor().length; j++) {
                        sbAuthorNames.append(books.get(i).getAuthor()[j].getFirstname())
                                        .append(" ")
                                        .append(books.get(i).getAuthor()[j].getLastname())
                                        .append(". ");
                    }

                    System.out.println(i+1
                            +". "+books.get(i).getBookName()
                            +". "+books.get(i).getPublishedYear()
                            +". "+sbAuthorNames.toString()
                            +". � �������: " + books.get(i).getCount());
                    g++;
                }
            }
            if(g < 1){
                System.out.println("��� ���� ��� ������");
                return null;
            }
                //System.out.printf("%d. %s%n",i+1,books.get(i).toString());

            System.out.println("������� ����� �����: ");
            int bookNumber = scanner.nextInt(); scanner.nextLine();
            history.setBook(books.get(bookNumber-1));
            System.out.println();
            System.out.println("������ ���������: ");
            for (int i = 0; i < reader.size(); i++) {
            if(reader.get(i) != null){
                System.out.printf("%d. %s%n",i+1,reader.get(i).toString());
            }
            }
            System.out.println("������� ����� ��������: ");
            int readerNumber = scanner.nextInt(); scanner.nextLine();
            history.setReader(reader.get(readerNumber-1));
            Calendar c = new GregorianCalendar();
            history.setGivenDate(c.getTime());
            return history;
        }      
}
*/