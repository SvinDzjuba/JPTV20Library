package jptv20library;

import java.util.Scanner;


public class App {
    public void run() {
        String repeat = "r";
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.printf("�������� ����� ������: ");
            int task = scanner.nextInt();
            System.out.println("������ - 0: ����� �� ���������");
            switch (task) {
                case 0:
                    repeat = "d";
                    System.out.println("����!");
                    break;
                default:
                    System.out.println("������� ����� �� ������: ");
            }
            
        }while("r".equals(repeat));
        }
    }

