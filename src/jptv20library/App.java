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
            System.out.println("0: Закончить программу");
            System.out.println("1: Добавить книгу");
            System.out.println("2: Список книг");
            System.out.println("3: Добавить читателя");
            System.out.println("4: Список читателей");
            System.out.println("5: Выдать книгу читателю");
            System.out.println("6: Вернуть книгу");
            System.out.println("7: Список выданных книг");
            System.out.println("Выберите номер задачи:");
            int task = scanner.nextInt(); scanner.nextLine();
            switch (task) {
                case 0:
                    repeat="q";
                    System.out.println("Пока!");
                    break;
                case 1:
                    System.out.println("--- Добавление книги ---");
                    books.add(addBook());
                    keeping.saveBooks(books);
                    break;
                case 2:
                    System.out.println("--- Список книг ---");
                    for (int i = 0; i < books.size(); i++) {
                        if(books.get(i) != null && books.get(i).getCount() > 0){
                            System.out.println(books.get(i).toString());
                        }
                    }
                    System.out.println("-------------------");
                    break;
                case 3:
                    System.out.println("--- Добавление читателя ---");
                    readers.add(addReader());
                    keeping.saveReaders(readers);
                    break;
                case 4:
                    System.out.println("--- Список читателей ---");
                    for (int i = 0; i < readers.size(); i++) {
                        if(readers.get(i) != null){
                            System.out.println(readers.get(i).toString());
                        }
                    }
                    System.out.println("-------------------");
                    break;
                case 5:
                    System.out.println("--- Выдача книги ---");
                    History history = addHistory();
                    if(history == null){
                        break;
                    }
                    history.getBook().setCount(history.getBook().getCount() - 1);
                    keeping.saveBooks(books);
                    histories.add(history);
                    keeping.saveHistories(histories);
                    System.out.println("Книга "+history.getBook().getBookName()
                                        +" выдана читателю "+history.getReader().getFirstName()
                                        +" " +history.getReader().getLastName()
                    );
                    System.out.println("-------------------");
                    break;
                case 6:
                    System.out.println("--- Возврат книги ---");
                    System.out.println("Список читаемых книг:");
                    int n = 0;
                    for (int i = 0; i < histories.size(); i++) {
                        if(histories.get(i) != null
                             && histories.get(i).getReturnedDate() == null
                                && histories.get(i).getBook().getCount() 
                                <  histories.get(i).getBook().getQuantity()
                        ){
                            System.out.printf("%d. Книгу \"%s\" читает %s %s%n"
                                    ,i+1
                                    ,histories.get(i).getBook().getBookName()
                                    ,histories.get(i).getReader().getFirstName()
                                    ,histories.get(i).getReader().getLastName()
                            );
                             n++;
                        }
                    }
                    if(n < 1){
                        System.out.println("Нет читаемых книг!");
                        System.out.println("-------------------");
                        break;
                    }
                    System.out.print("Выберите номер возврщаемой книги: ");
                    int numberHistory = scanner.nextInt(); scanner.nextLine();
                    Calendar c = new GregorianCalendar();
                    histories.get(numberHistory - 1).setReturnedDate(c.getTime());
                    histories.get(numberHistory - 1).getBook().setCount(
                            histories.get(numberHistory - 1).getBook().getCount()+1
                    );
                    keeping.saveBooks(books);
                    keeping.saveHistories(histories);
                    System.out.println("Книга "
                            +histories.get(numberHistory - 1).getBook().getBookName()
                            +" возвращена в библиотеку"
                    );
                    System.out.println("-------------------");
                    break;
                case 7:
                    System.out.println("Список читаемых книг:");
                    n = 0;
                    for (int i = 0; i < histories.size(); i++) {
                        if(histories.get(i) != null && histories.get(i).getReturnedDate() == null){
                            System.out.println(i+1+"."
                                    +histories.get(i).getReader().getFirstName()
                                    +" "+histories.get(i).getReader().getLastName()
                                    +" читает книгу под названием "
                                    +"'"
                                    +histories.get(i).getBook().getBookName()
                                    +"'");
                            n++;
                        }
                    }
                    if(n < 1){
                        System.out.println("Нет читаемых книг!");
                        System.out.println("-------------------");
                        break;
                    }
                    break;
                default:
                    System.out.println("Выберите цифру из списка!");;
            }
        }while("r".equals(repeat));
    }
    private Book addBook(){
        Book book = new Book();
        System.out.print("Введите название книги: ");
        book.setBookName(scanner.nextLine());
        System.out.print("Введите год издания книги: ");
        book.setPublishedYear(scanner.nextInt());scanner.nextLine();
        System.out.print("Введите количество экземпляров книги: ");
        book.setQuantity(scanner.nextInt());scanner.nextLine();
        book.setCount(book.getQuantity());
        System.out.print("Сколько авторов у книги: ");
        int countAuthors = scanner.nextInt();scanner.nextLine();
        Author[] authors = new Author[countAuthors];
        for (int i = 0; i < authors.length; i++) {
            Author author = new Author();
            System.out.println("Введите имя автора "+(i+1)+": ");
            author.setFirstname(scanner.nextLine());
            System.out.println("Введите фамилию автора: ");
            author.setLastname(scanner.nextLine());
            authors[i] = author;
        }
        book.setAuthor(authors);
        return book;
    }
    private Reader addReader(){
        Reader reader = new Reader();
        System.out.println("Введите имя читателя");
        reader.setFirstName(scanner.nextLine());
        System.out.println("Введите фамилию читателя");
        reader.setLastName(scanner.nextLine());
        System.out.println("Введите телефон читателя");
        reader.setPhone(scanner.nextLine());
        return reader;
    }

    private History addHistory() {
        History history = new History();
        System.out.println("Список книг:");
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
                        +". В наличии: " + books.get(i).getCount()
                );
                n++;
            }
        }
        if(n < 1){
            System.out.println("Нет книг для чтения");
            return null;
        }
        System.out.print("Выберите номер книги: ");
        int numberBook = scanner.nextInt(); scanner.nextLine();
        System.out.println("Список читателей:");
        for (int i = 0; i < readers.size(); i++) {
            if(readers.get(i) != null){
                System.out.println(i+1+". "+readers.get(i).toString());
            }
        }
        System.out.print("Выберите номер читателя: ");
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
                    reader.add(addReader());
                    keeper.saveReaders(reader);                       
                break;
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
                        histories.add(addHistory());
                        keeper.saveHistories(histories);
                break;              
                case 6:
                    int n = 0;
                    System.out.println("----- Список выданных книг ----");
                    for (int i = 0; i < histories.size(); i++) {
                        if(histories.get(i) != null && histories.get(i).getReturnedDate()== null){
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
                    System.out.println("----- Возврат выданной книги -----");
                    System.out.println("Список выданной книги с читателем"); 
                    printGivenBooks();
                    System.out.println("Выбарть книгу из списка ");
                    int numberHistory =scanner.nextInt();scanner.nextLine();
                    Calendar c= new GregorianCalendar();
                    if(histories.get(numberHistory - 1).getBook().getCount()
                            < histories.get(numberHistory - 1).getBook().getQuantity()){
                        histories.get(numberHistory - 1).setReturnedDate(c.getTime());
                        histories.get(numberHistory - 1).getBook().setCount(histories.get(numberHistory - 1).getBook().getCount()+1);
                    }else{
                        System.out.println("Данная книга отсутсвует");
                    }
                    
                    keeper.saveHistories(histories);
                    keeper.saveBooks(books);
                    System.out.printf("книга \"%s\" возвращена%n", histories.get(numberHistory-1).getBook().getBookName());
                    break;
                default:
                    System.out.println("----- Введите номер из списка ----- ");
            }
            
        }while("r".equals(repeat));
    }
    private void printGivenBooks(){     
        for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i) != null && histories.get(i).getReturnedDate()== null){
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
            Author[] authors = new Author[countAuthors];
            for(int i = 0; i < countAuthors; i++){
                Author author = new Author();
                System.out.printf("Введите имя автора: ");
                author.setFirstname(scanner.nextLine());
                System.out.println("");
                System.out.printf("Введите фамилию автора: ");
                author.setLastname(scanner.nextLine());
                System.out.println("");
                System.out.printf("Введите год рождения автора: ");
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
                            +". В наличии: " + books.get(i).getCount());
                    g++;
                }
            }
            if(g < 1){
                System.out.println("Нет книг для чтения");
                return null;
            }
                //System.out.printf("%d. %s%n",i+1,books.get(i).toString());

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
            history.setGivenDate(c.getTime());
            return history;
        }      
}
*/