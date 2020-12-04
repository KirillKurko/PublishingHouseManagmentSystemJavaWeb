package controller.services.projectServices;

import model.beans.project.Author;
import model.beans.project.Book;
import model.dao.projectDAOs.implementations.AuthorDAOImplementation;
import model.dao.projectDAOs.implementations.BookDAOImplementation;
import model.dao.projectDAOs.interfaces.AuthorDAO;
import model.dao.projectDAOs.interfaces.BookDAO;
import utilities.DatabaseUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorService {

    private static final String INSERT_AUTHOR_BOOK = "INSERT INTO BooksAuthors(bookID, authorID) VALUES (?, ?);";
    private static final String DELETE_BOOK_AUTHORS = "DELETE FROM BooksAuthors WHERE bookID = ?;";
    private static final String DELETE_AUTHOR_BOOKS = "DELETE FROM BooksAuthors WHERE authorID = ?;";

    private AuthorDAO authorDAO;
    private BookDAO bookDAO;

    public AuthorService() {
        authorDAO = new AuthorDAOImplementation();
        bookDAO = new BookDAOImplementation();
    }

    public void addAuthor(Author author, String bookName) {
        Book book = bookDAO.selectBookByName(bookName);
        int bookId = book.getId();
        int authorId = authorDAO.insertAuthor(author);
        insertAuthorBook(bookId, authorId);
    }

    public void deleteAuthor(int authorId) {
        deleteAuthorBooks(authorId);
        authorDAO.deleteAuthor(authorId);
    }

    private void insertAuthorBook(int bookId, int authorId) {
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHOR_BOOK)) {
            preparedStatement.setInt(1, bookId);
            preparedStatement.setInt(2, authorId);
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public boolean deleteBookAuthors(int bookId) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_AUTHORS)) {
            preparedStatement.setInt(1, bookId);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }

    private boolean deleteAuthorBooks(int authorId) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_AUTHOR_BOOKS)) {
            preparedStatement.setInt(1, authorId);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }

}
