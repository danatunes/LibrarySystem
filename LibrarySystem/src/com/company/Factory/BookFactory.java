package com.company.Factory;

public class BookFactory {

    public Book createBook(Integer book , String author , String title){
        return switch (book){
            case 1 -> new Journal(author , title);
            case 3 -> new Magazine(author , title);
            case 2 -> new Textbook(author , title);
            default -> throw new IllegalStateException("Unexpected value: ");
        };
    }

}
