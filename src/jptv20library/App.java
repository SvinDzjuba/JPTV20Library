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
                    for (int i = 0; i < reader.size(); i++) {
                        if(reader.get(i) == null){
                            reader.add(addReader());
                            keeper.saveReaders(reader);
                            break;
                        }
                    }
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
                    for (int i = 0; i < reader.size(); i++) {
                        if(histories.get(i) == null){
                            histories.set(i, addHistory());
                            break;
                        }
                    }
                break;
                
                case 6:
                    int n = 0;
                    System.out.println("----- ������ �������� ���� ----");
                    for (int i = 0; i < histories.size(); i++) {
                        if(histories.get(i) != null && histories.get(i).getReturndate() == null){
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
                    System.out.println("----- ������� ����� -----");
                    printGivenBooks();
                    System.out.print("�������� ������������ �����: ");
                    int historyNumber = scanner.nextInt(); scanner.nextLine();
                    Calendar c = new GregorianCalendar();
                    histories.get(historyNumber-1).setReturndate(c.getTime());
                    break;
                
                default:
                    System.out.println("----- ������� ����� �� ������ ----- ");
            }
            
        }while("r".equals(repeat));
    }
    private void printGivenBooks(){     
        for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i) != null && histories.get(i).getReturndate()== null){
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
            List<Author> authors = new ArrayList<>();
            for(int i = 0; i < countAuthors; i++){
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
                authors.add(author);
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
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i) != null){
                    System.out.printf("%d. %s%n",i+1,books.get(i).toString());
                }
            }
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
            history.setGivendate(c.getTime());
            return history;
        }      
}