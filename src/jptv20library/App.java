package jptv20library;

import java.util.Scanner;
import myclasses.Author;
import myclasses.Book;


public class App {
    Scanner scanner = new Scanner(System.in);
    public void run() {
        String repeat = "r";
        do{
            System.out.println("Задача - 0: Выход из программы");
            System.out.println("Задача - 1: Информация об авторе и книге");
            System.out.printf("Выберите номер задачи: ");
            int task = scanner.nextInt();
            switch (task) {
                case 0:
                    repeat = "d";
                    System.out.println("Пока!");
                    break;
                case 1:
                    System.out.println("Добавляем книгу");
                    addBook();
                default:
                    System.out.println("Введите номер из списка: ");
            }
            
        }while("r".equals(repeat));
    }
        private Book addBook(){
            Book book = new Book();
            System.out.println("Введите название книги: ");
            book.setBookName(scanner.nextLine());
            System.out.println("Введите количество авторов этой книги: ");
            int countAuthors = scanner.nextInt(); scanner.nextLine();  
            System.out.println("Введите автора книги: ");
            System.out.println("Введите дату издания книги: ");
            book.setPublishedYear(scanner.nextInt());
            Author [] authors = new Author[countAuthors];  
            for(int i = 0; i < authors.length; i++){
                Author author = new Author();
                System.out.println("Введите имя автора: ");
                author.setFirstName(scanner.nextLine());
                System.out.println("Введите фамилию автора: ");
                author.setLastName(scanner.nextLine());
                System.out.println("Введите год рождения автора: ");
                author.setYear(scanner.nextInt());
            }
            book.setAuthor(authors);
            return book;
        
        }
        
}



