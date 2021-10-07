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
            System.out.println("������ - 0: ����� �� ���������");
            System.out.println("������ - 1: �������� �����");
            System.out.println("������ - 2: ������ ����");
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
                default:
                    System.out.println("������� ����� �� ������: ");
            }
            
        }while("r".equals(repeat));
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
        
}



