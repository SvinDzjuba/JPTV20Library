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
            System.out.println("Задача - 0: Выход из программы");
            System.out.println("Задача - 1: Добавить книгу");
            System.out.println("Задача - 2: Список книг");
            System.out.println("Задача - 3: Ввод информации о читателе");
            System.out.println("Задача - 4: Информация о читателе");
            System.out.println("Задача - 5: Выдать книгу");
            System.out.println("Задача - 6: Список выданных книг");
            System.out.println("Задача - 7: Возврат выбранной книги");
            System.out.printf("Выберите номер задачи: ");
            int task = scanner.nextInt();scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = "d";
                    System.out.println("Пока!");
                    break;
                case 1:
                    System.out.println("---- Добавление книги ----");
                    books.add(addBook());
                    keeper.saveBooks(books);
                    break;
                case 2:
                    System.out.println("---- Список книг -----");
                    for (int i = 0; i < books.size(); i++) {
                        if(books.get(i) != null){
                            System.out.println(books.get(i).toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("---- Ввод информация о читателе ----");
                    for (int i = 0; i < reader.size(); i++) {
                        if(reader.get(i) == null){
                            reader.add(addReader());
                            keeper.saveReaders(reader);
                            break;
                        }
                    }
                case 4:
                    System.out.println("---- Читатель -----");
                    for (int i = 0; i < reader.size(); i++) {
                        if(reader.get(i) != null){
                            System.out.println(reader.get(i).toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("------ Выдать книгу -----");
                    for (int i = 0; i < reader.size(); i++) {
                        if(histories.get(i) == null){
                            histories.set(i, addHistory());
                            break;
                        }
                    }
                break;
                
                case 6:
                    int n = 0;
                    System.out.println("----- Список выданных книг ----");
                    for (int i = 0; i < histories.size(); i++) {
                        if(histories.get(i) != null && histories.get(i).getReturndate() == null){
                            System.out.println(histories.get(i).toString());
                            System.out.println("Книгу "+histories.get(i).getBook().getBookName()
                                +" читает "+histories.get(i).getReader().getFirstName()
                                +" "+ histories.get(i).getReader().getLastName());
                            n++;
                        }
                    }    
                    if(n<1){
                        System.out.println("----- Выданные книги отсутвуют -----");
                    }
                    System.out.println("");
                    break;   
                    
                case 7:
                    System.out.println("----- Возврат книги -----");
                    printGivenBooks();
                    System.out.print("Выберите возвращаемую книгу: ");
                    int historyNumber = scanner.nextInt(); scanner.nextLine();
                    Calendar c = new GregorianCalendar();
                    histories.get(historyNumber-1).setReturndate(c.getTime());
                    break;
                
                default:
                    System.out.println("----- Введите номер из списка ----- ");
            }
            
        }while("r".equals(repeat));
    }
    private void printGivenBooks(){     
        for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i) != null && histories.get(i).getReturndate()== null){
                System.out.printf("%d. Книгу: %s читает %s %s%n",
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
            System.out.printf("Введите название книги: ");
            book.setBookName(scanner.nextLine());
            System.out.println("");
            System.out.printf("Введите дату издания книги: ");
            book.setPublishedYear(scanner.nextInt());
            System.out.println("");
            System.out.printf("Введите количество авторов: ");
            int countAuthors = scanner.nextInt(); scanner.nextLine(); 
            System.out.println("=================================");
            List<Author> authors = new ArrayList<>();
            for(int i = 0; i < countAuthors; i++){
                Author author = new Author();
                System.out.printf("Введите имя автора: ");
                author.setFirstName(scanner.nextLine());
                System.out.println("");
                System.out.printf("Введите фамилию автора: ");
                author.setLastName(scanner.nextLine());
                System.out.println("");
                System.out.printf("Введите год рождения автора: ");
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
            System.out.printf("Введите имя читателя: ");
            reader.setFirstName(scanner.nextLine());
            System.out.println("");
            System.out.printf("Введите фамилию читателя: ");
            reader.setLastName(scanner.nextLine());
            System.out.println("");
            System.out.printf("Введите номер телефона читателя: ");
            reader.setPhone(scanner.nextLine());
            System.out.println("=================================");
            
            return reader;
        }
        
        
        private History addHistory(){
            History history = new History();
            System.out.println("Список книг: ");
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i) != null){
                    System.out.printf("%d. %s%n",i+1,books.get(i).toString());
                }
            }
            System.out.println("Введите номер книги: ");
            int bookNumber = scanner.nextInt(); scanner.nextLine();
            history.setBook(books.get(bookNumber-1));
            System.out.println();
            System.out.println("Список читателей: ");
            for (int i = 0; i < reader.size(); i++) {
            if(reader.get(i) != null){
                System.out.printf("%d. %s%n",i+1,reader.get(i).toString());
            }
            }
            System.out.println("Введите номер читателя: ");
            int readerNumber = scanner.nextInt(); scanner.nextLine();
            history.setReader(reader.get(readerNumber-1));
            Calendar c = new GregorianCalendar();
            history.setGivendate(c.getTime());
            return history;
        }      
}