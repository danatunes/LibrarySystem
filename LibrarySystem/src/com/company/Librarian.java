package com.company;

import com.company.Factory.Book;
import com.company.Factory.BookFactory;
import com.company.JDBC.BookRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class Librarian {

    String name;

    private BookRepository bookRepository;
    private User user = new User();
    private Transaction transaction;

    public Librarian() {
        bookRepository = new BookRepository();
    }



    public void addBook(Integer c, String author, String title) {
        BookFactory bookFactory = new BookFactory();

        Book book = bookFactory.createBook(c, author, title);
        book.displayBook();

        try {
            bookRepository.add(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void issueBook(String bookTitle, String dueDate) {
        transaction = new Transaction(user.getIIN(),bookTitle,dueDate);

    }


    public void returnBook() {

    }

    public void searchBook(String title, String author) {

        try {
            System.out.println(bookRepository.getBook(title, author));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void allCollection() {
        try {
            System.out.println(bookRepository.getBook());
            ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteBook(int id) {
        try {
            bookRepository.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createUser(){
        System.out.println("type Surname:");
        Scanner scanner = new Scanner(System.in);
        String surname = scanner.next();


        System.out.println("type Name:");
        Scanner scanner1 = new Scanner(System.in);
        name = scanner1.next();

        System.out.println("type IIN:");
        Scanner scanner2 = new Scanner(System.in);
        Long iin = scanner2.nextLong();

        user.setName(name);
        user.setSurname(surname);
        user.setIIN(iin);

    }


}
