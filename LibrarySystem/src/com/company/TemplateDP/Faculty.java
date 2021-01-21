package com.company.TemplateDP;

import java.util.Scanner;

public class Faculty extends MemberRecord{

    @Override
    public void payBookAmt() {
        System.out.println("Choice abonement for Faculty:");
        System.out.println("1 . 1 month 10kzt ");
        System.out.println("2 . 1 year 100kzt");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("please type sum of abonement:");
            choice = scanner.nextInt();
            System.out.println("Congrat 1 month abonem");
            requestBook();
        } else if (choice == 2) {
            System.out.println("please type sum of abonement:");
            choice = scanner.nextInt();
            System.out.println("Congrat 1 month abonem");
            requestBook();
        }
    }
}
