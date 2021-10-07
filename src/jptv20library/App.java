package jptv20library;

import java.util.Scanner;
import myclasses.Author;
import myclasses.Book;


public class App {
    Scanner scanner = new Scanner(System.in);
    public void run() {
        String repeat = "r";
        do{
            System.out.println("������ - 0: ����� �� ���������");
            System.out.println("������ - 1: ���������� �� ������ � �����");
            System.out.printf("�������� ����� ������: ");
            int task = scanner.nextInt();
            switch (task) {
                case 0:
                    repeat = "d";
                    System.out.println("����!");
                    break;
                case 1:
                    System.out.println("��������� �����");
                    addBook();
                default:
                    System.out.println("������� ����� �� ������: ");
            }
            
        }while("r".equals(repeat));
    }
        private Book addBook(){
            Book book = new Book();
            System.out.println("������� �������� �����: ");
            book.setBookName(scanner.nextLine());
            System.out.println("������� ���������� ������� ���� �����: ");
            int countAuthors = scanner.nextInt(); scanner.nextLine();  
            System.out.println("������� ������ �����: ");
            System.out.println("������� ���� ������� �����: ");
            book.setPublishedYear(scanner.nextInt());
            Author [] authors = new Author[countAuthors];  
            for(int i = 0; i < authors.length; i++){
                Author author = new Author();
                System.out.println("������� ��� ������: ");
                author.setFirstName(scanner.nextLine());
                System.out.println("������� ������� ������: ");
                author.setLastName(scanner.nextLine());
                System.out.println("������� ��� �������� ������: ");
                author.setYear(scanner.nextInt());
            }
            book.setAuthor(authors);
            return book;
        
        }
        
}



