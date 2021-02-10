package com.company;

import com.company.TemplateDP.Student;

import java.util.Scanner;

public class LibraryFacade {

    private Librarian librarian = new Librarian();
    private String author;
    private String title;


    public void mainMenu() {
        while (true) {
            System.out.println("Library system!");
            System.out.println("1 Work");
            System.out.println("2 Off");
            Scanner sc = new Scanner(System.in);
            Integer choice = sc.nextInt();

            if (choice == 1) {
                requestBook();
            }else
                break;


        }
    }

    public void requestBook() {

        while (true) {

            Integer choice;

            System.out.println("1 Create Book");
            System.out.println("2 Search Book");
            System.out.println("3 get all collection of books");
            System.out.println("4 delete book with id");
            System.out.println("5 get or reserve book");
            System.out.println("6 back to the main menu");
            Scanner scn = new Scanner(System.in);
            choice = scn.nextInt();
            if (choice == 1) {
                createBook();

            } else if (choice == 2) {
                searchBook();
            } else if (choice == 3) {
                librarian.allCollection();
            } else if (choice == 4) {
                deleteBook();
            } else if (choice == 5) {
                payBill();
            }

            break;
        }
    }

    public void createBook() {
        System.out.println("please typing what you want to create:");
        System.out.println("1 Journal");
        System.out.println("2 Textbook");
        System.out.println("3 Magazine");

        Scanner scan = new Scanner(System.in);
        Integer c = scan.nextInt();

        System.out.println("Author");
        Scanner a = new Scanner(System.in);

        System.out.println("Title");
        Scanner t = new Scanner(System.in);

        author = a.nextLine();
        title = t.nextLine();

        librarian.addBook(c, author, title);
    }

    public void searchBook() {
        System.out.println("Type title and author of book");
        Scanner scanner = new Scanner(System.in);
        title = scanner.nextLine();
        Scanner scanner1 = new Scanner(System.in);
        author = scanner1.nextLine();
        librarian.searchBook(title, author);
    }

    public void deleteBook() {
        System.out.println("type id:");
        Scanner scanner2 = new Scanner(System.in);
        Integer id = scanner2.nextInt();
        librarian.deleteBook(id);
    }


    public void payBill() {
        createUser();
        System.out.println("Please write title and due date:");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        String title = scanner.next();
        String dueDate = scanner1.next();
        librarian.issueBook(title, dueDate);

    }

    public void createUser() {
        librarian.createUser();
    }


}
