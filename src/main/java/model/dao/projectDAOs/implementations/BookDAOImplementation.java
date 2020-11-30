package model.dao.projectDAOs.implementations;

import model.beans.project.Book;
import model.dao.projectDAOs.interfaces.BookDAO;
import utilities.DatabaseUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImplementation implements BookDAO  {

    private static final String INSERT_BOOK = "INSERT INTO Book(name, title, fileLink) VALUES (?, ?, ?);";
    private static final String UPDATE_BOOK = "UPDATE Book SET name = ?, title = ?, fileLink = ? WHERE id = ?;";
    private static final String SELECT_BOOK = "SELECT * FROM Book WHERE id = ?;";
    private static final String SELECT_BOOK_BY_NAME = "SELECT * FROM Book WHERE name = ?;";
    private static final String SELECT_BOOKS = "SELECT * FROM Book;";
    private static final String DELETE_BOOK = "DELETE FROM Book WHERE id = ?;";

    @Override
    public int insertBook(Book book) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getFileLink());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return id;
    }

    @Override
    public boolean updateBook(Book book) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK)) {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getFileLink());
            preparedStatement.setInt(4, book.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Book selectBook(int id) {
        Book book = null;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String title = resultSet.getString("title");
                String fileLink = resultSet.getString("fileLink");
                book = new Book(id, name, title, fileLink);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return book;
    }

    @Override
    public Book selectBookByName(String name) {
        Book book = null;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_NAME)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String title = resultSet.getString("title");
                String fileLink = resultSet.getString("fileLink");
                book = new Book(id, name, title, fileLink);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> selectBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String title = resultSet.getString("title");
                String fileLink = resultSet.getString("fileLink");
                books.add(new Book(id, name, title, fileLink));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return books;
    }

    @Override
    public boolean deleteBook(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
