package jptv20library;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import nterfaces.Keeping;
import tools.SaverToFile;


public class App {
    Scanner scanner = new Scanner(System.in);
    private Book[] books = new Book[10];
    private Reader[] reader = new Reader[10];
    private History[] histories = new History[10];
    private Keeping keeper = new SaverToFile();

    public App() {
        books = keeper.loadBooks();
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
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] == null){
                            books[i] = addBook();
                            keeper.saveBooks(books);
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("---- ������ ���� -----");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] != null){
                            System.out.println(books[i].toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("---- ���� ���������� � �������� ----");
                    for (int i = 0; i < reader.length; i++) {
                        if(reader[i] == null){
                            reader[i] = addReader();
                            break;
                        }
                    }
                case 4:
                    System.out.println("---- �������� -----");
                    for (int i = 0; i < reader.length; i++) {
                        if(reader[i] != null){
                            System.out.println(reader[i].toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("------ ���� ������ -----");
                    for (int i = 0; i < reader.length; i++) {
                        if(histories[i] == null){
                            histories[i] = addHistory();
                            break;
                        }
                    }
                break;
                case 6:
                    int n = 0;
                    System.out.println("----- ������ �������� ���� ----");
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i] != null && histories[i].getReturndate() == null){
                            System.out.println(histories[i].toString());
                            System.out.println("����� "+histories[i].getBook().getBookName()
                                +" ������ �������� "+histories[i].getReader().getFirstName()
                                +" "+ histories[i].getReader().getLastName());
                            n++;
                        }
                    }    
                    if(n<1){
                        System.out.println("----- ������ ����� ����������� -----");
                    }
                    System.out.println("");
                    break;
                    
                case 7:
                    System.out.println("----- ������� ����� -----");
                    System.out.println("������ �������� ����: ");
                    printGivenBooks();
                    System.out.println("����� ������������ �����: ");
                    int numberHistory = scanner.nextInt();scanner.nextLine();
                    Calendar c = new GregorianCalendar();
                    histories[numberHistory -1].setReturndate(c.getTime());
                    for (int i = 0; i < 10; i++) {
                        System.out.println("����� "+histories[numberHistory-1].getBook().getBookName()+ "���������� "+ histories[numberHistory-1].getReader().getFirstName()+" "+histories[numberHistory-1].getReader().getLastName());
                    }
                default:
                    System.out.println("----- ������� ����� �� ������ ----- ");
            }
            
        }while("r".equals(repeat));
    }
    private void printGivenBooks(){
        for (int i = 0; i < histories.length; i++) {
            if(histories[i] != null && histories[i].getReturndate() == null){
                System.out.println("����� "+histories[i].getBook().getBookName()+" ������ �������� "+histories[i].getReader().getFirstName()+" "+ histories[i].getReader().getLastName());
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
            Author [] authors = new Author[countAuthors]; 
            System.out.println("=================================");
            for(int i = 0; i < authors.length; i++){
                Author author = new Author();
                System.out.printf("������� ��� ������: ");
                author.setFirstName(scanner.nextLine());
                System.out.println("");
                System.out.printf("������� ������� ������: ");
                author.setLastName(scanner.nextLine());
                System.out.println("");
                System.out.printf("������� ��� �������� ������: ");
                author.setYear(scanner.nextInt());scanner.nextLine();
                System.out.println("");
                System.out.println("===============================");
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
            for (int i = 0; i < books.length; i++) {
                if(books[i]!=null){
                    System.out.println(books[i].toString());
                }
            }
            System.out.println("������� ����� �����: ");
            int numberBook = scanner.nextInt();scanner.nextLine();
            for (int i = 0; i < reader.length; i++) {
                if(reader[i] != null){
                    System.out.println(reader[i].toString());
                }
            }
            System.out.println("������� ����� ��������: ");
            int numberReader = scanner.nextInt();scanner.nextLine();
            history.setBook(books[numberBook - 1]);
            history.setReader(reader[numberReader - 1]);
            Calendar c = new GregorianCalendar();
            history.setGivendate(c.getTime());
            return history;
        }
}
        
        





