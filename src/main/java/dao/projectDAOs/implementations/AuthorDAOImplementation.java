package dao.projectDAOs.implementations;

import beans.project.Author;
import dao.projectDAOs.interfaces.AuthorDAO;
import utilities.DatabaseUtility;

import java.sql.*;

public class AuthorDAOImplementation implements AuthorDAO {

    private static final String INSERT_AUTHOR = "INSERT INTO Author(name, surname) VALUES (?, ?);";
    private static final String UPDATE_AUTHOR  = "UPDATE Author SET name = ?, surname = ? WHERE id = ?;";
    private static final String SELECT_AUTHOR  = "SELECT * FROM Author WHERE id = ?;";
    private static final String DELETE_AUTHOR  = "DELETE FROM Author WHERE id = ?;";

    @Override
    public int insertAuthor(Author author) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHOR, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getSurname());
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
    public boolean updateAuthor(Author author) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AUTHOR)) {
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getSurname());
            preparedStatement.setInt(3, author.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Author selectAuthor(int id) {
        Author author = null;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AUTHOR)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                author = new Author(id, name, surname);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return author;
    }

    @Override
    public boolean deleteAuthor(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_AUTHOR)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
