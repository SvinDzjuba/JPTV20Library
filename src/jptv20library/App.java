package jptv20library;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import myclasses.Author;
import myclasses.Book;
import myclasses.History;
import myclasses.Reader;


public class App {
    Scanner scanner = new Scanner(System.in);
    private Book[] books = new Book[10];
    private Reader[] reader = new Reader[10];
    private History[] history = new History[10];
    Calendar c = new GregorianCalendar();
    public void run() {
        String repeat = "r";
        do{
            System.out.println("Задача - 0: Выход из программы");
            System.out.println("Задача - 1: Добавить книгу");
            System.out.println("Задача - 2: Список книг");
            System.out.println("Задача - 3: Ввод информации о читателе");
            System.out.println("Задача - 4: Информация о читателе");
            System.out.printf("Выберите номер задачи: ");
            int task = scanner.nextInt();scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = "d";
                    System.out.println("Пока!");
                    break;
                case 1:
                    System.out.println("---- Добавление книги ----");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] == null){
                            books[i] = addBook();
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("---- Список книг -----");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] != null){
                            System.out.println(books[i].toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("---- Ввод информация о читателе ----");
                    for (int i = 0; i < reader.length; i++) {
                        if(reader[i] == null){
                            reader[i] = addReader();
                            break;
                        }
                    }
                case 4:
                    System.out.println("---- Читатель -----");
                    for (int i = 0; i < reader.length; i++) {
                        if(reader[i] != null){
                            System.out.println(reader[i].toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("------ База данных -----");
                    
                default:
                    System.out.println("Введите номер из списка: ");
            }
            
        }while("r".equals(repeat));
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
            Author [] authors = new Author[countAuthors]; 
            System.out.println("=================================");
            for(int i = 0; i < authors.length; i++){
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
        
        }
        
        





