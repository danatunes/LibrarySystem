package com.company.JDBC;

import com.company.Factory.Book;
import com.company.Factory.Journal;
import com.company.Transaction;
import com.company.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    static Connection con
            = DBConnection.getConnection();

    public void add(Book book) throws Exception {
        try {
            String query
                    = "insert into books(name, "
                    + "author," + "type) VALUES (?, ?, ?)";
            PreparedStatement ps
                    = con.prepareStatement(query);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getClass().getSimpleName());
            int n = ps.executeUpdate();

        } catch (SQLException ex) {
            throw new Exception("Cannot run SQL statement: " + ex.getMessage());
        }

    }


    @Override
    public void delete(int id)
            throws SQLException {
        String query
                = "delete from books where id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }


    @Override
    public Book getBook(String title, String author)
            throws SQLException {

        String query
                = "select * from books where name= ? and author=?";
        PreparedStatement ps
                = con.prepareStatement(query);

        ps.setString(1, title);
        ps.setString(2, author);
        Book book = new Book();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            book.setTitle(rs.getString("name"));
            book.setAuthor(rs.getString("author"));

        }

        if (check == true) {
            return book;
        } else
            return null;
    }

    @Override
    public Book getBookAmn(String title)
            throws SQLException {

        String query
                = "select amount from books where name= ?";
        PreparedStatement ps
                = con.prepareStatement(query);

        ps.setString(1, title);
        Book book = new Book();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            book.setAmount(rs.getInt("name"));
        }

        if (check == true) {
            return book;
        } else
            return null;
    }

    @Override
    public List<Book> getBook()
            throws SQLException {
        String query = "select * from books";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Book> ls = new ArrayList();

        while (rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("name"));
            book.setAuthor(rs.getString("author"));
            ls.add(book);
        }
        return ls;
    }

    @Override
    public void update(Book book)
            throws SQLException {

        String query
                = "update books set name=?, "
                + " author= ? where id = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setInt(3, book.getId());
        ps.executeUpdate();
    }

    public void createUser(User user) throws Exception {
        try {
            String query
                    = "insert into readers(surname, "
                    + "name," + "iin) VALUES (?, ?, ?)";
            PreparedStatement ps
                    = con.prepareStatement(query);

            ps.setString(1, user.getSurname());
            ps.setString(2, user.getName());
            ps.setLong(2, user.getIIN());
            int n = ps.executeUpdate();

        } catch (SQLException ex) {
            throw new Exception("Cannot run SQL statement: " + ex.getMessage());
        }

    }

    @Override
    public void createTran(Transaction transaction) throws Exception {
        try {
            String query
                    = "insert into readers_books (reader_iin, "
                    + "book_title," + "due_date) VALUES (?, ?, ?)";
            PreparedStatement ps
                    = con.prepareStatement(query);

            ps.setLong(1, transaction.getMemberId());
            ps.setString(2, transaction.getBookTitle());
            ps.setDate(3, Date.valueOf(transaction.getDueDate()));
            int n = ps.executeUpdate();

        } catch (SQLException ex) {
            throw new Exception("Cannot run SQL statement: " + ex.getMessage());
        }
    }
}


