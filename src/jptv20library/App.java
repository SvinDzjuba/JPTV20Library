package jptv20library;

import java.util.Scanner;
import myclasses.Author;
import myclasses.Book;


public class App {
    Scanner scanner = new Scanner(System.in);
    private Book[] books = new Book[10];
    public void run() {
        String repeat = "r";
        do{
            System.out.println("Задача - 0: Выход из программы");
            System.out.println("Задача - 1: Добавить книгу");
            System.out.println("Задача - 2: Список книг");
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
        
}



