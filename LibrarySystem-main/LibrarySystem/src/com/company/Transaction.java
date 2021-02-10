package com.company;

import com.company.Factory.Book;
import com.company.JDBC.BookRepository;

import java.sql.SQLException;

public class Transaction {
    Long memberId;
    String title ;
    String dueDate;
    Book book;
    private BookRepository bookRepository = new BookRepository();

    public Transaction(Long memberId, String title, String dueDate){
        this.memberId = memberId;
        this.title = title;
        this.dueDate = dueDate;
        createTran();
    }

    public void createTran(){
        try {
            bookRepository.createTran(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public Long  getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getBookTitle() {
        return title;
    }

    public void setBookTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}
