package com.company.Factory;

public class Book implements IBook {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    int id;
    String title;
    String author;
    int amount;

    public Book(String author, String title) {
        id++;
        this.title = title;
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {return id;}


    @Override
    public void displayBook() {
        System.out.println(this.getClass().getSimpleName() + "\n " + getTitle() + "\n " + "Author " + getAuthor() + "\n-----------------------\n");
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ANSI_RED+ "Book :" +"\n"+
                ANSI_GREEN+ "id=" + id +"\n" +
                ANSI_YELLOW+"title: '" + title + '\'' +"\n"+
                ANSI_BLUE+"author: '" + author + '\''+"\n"
                ;
    }
}
