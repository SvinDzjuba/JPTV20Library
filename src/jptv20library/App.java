package jptv20library;

import java.util.Scanner;


public class App {
    public void run() {
        String repeat = "r";
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Выберите номер задачи: ");
            int task = scanner.nextInt();
            System.out.println("Задача - 0: Выход из программы");
            switch (task) {
                case 0:
                    repeat = "d";
                    System.out.println("Пока!");
                    break;
                default:
                    System.out.println("Введите номер из списка: ");
            }
            
        }while("r".equals(repeat));
        }
    }

